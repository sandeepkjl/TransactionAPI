package com.example.wipro.ModernizedNewPaymentPlatform.service;

import com.example.wipro.ModernizedNewPaymentPlatform.model.Customer;
import com.example.wipro.ModernizedNewPaymentPlatform.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorizationService {

    @Autowired
    private PaymentRepository repository;


    public List<Customer> getCustomers(String customerId){

        List<Customer> iterable= repository.findByCustomerId(customerId);
        List<Customer> customers =new ArrayList<Customer>();
        for(Customer account: iterable)
        {
            customers.add(account);
        }
        return customers;

    }

    public String findPasswordForCustomerId(String password){
        return repository.getPassword(password);
    }

}
