import React, { useEffect, useState } from "react";
import "../../styles/reserva/ReservaDatos.css";


const ReservaDatos = (props) => {
    
    let localStorageToken = null
    const [usuarioSetter, setUsuarioSetter] = useState(false)
    const [usuario, setUsuario] = useState({
        nombre: "",
        apellido: "",
        email: ""
    })

    let covid = document.getElementsByName('covid').value;

    useEffect(() => {
        if (!usuarioSetter) {
            setUsuario(JSON.parse(localStorage.getItem("myKeyForPersona")))
            localStorageToken = JSON.parse(localStorage.getItem("myKeyForToken"))
            setUsuarioSetter(true)
        }
    });

    const handleClick = (data)=>{
        if(data.target.id==="covid-si"){
            props.covid(1);
        }else{
            props.covid(0);
        }
        
    }

    const handleChangeCiudad = e => {
        props.ciudadUsuario(e.target.value);
        
    }

    const handleChangeMensaje = e => {
        props.mensajeDueño(e.target.value);
        }
    


    return (
        <form action="">
            <div className="form-top">
                <div className="form-datos">
                    <label >Nombre:</label>
                    <input type="text" name="nombre" id="nombre" disabled="disabled" value={usuario.nombre} />
                </div>
                <div className="form-datos">
                    <label >Apellido:</label>
                    <input type="text" name="apellido" id="apellido" disabled="disabled" value={usuario.apellido} />
                </div>
                <div className="form-datos">
                    <label >Correo Electronico:</label>
                    <input type="text" name="email" id="email" disabled="disabled" value={usuario.email} />
                </div>
                <div className="form-datos">
                    <label >* Ciudad:</label>
                    <input type="text" name="ciudad" id="ciudad" onChange={handleChangeCiudad}/>
                </div>
            </div>
            <div className="form-botton">
                <div className="form-mensaje">
                    <label htmlFor="msjDueño">Mensaje para el dueño:</label>
                    <textarea name="msjDueño" id="msjDueño" onChange={handleChangeMensaje} ></textarea>

                </div>
                <div className="obligatorio">
                    <div className="form-covid">
                        <input type="radio" name="covid" id="covid-si" onClick={handleClick} />
                        <label >Si</label>
                        <input type="radio" name="covid" id="covid-no" onClick={handleClick} />
                        <label >No</label>                        
                        <label >* ¿Estas vacunado para el Covid-19?</label>
                    </div>
                    <p>Los campos con * son obligatorios</p>
                </div>
            </div>
        </form>
    )
}
//<input type="text" name="" id="" />
export default ReservaDatos;