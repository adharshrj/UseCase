import './App.css';
import MyHome from './Components/MyHome';
import React, {useState, useEffect} from 'react'
import MyAdminLogin from './Components/Admin/MyAdminLogin';
import MyStudentLogin from './Components/Student/MyStudentLogin';
import MyProfLogin from './Components/Prof/MyProfLogin';
import MyAdminDashboard from './Components/Admin/Admin Dashboard/MyAdminDashboard';
import MyProfDashboard from './Components/Prof/Prof Dashboard/MyProfDashboard';
import MyStudentDashboard from './Components/Student/Student Dashboard/MyStudentDashboard';
import MyRegister from './Components/Register/MyRegister';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom"
import EventBus from "./Common/EventBus";
import ManageStudent from './Components/Prof/Prof Dashboard/StudentControl';
import {getCurrentUser,logout} from "./Components/Services/auth.service";
import AdminManageStudent from "./Components/Admin/AdminStudentControl"
import AdminManageProf from './Components/Admin/AdminProfControl';
import PayDash from './Components/Student/Student Payment/PayDash';
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
                <Route path='/home' component={MyHome} />
                <Route path='/admin' component={MyAdminLogin} />
                <Route path='/prof' component={MyProfLogin} />
                <Route path='/student' component={MyStudentLogin} />
                <Route protected path="/studentdash" component={MyStudentDashboard} />
                <Route protected path="/profdash" component={MyProfDashboard} />
                <Route protected path="/database/student" component={ManageStudent} />
                <Route protected path="/admindash" component={MyAdminDashboard}/>
                <Route protected path="/register" component={MyRegister}/>
                <Route protected path="/admindatabase/student" component={AdminManageStudent} />
                <Route protected path="/database/prof" component={AdminManageProf} />
                <Route protected path="/payment" component={PayDash}/>
    </Switch>
    </div>
    </Router>
  );
}


export default App;
