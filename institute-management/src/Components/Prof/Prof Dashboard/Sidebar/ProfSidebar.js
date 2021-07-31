import React, { useState } from "react";
import {BrowserRouter as Router, Route, Switch,Redirect} from "react-router-dom"
import {ProSidebar,Menu,MenuItem,SidebarHeader,SidebarFooter,SidebarContent} from "react-pro-sidebar";
import { FaCalendar, FaCalendarAlt, FaElementor} from "react-icons/fa";
import {Button} from 'react-bootstrap';
import { FiHome, FiLogOut, FiArrowLeftCircle, FiArrowRightCircle } from "react-icons/fi";
import { BiCog } from "react-icons/bi";
import "react-pro-sidebar/dist/css/styles.css";
import "./ProfSidebar.css"
import { Link } from 'react-router-dom';
import StudentEdit from "../StudentEdit";
import StudentList from "../StudentList";
import MyProfDashboard from "../MyProfDashboard";

export default function ProfSidebar() {
    const [menuCollapse, setMenuCollapse] = useState(false)
    const menuIconClick = () => {
        menuCollapse ? setMenuCollapse(false) : setMenuCollapse(true);
    };

    return (
        <Router>
        <div id="header">

            <ProSidebar collapsed={menuCollapse}>
                <SidebarHeader>
                    <div className="logotext">
                    <p>{menuCollapse ? "Prof" : "Professor"}</p>
                    </div>
                    <div className="closemenu" onClick={menuIconClick}>
                        {menuCollapse ? (<FiArrowRightCircle />) : (<FiArrowLeftCircle />)}
                    </div><br/>
                </SidebarHeader>
                <SidebarContent>
                    <Menu iconShape="square">
         
                        <MenuItem button icon={<FiHome />}>
                            Home
                        </MenuItem>
                
              
                        <MenuItem icon={<FaCalendarAlt />}>
                            Time Table</MenuItem>
                 
                        <MenuItem icon={<FaCalendar />}>Attendance</MenuItem>
                   
                        <MenuItem icon={<FaElementor />}>Remarks</MenuItem>
                   
                        <MenuItem icon={<BiCog />}>Settings</MenuItem>
                    
                    </Menu>
                </SidebarContent>
                <SidebarFooter>
                    <Menu iconShape="square">
                        <MenuItem icon={<FiLogOut />}>Logout</MenuItem>
                    </Menu>
                </SidebarFooter>
            </ProSidebar>
        </div>
        </Router>
    );
};
