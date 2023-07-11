package org.banking.repositories.database;

import org.banking.entities.enums.UserStatusEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
   private Long id;
   private String name;
   private String document;
   private LocalDate dateBirth;
   @Enumerated(EnumType.STRING)
   private UserStatusEnum status;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity address;

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }
}
