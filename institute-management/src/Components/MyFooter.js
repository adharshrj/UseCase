import React from 'react'
import './MyFooter.css'
export default function MyFooter() {
    return (
        <div className="footer">
        {/* <div className= "Box">
      <h1 style={{ color: "white", 
                   textAlign: "center", 
                   marginTop: "-50px" }}>
        Leading School
      </h1>
      <div className ="Container">
        <div className="Row">
          <div className="Column">
            <div className="Heading">About Us</div>
            
            <div className="FooterLink" href="#">Aim</div>
            <div className="FooterLink" href="#">Vision</div>
            <div className="FooterLink" href="#">Testmonials</div>
          </div>
          <div className="Column">
            <div className="Heading">Social Media</div>
                <div className="FooterLink" href="#">
                <i className="fab fa-facebook-f">
                    <span style={{ marginLeft: "10px" }}>
                    Facebook
                    </span>
                </i>
                </div>
                <div className="FooterLink" href="#">
                <i className="fab fa-instagram">
                    <span style={{ marginLeft: "10px" }}>
                    Instagram
                    </span>
                </i>
                </div>
                <div className="FooterLink" href="#">
                <i className="fab fa-twitter">
                    <span style={{ marginLeft: "10px" }}>
                    Twitter
                    </span>
                </i>
                </div>
                <div className="FooterLink" href="#">
                <i className="fab fa-youtube">
                    <span style={{ marginLeft: "10px" }}>
                    Youtube
                    </span>
                </i>
                </div>
          </div>
          <div className="Column">
            <div className="Heading">Contact Us</div>
            <div className="FooterLink" href="#">Aim</div>
            <div className="FooterLink" href="#">Vision</div>
            <div className="FooterLink" href="#">Testmonials</div>
          </div>
        </div>
        
      </div>
    </div> */}
    <div className='Copyright'>
      Copyright &copy; {new Date().getFullYear()} {' '}
        <a className='Adharsh' href="http://adharshrj.github.io">
          Adharsh RJ.  
        </a>
        <a> All Rights Reserved.</a>
      </div>
    </div>
    );
}
