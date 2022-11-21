import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../../styles/reserva/ReservaCheck.css";
import Alojamientos from "../../utils/Alojamientos.json";
import { Icon } from '@material-ui/core';
import swal from 'sweetalert2';
import axios from 'axios';
import url from "../../utils/datosInicio.json"


const ReservaCheck = (props) => {

    /*Aca estuve probando lo de traer la fecha y la trae pero luego no supe como tomar solo la fecha
    ponerla en el check*/
    const [urlImg, setUrlImg] = useState('')
    const [validacion, setValidacion] = useState(false)

    const [logOk, setLogOk] = useState(false)
    const [token, setToken] = useState(null)
    const [datosUsuario, setDatosUsuario] = useState({
        nombre: "",
        apellido: ""
    })

    const [check, setCheck] = useState([null, null])

    const confirmacionEmail = {
        subject: "Confirmacion de creacion de Reserva. NeoTravel",
        body: "Te has registrado correctamente en nuestro servicio. Gracias por unirte a NeoTravel, "
    }
    const urlBase = 'https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/'

    useEffect(() => {
        setCheck(props.datosCheck)
        setUrlImg(props.nombreS3);
        if (!logOk) {
            if (JSON.parse(localStorage.getItem("myKeyForPersona")) != null) {
                setDatosUsuario(JSON.parse(localStorage.getItem("myKeyForPersona")))
                setToken(JSON.parse(localStorage.getItem("myKeyForToken")))
                setLogOk(true)
            }
        }
    });
    // useEffect(() => {
    //     setUrlImg(props.nombreS3);
    // }, [props])

    const mostrarAlerta = () => {
        swal.fire({
            html: `<h1 class="tituloSwal">¡Muchas Gracias</h1>
            <br>
            <p class="textSwal">Su reserva se ha realizado con éxito</p>`,
            icon: "success",
            confirmButtonText: "Ok",
            confirmButtonColor: "#1DBEB4"
        }).then(function () {
            window.location = "/";
        })
    }

    //let startDateParse = startDate !== null ? (new Date(startDate).getFullYear() + "-" + format(new Date(startDate), "MM") + "-" + format(new Date(startDate), "dd")) : null;


    const handleClick = () => {

        const cero = "0";

        axios.post(`http://${url.hostUrl}:8080/reservas/nuevo`, {
            horaLlegada: props.horario,
            fechaInicio: `${props.datosCheck[0].getFullYear()}-${props.datosCheck[0].getMonth() + 1 < 10 ? cero.concat(props.datosCheck[0].getMonth() + 1) : props.datosCheck[0].getMonth() + 1}-${props.datosCheck[0].getDate() < 10 ? cero.concat(props.datosCheck[0].getDate()) : props.datosCheck[0].getDate()}`,
            fechaFinal: `${props.datosCheck[1].getFullYear()}-${props.datosCheck[1].getMonth() + 1 < 10 ? cero.concat(props.datosCheck[1].getMonth() + 1) : props.datosCheck[1].getMonth() + 1}-${props.datosCheck[1].getDate() < 10 ? cero.concat(props.datosCheck[1].getDate()) : props.datosCheck[1].getDate()}`,
            ciudadUsuario: props.ciudadUsuario,
            mensajeDuenio: props.mensaje,
            covid: props.confirmacionCovid,
            producto: props.alojamiento.id,
            usuario: datosUsuario.id
        }, {
            headers: {
                accept: '*/*',
                'Content-Type': 'application/json',
                Authorization: `Bearer ${token.jwt}`
            }
        })
            .then((response) => {
                mostrarAlerta()
                axios.post(`http://${url.hostUrl}:8080/email/verificacion/${datosUsuario.email}/${confirmacionEmail.subject}/Su Reserva en el hotel ${props.alojamiento.nombre} en la ciudad ${props.alojamiento.ciudad.nombre} a sido confimada, gracias por confiar en nosotros`)
                console.log(response);
            })

    }

    const setFecha = (index) => {

        if ((check[index] === null) || (check[index] === "")) {
            return '--/--/----'
        } else {
            let fecha1 = check[index].getDate()
            let fecha2 = check[index].getMonth() + 1
            let fecha3 = check[index].getFullYear()

            return `${fecha1}/${fecha2}/${fecha3}`
        }
    }

    return (
        <div className="div-general-check">

            <div className="reserva-contenedor-right">

                <h3>Detalles de la reserva</h3>
                <div className="separador-imagen-texto">
                    <div className="reserva-img">
                        <img src={urlBase + urlImg + '/Portada.jpg'} alt="Portada" width="100%" height="100%" />
                    </div>
                    <div className="reserva-contenedor-boton">
                        <div className="reserva-nombre">
                            <p className="reserva-categoria">{props.alojamiento.categoria.titulo}</p>
                            <h3>{props.alojamiento.nombre}</h3>
                            <p>
                                <Icon className="ratingStar">{Alojamientos[0].star1}</Icon>
                                <Icon className="ratingStar">{Alojamientos[0].star2}</Icon>
                                <Icon className="ratingStar">{Alojamientos[0].star3}</Icon>
                                <Icon className="ratingStar">{Alojamientos[0].star4}</Icon>
                                <Icon className="ratingStar">{Alojamientos[0].star5}</Icon>
                            </p>
                            <p className="reserva-location"><i className="fas fa-map-marker-alt"></i> {props.alojamiento.ciudad.nombre}, {props.alojamiento.ciudad.pais}</p>
                        </div>
                        <div className="reserva-datos-check">
                            <div>
                                <h4>Check-in</h4>
                                { }
                                <p>{setFecha(0)}</p>
                            </div>
                            <div>
                                <h4>Check-out</h4>
                                <p>{setFecha(1)}</p>
                            </div>
                        </div>
                        <div className="reserva-boton">
                            {!validacion ? <></> : <p className="p-obligatorio">Debe llenar los campos obligatorios</p>}
                            {props.ciudadUsuario != null && props.confirmacionCovid != null ?
                                <button id="botonReservaSwal" onClick={handleClick}>Confirmar Reserva</button> :
                                <button id="botonReservaSwal" onClick={() => setValidacion(true)} >Confirmar Reserva</button>}
                        </div>

                    </div>
                </div>
            </div>
        </div>
    )
}

export default ReservaCheck;