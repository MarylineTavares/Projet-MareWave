import './Calendar.css'
import { useState, useEffect } from "react";
import Arrivee from '../images/Arrivee.png';
import Bateau from '../images/Bateau.png';
import Chemin from '../images/Chemin.png';
import Depart from '../images/Depart.png';
import {Link} from 'react-router-dom';
import {Routes, Route} from 'react-router-dom';
import Booking from './Booking';
import Alert from '@mui/material/Alert';
import { useForm } from 'react-hook-form';
import {Paper} from '@mui/material';
import Moment from 'react-moment';
import 'moment/locale/fr'

function Calendar (){
  // Récupérer la liste des ports dans la base de données
  const [departurePorts, setDeparturePorts] = useState([]);
  const [arrivalPorts, setArrivalPorts] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch ('http://localhost:8080/departure_ports')
      const data = await response.json();
      setDeparturePorts(data);
    };
    fetchData();
    }, [])
  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch ('http://localhost:8080/arrival_ports')
      const data = await response.json();
      setArrivalPorts(data);
    };
    fetchData();
    }, [])

    //Récupérer la date du jour pour filtrer les résultats sur les dates de départ postérieures à la date du jour
    const date = new Date();
    function today (){
      const year=date.getFullYear();
      const month=date.getMonth()+1;
      const day=date.getDay();
      
      if(month<10 && day <10){
        return (year+'-'+0+month+'-'+0+day)
      }
      else if(month<10 && day>10){
        return (year+'-'+0+month+'-'+day)
      }

      else if(month>10 && day<10){
        return (year+'-'+month+'-'+0+day)
      }
      else {return (year+'-'+month+'-'+day)}
    }
  
    //Récupérer les données du formulaire
  const [departure, setDeparture] = useState("");
  const [arrival, setArrival] = useState("");
  const [departureDate, setDepartureDate] = useState("");
  const [arrivalDate, setArrivalDate] = useState("");
  const [type, setType] = useState('');
  const [results, setResults] = useState([]);
  const [isResultsLoading, setIsResultsLoading] = useState(true);
  const {
    register,
    formState: {isValid},
  } = useForm({defaultValues:{
    departure:"",
    arrival:"",
  }}); // Le formulaire peut être soumis uniquement si les informations obligatoires sont completées
  const handleClick = (event) => { 
    event.preventDefault()
    if (departureDate) {
      fetch(`http://localhost:8080/calendar?departure=${departure}&arrival=${arrival}&departureDate=${departureDate}`)
        .then(response => (response.json()))
        .then(data => {setResults(data);
                      setIsResultsLoading(false)})
        .catch(error => console.error(error))
    } 
    else if (arrivalDate){
      fetch(`http://localhost:8080/calendar?departure=${departure}&arrival=${arrival}&arrivalDate=${arrivalDate}`)
        .then(response => (response.json()))
        .then(data => {setResults(data);
                      setIsResultsLoading(false)})
        .catch(error => console.error(error))
    }
    else if (!departureDate && !arrivalDate){
      fetch(`http://localhost:8080/calendar?departure=${departure}&arrival=${arrival}`)
        .then(response => (response.json()))
        .then(data => {setResults(data);
                      setIsResultsLoading(false)})
        .catch(error => console.error(error))
    }}

    //Affichage du résultat de la recherche
    function result(){
      if (isResultsLoading) return null;
      if (results.length){
        return (
          <div className="results">
            {results
            .filter((result)=>{
              return (result.departureDate>=today())}) 
            .map((result,index)=>(
              <li key={index}>
                <div className='datas'>
                  <div className='data'>
                    <div className='data-img'><img src={Depart} alt='depart'/></div>
                    <div className='data-img'><img src={Chemin} alt='chemin'/></div>
                    <div className='data-img'><img src={Bateau} alt='bateau'/></div> 
                    <div className='data-img'><img src={Chemin} alt='chemin'/></div>
                    <div className='data-img'><img src={Arrivee} alt='arrivee'/></div>  
                  </div>
                  <div className='data'>            
                    <div className='data-text'>{departure}</div>
                    <div className='data-text data-date'><Moment format="LL" locale="fr">{result.departureDate}</Moment></div>
                    <div className='data-text'>{arrival}</div>  
                    <div className='data-text data-date'><Moment format="LL" locale="fr">{result.arrivalDate}</Moment></div>
                  </div>
                  <div className="data">
                    <div className='data-additional'>Reference: {result.reference}</div>
                    <div className='data-additional'>Temps de transit: <Moment diff={result.departureDate} unit="days">{result.arrivalDate}</Moment> jours </div>
                  </div>
                  <div className="data">
                    <Link to="/reservation" state={{origin:departure, destination: arrival}} className="data-button" style={{textDecoration:'none'}}> Réserver </Link>
                  </div>
                  <Routes>
                    <Route path="/reservation" element={Booking}/>
                  </Routes>
                </div>
              </li>
            ))}
          </div>
        )}   
        return(<div className="empty">Aucun résultat</div>)    
    }

  return (
    <div className="calendar">
       <Paper elevation={3} sx={{padding:'30px 30px', width: 800, margin: "20px auto"}}>
      <h2>| Consulter le calendrier </h2>
      <div className="search-container">
        <Alert severity="warning" sx={{width:"100%"}}> 
            Veuillez completer l'ensemble des informations obligatoires (*)
        </Alert><br/>
        <div className="search-inner">
          <label>Origine *</label><br/>
          <input placeholder="Port, Ville, Pays" type="text" className="input-text" name="departure"
            {...register("departure",{required:true})}
            id="departure"
            value = {departure}
            onChange = {(event) => setDeparture (event.target.value)}
          />
          <div className="dropdown">
            {departure &&
              departurePorts.filter(port => port.departure.toLowerCase().includes(departure.toLowerCase()) && port.departure.toLowerCase() !== departure.toLowerCase())
              .slice(0,10)
              .map((port,index) => (<div key={index} onClick={(e) => setDeparture (port.departure)}>{port.departure}</div>))}
          </div>
        </div>
        
        <div className="search-inner">
          <label>Destination *</label><br/>
          <input placeholder="Port, Ville, Pays" type="text" className="input-text" name="arrival"
            {...register("arrival",{required:true})}
            id="arrival"
            value = {arrival}
            onChange = {(event) => setArrival (event.target.value)}
          />
          <div className="dropdown">
            {arrival &&
              arrivalPorts.filter(port => port.arrival.toLowerCase().includes(arrival.toLowerCase()) && port.arrival.toLowerCase() !== arrival.toLowerCase())
              .slice(0,10)
              .map((port,index) => (<div key={index} onClick={(e) => setArrival (port.arrival)}>{port.arrival}</div>))}
          </div>  
        </div>
        
        <div className="search-calendar">
          <label>Recherche sur</label><br/>
          <select onChange={(event)=>setType(event.target.value)} className="select-text">
            <option value=""></option>
            <option value="depart">Départ</option>
            <option value="arrivee">Arrivée</option>
          </select>
        </div>

        <div className="search-calendar">
          {type === "depart" && (
          <div className="search">
            <label>Date</label>
            <div className="col-sm-5">
              <input type="date" className="form-control" name="todate" placeholder="JJ/MM/AAAA" value={departureDate} onChange={(event)=>setDepartureDate(event.target.value)}/>
            </div>
          </div>
          )}
        </div>

        <div className="search-calendar">
          {type === "arrivee" && (
          <div className="search">
            <label>Date</label>
            <div className="col-sm-5">
              <input type="date" className="form-control" name="todate" placeholder="JJ/MM/AAAA" value={arrivalDate} onChange={(event)=>setArrivalDate(event.target.value)}/>
            </div>
          </div>
          )}
        </div>
    
        <div>
          <button disabled={!isValid} onClick={handleClick}>Rechercher</button>
        </div>   
          {result()}
        </div>  
        </Paper>
    </div>
  )
}

export default Calendar