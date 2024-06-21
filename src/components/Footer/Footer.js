import ItemsContainer from "./ItemsContainer"
import './Footer.css';

function Footer(){
    return(
        <footer className="footer">
            <div className="footer-links">
                <ItemsContainer/>
            </div>
            <div className="footer-copyright">
                <span> © 2024 Apply. All rights reserved.</span>
            </div>
        </footer>
        

    )
}

export default Footer