package com.evolutivo.flightmanagement.repository;

import com.evolutivo.flightmanagement.domain.model.FlightRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFlightRequestRepository extends JpaRepository<FlightRequest, Integer> {

    List<FlightRequest> findByStatusOrderByRequestDateAsc(String status);

}
