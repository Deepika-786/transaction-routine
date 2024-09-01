package com.pismo.transaction.controller;

import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pismo.transaction.dto.TransactionRequest;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequest transactionRequest) {
        Transaction transaction = transactionService.createTransaction(
                transactionRequest.getAccountId(),
                transactionRequest.getOperationTypeId(),
                transactionRequest.getAmount()
        );
        return ResponseEntity.ok(transaction);
    }
}
