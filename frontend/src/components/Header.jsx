import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function Header(props) {

    const headerRegistrarse = props.header.headerRegistrarse;
    const headerIniciarSesion = props.header.headerIniciarSesion;
    const [headerLogeado, setHeaderLogeado] = useState(false)

    const [logOk, setLogOk] = useState(false)
    const [datosUsuario, setDatosUsuario] = useState({
        nombre:"",
        apellido:""
    })

    useEffect(() => {
        
        if (!logOk) {       
            if (JSON.parse(localStorage.getItem("myKeyForPersona"))!=null) {
                setDatosUsuario(JSON.parse(localStorage.getItem("myKeyForPersona")))
                setHeaderLogeado(true)
                setLogOk(true)
            }
        }
        
    });


/* 
    useEffect(() => {
        console.log("1");
        if (!logOk) {
            console.log(localStorage.getItem("myKeyForPersona"));
            if (JSON.parse(localStorage.getItem("myKeyForPersona"))!=null) {                
                console.log("3");
                setDatosUsuario(JSON.parse(localStorage.getItem("myKeyForPersona")))
                setHeaderLogeado(true)
                setLogOk(true)
            }
        }
        
    });    */ 
    
    //{console.log(JSON.parse(localStorageName))}
    const handleCerrarSesion = () => {
        localStorage.removeItem("myKey")
        localStorage.removeItem("myKeyForToken")
        localStorage.removeItem("myKeyForPersona")
        localStorage.removeItem("logueado")
    }

    const cambiarBotenes = (datos)=>{
        props.cambiarBotton(datos)
    }

    return (
        <header className="header">
            <div className="header-left">
                <Link to='/' onClick={()=>cambiarBotenes(1)}><img src="../images/logoNeoTravel.png" alt="logo1" /></Link>
                <Link to='/' onClick={()=>cambiarBotenes(1)} className="frase"><p>Porque todo comienza con un buen lugar</p></Link>
            </div>
            <div className="header-right">
                <input type="checkbox" id="menu-bar" />
                <img className="menu-icon" src="../images/menu.svg" alt="" />
                <span id="menu-span-bar">X</span>

                {!headerLogeado ?
                    <>
                        <div className="menuH">MENÚ</div>
                        <div className="buttons">
                            {!headerRegistrarse ?
                                <Link to="/registrarme" className="button-unfilled" id="crearCuenta" onClick={()=>cambiarBotenes(2)}>Crear Cuenta</Link>
                                : <></>}
                            <hr />
                            {!headerIniciarSesion ?
                                <Link to='/login' className="button-unfilled" id="iniciarSesion" onClick={()=>cambiarBotenes(3)} >Iniciar Sesión</Link>
                                : <></>}

                        </div> </> :

                    <div className="div-nombre-avatar">
                        <div className="div-avatar">
                            <p>{datosUsuario.nombre.split("")[0]}{datosUsuario.apellido.split("")[0]}</p>
                        </div>
                        <div className="div-nombre">
                            <a className="p-CerrarX" href="/" onClick={handleCerrarSesion}>X</a>
                            <p>Hola,</p>
                            <p className="p-nombre">{datosUsuario.nombre} {datosUsuario.apellido}</p>
                            <p className="p-cerrarSecion">¿Deseas <a href="/">cerrar sesión</a>?</p>
                        </div>
                    </div>
                }

                <ul className="social-network-header">
                    <li>
                        <img src="../images/facebookC3.png" alt="facebook" />
                    </li>
                    <li>
                        <img src="../images/linkedinC3.png" alt="linkedin" />
                    </li>
                    <li>
                        <img src="../images/twitterC3.png" alt="twitter" />
                    </li>
                    <li>
                        <img src="../images/instagramC3.png" alt="instagram" />
                    </li>
                </ul>
            </div>
        </header>
    )

}
export default Header;