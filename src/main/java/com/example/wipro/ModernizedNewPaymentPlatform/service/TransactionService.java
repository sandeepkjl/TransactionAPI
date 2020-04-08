package com.example.wipro.ModernizedNewPaymentPlatform.service;

import com.example.wipro.ModernizedNewPaymentPlatform.model.TransactionDetail;
import com.example.wipro.ModernizedNewPaymentPlatform.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<TransactionDetail> getTransactionById(String id){
        List<TransactionDetail> transactionDetails=repository.findByAccountId(id);

        return transactionDetails;
    }
}
