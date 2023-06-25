import axios from 'axios';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export default function AddItem() {

            let navigate = useNavigate();

        const[item,setItem]=useState({
            itemName:""
        })

        const{itemName}=item;

        const onInputChange=(e)=>{

            setItem({...item,[e.target.name]: e.target.value});
        
        };

        const onSubmit = async (e)=>{
            e.preventDefault();
            try{
            await axios.post("http://localhost:8080/item",item)
            navigate("/");
            }
            catch(e){
                toast("Wow so easy!");
            }
        };


  return (
    <div className="container">
        <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center m-4">Add New Item</h2>
                <form onSubmit={(e)=>onSubmit(e)}>
                <div className="mb-3">
                    <label htmlFor="ItemName" className="form-label">
                    Item Name
                    </label>
                    <input type={"text"}
                    className="form-control"
                    placeholder="Enter item name"
                    name="itemName"
                    value={itemName}
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
