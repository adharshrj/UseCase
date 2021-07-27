import { render } from 'react-dom';
import React, { useState } from "react";
import { Form, FormControl, Button, FormGroup,FormLabel } from "react-bootstrap";
import "./MyStudentLogin.css";
import MyStudentDashboard from './Student Dashboard/MyStudentDashboard';
import { Redirect } from 'react-router';

export default function MyStudentLogin() {
    const [studentname, setStudentName] = useState("");
    const [password, setPassword] = useState("");

    const validateFormFields = () => {
        return studentname.length > 0 && password.length > 0;
    }
    const handleSubmit = (event) => {
        event.preventDefault();
    };


    return (
 
            <div className = "slogin" align = "center">
            <h1> Welcome Student </h1>
            <Form onSubmit={handleSubmit} className = "slogin">
                <FormGroup controlId="Username" bsSize="large">
                    <FormLabel>Username: </FormLabel>
                    <FormControl
                        autoFocus
                        type="text"
                        value={studentname}
                        onChange={e => setStudentName(e.target.value)}
                    />
                </FormGroup>
                <FormGroup controlId="password" bsSize="large">
                    <FormLabel>Password: </FormLabel>
                    <FormControl
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                        type="password"
                    />
                </FormGroup>
                <Button className = "formb" variant="custom" block bssize="large" disabled={!validateFormFields()} type="submit">
                    Login
                </Button>
            </Form>
            </div>
    );
}
render(<MyStudentLogin />, document.getElementById('root'));