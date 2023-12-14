package com.workout.service;

public interface PaymentService {
    void createPayment(String debitAccount, String creditAccount, String transferAmount);
}
