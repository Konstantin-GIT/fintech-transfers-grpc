package com.workout.controller;

import com.workout.dto.PaymentDto;
import com.workout.service.PaymentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import static com.workout.controller.PaymentController.PAYMENT_CONTROLLER_PATH;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${base-url}" + PAYMENT_CONTROLLER_PATH)
public class PaymentController {

    public static final String PAYMENT_CONTROLLER_PATH = "/payments";

    @Qualifier("PaymentServiceImpl")
    private final PaymentService paymentService;

    @PutMapping
    @ResponseStatus(OK)
    public String createPayment(@RequestBody @Valid PaymentDto paymentDto) {
        paymentService.createPayment(paymentDto.getDebitAccount(), paymentDto.getCreditAccount(), paymentDto.getTransferAmount());
        return "complied method createPayment";
    }
}
