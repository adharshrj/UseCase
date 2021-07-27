import React from 'react'
import MySchoolHome from './MySchoolHome';
import MyNavbar from './MyNavbar';
import MyFooter from './MyFooter';
export default function School() {
    return (
        <div>
            <div><MyNavbar /></div>
            <div><MySchoolHome /></div>
            <div><MyFooter /></div>
        </div>
    )
}
