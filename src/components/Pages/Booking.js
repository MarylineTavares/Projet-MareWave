import './Booking.css'
import {useState, useEffect} from "react";
import { useLocation } from "react-router-dom";
import Alert from '@mui/material/Alert';
import { useForm } from 'react-hook-form';
import {Paper} from '@mui/material';
import { NumericFormat } from 'react-number-format';

function Booking (props){
    let location = useLocation();
    let departure = location.state.origin; // le port de départ correspond au résultat de la recherche précédente
    let arrival = location.state.destination; // le port de d'arrivée correspond au résultat de la recherche précédente
    const [coord1, setCoord1]  = useState(''); //récupération des coordonées géographiques du port de départ
    const [coord2, setCoord2]  = useState(''); //récupération des coordonées géographiques du port d'arrivée
    const {getDistance, convertDistance} = require ('geolib'); 
    const distance = convertDistance(getDistance(coord1,coord2, 1000),'km');// calcul de la distance en km entre le port de départ et d'arrivée
    
    //Récuperer les données du formulaire
    const [type, setType] = useState('');
    const [dimension, setDimension] = useState('');
    const [height, setHeight] = useState('');
    const [length, setLength] = useState('');
    const [width, setWidth] = useState('');
    const [quantity, setQuantity] = useState('');
    const [valueHT, setValueHT] = useState('');
    let volume = 0
    if (type==="conteneur_complet"){
        volume=dimension
    } else {volume=length*height*width}

    let price=0
    if (type==="conteneur_complet"&&dimension==="33"){
        price=volume*quantity*30+(0.021*distance)}
    else if (type==="conteneur_complet"&&dimension==="64"){
        price=volume*quantity*30+(0.021*distance)}
    else if (type==="conteneur_complet"&&dimension==="76"){
        price=volume*quantity*30+(0.021*distance)}
    else if (type==="conteneur_complet"&&dimension==="29"){
        price=volume*quantity*30+(0.021*distance)}
    else {price=volume*quantity*40+(0.021*distance)}

    const [toggle, setToggle] = useState(false)

    //Gérer le calcul du prix et la réservation ( champs obligatoires à remplir pour pouvoir cliquer sur les boutons)
    const {
        register,
        formState: {isValid},
      } = useForm({defaultValues:{
        length:"",
        height:"",
        width:"",
        quantity:""
      }});

    useEffect(() => {
        fetch(`http://localhost:8080/departure_ports/coordinate?keyword=${departure}`)
            .then(response => (response.json()))
            .then(data => setCoord1(data))

        fetch(`http://localhost:8080/arrival_ports/coordinate?keyword=${arrival}`)
            .then(response => (response.json()))
            .then(data => setCoord2(data))
        })

    const handleClick = (e) => {
        e.preventDefault()
        if (type==="conteneur_complet"){
            const quote = {distance, type, dimension, quantity, valueHT, volume, price}
            fetch("http://localhost:8080/quotation",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(quote)})
            .then(response => (response.json()))
            .then(data => console.log(data))
            .catch(error => console.error(error))
        } else {
        const quote = {distance, type, length, height, width, quantity, valueHT, volume, price}
        fetch("http://localhost:8080/quotation",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(quote)})
        .then(response => (response.json()))
        .then(data => console.log(data))
        .catch(error => console.error(error))
        }   
    }
   
        return(
        <div className="quotation">      
            <Paper elevation={3} sx={{padding:'30px 30px', width: 800, margin: "20px auto"}}>
                <h2><span className="quotation-title">|</span> Réservation </h2>
                
                <div className="search-container">
                    <Alert severity="warning" sx={{width:"100%"}}> 
                        Veuillez completer l'ensemble des informations obligatoires (*)
                    </Alert><br/>
                    <div className="search-inner">
                        <label>Origine</label><br/>
                        <input value={departure} disabled={true} className="input-text"/>
                    </div>
                    <div className="search-inner">
                        <label>Destination</label><br/>
                        <input value={arrival}  disabled={true} className="input-text"/>
                    </div>
                    <div className="search-inner">
                        <label>Type de marchandise *</label><br/>
                        <select 
                        {...register("type",{required:true})}
                        id="type"
                        value={type} onChange={(event)=>setType(event.target.value)}  
                        className="field">
                            <option value=""></option>
                            <option value="conteneur_complet">Conteneur complet</option>
                            <option value="conteneur_partiel">Conteneur partiel</option>
                            <option value="hors_gabarit">Hors gabarit</option>
                        </select>
                    
                    </div>
                    {type === "conteneur_complet" && (
                    <div className="dropdown-quotation">
                        <div className="search-inner">
                            <legend>Type de conteneur *</legend>
                            <select {...register("dimension",{required:true})}
                            id="dimension"
                            value={dimension} onChange={(event)=>setDimension(event.target.value)} 
                            className="field">
                                <option value=""></option>
                                <option value="33">20 Pieds DRY</option>
                                <option value="64">40 Pieds DRY</option>
                                <option value="76">40 Pieds HC DRY</option>
                                <option value="29">20 Pieds REEFER</option>
                            </select>
                        </div>
                        <div className="search-inner">
                            <legend>Quantité *</legend>
                            <input {...register("quantite",{required:true})}
                            id="quantity"
                            type="number" min="0" step="1" 
                            className="field"
                            value={quantity}
                            onChange={(event)=>setQuantity(event.target.value)}/>
                        </div>   
                        <div className="search-inner">
                            <legend>Valeur de la marchandise HT</legend>
                            <input 
                            type="number" min="0" step="0.01" placeholder="€" 
                            className="field"
                            value={valueHT}
                            onChange={(event)=>setValueHT(event.target.value)}/>
                        </div>     
                    </div>
                    )}
                    {type === "conteneur_partiel" &&(
                    <div className="dropdown-quotation">
                        <div className="search-inner">
                            <legend>Longueur *</legend>
                            <input {...register("longueur",{required:true})}
                            id="length"
                            type="number" min="0" step="0.1" placeholder="cm" 
                            className="field"
                            value={length}
                            onChange={(event)=>setLength(event.target.value)}/>
                        </div>
                        <div className="search-inner">
                            <legend>Largeur *</legend>
                            <input {...register("largeur",{required:true})}
                            id="width"
                            type="number" min="0" step="0.1" placeholder="cm" 
                            className="field"
                            value={width}
                            onChange={(event)=>setWidth(event.target.value)}/>
                        </div>
                        <div className="search-inner">
                            <legend>Hauteur *</legend>
                            <input {...register("hauteur",{required:true})} 
                            id="height"
                            type="number" min="0" step="0.1" placeholder="cm" 
                            className="field"
                            value={height}
                            onChange={(event)=>setHeight(event.target.value)}/>
                        </div>
                        <div className="search-inner">
                            <legend>Quantité *</legend>
                            <input {...register("quantite",{required:true})}
                            id="quantity"
                            type="number" min="0" step="1" 
                            className="field"
                            value={quantity}
                            onChange={(event)=>setQuantity(event.target.value)}/>
                        </div>
                        <div className="search-inner">
                            <legend>Valeur de la marchandise HT</legend>
                            <input 
                            type="number" min="0" step="0.01" placeholder="€" 
                            className="field"
                            value={valueHT}
                            onChange={(event)=>setValueHT(event.target.value)}/>
                        </div>
                    </div>
                    )}
                    {type === "hors_gabarit" && (
                    <div className="dropdown-quotation">
                        <div className="search-inner">
                            <legend>Longueur *</legend>
                            <input {...register("longueur",{required:true})}
                            id="length"
                            type="number" min="0" step="0.1" placeholder="cm" 
                            className="field"
                            value={length}
                            onChange={(event)=>setLength(event.target.value)} />
                        </div>
                        <div className="search-inner">
                            <legend>Largeur *</legend>
                            <input {...register("largeur",{required:true})} 
                            id="width"
                            type="number" min="0" step="0.1" placeholder="cm" 
                            className="field"
                            value={width}
                            onChange={(event)=>setWidth(event.target.value)} />
                        </div>
                        <div className="search-inner">
                            <legend>Hauteur *</legend>
                            <input {...register("hauteur",{required:true})}
                            id="height"
                            type="number" min="0" step="0.1" placeholder="cm" 
                            className="field"
                            value={height}
                            onChange={(event)=>setHeight(event.target.value)}/>
                        </div>
                        <div className="search-inner">
                            <legend>Quantité *</legend>
                            <input {...register("quantite",{required:true})}
                            id="quantity"
                            type="number" min="0" step="1" 
                            className="field"
                            value={quantity}
                            onChange={(event)=>setQuantity(event.target.value)}/>
                        </div>
                        <div className="search-inner">
                            <legend>Valeur de la marchandise HT</legend>
                            <input 
                            type="number" min="0" step="0.01" placeholder="€" 
                            className="field"
                            value={valueHT}
                            onChange={(event)=>setValueHT(event.target.value)}/>
                        </div>
                    </div>
                    )}    
                    {toggle && isValid &&( 
                    <div className="price">
                        <p>Montant total: <NumericFormat thousandSeparator=" " value={price.toFixed(2)}/> € </p> 
                    </div>)}
                    <button disabled={!isValid} onClick={() => setToggle(!toggle)}> Calculer </button> 
                    <button disabled={!isValid} onClick={handleClick}> Réserver </button> 
                </div> 
            </Paper>                      
        </div>
    )
}

export default Booking