import "./Group.css"
import Navire from '../images/Navire.png';
import Agence from '../images/Agence.png';
import Employes from '../images/Employes.png';
import Pays from '../images/Pays.png';
import Conteneur from '../images/Conteneur.png';
import CA from '../images/CA.png';

function Group (){
    return(
        <div className="group" id="ourcompany">
            <div ClassName="testimonial">
                <div className="text-section">
                    <h3> « Notre entreprise est dévouée pour offrir la meilleure expérience client» <br/>
                    <span>Président du Groupe MareWave</span></h3>
                </div>
            </div>
            <div className="group-title">
                <h2>| D'UNE PASSION NEE UNE ENTREPRISE ENGAGEE AUPRES DE SES CLIENTS</h2><br/>
                <p>L’histoire du Groupe MareWave débute en 1988, lorsque le PDG Pierre Dupont réalise un petit bond dans le passé et découvrir l’histoire du transport maritime au détour d'un voyage en Egypte.
                    La découverte de sa passion pour la mer le pousse fonder MareWave avec un seul navire marchand.
                    Depuis, l’entreprise s’est développée et diversifiée pour inclure des services de qualité.
                </p>
            </div>
            <div className="figures">
                <div>
                    <img src={CA} alt="CA"/>
                    <p>1 milliard de CA en 2023 </p>
                </div>
                <div>
                    <img src={Navire} alt="navire"/>
                    <p>500 navires </p>
                </div>
                <div>
                    <img src={Agence} alt="agence"/>
                    <p>7 agences</p>
                </div>
                <div>
                    <img src={Pays} alt="pays"/>
                    <p>15 pays </p>
                </div>
                <div>
                    <img src={Employes} alt="employes"/>
                    <p>10 000 employés </p>
                </div>
                <div>
                    <img src={Conteneur} alt="conteneur"/>
                    <p>100 000 conteneurs transportés en 2023 </p>
                </div>
            </div>
            <div className="presence" id="ourpresence">
                <h2>| NOUS SOMMES PRESENTS DANS 15 PAYS</h2>
                <p>Notre réseau de partenaires présents dans le monde entier vous assure une connexion pour l'import et l'export de vos marchandises</p>
                <div className="international">            
                        <p><span className="bold">Europe:</span><br/>
                            - Belgique <br/>
                            - Espagne<br/>
                            - Grèce<br/>
                            - France<br/>
                            - Italie<br/>
                            - Pays-Bas<br/><br/>
                            <span className="bold">Asie:</span><br/>
                            - Chine<br/>
                            - Corée du Sud<br/>
                            - Singapour<br/><br/>
                            <span className="bold">Afrique:</span><br/>
                            - Afrique du Sud<br/>
                            - Côte d'Ivoire<br/>
                            - Djbouti<br/>
                            - Kenya<br/>
                            - Mozambique<br/>
                            - Nigéria<br/>  
                        </p>    
                </div>
            </div>
        </div>
    )
}

export default Group;