package repositories;

import models.Airplane;
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
        // Criando aviões para os voos
        Airplane airplane1 = new Airplane("Boeing 737", "Gol", 180);
        Airplane airplane2 = new Airplane("Airbus A320", "Latam", 200);
        Airplane airplane3 = new Airplane("Boeing 777", "Emirates", 350);
        Airplane airplane4 = new Airplane("Embraer E195", "Azul", 120);

        Flight flight1 = new Flight(airplane1, "São Paulo", "Rio de Janeiro", 300);
        flight1.setCode("123");
        flight1.setDepartureDate(LocalDate.of(2025, 8, 20));
        flight1.setArrivalDate(LocalDate.of(2025, 8, 20));

        Flight flight2 = new Flight(airplane2, "Brasília", "Salvador", 350);
        flight2.setCode("456");
        flight2.setDepartureDate(LocalDate.of(2025, 9, 5));
        flight2.setArrivalDate(LocalDate.of(2025, 9, 6));

        Flight flight3 = new Flight(airplane3, "Dubai", "São Paulo", 500);
        flight3.setCode("789");
        flight3.setDepartureDate(LocalDate.of(2025, 12, 15));
        flight3.setArrivalDate(LocalDate.of(2025, 12, 16));

        Flight flight4 = new Flight(airplane4, "Curitiba", "Florianópolis", 280);
        flight4.setCode("321");
        flight4.setDepartureDate(LocalDate.of(2026, 1, 10));
        flight4.setArrivalDate(LocalDate.of(2026, 1, 10));

        flights.add(flight2);
        flights.add(flight1);
        flights.add(flight3);
        flights.add(flight3);
    }
}
