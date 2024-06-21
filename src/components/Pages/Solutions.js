import './Solutions.css';
import RORO from '../images/RORO.jpg';
import Total from '../images/Total.jpg';
import Partiel from '../images/Partiel.jpg';

function Fret (){
    return(
        <>
            <div className="fret" id="fretmaritime">
                <h2>| NOS SERVICES DE FRET MARITIME</h2>

                <div className="fret-card">
                    <div className="card">
                        <img src={RORO} alt="navire-roulier"/>
                        <div className="card-text">
                            <h3>Navire roulier</h3><br/>
                            <p> Un envoi par navire roulier permet de transporter des marchandises roulées, telles que des voitures, des camions...
                                Les bateaux ont des rampes construites sur le bateau lui-même ou fixées à terre, de sorte que le chargement sur roues est beaucoup plus facile qu'avec une grue.
                                La cargaison sur roues accède au bateau par des portes situées à l'arrière ou à la proue. Il existe également le porte-voitures, qui est un modèle de transport carré destiné au chargement et déchargement uniquement des voitures.
                            </p>
                        </div>
                    </div>
                    <div div className="card">
                        <img src={Partiel} alt="LCL"/>
                        <div className="card-text">
                            <h3>LCL - Groupage maritime</h3><br/>
                            <p>LCL (Less than Container Load) correspond au groupage martime.
                                Le transport de conteneurs LCL est un service fourni par les transitaires vous permettant de réserver une partie de l'espace du conteneur.
                                Lorsque l'exportateur ou l'importateur ne dispose pas de suffisamment de marchandises pour remplir un conteneur entier et que l'expédition est effectuée par voie maritime, ce type d'expédition est utilisé.      
                                Lorsque plusieurs importateurs ou exportateurs ont des besoins similaires pour de petites expéditions, la possibilité de les regrouper dans un conteneur partagé est offerte. Le coût est à la charge du client en fonction de l'espace qu'il occupe dans le conteneur.       
                            </p>
                        </div>
                    </div>
                    <div div className="card">
                        <img src={Total} alt="FCL"/>
                        <div className="card-text">
                            <h3>FCL - Transport de conteneur complet</h3><br/>
                            <p> Le FCL (Full Container Load), correspond à l'expédition de marchandises dans des conteneurs maritimes.
                                Il existe différents types de conteneurs (20 ou 40 pieds). Dans le cas du FCL, Le transport maritime en conteneurs complets offre une plus grande sécurité et protection des marchandises pendant le transport, puisque les conteneurs sont scellés et protégés.
                                Avec le FCL, vous êtes soumis à un taux forfaitaire par conteneur, même si l’espace de chargement n’est pas entièrement utilisé. Une expédition en FCL devient rentable si vous remplissez au minimum 60% d’un conteneur.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Fret;