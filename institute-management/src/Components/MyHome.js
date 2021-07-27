import React from 'react'
import { render } from 'react-dom';
import Typical from 'react-typical'
import './MyHome.css';

export default function MyHome() {
  return (
    <div>
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
    </div >
  
  );
}
render(<MyHome />, document.getElementById('root'));