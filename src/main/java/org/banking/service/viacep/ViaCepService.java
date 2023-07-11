package org.banking.service.viacep;

import org.banking.entities.viacep.ViaCepResponse;
import org.banking.repositories.viacep.ViaCepClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    @Autowired
    private ViaCepClient client;
    public ViaCepResponse getAddress(String zipCode){
        return client.getAddress(zipCode);

    }
}
