package com.evolutivo.flightmanagement.domain.model;

import com.evolutivo.flightmanagement.domain.model.type.FlightRequestStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "flight_request", schema = "public", catalog = "iqkxrnao")
public class FlightRequest {
    private int id;
    private String name;
    private Timestamp travelDate;
    private String destination;
    private String status;
    private Timestamp requestDate;
    private Timestamp reservedDate;

    protected FlightRequest(String name, Timestamp travelDate, String destination, String status, Timestamp requestDate) {
        this.name = name;
        this.travelDate = travelDate;
        this.destination = destination;
        this.status = status;
        this.requestDate = requestDate;
    }

    protected FlightRequest() {
    }

    public static FlightRequest createFlightRequest(String name, Timestamp travelDate, String destination) {
        return new FlightRequest(name, travelDate, destination, FlightRequestStatus.NEW.toString(),
                new Timestamp(System.currentTimeMillis()));
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "travel_date")
    public Timestamp getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Timestamp travelDate) {
        this.travelDate = travelDate;
    }

    @Basic
    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "request_date")
    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    @Basic
    @Column(name = "reserved_date")
    public Timestamp getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Timestamp reservedDate) {
        this.reservedDate = reservedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightRequest that = (FlightRequest) o;

        if (id != that.id) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(travelDate, that.travelDate)) return false;
        if (!Objects.equals(destination, that.destination)) return false;
        if (!Objects.equals(status, that.status)) return false;
        if (!Objects.equals(requestDate, that.requestDate)) return false;
        if (!Objects.equals(reservedDate, that.reservedDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (travelDate != null ? travelDate.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
        result = 31 * result + (reservedDate != null ? reservedDate.hashCode() : 0);
        return result;
    }
}
