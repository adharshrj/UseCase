import React from 'react'
import { render } from 'react-dom';
import './MySchoolHome.css';
import {BrowserRouter as Router, Route, Switch,Redirect} from "react-router-dom"



export default function MySchoolHome() {
  return (
    <Router>
       <Switch>
            <Redirect exact from="/" to="/home" />
              <Route path="/home" />      
        </Switch>      
    
   
    </Router>   
    
  );
}
render(<MySchoolHome />, document.getElementById('root'));