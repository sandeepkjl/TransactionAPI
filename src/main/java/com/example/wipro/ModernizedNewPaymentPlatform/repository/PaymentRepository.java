package com.example.wipro.ModernizedNewPaymentPlatform.repository;

import com.example.wipro.ModernizedNewPaymentPlatform.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends CrudRepository<Customer, String> {



    Customer findByAccountId(String accountId);

    @Query(value = "SELECT  * FROM CUSTOMER WHERE CUSTOMER_ID=?1" , nativeQuery = true)
    List<Customer> findByCustomerId(String customerId);

    @Query(value = "SELECT PASSWORD FROM CUSTOMER WHERE CUSTOMER_ID=?1" , nativeQuery = true)
    public String getPassword(String customerId);



    @Modifying
    @Query(value = "UPDATE CUSTOMER SET BALANCE_AMOUNT = BALANCE_AMOUNT-?1 WHERE ACCOUNT_ID = ?2", nativeQuery = true)
    @Transactional
    public void updateFromAccount(double amount,String accountId);

    @Modifying
    @Query(value = "UPDATE CUSTOMER SET BALANCE_AMOUNT = BALANCE_AMOUNT+?1 WHERE ACCOUNT_ID = ?2", nativeQuery = true)
    @Transactional
    public void updateToAccount(double amount,String accountId);








}
