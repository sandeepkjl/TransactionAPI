package com.example.wipro.ModernizedNewPaymentPlatform.repository;

import com.example.wipro.ModernizedNewPaymentPlatform.model.TransactionDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionDetail,String> {

    TransactionDetail save(TransactionDetail detail);

    List<TransactionDetail> findByAccountId(String accountId);


}
