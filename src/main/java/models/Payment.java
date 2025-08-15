package models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Payment implements Serializable {
    private String paymentMethod;
    private LocalDateTime dateTime;

    public Payment(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.dateTime = LocalDateTime.now();
    }

    public boolean verifyPayment(double valueReceived, double valueCharged){
        if (valueReceived == valueCharged) {
            return true;
        }
        return false;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
