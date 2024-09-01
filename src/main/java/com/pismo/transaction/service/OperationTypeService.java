package com.pismo.transaction.service;

import com.pismo.transaction.model.OperationType;

public interface OperationTypeService {
    OperationType createOperationType(Long operationTypeId, String description);
    OperationType getOperationTypeById(Long operationTypeId);
}
