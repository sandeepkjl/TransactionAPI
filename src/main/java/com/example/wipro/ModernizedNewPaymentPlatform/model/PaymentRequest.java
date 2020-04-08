package com.example.wipro.ModernizedNewPaymentPlatform.model;

public class PaymentRequest {

    private String fromAccountId;
    private String toAccountId;
    private double balance;

    public PaymentRequest() {
    }

    public PaymentRequest(String fromAccountId, String toAccountId, double balance) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.balance = balance;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "fromAccountId='" + fromAccountId + '\'' +
                ", toAccountId='" + toAccountId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
