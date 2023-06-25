import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
            <div className="container-fluid">
                <a className="navbar-brand" href="/">
                    Welcome Page
                </a>
                <button
                 className="navbar-toggler" 
                 type="button" data-bs-toggle="collapse" 
                 data-bs-target="#navbarSupportedContent" 
                 aria-controls="navbarSupportedContent" 
                 aria-expanded="false" 
                 aria-label="Toggle navigation"
                 >
                    <span className="navbar-toggler-icon"></span>
                </button>
                <Link className="btn btn-outline-light" to="/makeAnOrder">Make an Order</Link>
                <Link className="btn btn-outline-light mx-2" to="/addPerson">Add Person</Link>
                <Link className="btn btn-outline-light mx-2" to="/addItem">Add Item</Link>
                <Link className="btn btn-outline-light mx-2" to="/orders">Orders</Link>
            </div>
        </nav>
    </div>
 )
}
