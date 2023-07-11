package org.banking.service;

import org.banking.repositories.account.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

@Service
public class AccountService {

    @Autowired
    AccountClient client;

    public void createAccount(String document){
        client.createAccount(document);
    }
}
