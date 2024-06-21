import {React, useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import {Container, Paper, Button} from '@mui/material';

export default function Signup() {

    const paperStyle = {padding:'50px 20px', width: 600, margin: "20px auto"}
    const [firstName,setFirstName]=useState('')
    const [lastName,setLastName]=useState('')
    const [email,setEmail]=useState('')
    const [password,setPassword]=useState('')
    const handleClick = (e) =>{
        e.preventDefault()
        const user = {firstName, lastName,email,password}
        console.log(user)
        fetch("http://localhost:8080/auth/signup",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(user)
        }).then(()=>{
            console.log("added")
        })}

    

  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:'black'}}><u>S'inscrire</u></h1>
            <Box
            component="form"
            sx={{
                '& > :not(style)': { m: 1, width: '25ch' },
            }}
            noValidate
            autoComplete="off"
            >
                <TextField id="outlined-basic" label="firstName" variant="outlined" fullWidth
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
                />
                <TextField id="outlined-basic" label="lastName" variant="outlined" fullWidth
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
                />
                <TextField id="outlined-basic" label="email" variant="outlined" fullWidth
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                />
                <TextField id="outlined-basic" label="password" variant="outlined" fullWidth
                value={password}
                onChange={(e) => setPassword(e.target.value)}/>

                <Button variant="outlined" style={{color:"black", border: '1px solid rgba(0, 0, 0)', textTransform:"none" }} onClick={handleClick}>Valider</Button>
            </Box>
        </Paper>
    </Container>
  );
}
