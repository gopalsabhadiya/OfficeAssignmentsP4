package com.airline.host.service;

import com.airline.host.entity.Flight;
import com.airline.host.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;


    public Flux<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Mono<Flight> saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }
}
