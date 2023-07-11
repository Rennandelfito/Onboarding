package org.banking.repositories.viacep;

import org.banking.entities.viacep.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Viacep" , url = "viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{zipCode}/json/")
    ViaCepResponse getAddress(@PathVariable("zipCode") String zipCode);
}
