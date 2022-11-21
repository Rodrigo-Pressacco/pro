import React, { useEffect, useState } from "react";
import { Link, useLocation } from "react-router-dom";
import axios from 'axios';
import ReservaFecha from "./reserva/ReservaFecha";
import ReservaDatos from "./reserva/ReservaDatos";
import ReservaHorarios from "./reserva/ReservaHorarios";
import ReservaCheck from "./reserva/ReservaCheck";
import DetallesNormas from "./detalles/DetallesNormas";
import url from "../utils/datosInicio.json"
import "../styles/reserva/Reserva.css";
import generarFechas from "./extras/GenerarFechas";


const Reserva = (props) => {

    const [horarios, setHorarios] = useState (null);
    const [fechaSelecionada, setFechaSelecionada] = useState([null, null])
    const r = useLocation()

    const [loading, setLoading] = useState(true);

    // Datos para DatePicker
    const [fechasNoDisponibles, setFechasNoDisponibles] = useState([])
    const [fechasListas, setFechasListas] = useState(false)
    
    /*data contiene el valor del producto al que entramos estos datos habria q enviarlos al check
    para poner el nombre la imagen y esos datos y que sea dinamico*/


    const [data, setData] = useState({
        id: r,
        nombre: null,
        descripcion: null,
        latitud: null,
        longitud: null,
        categoria: { id: null, titulo: null, descripcion: null, url_imagen: null },
        ciudad: { id: null, nombre: null, pais: null },
        imagen: [{ id: null, titulo: null, url_imagen: null, producto: null }],
        caracteristicas: [{ id: null, nombre: null, icono: null }],
        reservas: [{id: 1, horaLlegada: '', fechaInicio: '', fechaFinal: '', producto: null,usuario: null}],
    });

    useEffect(() => {
        if (loading) {
            let fechas = []
            axios
            .get(`http://${url.hostUrl}:8080/productos/${r.pathname.split("/")[2]}`)
            .then((response) => {
                setData(response.data);
                response.data.reservas.forEach(e => {
                    fechas.push([e.fechaInicio,e.fechaFinal])
                setFechasNoDisponibles(fechas) /*TODO: Usar hook para actualizar (simil al += 1)*/
                if (response.data.reservas.indexOf(e) === response.data.reservas.length - 1){
                    setFechasListas(true)
                    setLoading(false);
                }
            })
        })
        }

    },[r.pathname.split("/")[2]]);

    const handleFecha = (datos) => {
        setFechaSelecionada(datos)
    }
    
    const handleHorario = (datos) => {
        setHorarios(datos)
    }

    const [covid,setCovid] = useState(0)
    const [ciudadUsuario,setCiudadUsuario] = useState(null)
    const [mensaje,setMensaje] = useState(null)
    const [confirmacionCovid,setConfirmacionCovid] = useState(null)

    const handleCovid = (dato)=>{
        //console.log(dato);
        setConfirmacionCovid(dato)
    }

    const handleCiudadUsuario = (dato)=>{
        setCiudadUsuario(dato);
    }

    const handleMensaje = (dato)=>{
        setMensaje(dato);
    }


    return (
        
    <>
        
        <div className="heading">
            <Link to={`/detalle/${data.id}`}><i className="fas fa-chevron-left flecha-atras"></i></Link>
            <span>
                <p className="categoria-producto">{data.categoria.titulo}</p>
                <h1 className="titulo-producto">{data.nombre}</h1>
            </span>
        </div>
        <div className="div-general-reserva">
            <div className="div-columan-left">
                <div className="div-reserva-datos">
                    <h3>Completá Tus datos</h3>
                    < ReservaDatos covid={handleCovid} ciudadUsuario={handleCiudadUsuario} mensajeDueño={handleMensaje} />
                </div>
                <div className="div-reserva-mapa">
                    <h3>Selecciona tu fecha de reserva</h3>
                    { fechasListas ? < ReservaFecha fechas={handleFecha} fechasOcupadas = {generarFechas(fechasNoDisponibles)} /> : <ReservaFecha fechas={handleFecha} fechasOcupadas={[]}/>}
                </div>
                <div className="div-reserva-horario">
                    <h3>Tu horario de llegada</h3>
                    < ReservaHorarios horario={handleHorario} />
                </div>
            </div>
            <div className="div-columan-right">
                <div className="div-reserva-check">
                    < ReservaCheck datosCheck={fechaSelecionada} alojamiento={data} loading={loading} nombreS3={data.nombre} horario={horarios} confirmacionCovid={confirmacionCovid} mensaje={mensaje} ciudadUsuario={ciudadUsuario} />
                </div>
            </div>
        </div>
        <DetallesNormas />
        
    </>
    )
}
export default Reserva;