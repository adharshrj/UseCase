import React from 'react'
import MyAdminLogin from './Admin/MyAdminLogin';
import MyProfLogin from './Prof/MyProfLogin';
import MyStudentLogin from './Student/MyStudentLogin';
import {Navbar, Nav, NavDropdown, Form, FormControl, Button} from 'react-bootstrap';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom"
import MyHome from './MyHome';
import './MyNavbar.css'
export default function MyNavbar() {
    return (
        <Router>
            <div className="MyNavbar">
                <Navbar id = "nav-bar" variant="custom" expand="lg">
                    <Navbar.Brand href="/home"><img
                        src="/school.ico"
                        width="40"
                        height="30"
                        className="d-inline-block align-top"
                        alt="Leading Institute"
                    /></Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav">Menu</Navbar.Toggle>
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="mr-auto">
                            <Nav.Link id = "nav-link" href="/home">Home</Nav.Link>
                            <Nav.Link id = "nav-link" href="#About">About</Nav.Link>
                            <NavDropdown  title="Login" id="responsive-nav-dropdown">
                                <NavDropdown.Item href="/admin">Administrator</NavDropdown.Item>
                                <NavDropdown.Item href="/prof">Professor</NavDropdown.Item>
                                <NavDropdown.Item href="/student">Student</NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                            <Button variant="outline-success">Search</Button>
                        </Form>
                    </Navbar.Collapse>
                </Navbar>
            </div>     
            <Switch>
                <Route exact path='/' />
                <Route path='/home' component={MyHome} />
                <Route path='/admin' component={MyAdminLogin} />
                <Route path='/prof' component={MyProfLogin} />
                <Route path='/student' component={MyStudentLogin} />
            </Switch>
        </Router>
    )
}
