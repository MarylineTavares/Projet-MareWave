import React from 'react';
import {Routes, Route} from 'react-router-dom';
import Calendar from './components/Pages/Calendar';
import Needs from './components/Pages/Needs';
import Solutions from './components/Pages/Solutions';
import Tracking from './components/Pages/Tracking';
import Booking from './components/Pages/Booking';
import Group from './components/Pages/Group';
import Signup from './components/Pages/Signup';
import Signin from './components/Pages/Signin';
import Contacts from './components/Pages/Contacts';
import NavBar from './components/NavBar/NavBar';
import Home from './components/Pages/Home';

function App () {
  return (
      <div>
        <NavBar/>        
        <Routes>
          <Route path="/" exact Component={Home}/>
          <Route path="/vos_besoins" Component={Needs}/>
          <Route path="/nos_solutions" Component={Solutions}/>
          <Route path="/notre_groupe" Component={Group}/>
          <Route path="/se_connecter" Component={Signin}/>
          <Route path="/inscription" Component={Signup}/>
          <Route path="/contact" Component={Contacts}/>
          <Route path="/consulter_le_calendrier/*" Component={Calendar}/>
          <Route path="/reservation" Component={Booking}/>
          <Route path="/suivre_un_conteneur" Component={Tracking}/>
        </Routes>
      </div>
  )
};

export default App;