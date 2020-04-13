package com.airline.host.controller;

import com.airline.host.entity.Flight;
import com.airline.host.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public Flux<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @PostMapping
    public Mono<Flight> saveFlight(@RequestBody Flight flight){
        return flightService.saveFlight(flight);
    }
}
