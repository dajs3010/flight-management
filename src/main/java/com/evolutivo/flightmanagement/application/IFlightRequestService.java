package com.evolutivo.flightmanagement.application;

import com.evolutivo.flightmanagement.application.dto.FlightRequestDTO;
import com.evolutivo.flightmanagement.domain.model.FlightRequest;

import java.util.List;
import java.util.Optional;

public interface IFlightRequestService {

    List<FlightRequest> findByStatus(String status);

    FlightRequest createFlightRequest(FlightRequestDTO flightRequestDTO);

    Optional<FlightRequest> reserveFlightRequest(Integer id);

}
