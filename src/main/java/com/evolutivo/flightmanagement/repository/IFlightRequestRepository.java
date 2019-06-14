package com.evolutivo.flightmanagement.repository;

import com.evolutivo.flightmanagement.domain.model.FlightRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightRequestRepository extends JpaRepository<FlightRequest, Integer> {

    List<FlightRequest> findByStatusOrderByRequestDateAsc(String status);

}
