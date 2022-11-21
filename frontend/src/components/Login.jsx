import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from 'axios';
import "../styles/Login.css";
import url from "../utils/datosInicio.json"

const Login = (props) => {
    /*mandar email*/


   

    /*fin mandar email*/
    const [loginEmail, setLoginEmail] = useState("");
    const [loginPassword, setLoginPassword] = useState("");
    const [loginErrorEmail, setLoginErrorEmail] = useState();
    const [loginErrorPassword, setLoginErrorPaswword] = useState();
    const [loginButton, setLoginButton] = useState(false);

    const [elementoEnviado, setElementoEnviado] = useState();
    const localStorageKey = "myKey";
    const localStorageKeyToken = "myKeyForToken";
    const localStorageKeyPersona = "myKeyForPersona";
    const localStorageLogueado = "logueado";

    const [datosUsuarioTraidos, setdatosUsuarioTraidos] = useState([{
        id: null,
        email: null
    }]);

    useEffect(() => {
        if (datosUsuarioTraidos[0].email === null) {
            axios.get(`http://${url.hostUrl}:8080/usuarios/todos`)
                .then((response) => {
                    setdatosUsuarioTraidos(response.data)
                })
        }
    });

    const arrayFiltradoEmail = datosUsuarioTraidos.filter(element => {
        return element.email === loginEmail
    })


    const handleChangeEmail = e => {
        setLoginEmail(e.target.value);
    }

    const handleChangePassword = e => {
        setLoginPassword(e.target.value);
    }

    const blurEmail = e => {
        if (arrayFiltradoEmail.length !== 0) {
            setLoginErrorPaswword(false)
            setLoginErrorEmail(false)
        }
        else {
            setLoginButton(false)
            setLoginErrorEmail(true)
        }
    }

    const blurPassword = () => {
        if (arrayFiltradoEmail[0] !== null) {
            setLoginButton(true)

            setLoginErrorPaswword(false)
            setLoginErrorEmail(false)
            setElementoEnviado(arrayFiltradoEmail[0])

        }
        else {
            setLoginButton(false)
            setLoginErrorPaswword(true)
        }
    }

    function handleClickButton(e) {
        e.preventDefault()
    }

    function onSubmitForm() {
        
        props.logeado(true)

        axios.post(`http://${url.hostUrl}:8080/authenticate`, {
            username: elementoEnviado.email,
            password: loginPassword
        }, {
            headers: {
                'accept': '*/*',
                'content-type': 'application/json'
            }
        })
            .then((response) => {
                localStorage.setItem(localStorageKey, JSON.stringify(elementoEnviado))
                localStorage.setItem(localStorageKeyPersona, JSON.stringify(response.data[0]))
                localStorage.setItem(localStorageKeyToken, JSON.stringify(response.data[1]))
                localStorage.setItem(localStorageLogueado, JSON.stringify(true))
                props.dataUsuario(response.data[0])
                
            })
            .catch((error) => {
                console.log("hola");
                console.log(error);
            });
    }

    const cambiarBotenes = (datos) => {
        props.cambiarBotton(datos)
    }

    return (
        <div className="div-login">
            <h1>Ingresar</h1>
            <form className="form-Login">
                <div className="div-email-password-login">
                    {loginErrorEmail || loginErrorPassword ? <p>Por favor, vuelva a intentarlo sus credenciales son inválidas</p> : <></>}
                    <label>Email:</label>
                    <input type="email" name="login-email" id="login-email" className="login-email-password" onChange={handleChangeEmail} onBlur={blurEmail} />
                </div>
                <div className="div-email-password-login">
                    <label>Contraseña:</label>
                    <input type="password" name="login-password" id="login-password" className="login-email-password" onChange={handleChangePassword} onBlur={blurPassword} />
                </div>
                <div className="div-button">
                    {loginButton ? <Link to="/" className="login-link" onClick={onSubmitForm}>Ingresar</Link> :
                        <button onClick={handleClickButton} className="login-link login-button">Ingresar</button>
                    }

                    <p>¿Aún no tenes cuenta? <Link to="/registrarme" onClick={() => cambiarBotenes(2)} >Registrate</Link></p>
                </div>
            </form>
        </div>
    )
}

export default Login;