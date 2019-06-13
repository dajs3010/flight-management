import React, {Component} from 'react';
import './App.css';
import {BrowserRouter} from 'react-router-dom';
import classnames from 'classnames';
import CreateFlightRequest from './options/CreateFlightRequest';
import ShowFlightRequests from './options/ShowFlightRequests';
import {Button, Col, Input, Label, Nav, NavItem, NavLink, Row, TabContent, TabPane} from "reactstrap";
import * as Constants from './Constants';
import {toast, ToastContainer} from "react-toastify";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            activeTab: '1',
            password: '',
            user: '',
            lockSupervisorTabs: true
        };
    }

    toggle = (tab) => {
        if (this.state.activeTab !== tab) {
            this.setState({
                activeTab: tab
            });
        }
    };

    onChangeUser = (event) => {
        this.setState({user: event.target.value})
    };

    onChangePassword = (event) => {
        this.setState({password: event.target.value})
    };

    login = () => {
        if (this.state.password === Constants.SUPERVISOR_PASSWORD && this.state.user === Constants.SUPERVISOR_USER) {
            toast.success("Logged In Successfully");
            this.setState({lockSupervisorTabs: false});
        } else {
            toast.error("Invalid Credentials!");
        }
        this.setState({password: '', user: ''});
    };

    logout = () => {
        this.setState({password: '', user: '', lockSupervisorTabs: true});
    };

    render() {

        const {activeTab, lockSupervisorTabs, user, password} = this.state;
        const hideStyle = lockSupervisorTabs ? {} : {display:'none'};

        return (
            <div className="px-5 py-5">
                <BrowserRouter basename={process.env.REACT_APP_ROUTER_BASE || ''}>
                    <div>
                        <div>
                            <Row>
                                <Col className="col-4">
                                    <h2>Flight Management</h2>
                                </Col>
                                <Col className="text-right col-1" style={hideStyle}>
                                    <Label for="user">User</Label>
                                </Col>
                                <Col style={hideStyle}>
                                    <Input name="user" id="user" placeholder="Enter user name"
                                           value={user} maxLength={50}
                                           onChange={this.onChangeUser}/>
                                </Col>
                                <Col className="text-right col-1" style={hideStyle}>
                                    <Label for="password">Password</Label>
                                </Col>
                                <Col style={hideStyle}>
                                    <Input name="password" id="password" placeholder="Enter password"
                                           type="password"
                                           value={password} maxLength={50}
                                           onChange={this.onChangePassword}/>
                                </Col>
                                <Col className="col-1" style={hideStyle}>
                                    <Button color="primary" onClick={() => this.login()}>Login</Button>
                                </Col>
                                {lockSupervisorTabs ? null : <Col className="col-8 text-right">
                                    <Button color="secondary" onClick={() => this.logout()}>Logout</Button>
                                </Col>}
                            </Row>
                        </div>
                        <Nav tabs className="pt-4">
                            <NavItem>
                                <NavLink
                                    className={classnames({active: activeTab === '1'})}
                                    onClick={() => {
                                        this.toggle('1');
                                    }}
                                >
                                    Create Flight Request
                                </NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink disabled={lockSupervisorTabs}
                                         className={classnames({active: activeTab === '2'})}
                                         onClick={() => {
                                             this.toggle('2');
                                         }}
                                >
                                    New Flight Requests
                                </NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink disabled={lockSupervisorTabs}
                                         className={classnames({active: activeTab === '3'})}
                                         onClick={() => {
                                             this.toggle('3');
                                         }}
                                >
                                    Reserved Flight Requests
                                </NavLink>
                            </NavItem>
                        </Nav>
                        <TabContent activeTab={activeTab}>
                            <TabPane tabId="1">
                                <Row>
                                    <Col sm="12">
                                        <CreateFlightRequest/>
                                    </Col>
                                </Row>
                            </TabPane>
                            <TabPane tabId="2">
                                <Row>
                                    <Col sm="12">
                                        <ShowFlightRequests status={Constants.NEW}/>
                                    </Col>
                                </Row>
                            </TabPane>
                            <TabPane tabId="3">
                                <Row>
                                    <Col sm="12">
                                        <ShowFlightRequests status={Constants.RESERVED}/>
                                    </Col>
                                </Row>
                            </TabPane>
                        </TabContent>
                        <ToastContainer/>
                    </div>
                </BrowserRouter>
            </div>
        );

    }

}

export default App;
