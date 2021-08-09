import React, { useState, useRef } from "react";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import Form from "react-validation/build/form";
import "./MyProfLogin.css";
import {useHistory} from "react-router-dom"
import {login} from "../Services/auth.service";
import "./MyProfLogin.css"
const required = (value) => {
    if (!value) {
      return (
        <div className="alert alert-danger" role="alert">
          This field is required!
        </div>
      );
    }
  };
export default function MyProfLogin() {
    const form = useRef();
    const checkBtn = useRef();
    
    const [profname, setProfName] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState("");


    const onChangeProfName = (e) => {
        const profname = e.target.value;
        setProfName(profname);
      };
    
      const onChangePassword = (e) => {
        const password = e.target.value;
        setPassword(password);
      };

    const history = useHistory();

    const handleLogin = (e) => {
        e.preventDefault();
    
        setMessage("");
        setLoading(true);
        
        form.current.validateAll();
       
        if (checkBtn.current.context._errors.length === 0) {
          login(profname, password).then(
            () => {
              history.push("/profdash");
              window.location.reload();
            }, (error) => {
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
        <div className="MyProfLogin" align = "center">
            <Form onSubmit={handleLogin} ref={form}>
          <div className="form-group">
            <label htmlFor="username">Username</label>
            <Input
              type="text"
              className="form-control"
              name="username"
              value={profname}
              onChange={onChangeProfName}
              validations={[required]}
            />
          </div>

          <div className="form-group">
            <label htmlFor="password">Password</label>
            <Input
              type="password"
              className="form-control"
              name="password"
              value={password}
              onChange={onChangePassword}
              validations={[required]}
            />
          </div>

          <div className="form-group">
            <button className="btn-custom" disabled={loading}>
              {loading && (
                <span className="spinner-border spinner-border-sm"></span>
              )}
              <span>Login</span>
            </button>
          </div>

          {message && (
            <div className="form-group">
              <div className="alert-danger" role="alert">
                {message}
              </div>
            </div>
          )}
          <CheckButton style={{ display: "none" }} ref={checkBtn} />
        </Form>
        </div>
    );
}