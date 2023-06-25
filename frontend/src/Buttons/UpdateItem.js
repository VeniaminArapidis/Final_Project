import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';

export default function UpdateItem() {

            let navigate = useNavigate();
            
            const {itemId} = useParams();

        const[item,setItem]=useState({
            itemName:""
        })

        const{itemName}=item;

        const onInputChange=(e)=>{

            setItem({...item,[e.target.name]: e.target.value});
        
        };

        useEffect(()=>{
            loadItem()
        },[])

        const onSubmit = async (e)=>{
            e.preventDefault();
            await axios.put(`http://localhost:8080/item/${itemId}`,item)
            navigate("/");
        };

        const loadItem = async () =>{
            const result = await axios.get(`http://localhost:8080/item/${itemId}`)
            setItem(result.data)
        }


  return (
    <div className="container">
        <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center m-4">Update Item</h2>
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
