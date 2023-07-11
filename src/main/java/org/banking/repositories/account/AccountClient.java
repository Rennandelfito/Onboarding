package org.banking.repositories.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "Account" , url = "localhost:9090/account")
public interface AccountClient {

    @PostMapping
    void createAccount(@RequestHeader(name = "document") String document);
}
