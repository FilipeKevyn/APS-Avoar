package repositories;

import models.Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private List<Flight> flights = new ArrayList<>();

    public FlightRepository() {
        initilizationFligths();
    }

    public List<Flight> getAllFlights(){
        return flights;
    }

    private void initilizationFligths(){
        Flight flight1 = new Flight("São Paulo", "Rio de Janeiro", 300);
        flight1.setCode("123");
        flight1.setDepartureDate(LocalDate.of(2025, 8, 20));
        flight1.setArrivalDate(LocalDate.of(2025, 8, 20));

        Flight flight2 = new Flight("Brasília", "Salvador", 350);
        flight2.setCode("456");
        flight2.setDepartureDate(LocalDate.of(2025, 9, 5));
        flight2.setArrivalDate(LocalDate.of(2025, 9, 6));

        Flight flight3 = new Flight("Dubai", "São Paulo", 500);
        flight3.setCode("789");
        flight3.setDepartureDate(LocalDate.of(2025, 12, 15));
        flight3.setArrivalDate(LocalDate.of(2025, 12, 16));

        Flight flight4 = new Flight("Curitiba", "Florianópolis", 280);
        flight4.setCode("321");
        flight4.setDepartureDate(LocalDate.of(2026, 1, 10));
        flight4.setArrivalDate(LocalDate.of(2026, 1, 10));

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
    }
}
