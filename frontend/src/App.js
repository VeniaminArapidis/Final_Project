
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AddPerson from './Buttons/AddPerson';
import AddItem from './Buttons/AddItem';
import UpdatePerson from './Buttons/UpdatePerson';
import UpdateItem from './Buttons/UpdateItem';
import MakeAnOrder from './Buttons/MakeAnOrder';
import Orders from './pages/Orders';



function App() {
  return (
    <div className="App">

      <Router>
      <Navbar />
      <Routes>
        <Route exact path = "/" element={<Home/>}/>
        <Route exact path= "/orders" element={<Orders/>}/>
        <Route exact path="/addPerson" element={<AddPerson/>}/>
        <Route exact path="/addItem" element={<AddItem/>}/>
        <Route exact path="/updatePerson/:personID" element={<UpdatePerson/>}/>
        <Route exact path="/updateItem/:itemId" element={<UpdateItem/>}/>
        <Route exact path="/makeAnOrder/" element={<MakeAnOrder/>}/>
      </Routes>
      </Router>
      
      
    </div>
  );
}

export default App;
