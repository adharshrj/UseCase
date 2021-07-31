import React from 'react'
import ProfSidebar from './Sidebar/ProfSidebar'
import {BrowserRouter as Router, Route, Switch} from "react-router-dom"
import StudentEdit from './StudentEdit'
import StudentList from './StudentList'
import School from '../../School'
export default function MyProfDashboard() {
    return (
        <Router>
            <ProfSidebar/> 
        <Switch>
          <Route path='/' exact={true} component={MyProfDashboard}/>
          <Route path='/student' exact={true} component={StudentList}/>
          <Route path='/student/:id' component={StudentEdit}/>
          <Route path='/logout' component={School}/>

        </Switch>
      </Router>
        
    )
}
