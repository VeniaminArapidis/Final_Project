import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export default function MakeAnOrder() {
    
    let navigate = useNavigate();
    toast.configure();

    const[order, setOrder]= useState({
        email: "",
        itemName: "",
        quantity: ""
    });

    const {email,itemName,quantity}=order;

    const onInputChange=(e)=>{
        setOrder({...order,[e.target.name]: e.target.value});
    };


    const onSubmit = async (e) =>{
        e.preventDefault();
        try{
            await axios.post("http://localhost:8080/makeAnOrder",order)
            navigate("/")
            toast.success("Order created successfully.")
        }
        catch(e){
            toast.error(e.response.data.error);
        }
    }



  return (
    <div className="container">
        <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className="text-center m-4">Make your Order</h2>
            <form onSubmit={(e)=>onSubmit(e)}>
                <div className="mb-3">
                    <label htmlFor="Email" className="form-label">
                    Customer E-mail
                    </label>
                    <input type={"email"}
                    className="form-control"
                    placeholder="Enter Customer E-mail"
                    name="email"
                    value={email}
                    onChange={(e)=>onInputChange(e)}
                    /> 
                </div>
                <div className="mb-3">
                    <label htmlFor="Item Name" className="form-label">
                    Item Name
                    </label>
                    <input type={"text"}
                    className="form-control"
                    placeholder="Enter Item Name"
                    name="itemName"
                    value={itemName}
                    onChange={(e)=>onInputChange(e)}
                    /> 
                </div>
                <div className="mb-3">
                    <label htmlFor="Quantity" className="form-label">
                    Quantity
                    </label>
                    <input type={"number"}
                    className="form-control"
                    placeholder="Enter Quantity"
                    name="quantity"
                    value={quantity}
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
