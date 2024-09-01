package com.pismo.transaction.controller;

import com.pismo.transaction.model.Account;
import com.pismo.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody String documentNumber) {
        Account account = accountService.createAccount(documentNumber);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
        Account account = accountService.getAccountById(accountId);
        return ResponseEntity.ok(account);
    }
}
