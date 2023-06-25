import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function Orders() {


    //Order

    const [orders, setOrder] = useState([])


    useEffect(()=>{

        loadOrders();

    },[]);

    const loadOrders =async () =>{

        const result =await axios.get("http://localhost:8080/orders");
        setOrder(result.data);
    };

    const deleteOrder = async (orderId) =>{
        await axios.delete(`http://localhost:8080/orderDel/${orderId}`)
        loadOrders()
    }

    //Order Details

    const [orderDetails, setOrderDetails] = useState([])


    useEffect(()=>{

        loadOrderDetails();

    },[]);


    const loadOrderDetails = async () =>{

        const result = await axios.get("http://localhost:8080/orderDetails")
        setOrderDetails(result.data);
    }






  return (
    <div>
        <div className="container">Orders
            <div className="py-4">
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">A/A</th>
                            <th scope="col">Order ID</th>
                            <th scope="col">Order Date</th>
                            <th scope="col">Customer Email</th>
                            <th scope="col">Action</th>
                            
                        </tr>
                    </thead>
                    <tbody>

                        {

                            orders.map((order, index)=>(

                                <tr>
                                <th scope="row" key={index}>{index + 1}</th>
                                <td>{order.orderId}</td>
                                <td>{order.orderDate}</td>
                                <td>{order.email.email}</td>
                                <td>
                                    <button className="btn btn-danger mx-2"
                                                onClick={()=>deleteOrder(order.orderId)}>
                                                    Delete
                                    </button>
                                </td>
                                </tr>
                            ))
                        }
                    
                    </tbody>
                </table>
            </div>
        </div>
        <div className="container"> Order Details
            <div className="py-4">
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">A/A</th>
                            <th scope="col">Order Details ID</th>
                            <th scope="col">Order ID</th>
                            <th scope="col">Item ID</th>
                            <th scope="col">Quantity</th>
                        </tr>
                    </thead>
                    <tbody>

                        {
                            orderDetails.map((orderDetails, index)=>(

                               <tr>
                                <th scope="row" key={index}>{index + 1}</th>
                                <td>{orderDetails.orderDetailsId}</td>
                                <td>{orderDetails.orderId.orderId}</td>
                                <td>{orderDetails.itemId.itemId}</td>
                                <td>{orderDetails.quantity}</td>
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
