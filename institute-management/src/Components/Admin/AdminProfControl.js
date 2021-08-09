import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

export default function AdminManageProf() {
  const [resn, setResult] = useState([]);
  const [res1, setResult1] = useState([]);
  useEffect((toInput) => {
    fetch("http://localhost:4200/api/prof/all", {
			method : "POST",
			cache : "no-cache",
			credentials : "include",
			headers : {
				"Content-Type":"application/json"
			},
			redirect : "follow",
			referrerPolicy: "no-referrer", // no-referrer, *client
	      	body: JSON.stringify(toInput)

    	}).then(resn => resn.json()).then(data => {
      console.log(data);
      setResult(data);
    }).catch(e => {
      console.error("ERR ...");
      console.error(e);
    }).finally(() => {
      console.log("I am in finally");
    })

  }, [res1])
  const deleteUser = (e) => {
    e.preventDefault();
    const id = e.target.id;
    console.log(id);
    const url = `http://localhost:4200/api/prof/${id}`
    axios.delete(url)
      .then(res1 => {
        console.log(res1);
        setResult1(res1.data);
        console.log(res1.data);
      })
  }
  return (
    <div>
      <div className="container-xl ">
        <div className="col-lg-13">
          <div className="card">
            <div className="card-header" style={{color:"white",backgroundColor:"blue"}}><h4>PROFESSOR LIST</h4></div>
            <div className="card-body">
              <table className="table table-bordered table-dark">
                <thead>
                  <tr className="table-dark">
                 
                  <th scope="col">Id</th>
                    <th scope="col">Firstname</th>
                    <th scope="col">Lastname</th>
                    <th scope="col">Department</th>
                    <th scope="col">Type</th>
                  </tr>
                </thead>
                <tbody>
                  {resn.map((x) => {
                    return <tr >
                      <td ><label key={x.id}>{x.id}</label></td>
                      <td ><label key={x.fname}>{x.fname}</label></td>
                      <td ><label key={x.lname}>{x.lname}</label></td>
                      <td ><label key={x.department}>{x.department}</label></td>
                      <td ><label key={x.type}>{x.type}</label></td>
                      <td ><button className="btn btn-primary active" id={x.id} onClick={deleteUser}>delete</button></td>
                    </tr>
                  })}


                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}