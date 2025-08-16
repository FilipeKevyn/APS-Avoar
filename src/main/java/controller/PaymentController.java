package controller;

import models.Payment;

public class PaymentController {
    public Payment verifyPayment(double valueRecived, double valueChanged){
        Payment payment = new Payment();
        payment = payment.verifyPayment(valueRecived, valueChanged);
        return payment;
    }
}
