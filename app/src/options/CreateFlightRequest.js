import React from 'react';
import {Button, Col, Form, FormGroup, Input, Label, Row} from 'reactstrap';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import axios from 'axios';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import * as Constants from '../Constants';

class CreateFlightRequest extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            destination: '',
            travelDate: new Date(),
            invalidForm: true
        };
    }

    onChangeName = (event) => {
        this.setState({name: event.target.value})
    };

    onChangeDestination = (event) => {
        this.setState({destination: event.target.value})
    };

    onChangeTravelDate = (date) => {
        this.setState({travelDate: date})
    };

    saveFlightRequest = () => {
        axios.post(`${Constants.BASE_URL}/api/v1/flight-request`, {
            "name": this.state.name,
            "travelDate": this.state.travelDate,
            "destination": this.state.destination
        })
            .then(response => {
                toast.success("Flight Request Saved!");
                this.setState({
                    name: '',
                    destination: '',
                    travelDate: new Date(),
                });
            })
            .catch(error => {
                toast.error("There was an error saving the Flight Request!");
                console.error(error);
            });
    };

    render() {

        const invalidForm = (this.state.name === null || this.state.name === '') ||
            (this.state.destination === null || this.state.destination === '') ||
            (this.state.travelDate === null || this.state.travelDate === '');

        return (
            <div className="px-5 py-3">
                <Form>
                    <FormGroup>
                        <Label for="name">Applicant Name</Label>
                        <Input name="name" id="name" placeholder="Enter name"
                               value={this.state.name} maxLength={50}
                               onChange={this.onChangeName}/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="destination">Destination</Label>
                        <Input name="destination" id="destination" placeholder="Enter destination"
                               value={this.state.destination} maxLength={50}
                               onChange={this.onChangeDestination}/>
                    </FormGroup>
                    <FormGroup>
                        <Row>
                            <Col>
                                <Label for="travelDate">Travel Date</Label>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <DatePicker
                                    id="travelDate"
                                    minTime={new Date()}
                                    minDate={new Date()}
                                    selected={this.state.travelDate}
                                    timeInputLabel="Time:"
                                    onChange={this.onChangeTravelDate}
                                    dateFormat="MM/dd/yyyy h:mm aa"
                                    showTimeInput
                                />
                            </Col>
                        </Row>
                    </FormGroup>
                    <FormGroup>
                        <Button disabled={invalidForm} color="primary" onClick={this.saveFlightRequest}>Save</Button>
                    </FormGroup>
                </Form>
            </div>
        );
    }

}

export default CreateFlightRequest;