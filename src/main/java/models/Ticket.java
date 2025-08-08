package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    private String code;
    private String seat;
    private String classAirplane;
    private LocalDate date;
    private Double value;

    private List<Flight> flights = new ArrayList<>();
    private Payment payment;

    public Ticket(String code, String seat, String classAirplane, LocalDate date) {
        this.code = code;
        this.seat = seat;
        this.classAirplane = classAirplane;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getClassAirplane() {
        return classAirplane;
    }

    public void setClassAirplane(String classAirplane) {
        this.classAirplane = classAirplane;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return String.format(
                "------------- Ticket %s --------------\n" +
                        "Assento: %-15s %s\n" +
                        "Classe:  %-15s R$ %.2f\n",
                code,
                seat, date,
                classAirplane, value
        );
    }
}
