import '../HeroSection/HeroSection.css'
import {Link} from 'react-router-dom'
import Carousel from "react-multi-carousel";
import "react-multi-carousel/lib/styles.css";

 
function HeroSection(){

  const responsive = {
    superLargeDesktop: {
      breakpoint: { max: 4000, min: 3000 },
      items: 1
    },
    desktop: {
      breakpoint: { max: 3000, min: 1024 },
      items: 1
    },
    tablet: {
      breakpoint: { max: 1024, min: 464 },
      items: 1
    },
    mobile: {
      breakpoint: { max: 464, min: 0 },
      items: 1
    }
  };


    return (
    <div className="container">
      <Carousel responsive={responsive}className="caroussel" >  
                <div class="msg-col">
                    <h1>OBTENIR UN HORAIRE</h1>
                    <p>Anticipez l'import et l'export de vos marchandises en consultant les horaires de départ et arrivée de vos conteneurs.</p>   
                    <Link to= "/consulter_le_calendrier"> Consulter le calendrier </Link>
                </div>
                <div class="msg-col">
                    <h1>SUIVRE VOS ENVOIS</h1>
                    <p>Consultez un espace de suivi pour chaque opération de transport de manière fiable et mises à jour en temps réel.</p>
                    <Link to= "/suivre_un_conteneur"> Suivre un conteneur </Link> 
                </div>  
            </Carousel>

    </div>                 
 
    
    )
}

export default HeroSection;