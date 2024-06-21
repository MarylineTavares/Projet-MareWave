import {React, useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import {Container, Paper, Button} from '@mui/material';
import PersonAddAltRoundedIcon from '@mui/icons-material/PersonAddAltRounded';
import { Link } from "react-router-dom";

export default function Signin() {

    const paperStyle = {padding:'50px 20px', width: 600, margin: "20px auto"}
    const [email,setEmail]=useState('')
    const [password,setPassword]=useState('')
    const handleClick = (e) =>{
        e.preventDefault()
        const user = {email,password}
        console.log(user)
        fetch("http://localhost:8080/auth/signin",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(user)
        }).then(()=>{
            console.log("success")
        })}

  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:'black'}}><u>Se connecter</u></h1>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="email" variant="outlined" fullWidth
      value={email}
      onChange={(e) => setEmail(e.target.value)}
      />
      <TextField id="outlined-basic" label="password" variant="outlined" fullWidth
      value={password}
      onChange={(e) => setPassword(e.target.value)}/>

    <Button variant="outlined" style={{color:"black", border: '1px solid rgba(0, 0, 0)', textTransform:"none" }} onClick={handleClick}>Valider</Button>

    <li className="title">
        <Link to="/inscription" className="link" style={{textDecoration:'none'}}><PersonAddAltRoundedIcon/></Link>
    </li>
    </Box>
    </Paper>
    </Container>
  );
}
