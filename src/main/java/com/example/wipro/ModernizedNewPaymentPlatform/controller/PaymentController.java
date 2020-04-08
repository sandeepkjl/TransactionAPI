package com.example.wipro.ModernizedNewPaymentPlatform.controller;


import com.example.wipro.ModernizedNewPaymentPlatform.Exception.AuthorizationException;
import com.example.wipro.ModernizedNewPaymentPlatform.model.Customer;
import com.example.wipro.ModernizedNewPaymentPlatform.model.PaymentRequest;
import com.example.wipro.ModernizedNewPaymentPlatform.model.PaymentResponse;
import com.example.wipro.ModernizedNewPaymentPlatform.model.TransactionDetail;
import com.example.wipro.ModernizedNewPaymentPlatform.service.AuthorizationService;
import com.example.wipro.ModernizedNewPaymentPlatform.service.PaymentService;
import com.example.wipro.ModernizedNewPaymentPlatform.service.TransactionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private AuthorizationService authService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/payment", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<PaymentResponse> doPayment(@RequestBody PaymentRequest request,
                                                    @RequestHeader("CustoemrID") String customerId,
                                                    @RequestHeader("Password") String password ){

        //validate customer
        boolean authorized=validateCustomer(customerId,password);
        if(!authorized){
            throw new AuthorizationException("Either CutomerID or password is incorrect");

        }

        PaymentResponse response=paymentService.startPayment(request);

        return new ResponseEntity<PaymentResponse>(response,HttpStatus.CREATED);


    }

    @RequestMapping(value = "/getTransactionByAccountById/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<TransactionDetail>> getPayemnt(@PathVariable("id") String id){
        List<TransactionDetail> transactionDetails=transactionService.getTransactionById(id);
        return new ResponseEntity<List<TransactionDetail>>(transactionDetails,HttpStatus.OK);
    }


    //check customer is authorized ot not
    public boolean validateCustomer(String customerId, String password){
        boolean isAuthenticated=false;

        List<Customer> customers=authService.getCustomers(customerId);
        boolean customerExist=false;
        boolean isPasswordCorrect=false;
        for(Customer customer:customers){
            if(customer.getCustomerId().equals(customerId)){
                customerExist=true;
            }
        }

        String passwordForCustomer = authService.findPasswordForCustomerId( customerId);
        if(StringUtils.equalsIgnoreCase(passwordForCustomer,password)){
            isPasswordCorrect=true;
        }

        if(customerExist&& isPasswordCorrect){
            isAuthenticated=true;
        }

        return isAuthenticated;



    }

}
