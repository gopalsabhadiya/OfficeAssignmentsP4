package com.airline.host.repository;

import com.airline.host.entity.Flight;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends ReactiveCrudRepository<Flight, Integer> {
}
