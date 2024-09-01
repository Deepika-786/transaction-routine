package com.pismo.transaction.service;

import com.pismo.transaction.model.Account;

public interface AccountService {

    Account createAccount(String documentNumber);
    Account getAccountById(Long accountId);
}
