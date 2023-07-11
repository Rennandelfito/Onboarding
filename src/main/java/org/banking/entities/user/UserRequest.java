package org.banking.entities.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {
    @NotBlank (message = "name cannot be null or empty")
    @Size(min = 4 , max = 60, message = "invalid name")
   private String name;
    @NotBlank (message = "document cannot be null or empty")
    @Size(min = 11, max = 11, message = "invalid document")
   private String document;
    @NotBlank (message = "dateBirth cannot be null or empty")

   private String dateBirth;
    @NotBlank (message = "zipCode cannot be null or empty")

   private String zipCode;
    @NotNull (message = "numberHouse cannot be null")
   private Integer numberHouse;
   private String complement;

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

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(Integer numberHouse) {
        this.numberHouse = numberHouse;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String  toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", numberHouse=" + numberHouse +
                ", complement='" + complement + '\'' +
                '}';
    }
}
