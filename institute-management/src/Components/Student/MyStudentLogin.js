import { render } from 'react-dom';
import React, { useState, useRef } from "react";
import { Form, FormControl, Button, FormGroup,FormLabel } from "react-bootstrap";
import "./MyStudentLogin.css";
import MyStudentDashboard from './Student Dashboard/MyStudentDashboard';
import { Redirect } from 'react-router';
import AuthService from "./Services/auth.service";
import CheckButton from "react-validation/build/button";
export default function MyStudentLogin(props) {
    
    const form = useRef();
    const checkBtn = useRef();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState("");

    const onChangeUsername = (e) => {
        const username = e.target.value;
        setUsername(username);
    };
    
    const onChangePassword = (e) => {
        const password = e.target.value;
        setPassword(password);
    };
    const validateFormFields = () => {
        return username.length > 0 && password.length > 0;
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        setMessage("");
        setLoading(true);
    
        form.current.validateAll();
        if (checkBtn.current.context._errors.length === 0) {
            AuthService.login(username, password).then(
              () => {
                props.history.push("/profile");
                window.location.reload();
              },
              (error) => {
                const resMessage =
                  (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                  error.message ||
                  error.toString();
      
                setLoading(false);
                setMessage(resMessage);
              }
            );
          } else {
            setLoading(false);
          }
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
                        value={username}
                        onChange={onChangeUsername}
                    />
                </FormGroup>
                <FormGroup controlId="password" bsSize="large">
                    <FormLabel>Password: </FormLabel>
                    <FormControl
                        value={password}
                        onChange={onChangePassword}
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