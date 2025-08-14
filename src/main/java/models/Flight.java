package models;

import java.io.Serializable;
import java.time.LocalDate;

public class Flight implements Serializable {
    private String code;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String departureCity;
    private String arrivalCity;
    private double priceEconomic;
    private double priceExecutive;
    private double priceFirstClass;


    private Airplane airplane;

    public Flight(Airplane airplane, String departureCity, String arrivalCity, double defaultPrice){
        this.airplane = airplane;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        setPrices(defaultPrice);
    }

    private void setPrices(double defaultPrice) {
        priceFirstClass = defaultPrice * 1.70;
        priceExecutive = defaultPrice * 1.25;
        priceEconomic = defaultPrice * 1.05;
    }
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

    public double getPriceEconomic() {
        return priceEconomic;
    }

    public void setPriceEconomic(double priceEconomic) {
        this.priceEconomic = priceEconomic;
    }

    public double getPriceExecutive() {
        return priceExecutive;
    }

    public void setPriceExecutive(double priceExecutive) {
        this.priceExecutive = priceExecutive;
    }

    public double getPriceFirstClass() {
        return priceFirstClass;
    }

    public void setPriceFirstClass(double priceFirstClass) {
        this.priceFirstClass = priceFirstClass;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    @Override
    public String toString() {
        return String.format(
                "Voo %s: %s -> %s",
                code,
                departureCity,
                arrivalCity
        );
    }
}
