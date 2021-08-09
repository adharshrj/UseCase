import React, { useState } from "react";
import {ProSidebar,Menu,MenuItem,SidebarHeader,SidebarFooter,SidebarContent} from "react-pro-sidebar";
import { FaDatabase, FaList, FaListAlt, FaPlus, FaPlusCircle, FaPlusSquare, FaRegHeart } from "react-icons/fa";
import { FiHome, FiLogOut, FiArrowLeftCircle, FiArrowRightCircle, FiDatabase } from "react-icons/fi";
import { RiDatabase2Fill, RiPencilLine } from "react-icons/ri";
import { BiCog } from "react-icons/bi";
import "react-pro-sidebar/dist/css/styles.css";
import "./AdminSidebar.css"
import { useHistory } from "react-router-dom";
import {Modal} from 'react-bootstrap'
import MyRegister from "../../../Register/MyRegister";
export default function AdminSidebar() {

    const [shows, setShows] = useState(false);
    const [showp, setShowp] = useState(false);
  
    const handleSClose = () => setShows(false);
    const handlePClose = () => setShowp(false);

    const handleSShow = () => setShows(true);
    const handlePShow = () => setShowp(true);

    const [menuCollapse, setMenuCollapse] = useState(false)
    const menuIconClick = () => {
        menuCollapse ? setMenuCollapse(false) : setMenuCollapse(true);
    };
    var history=useHistory();
    const handlehome = () =>{
        history.push("/admindash");
        window.location.reload();
    }

    const handlelogout = () =>{
        history.push("/home");
        window.location.reload();
    }

    const handleAtt = () =>{
        history.push("database/student");
              window.location.reload();
    }

    
    const handlePtt = () =>{
        history.push("database/prof");
              window.location.reload();
    }
    return (
        <div id="header">

            <ProSidebar collapsed={menuCollapse}>
                <SidebarHeader>
                    <div className="logotext">
                    <p>{menuCollapse ? "Admin" : "Administrator"}</p>
                    </div>
                    <div className="closemenu" onClick={menuIconClick}>
                        {menuCollapse ? (<FiArrowRightCircle />) : (<FiArrowLeftCircle />)}
                    </div>
                </SidebarHeader>
                <br/>
                <SidebarContent>
                    <Menu iconShape="square">
                        <MenuItem icon={<FiHome />}onClick={handlehome}>Home</MenuItem>
                        <MenuItem icon={<FaPlus />}onClick={handleSShow}>Register Student</MenuItem>
                        <MenuItem icon={<FaPlusCircle />} onClick={handlePShow}>Register Professor</MenuItem>
                        <MenuItem icon={<RiDatabase2Fill />} onClick={handleAtt}>Student DB</MenuItem>
                        <MenuItem icon={<FiDatabase/>}onClick={handlePtt}>Professor DB</MenuItem>
                        <MenuItem icon={<BiCog />}>Settings</MenuItem>
                    </Menu>
                </SidebarContent>
                <SidebarFooter>
                    <Menu iconShape="square">
                        <MenuItem icon={<FiLogOut />}onClick={handlelogout}>Logout</MenuItem>
                    </Menu>
                </SidebarFooter>
            </ProSidebar>
            <Modal size="md" show={showp} onHide={handlePClose} backdrop="static" keyboard={false}>
                    <Modal.Header closeButton>
                        <h2> Register Professor </h2>
                        </Modal.Header>
                        <MyRegister/>
                        </Modal>
                <Modal size="md"  show={shows} onHide={handleSClose} backdrop="static" keyboard={false}>
                    <Modal.Header closeButton>
                        <h2> Register Student </h2>
                        </Modal.Header>
                        <MyRegister/>
                        </Modal>
        </div>
    );
};
