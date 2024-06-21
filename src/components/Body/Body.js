import './Body.css';
import containers from '../images/containers.jpg';
import BTN from '../Buttons/LearnMore';
import Globe from '../images/Globe.webp';
import LCL from '../images/LCL.jpg';
import { NavHashLink } from 'react-router-hash-link';

function Body(){
    
    return(
    <div class="content">
        <div class="section1">
            <div class="image">
                <img src={containers} alt="containers"/>
            </div>
            <div class="text">
                <h3>A PROPOS DE NOUS</h3>
                <h4>Nous sommes spécialisés dans le transport maritime</h4>
                <p>Chez MareWave, nous travaillons depuis plus de 10 ans avec les meilleurs partenaires 
                    nationaux et internationaux pour assurer le transport de vos marchandises dans les meilleurs conditions
                </p>
                <div class="container-learn-more">
                    <NavHashLink to="/notre_groupe/#ourcompany"> <BTN/></NavHashLink>
                </div>
            </div> 
        </div>

        <div class="section2">
            <div class="text">
                <h3>NOS SERVICES</h3> 
                <h4>Nous vous proposons des moyens transports adaptés à vos besoins</h4>
                <p>MareWave vous propose des moyens de transport adaptés au volume de vos marchandises:<br/>
                    - Navire roulier<br/>
                    - Groupage maritime<br/>
                    - Transport de conteneur complet</p>
                <NavHashLink to="/nos_solutions/#fretmaritime"><BTN/></NavHashLink>
            </div>
            <div class="image">
                <img src={LCL} alt="LCL"/>
            </div>
        </div>

        <div class="section3">
            <div class="text">
                <h3> NOS ENGAGEMENTS </h3>
                <h4> Nous accordons une grande importance à l'expérience de nos clients</h4>
                <p>MareWave travaille chaque jour pour vous offre le meilleur service client</p>
                <NavHashLink to="/vos_besoins/#import"> <BTN/></NavHashLink>
            </div>         
            <div class="card-container">
                <div class="card">
                    <div class="content">   
                        <h2>01</h2>    
                        <h3>Délai de livraison</h3>
                        <p> En cas de retard et selon les cas, MareWave s'engage à vous dédommager. </p>
                    </div>
                </div>
                <div class="card">
                    <div class="content"> 
                        <h2>02</h2>                      
                        <h3>Tarifs adaptés à vos besoins</h3>
                        <p>Nous analysons ensemble vos besoins pour vous proposer des prix au plus juste</p>  
                    </div>
                </div>
                <div class="card">
                    <div class="content">   
                        <h2>03</h2>                         
                        <h3>Assurance marchandises</h3>
                        <p>Vous pouvez souscrire à l'assurance MareWaveAssu pour couvrir vos marchandises. </p> 
                    </div>
                </div>
                <div class="card">
                    <div class="content">   
                        <h2>04</h2>                        
                        <h3>Formalités douanières</h3>
                        <p> A l’arrivée nous pouvons prendre en charge les formalités douanières</p> 
                    </div>
                </div>
            </div>      
        </div>
        
        <div class="section4">
            <div class="text">
                <h3> NOTRE PRESENCE</h3>
                <h4>Notre rayonnement national et international</h4>
                <p> Nos partenariats nous permettent d'être présent dans 15 pays en Europe, en Asie et en Afrique.
                </p>
                <div class="container-learn-more">
                <NavHashLink to="/notre_groupe/#ourpresence"> <BTN/></NavHashLink>
                </div>
            </div> 
            <div class="image">
                <img src={Globe} alt="globe"/>
            </div>     
            
        </div>
    </div>
        
    );
}

export default Body;