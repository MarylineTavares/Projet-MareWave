import Items from "./Items";
import {VOS_BESOINS, NOS_SOLUTIONS, NOTRE_GROUPE, LIENS_UTILES} from './ListItems'


import './Footer.css';

const ItemsContainer = () => {
    return (
        <div className="items-container">
            <Items Links={VOS_BESOINS} title="VOS BESOINS"/>
            <Items Links={NOS_SOLUTIONS} title="NOS SOLUTIONS"/>
            <Items Links={NOTRE_GROUPE} title="NOTRE GROUPE"/>
            <Items Links={LIENS_UTILES} title="LIENS UTILES"/>
        </div>
    );
}

export default ItemsContainer;