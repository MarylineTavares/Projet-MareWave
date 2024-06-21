import React from 'react';
import './Footer.css';
import { NavHashLink } from 'react-router-hash-link';


const Items = ({Links, title}) => {
    return (
    <ul>
        <h1 className="items-title">{title}</h1>
        {Links.map((link) =>(
            <li key={link.name}>
                <div className="items-link">
                    <NavHashLink to={link.link} style={{color: 'lightgrey', textDecoration: 'none'}}> {link.name}</NavHashLink>
                </div>
            </li>
        ))}
    </ul>
    );
};

export default Items;