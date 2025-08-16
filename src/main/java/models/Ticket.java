package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    private String classAirplane;
    private LocalDate departureDate;
    private Double value;

    private List<Flight> flights = new ArrayList<>();
    private Payment payment;

    public Ticket(Flight flight, String classAirplane, Double value) {
        flights.add(flight);
        this.classAirplane = classAirplane;
        this.value = value;
    }

    public LocalDate getDepartureDate() {
        return flights.get(0).getDepartureDate();
    }

    public String getClassAirplane() {
        return classAirplane;
    }

    public void setClassAirplane(String classAirplane) {
        this.classAirplane = classAirplane;
    }

    public LocalDate getDate() {
        return departureDate;
    }

    public void setDate(LocalDate date) {
        departureDate = date;
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
        return String.format("Data: %s | Classe: %s | Valor: R$ %.2f", getDepartureDate(), classAirplane, value);
    }
}
