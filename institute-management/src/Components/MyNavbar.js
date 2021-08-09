import React, {useState} from 'react'
import MyAdminLogin from './Admin/MyAdminLogin';
import MyProfLogin from './Prof/MyProfLogin';
import MyStudentLogin from './Student/MyStudentLogin';
import {Navbar, Nav, NavDropdown, Form, FormControl, Button} from 'react-bootstrap';
import './MyNavbar.css'
import {Modal} from 'react-bootstrap'
export default function MyNavbar() {

    const [showa, setShowa] = useState(false);
    const [shows, setShows] = useState(false);
    const [showp, setShowp] = useState(false);
    const handleAClose = () => setShowa(false);
    const handleSClose = () => setShows(false);
    const handlePClose = () => setShowp(false);
    const handleAShow = () => setShowa(true);
    const handleSShow = () => setShows(true);
    const handlePShow = () => setShowp(true);
    return (
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
                                <NavDropdown.Item onClick={handleAShow}>Administrator</NavDropdown.Item>
                                <NavDropdown.Item onClick={handlePShow}>Professor</NavDropdown.Item>
                                <NavDropdown.Item onClick={handleSShow}>Student</NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                            <Button variant="outline-success">Search</Button>
                        </Form>
                    </Navbar.Collapse>
                </Navbar>
                <Modal size="md" show={showa} onHide={handleAClose} backdrop="static" keyboard={false}>
                    <Modal.Header closeButton>
                        <h2> Welcome Admininstrator </h2>
                        </Modal.Header>
                        <MyAdminLogin/>
                        </Modal>
                <Modal size="md" show={showp} onHide={handlePClose} backdrop="static" keyboard={false}>
                    <Modal.Header closeButton>
                        <h2> Welcome Professor </h2>
                        </Modal.Header>
                        <MyProfLogin/>
                        </Modal>
                <Modal size="md"  show={shows} onHide={handleSClose} backdrop="static" keyboard={false}>
                    <Modal.Header closeButton>
                        <h2> Welcome Student </h2>
                        </Modal.Header>
                        <MyStudentLogin/>
                        </Modal>
            </div>     
    )
}
