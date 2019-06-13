package com.evolutivo.flightmanagement.domain.impl;

import com.evolutivo.flightmanagement.domain.IFlightRequestHandler;
import com.evolutivo.flightmanagement.domain.model.FlightRequest;
import com.evolutivo.flightmanagement.domain.model.type.FlightRequestStatus;
import com.evolutivo.flightmanagement.repository.IFlightRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FlightRequestHandler implements IFlightRequestHandler {

    @Autowired
    private IFlightRequestRepository flightRequestRepository;

    @Override
    public FlightRequest createFlightRequest(FlightRequest flightRequest) {
        return flightRequestRepository.save(flightRequest);
    }

    @Override
    public FlightRequest reserveFlightRequest(FlightRequest flightRequest) {
        flightRequest.setStatus(FlightRequestStatus.RESERVED.toString());
        flightRequest.setReservedDate(new Timestamp(System.currentTimeMillis()));
        return flightRequestRepository.save(flightRequest);
    }
}
