import React from 'react'
import { render } from 'react-dom';
import Typical from 'react-typical'
import './MyHome.css';
import MyNavbar from './MyNavbar';
import MyFooter from './MyFooter';
export default function MyHome() {
  return (
    <div>
       <MyNavbar/>
     
      <div className="Home">
        <img src={('./school.png')} alt="Leading Institute" />
      </div>
      <div className="typical">
        <h1>Leading Institute</h1>
        <p>
          <Typical
            loop={Infinity}
            wrapper='b'
            steps={[
              'Conceive',
              1000,
              'Believe',
              1000,
              'Achieve',
              1000
            ]} />
        </p>
       
      </div>
      <MyFooter />
    </div >
  
  );
}
render(<MyHome />, document.getElementById('root'));