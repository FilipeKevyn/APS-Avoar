package controller;

import models.Payment;

public class PaymentController {
    public boolean verifyPayment(double valueRecived, double valueChanged){
        return new Payment("Pix").verifyPayment(valueRecived, valueChanged);
    }
}
