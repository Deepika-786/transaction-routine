package com.pismo.transaction.service.impl;

import com.pismo.transaction.exception.ResourceNotFoundException;
import com.pismo.transaction.model.Account;
import com.pismo.transaction.repository.AccountRepository;
import com.pismo.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(String documentNumber) {
        Account account = new Account();
        account.setDocumentNumber(documentNumber);
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            return account.get();
        } else {
            throw new ResourceNotFoundException("Account not found for id: " + accountId);
        }
    }
}
