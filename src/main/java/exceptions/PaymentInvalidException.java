package exceptions;

public class PaymentInvalidException extends IllegalArgumentException{
    public PaymentInvalidException(String msg) {
        super(msg);
    }
}
