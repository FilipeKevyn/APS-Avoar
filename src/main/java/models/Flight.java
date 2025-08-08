package models;

import java.io.Serializable;
import java.time.LocalDate;

public class Flight implements Serializable {
    private String code;
    private LocalDate departureDate;
    private LocalDate arrivalDate;

    private Airplane airplane;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
