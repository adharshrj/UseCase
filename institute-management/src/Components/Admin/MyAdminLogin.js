import { render } from 'react-dom';
import React, { useState } from "react";
import { Form, FormControl, Button, FormGroup,FormLabel } from "react-bootstrap";
import "./MyAdminLogin.css";
import MyAdminDashboard from './Admin Dashboard/MyAdminDashboard';

export default function MyAdminLogin() {
    const [adminname, setAdminName] = useState("");
    const [password, setPassword] = useState("");

    const validateFormFields = () => {
        return adminname.length > 0 && password.length > 0;
    }
    const handleSubmit = (event) => {
        event.preventDefault();
    }
    
    return (
        <div className="MyAdminLogin" align = "center">
            <h1> Welcome Administrator </h1>
            <Form onSubmit={handleSubmit}>
                <FormGroup controlId="Username" bssize="large">
                    <FormLabel>Username: </FormLabel>
                    <FormControl
                        autoFocus
                        type="text"
                        value={adminname}
                        onChange={e => setAdminName(e.target.value)}
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
                <Button className = "forma" variant="custom" block bssize="large" disabled={!validateFormFields()} type="submit" >
                    Login
                </Button>
            </Form>
        </div>
    );
}
render(<MyAdminLogin />, document.getElementById('root'));