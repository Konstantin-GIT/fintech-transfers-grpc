package com.workout.service;

import com.workout.grpc.AccountBalanceServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final AccountBalanceServiceClient accountBalanceServiceClient;
    @Override
    public void createPayment(String debitAccount, String creditAccount, String transferAmount) {


        String resultDebitAccount = accountBalanceServiceClient.changeAccountBalance(debitAccount, transferAmount );

        String resultCreditAccount = accountBalanceServiceClient.changeAccountBalance(creditAccount, transferAmount );

        System.out.println("resultDebitAccount = " + resultDebitAccount);
        System.out.println("resultCreditAccount = " + resultCreditAccount);

    }

}
