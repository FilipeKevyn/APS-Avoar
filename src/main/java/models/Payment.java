package models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Payment implements Serializable {
    private String paymentMethod;
    private LocalDateTime dateTime;
    private String status = "pending";

    public Payment(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.dateTime = LocalDateTime.now();
        this.status = "done";
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
