import React, { useState } from "react";
import {ProSidebar,Menu,MenuItem,SidebarHeader,SidebarFooter,SidebarContent} from "react-pro-sidebar";
import { FaCalendarCheck} from "react-icons/fa";
import { FiHome, FiLogOut, FiArrowLeftCircle, FiArrowRightCircle, FiCalendar } from "react-icons/fi";
import { RiBankCardLine } from "react-icons/ri";
import { BiCog } from "react-icons/bi";
import "react-pro-sidebar/dist/css/styles.css";
import "./StudentSidebar.css"
import { useHistory } from "react-router-dom";
export default function StudentSidebar() {
    const [menuCollapse, setMenuCollapse] = useState(false)
    const menuIconClick = () => {
        menuCollapse ? setMenuCollapse(false) : setMenuCollapse(true);
    };

    var history = useHistory();

    const handlelogout = () =>{
        history.push("/home");
        window.location.reload();
    }

    const handlehome = () =>{
        history.push("/studentdash");
        window.location.reload();
    }


    return (
        <div id="header">

            <ProSidebar collapsed={menuCollapse}>
                <SidebarHeader>
                    <div className="logotext">
                    <p>{menuCollapse ? "Student" : "Student"}</p>
                    </div>
                    <div className="closemenu" onClick={menuIconClick}>
                        {menuCollapse ? (<FiArrowRightCircle />) : (<FiArrowLeftCircle />)}
                    </div><br/>
                </SidebarHeader>
                <SidebarContent>
                    <Menu iconShape="square">
                        <MenuItem active={true} icon={<FiHome />}>
                           <button className="btn" onClick={handlehome}>Home</button>
                        </MenuItem>
                        <MenuItem icon={<FiCalendar />}>Time Table</MenuItem>
                        <MenuItem icon={<FaCalendarCheck />}>Attendance</MenuItem>
                        <MenuItem icon={<RiBankCardLine />}><button className="btn" onClick={history.push("/student/payment")}>Fee Payment</button></MenuItem>
                        <MenuItem icon={<BiCog />}>Settings</MenuItem>
                    </Menu>
                </SidebarContent>
                <SidebarFooter>
                    <Menu iconShape="square">
                        <MenuItem icon={<FiLogOut />}><button className="btn" onClick={handlelogout}>Logout</button></MenuItem>
                    </Menu>
                </SidebarFooter>
            </ProSidebar>
        </div>
    );
};
