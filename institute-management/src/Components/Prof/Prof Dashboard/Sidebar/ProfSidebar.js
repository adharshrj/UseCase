import React, { useState } from "react";
import {BrowserRouter as Router, useHistory} from "react-router-dom"
import {ProSidebar,Menu,MenuItem,SidebarHeader,SidebarFooter,SidebarContent} from "react-pro-sidebar";
import { FaCalendar, FaCalendarAlt, FaElementor} from "react-icons/fa";
import { FiHome, FiLogOut, FiArrowLeftCircle, FiArrowRightCircle } from "react-icons/fi";
import { BiCog } from "react-icons/bi";
import "react-pro-sidebar/dist/css/styles.css";
import "./ProfSidebar.css"



export default function ProfSidebar() {
    const [menuCollapse, setMenuCollapse] = useState(false)
    const menuIconClick = () => {
        menuCollapse ? setMenuCollapse(false) : setMenuCollapse(true);
    };

    var history = useHistory();
    const handleAtt = () =>{
        history.push("/database/student");
              window.location.reload();
    }

    const handlehome = () =>{
        history.push("/profdash");
              window.location.reload();
    }

    const handlelogout = () =>{
        history.push("/home");
        window.location.reload();
    }
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
         
                        <MenuItem button icon={<FiHome />} onClick = {handlehome}>
                            Home
                        </MenuItem>
                
              
                        <MenuItem icon={<FaCalendarAlt />}>Time Table</MenuItem>
                 
                        <MenuItem icon={<FaCalendar />} onClick={handleAtt}>Attendance</MenuItem>
                   
                        <MenuItem icon={<FaElementor />}>Remarks</MenuItem>
                   
                        <MenuItem icon={<BiCog />}>Settings</MenuItem>
                    
                    </Menu>
                </SidebarContent>
                <SidebarFooter>
                    <Menu iconShape="square">
                        <MenuItem icon={<FiLogOut />} onClick={handlelogout}>Logout</MenuItem>
                    </Menu>
                </SidebarFooter>
            </ProSidebar>
        </div>
        </Router>
    );
};
