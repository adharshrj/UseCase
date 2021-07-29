import { render } from 'react-dom';
import React, { useState, useEffect } from "react";
import { Form, FormControl, Button, FormGroup,FormLabel, Alert } from "react-bootstrap";
import "./MyStudentLogin.css";
import MyStudentDashboard from './Student Dashboard/MyStudentDashboard';
import {BrowserRouter as Router, Route, Switch,useHistory} from "react-router-dom"
export default function MyStudentLogin() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const validateFormFields = () => {
      return username.length > 0 && password.length > 0;
  }


  const handleSubmit = (event) => {
      event.preventDefault();
      
  }
  
  return (
      <div className="MyStudentLogin" align = "center">
          <h1> Welcome Student </h1>
          <Form onSubmit={handleSubmit}>
              <FormGroup controlId="Username" bssize="large">
                  <FormLabel>Username: </FormLabel>
                  <FormControl
                      autoFocus
                      type="text"
                      value={username}
                      onChange={e => setUsername(e.target.value)}
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
              <Button className = "formb" variant="custom" block bssize="large" disabled={!validateFormFields()} type="submit" >
                  Login
              </Button>
          </Form>
      </div>
  );
}
render(<MyStudentLogin />, document.getElementById('root'));