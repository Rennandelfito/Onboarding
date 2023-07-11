package org.banking.service.user;

import org.banking.entities.enums.ApproveEnum;
import org.banking.entities.enums.UserStatusEnum;
import org.banking.entities.exceptions.ValidationUserException;
import org.banking.entities.user.UserRequest;
import org.banking.entities.user.UserResponse;
import org.banking.entities.viacep.ViaCepResponse;
import org.banking.repositories.database.AddressEntity;
import org.banking.repositories.database.AddressRepository;
import org.banking.repositories.database.UserEntity;
import org.banking.repositories.database.UserRepository;
import org.banking.service.AccountService;
import org.banking.service.viacep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountService accountService;

    static final String COUNTRY_DEFAULT = "Brasil";

    public void post(UserRequest user) {
        LocalDate birthDate = getBirthDate(user);
        validationMinorAge(birthDate);
        ViaCepResponse address = viaCepService.getAddress(user.getZipCode());
        AddressEntity addressEntity = saveAddress(user, address);
        UserEntity userSaved = saveUser(user, birthDate, addressEntity);
        updateAddressEntity(addressEntity, userSaved);
    }

    public List<UserResponse> getAll() {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponse> userResponse = users.stream().filter(user -> user.getStatus() == UserStatusEnum.ANALYSIS).map(it -> {
            return new UserResponse(it.getId(), it.getName(), it.getDocument(),
                    it.getDateBirth(), it.getAddress().getCountry(),
                    it.getAddress().getState(), it.getAddress().getCity(),
                    it.getAddress().getNeighborhood(), it.getAddress().getStreet(),
                    it.getAddress().getNumberhouse());
        }).collect(Collectors.toList());
        return userResponse;
    }

    public void approve(Long id, ApproveEnum approve) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ValidationUserException("user not found");
        }
        UserEntity userEntity = optionalUser.get();
        if (approve == ApproveEnum.APPROVED) {
            userEntity.setStatus(UserStatusEnum.APROVED);
            accountService.createAccount(userEntity.getDocument());
        } else {
            userEntity.setStatus(UserStatusEnum.REPROVED);
        }

        userRepository.save(userEntity);
    }

    public void delete(Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ValidationUserException("usr not found");
        }
        UserEntity user = optionalUser.get();
        userRepository.delete(user);
    }

    private LocalDate getBirthDate(UserRequest user) {
        LocalDate birthDate = LocalDate.parse(user.getDateBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return birthDate;
    }

    private void updateAddressEntity(AddressEntity addressEntity, UserEntity userSaved) {
        addressEntity.setUser(userSaved);
        addressRepository.save(addressEntity);
    }

    private UserEntity saveUser(UserRequest user, LocalDate birthDate, AddressEntity addressEntity) {
        UserEntity userEntity = new UserEntity();
        userEntity.setDateBirth(birthDate);
        userEntity.setName(user.getName());
        userEntity.setDocument(user.getDocument());
        userEntity.setAddress(addressEntity);
        userEntity.setStatus(UserStatusEnum.ANALYSIS);
        return userRepository.save(userEntity);
    }

    private void validationMinorAge(LocalDate birthDate) {
        Long year = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        if (year < 18) {
            throw new ValidationUserException("User is minor age");
        }
    }

    private AddressEntity saveAddress(UserRequest user, ViaCepResponse address) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry(COUNTRY_DEFAULT);
        addressEntity.setState(address.getUf());
        addressEntity.setCity(address.getLocalidade());
        addressEntity.setNeighborhood(address.getBairro());
        addressEntity.setStreet(address.getLogradouro());
        addressEntity.setNumberhouse(user.getNumberHouse());
        return addressRepository.save(addressEntity);
    }
}
