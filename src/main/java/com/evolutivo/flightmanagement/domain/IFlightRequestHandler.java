package com.evolutivo.flightmanagement.domain;

import com.evolutivo.flightmanagement.domain.model.FlightRequest;

public interface IFlightRequestHandler {

    FlightRequest createFlightRequest(FlightRequest flightRequest);

    FlightRequest reserveFlightRequest(FlightRequest flightRequest);

}
