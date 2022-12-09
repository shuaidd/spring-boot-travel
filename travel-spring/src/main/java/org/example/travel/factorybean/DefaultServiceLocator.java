package org.example.travel.factorybean;

import org.example.travel.factorybean.AccountServiceImpl;
import org.example.travel.factorybean.ClientServiceImpl;

public class DefaultServiceLocator {

    private static ClientServiceImpl clientService = new ClientServiceImpl();
    private static AccountServiceImpl accountService = new AccountServiceImpl();

    public ClientServiceImpl createClientServiceInstance() {
        return clientService;
    }
    public AccountServiceImpl createAccountServiceInstance() {
        return accountService;
    }
}