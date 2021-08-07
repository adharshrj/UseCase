import './App.css';
import MyHome from './Components/MyHome';
import React, {useState, useEffect} from 'react'
import MyAdminLogin from './Components/Admin/MyAdminLogin';
import MyStudentLogin from './Components/Student/MyStudentLogin';
import MyProfLogin from './Components/Prof/MyProfLogin';
import MyAdminDashboard from './Components/Admin/Admin Dashboard/MyAdminDashboard';
import MyProfDashboard from './Components/Prof/Prof Dashboard/MyProfDashboard';
import MyStudentDashboard from './Components/Student/Student Dashboard/MyStudentDashboard';
import TestLogin from './Components/TestLogin';
import MyRegister from './Components/Register/MyRegister';
import StudentList from './Components/Prof/Prof Dashboard/StudentList';
import {BrowserRouter as Router, Route, Switch,Redirect} from "react-router-dom"
import EventBus from "./Common/EventBus";
import {getCurrentUser,login,logout} from "./Components/Services/auth.service"
const App = () => {
  const [showProfBoard, setShowProfBoard] = useState(false);
  const [showAdminBoard, setShowAdminBoard] = useState(false);
  const [showStudentBoard, setShowStudentBoard] = useState(false);
  const [currentUser, setCurrentUser] = useState(undefined);

  useEffect(() => {
    const user = getCurrentUser();

    if (user) {
      setCurrentUser(user);
      setShowProfBoard(user.roles.includes("ROLE_PROF"));
      setShowAdminBoard(user.roles.includes("ROLE_ADMIN"));
      setShowStudentBoard(user.roles.includes("ROLE_STUDENT"))
    }

    EventBus.on("logout", () => {
      logOut();
    });

    return () => {
      EventBus.remove("logout");
    };
  }, []);

  const logOut = () => {
    logout();
    setShowStudentBoard(false)
    setShowProfBoard(false);
    setShowAdminBoard(false);
    setCurrentUser(undefined);
  };

  return (
    <Router>
    <div className="App">
   
    

    <Switch>
                <Route exact path='/' component={MyHome} />
                <Route path='/admin' component={MyAdminLogin} />
                <Route path='/prof' component={MyProfLogin} />
                <Route path='/student' component={MyStudentLogin} />
                <Route protected path="/studentdash" component={MyStudentDashboard} />
                <Route protected path="/profdash" component={MyProfDashboard} />
                <Route protected path="/admindash" component={MyAdminDashboard}/>
    </Switch>
    </div>
    </Router>
  );
}


export default App;
