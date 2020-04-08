package com.example.wipro.ModernizedNewPaymentPlatform.service;

import com.example.wipro.ModernizedNewPaymentPlatform.Exception.AccountNotFoundException;
import com.example.wipro.ModernizedNewPaymentPlatform.Exception.BalanceNotSufficientException;
import com.example.wipro.ModernizedNewPaymentPlatform.model.Customer;
import com.example.wipro.ModernizedNewPaymentPlatform.model.PaymentRequest;
import com.example.wipro.ModernizedNewPaymentPlatform.model.PaymentResponse;
import com.example.wipro.ModernizedNewPaymentPlatform.model.TransactionDetail;
import com.example.wipro.ModernizedNewPaymentPlatform.repository.PaymentRepository;
import com.example.wipro.ModernizedNewPaymentPlatform.repository.TransactionRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional(rollbackFor = Exception.class)
    public PaymentResponse startPayment(PaymentRequest request){
        //check from and to account id exist
        validateFromAndToAccount(request);

        //check balance is available or not.
        checkBalance(request);

        paymentRepository.updateFromAccount(request.getBalance(), request.getFromAccountId());
        paymentRepository.updateToAccount(request.getBalance(), request.getToAccountId());


        //store transaction in to tx table
        int paymentId=storeTransction(request);


        return mappedResponse(request,paymentId);



    }

    private void validateFromAndToAccount(PaymentRequest request){
        Customer customer=null;
        customer= paymentRepository.findByAccountId(request.getFromAccountId());
        if(customer==null){
            throw new AccountNotFoundException("From account Not Found");
        }

        customer=paymentRepository.findByAccountId(request.getToAccountId());
        if(customer==null){
            throw new AccountNotFoundException("To Account Not Found");
        }

    }

    private void checkBalance(PaymentRequest request){
       Customer customer= paymentRepository.findByAccountId(request.getFromAccountId());
       if(customer.getBalanceAmount()<request.getBalance()==true){
           throw new BalanceNotSufficientException("Balance is not sufficent to intiate transaction.");
       }

    }


    private int storeTransction(PaymentRequest request){
        Customer customer=paymentRepository.findByAccountId(request.getFromAccountId());
        TransactionDetail txDetail = new TransactionDetail(
                customer.getCustomerId(),customer.getAccountId(),request.getBalance()
                ,customer.getEmail(),customer.getAddress(),customer.getPhone(),new Date());

        TransactionDetail detail=transactionRepository.save(txDetail);

        return detail.getTranscationId();

    }

    private PaymentResponse mappedResponse(PaymentRequest request, int paymentId){
        PaymentResponse response=new PaymentResponse(String.valueOf(paymentId),
                request.getFromAccountId(),request.getToAccountId(),request.getBalance());
        return response;

    }


}
