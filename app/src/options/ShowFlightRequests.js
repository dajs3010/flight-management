import React from 'react';
import axios from 'axios';
import {toast} from 'react-toastify';
import {Button, Table} from 'reactstrap';
import * as Constants from '../Constants';

class ShowFlightRequests extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            flightRequests: []
        };
    }

    componentWillReceiveProps(nextProps, nextState) {
        this.getFlightRequests();
    }

    getFlightRequests = () => {
        axios.get(`${Constants.BASE_URL}/api/v1/flight-request?status=${this.props.status}`)
            .then(response => {
                this.setState({flightRequests: response.data});
            })
            .catch(error => {
                toast.error("There was an error getting the Flight Requests!");
                console.error(error);
            });
    };

    componentDidMount() {
        this.getFlightRequests();
    };

    reserveFlightRequest = (id) => {
        axios.put(`${Constants.BASE_URL}/api/v1/flight-request/${id}/reserve`)
            .then(response => {
                toast.success("Flight Request Reserved! Please go to the Reserved Flight Requests Tab to see it.");
                this.getFlightRequests();
            })
            .catch(error => {
                toast.error("There was an error reserving the Flight Request!");
                console.error(error);
            });
    };

    formatDate = (date) => {
        const minutes = date.getMinutes() < 10 ? `0${date.getMinutes()}` : `${date.getMinutes()}`;
        return `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()} ${date.getHours()}:${minutes}`;
    };

    render() {

        const {flightRequests} = this.state;

        return (
            <div className="px-5 py-3">
                <Table striped bordered responsive>
                    <thead>
                    <tr>
                        <th>Applicant Name</th>
                        <th>Destination</th>
                        <th>Travel Date</th>
                        <th>Request Date</th>
                        {this.props.status === Constants.NEW ? <th>Actions</th> : <th>Reserved Date</th>}
                    </tr>
                    </thead>
                    <tbody>
                    {flightRequests.map(flightRequest => {
                        const {id, name, destination, travelDate, requestDate, reservedDate} = flightRequest;
                        const formattedTravelDate = this.formatDate(new Date(travelDate));
                        const formattedRequestDate = this.formatDate(new Date(requestDate));
                        const formattedReservedDate = this.formatDate(new Date(reservedDate));
                        return <tr key={id}>
                            <td>{name}</td>
                            <td>{destination}</td>
                            <td>{formattedTravelDate}</td>
                            <td>{formattedRequestDate}</td>
                            {this.props.status === Constants.NEW ?
                                <td>
                                    <Button color="primary"
                                            onClick={() => this.reserveFlightRequest(id)}>Reserve</Button>
                                </td> : <td>{formattedReservedDate}</td>}
                        </tr>;
                    })}
                    </tbody>
                </Table>
            </div>
        );
    }

}

export default ShowFlightRequests;