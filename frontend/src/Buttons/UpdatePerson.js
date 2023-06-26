import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export default function UpdatePerson() {

          let navigate = useNavigate();
          toast.configure();

          const {personID}=useParams();

      const [people,setPeople]=useState({
        firstName:"",
        lastName:"",
        email:""
      })

      const{firstName,lastName,email}=people;

      const onInputChange=(e)=>{

        setPeople({...people,[e.target.name]: e.target.value});

      };

      useEffect(()=>{
        loadPeople();
      },[]);

      const onSubmit= async (e)=>{
          e.preventDefault();
          try{
              await axios.put(`http://localhost:8080/people/${personID}`,people)
              navigate("/");
              toast.success("Customer updated successfully.")
          }
          catch(e){
                toast.error(e.message);
          }
      };

      const loadPeople = async () => {
        try{
            const result = await axios.get(`http://localhost:8080/people/${personID}`)
            setPeople(result.data)
        }
        catch(e){
          toast.error(e.message);
        }
      }




  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
              <h2 className="text-center m-4">Update Customer</h2>
              <form onSubmit={(e)=>onSubmit(e)}>
              <div className="mb-3">
                <label htmlFor="FirstName" className="form-label">
                  First Name
                </label>
                <input type={"text"}
                className="form-control"
                placeholder="Enter your first name"
                name="firstName"
                value={firstName}
                onChange={(e)=>onInputChange(e)}
                /> 
              </div>
              <div className="mb-3">
                <label htmlFor="LastName" className="form-label">
                  Last Name
                </label>
                <input type={"text"}
                className="form-control"
                placeholder="Enter your last name"
                name="lastName"
                value={lastName}
                onChange={(e)=>onInputChange(e)}
                /> 
              </div>
              <div className="mb-3">
                <label htmlFor="Email" className="form-label">
                  Email
                </label>
                <input type={"text"}
                className="form-control"
                placeholder="Enter your email"
                name="email"
                value={email}
                onChange={(e)=>onInputChange(e)}
                /> 
              </div>
              <button type="submit" className="btn btn-outline-primary">
                Submit
              </button>
              <Link type="submit" className="btn btn-outline-danger mx-2" to="/">
                Cancel
              </Link>
              </form>
          </div>
        </div>
    </div>
  )
}
