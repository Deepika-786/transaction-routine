package com.pismo.transaction.service;

import com.pismo.transaction.model.Transaction;

public interface TransactionService {

    Transaction createTransaction(Long accountId, Long operationTypeId, Double amount);
}
