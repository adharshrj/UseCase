import { render } from 'react-dom';
import React, { useState } from "react";
import { Form, FormControl, Button, FormGroup,FormLabel } from "react-bootstrap";
import "./MyProfLogin.css";

export default function MyProfLogin() {
    const [profname, setProfName] = useState("");
    const [password, setPassword] = useState("");

    const validateFormFields = () => {
        return profname.length > 0 && password.length > 0;
    }
    const handleSubmit = (event) => {
        event.preventDefault();
    }
    
    return (
        <div className="MyProfLogin" align = "center">
            <h1> Welcome Professor </h1>
            <Form onSubmit={handleSubmit}>
                <FormGroup controlId="Username" bsSize="large">
                    <FormLabel>Username: </FormLabel>
                    <FormControl
                        autoFocus
                        type="text"
                        value={profname}
                        onChange={e => setProfName(e.target.value)}
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
                <Button className="formp" variant="custom" block bssize="large" disabled={!validateFormFields()} type="submit">
                    Login
                </Button>
            </Form>
        </div>
    );
}
render(<MyProfLogin />, document.getElementById('root'));