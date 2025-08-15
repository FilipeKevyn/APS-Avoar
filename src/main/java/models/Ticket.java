package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    private String classAirplane;
    private LocalDate date;
    private Double value;

    private List<Flight> flights = new ArrayList<>();
    private Payment payment;

    public Ticket(String classAirplane, String date, Double value) {
        this.classAirplane = classAirplane;
        this.date = LocalDate.parse(date);
        this.value = value;
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

    public String toString() {
        return String.format("Data: %s | Classe: %s | Valor: R$ %.2f", date, classAirplane, value);
    }
}
