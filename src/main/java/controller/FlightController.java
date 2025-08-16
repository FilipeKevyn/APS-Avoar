package controller;

import models.Flight;
import repositories.FlightRepository;

import java.util.ArrayList;
import java.util.List;

public class FlightController {
    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlights(){
        return flightRepository.getAllFlights();
    }
}
