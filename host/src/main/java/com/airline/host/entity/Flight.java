package com.airline.host.entity;

import com.airline.host.entity.enums.FlightStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Flight {

    private @Id Integer id;
    private FlightStatus status;
    private String flightName;
    private Double price;
    private Integer noOfHops;
    private SeatMatrix seatMatrix;
}
