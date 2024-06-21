import { Link } from "react-router-dom";
import "./NavBar.css";
import { useRef } from "react";


const Navbar = () => {
    const navRef = useRef();

  return (
    <>
        <div className="navbar-container">
            <div className="logo">
                <Link to="/" style={{textDecoration:'none', color:'whitesmoke'}}><h1>MareWave<span className="point">.</span></h1></Link>
            </div> 
            <div className="menu-list">
                <nav className="navbar" ref={navRef}>      
                    <ul id="responsive"> 
                        <li className="title"><Link to="/vos_besoins" className="text-link" style={{textDecoration:'none'}}>Vos besoins</Link></li>
                        <li className="title"><Link to="/nos_solutions" className="text-link" style={{textDecoration:'none'}}>Nos solutions</Link></li>
                        <li className="title"><Link to="/notre_groupe" className="text-link" style={{textDecoration:'none'}}>Notre groupe</Link></li>  
                        <li className="title"><Link to="/contact" className="text-link" style={{textDecoration:'none'}}>Contact</Link></li>     
                    </ul>
                </nav> 
            </div>
            <div className="client">
                <ul>
                    <li className="title">
                        <Link to="/se_connecter" className="link" style={{textDecoration:'none'}}>Se connecter</Link>
                    </li>
                </ul>
            </div>
            
        </div> 
    </>
  );
}

export default Navbar;