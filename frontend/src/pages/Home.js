import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useParams } from 'react-router-dom';

export default function Home() {

    const [people,setPeople] = useState([])

    const {personID} = useParams();

    useEffect(()=>{
        loadPeople();
    },[]);

    const loadPeople = async() =>{
        const result =await axios.get("http://localhost:8080/peopleAll/")
        setPeople(result.data);
    };

    const deletePerson = async (personID) =>{
        await axios.delete(`http://localhost:8080/peopleDel/${personID}`)
        loadPeople()
    }



    //Item 
    const [items, setItem] = useState([])

    const {itemId}=useParams();

    useEffect(()=>{
        loadItem();
    },[]);
    
    const loadItem = async() =>{
        const itemResult = await axios.get("http://localhost:8080/items/")
        setItem(itemResult.data);
    }


    const deleteItem = async (itemId) =>{
        await axios.delete(`http://localhost:8080/items/${itemId}`)
        loadItem()
    }


  return (
    <div>
        <div className="container">Customer
            <div className="py-4">
                <table className="table border shadow">
                    <thead>
                        <tr>
                        <th scope="col">A/A</th>
                        <th scope="col">Person ID</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                            {
                                people.map((person, index)=>(
                                    <tr>
                                        <th scope="row" key={index}>{index + 1}</th>
                                        <td>{person.personID}</td>
                                        <td>{person.firstName}</td>
                                        <td>{person.lastName}</td>
                                        <td>{person.email}</td>
                                        <td>
                                            <Link className="btn btn-outline-primary mx-2"
                                            to={`/updatePerson/${person.personID}`}
                                            >Update</Link>
                                            <button className="btn btn-danger mx-2"
                                            onClick={()=>deletePerson(person.personID)}
                                            >Delete</button>
                                        </td>
                                    </tr>

                                ))
                            } 
                    </tbody>
                </table>
            </div>
        
        </div>
        <div className="container">Items
            <div className="py-4">
                    <table className="table border shadow">
                        <thead>
                            <tr>
                            <th scope="col">A/A</th>
                            <th scope="col">Item ID</th>
                            <th scope="col">Item Name</th>
                            <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>

                                {
                                    items.map((item, index)=>(
                                        <tr>
                                            <th scope="row" key={index}>{index + 1}</th>
                                            <td>{item.itemId}</td>
                                            <td>{item.itemName}</td>
                                            <td>
                                                <Link className="btn btn-outline-primary mx-2"
                                                to={`/updateItem/${item.itemId}`}
                                                >Update</Link>
                                                <button className="btn btn-danger mx-2"
                                                onClick={()=>deleteItem(item.itemId)}
                                                >Delete</button>
                                            </td>
                                        </tr>

                                    ))
                                }
                            
                        </tbody>
                    </table>
            </div>
        </div>
    </div>

    
  )
}
