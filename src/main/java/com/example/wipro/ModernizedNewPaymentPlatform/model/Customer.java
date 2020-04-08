package com.example.wipro.ModernizedNewPaymentPlatform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @Column(name = "CUSTOMER_ID")
    private String customerId;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "BALANCE_AMOUNT")
    private double balanceAmount;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String Address;
    @Column(name = "PHONE")
    private String phone;

    public Customer() {
    }

    public Customer(String accountId, String customerId, String password, double balanceAmount, String email, String address, String phone) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.password = password;
        this.balanceAmount = balanceAmount;
        this.email = email;
        Address = address;
        this.phone = phone;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
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

    @Override
    public String toString() {
        return "Customer{" +
                "accountId=" + accountId +
                ", customerId='" + customerId + '\'' +
                ", password='" + password + '\'' +
                ", balanceAmount='" + balanceAmount + '\'' +
                ", email='" + email + '\'' +
                ", Address='" + Address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
