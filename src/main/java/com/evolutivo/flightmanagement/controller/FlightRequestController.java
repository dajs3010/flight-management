package com.evolutivo.flightmanagement.controller;

import com.evolutivo.flightmanagement.application.IFlightRequestService;
import com.evolutivo.flightmanagement.application.dto.FlightRequestDTO;
import com.evolutivo.flightmanagement.domain.model.FlightRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FlightRequestController {

    @Autowired
    private IFlightRequestService flightRequestService;

    @GetMapping("/flight-request")
    public List<FlightRequest> findByStatus(@RequestParam String status) {
        return flightRequestService.findByStatus(status.toUpperCase());
    }

    @PostMapping("flight-request")
    public FlightRequest createFlightRequest(@RequestBody FlightRequestDTO flightRequestDTO) {
        return flightRequestService.createFlightRequest(flightRequestDTO);
    }

    @PutMapping("flight-request/{id}/reserve")
    public ResponseEntity reserveFlightRequest(@PathVariable Integer id) {
        final Optional<FlightRequest> flightRequest = flightRequestService.reserveFlightRequest(id);
        if (flightRequest.isPresent()) return ResponseEntity.ok(flightRequest.get());
        return ResponseEntity.badRequest().body("Can't find the flight request with id: " + id);
    }

}
