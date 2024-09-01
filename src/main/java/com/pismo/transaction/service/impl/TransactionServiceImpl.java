package com.pismo.transaction.service.impl;

import com.pismo.transaction.exception.ResourceNotFoundException;
import com.pismo.transaction.model.Account;
import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.repository.AccountRepository;
import com.pismo.transaction.repository.OperationTypeRepository;
import com.pismo.transaction.repository.TransactionRepository;
import com.pismo.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    @Override
    public Transaction createTransaction(Long accountId, Long operationTypeId, Double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for id: " + accountId));

        OperationType operationType = operationTypeRepository.findById(operationTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Operation type not found for id: " + operationTypeId));

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setOperationType(operationType);
        if(operationType.getOperationTypeId()==1 || operationType.getOperationTypeId()==2 || operationType.getOperationTypeId()==3){
            transaction.setAmount(-amount);
        }
        else if(operationType.getOperationTypeId()==4){
            transaction.setAmount(amount);
        }
        else {
            throw new RuntimeException("Operation type not found for id: " + operationTypeId);
        }
        transaction.setEventDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }
}
