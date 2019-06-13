package com.evolutivo.flightmanagement.application.impl;

import com.evolutivo.flightmanagement.application.IFlightRequestService;
import com.evolutivo.flightmanagement.application.dto.FlightRequestDTO;
import com.evolutivo.flightmanagement.domain.IFlightRequestHandler;
import com.evolutivo.flightmanagement.domain.model.FlightRequest;
import com.evolutivo.flightmanagement.repository.IFlightRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightRequestService implements IFlightRequestService {

    @Autowired
    private IFlightRequestRepository flightRequestRepository;

    @Autowired
    private IFlightRequestHandler flightRequestHandler;

    @Override
    public List<FlightRequest> findByStatus(String status) {
        return flightRequestRepository.findByStatusOrderByRequestDateAsc(status);
    }

    @Override
    public FlightRequest createFlightRequest(FlightRequestDTO flightRequestDTO) {
        final FlightRequest flightRequest =
                FlightRequest.createFlightRequest(flightRequestDTO.name, flightRequestDTO.travelDate,
                        flightRequestDTO.destination);
        return flightRequestHandler.createFlightRequest(flightRequest);
    }

    @Override
    public Optional<FlightRequest> reserveFlightRequest(Integer id) {
        final Optional<FlightRequest> optionalFlightRequest = flightRequestRepository.findById(id);
        return optionalFlightRequest.map(flightRequest -> flightRequestHandler.reserveFlightRequest(flightRequest));
    }
}
