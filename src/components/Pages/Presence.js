import './Presence.css'
import Capture from '../images/Capture.jpg'

function Presence (){
 return(
    <div className="presence">
        <h1>NOUS SOMMES PRESENTS DANS 14 PAYS</h1>
        <p>Notre réseau de partenaires présents dans le monde entier vous assure une connexion pour l'import et l'export de vos marchandises</p>
        <img src={Capture} alt="carte du monde"/>
    </div>
    
 )
}

export default Presence;