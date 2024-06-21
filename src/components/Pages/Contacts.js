import './Contacts.css'
import React from 'react';
import {useState, useEffect} from 'react';
import {Paper} from '@mui/material';


function Contacts () {

    const [contacts, setContacts] = useState ([])
    const [search, setSearch] = useState ([])

    useEffect(() => {
        const fetchData = async () => {
          const response = await fetch ('http://localhost:8080/contacts')
          const data = await response.json();
          setContacts(data);
          };
        fetchData();
        }, [])

    return(
        <div className="contact">
            <Paper elevation={3} sx={{padding:'30px 30px', width: 800, margin: "20px auto"}}>
                <h2>| Contact </h2>
                <div className="search">
                    <input
                    className="search-bar"
                    placeholder="Rechercher"
                    value={search}
                    onChange={(event) => setSearch (event.target.value)}
                    />
                </div>
                <div className="search-section">
                    {contacts
                    .filter ((contact)=>{
                        return (contact.name.toLowerCase().includes(search)
                    )}) 
                    .map ((contact) => {
                        return(
                            <div className="search-result" key={contact.id}>
                                <span className="bold">{contact.name}</span><br/>
                                {contact.address}<br/>
                                {contact.phone}<br/><br/>
                            </div>
                        )
                    })}
                    
                </div>
            </Paper>
        </div>
    )
}

export default Contacts