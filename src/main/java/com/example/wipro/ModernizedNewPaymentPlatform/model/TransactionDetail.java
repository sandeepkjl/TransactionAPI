package com.example.wipro.ModernizedNewPaymentPlatform.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION_DETAIL_TDS")
public class TransactionDetail {

    @GeneratedValue
    @Id
    private int transcationId;

    private String customerId;
    private String accountId;
    private double debitedAmount;
    private String email;
    private String Address;
    private String phone;
    private Date timestamp;


    public TransactionDetail() {
    }

    public TransactionDetail(String customerId, String accountId, double debitedAmount,
                             String email, String address, String phone, Date timestamp) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.debitedAmount = debitedAmount;
        this.email = email;
        Address = address;
        this.phone = phone;
        this.timestamp = timestamp;
    }

    public int getTranscationId() {
        return transcationId;
    }

    public void setTranscationId(int transcationId) {
        this.transcationId = transcationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getDebitedAmount() {
        return debitedAmount;
    }

    public void setDebitedAmount(double debitedAmount) {
        this.debitedAmount = debitedAmount;
    }

    @Override
    public String toString() {
        return "TransactionDetail{" +
                "transcationId=" + transcationId +
                ", customerId='" + customerId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", debitedAmount='" + debitedAmount + '\'' +
                ", email='" + email + '\'' +
                ", Address='" + Address + '\'' +
                ", phone='" + phone + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
