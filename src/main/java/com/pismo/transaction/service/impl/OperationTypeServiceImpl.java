package com.pismo.transaction.service.impl;


import com.pismo.transaction.exception.ResourceNotFoundException;
import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.repository.OperationTypeRepository;
import com.pismo.transaction.service.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationTypeServiceImpl implements OperationTypeService {

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    @Override
    public OperationType createOperationType(Long operationTypeId, String description) {
        OperationType operationType = new OperationType();
        operationType.setOperationTypeId(operationTypeId);
        operationType.setDescription(description);
        return operationTypeRepository.save(operationType);
    }

    @Override
    public OperationType getOperationTypeById(Long operationId) {
        Optional<OperationType> operationType = operationTypeRepository.findById(operationId);
        if (operationType.isPresent()) {
            return operationType.get();
        } else {
            throw new ResourceNotFoundException("Operation Type not found for id: " + operationType);
        }
    }
}
