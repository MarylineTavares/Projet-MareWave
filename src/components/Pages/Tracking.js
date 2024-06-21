import './Tracking.css'
import Paper from '@mui/material/Paper';
import { useState } from 'react';

const Tracking = () => {
    const[reference, setReference] = useState('');
    const[results, setResults]=useState([]);
    const [isResultsLoading, setIsResultsLoading] = useState(true);
    const handleClick = (e) =>{
      e.preventDefault()
      fetch(`http://localhost:8080/tracking?reference=${reference}`)
      .then(response => (response.json()))
      .then(data => {setResults(data);
                    setIsResultsLoading(false)})
      .catch(error => console.error(error))
      }
    function result(){
      if (isResultsLoading) return null;
      if (results.length){
        return (<div className="history-tl-container">
          {results.map((result,index)=>(
          <li key={index}>
            <ul class="tl">
              <li class="tl-item" ng-repeat="item in retailer_history">
                <div class="item-title">Pré-acheminement</div>
                <div class="item-detail">Statut: {result.preRoutingStatus}</div>
                <div class="timestamp">{result.preRouting}</div>
              </li>
              <li class="tl-item" ng-repeat="item in retailer_history">  
                <div class="item-title">Préparation des documents pour la douane</div>
                <div class="item-detail">Statut: {result.preparingDocumentCustomsStatus}</div>
                <div class="timestamp">{result.preparingDocumentCustoms}</div>
              </li>
              <li class="tl-item" ng-repeat="item in retailer_history">                    
                <div class="item-title">Transport</div>
                <div class="item-detail">Statut: {result.transportStatus}</div>
                <div class="timestamp">{result.transport}</div>
              </li>
              <li class="tl-item" ng-repeat="item in retailer_history">
                <div class="item-title">Dédouanement</div>
                <div class="item-detail">Statut: {result.customsClearanceStatus}</div>
                <div class="timestamp"> {result.customsClearance}</div>
              </li>
              <li class="tl-item" ng-repeat="item in retailer_history">   
                <div class="item-title">Post-acheminement</div>
                <div class="item-detail">Statut: {result.postRoutingStatus}</div>
                <div class="timestamp">{result.postRouting}</div>
              </li>
            </ul>
          </li>))}
        </div>)
        }
      
        return(<div className="empty">Aucun résultat</div>)
    }
    
    return (
        <div className='tracking'>
          <Paper elevation={3} sx={{padding:'30px 30px', width: 800, height:730, margin: "20px auto"}}>
              <h2>| Suivre un transport</h2>
              <p>Pour suivre votre conteneur, veuillez saisir les références</p>
              <input placeholder="ex ABCD3456" type="text" className="input-text"
              value={reference}
              onChange={(e) => setReference(e.target.value)}
              />
              <button onClick={handleClick}>Rechercher</button>
          
            {result()}
          </Paper>
        </div>
    )
}

export default Tracking