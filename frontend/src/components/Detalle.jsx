import React, { useContext, useEffect, useState } from "react";
import { useParams, Link} from "react-router-dom";
import axios from 'axios';
import url from "../utils/datosInicio.json"
import "../styles/Detalle.css"
import Imagenes from "./detalles/Imagenes";
import DetallesCaracteristicas from "./detalles/DetallesCaracteristicas";
import DetallesFecha from "./detalles/DetallesFecha";
import DetallesMapa from "./detalles/DetallesMapa";
import DetallesNormas from "./detalles/DetallesNormas";
import "../styles/detalles/DetallesCaracteristicas.css";
import generarFechas from "./extras/GenerarFechas";


const Detalle = (props) => {

    const [loading, setLoading] = useState(true);
    const [usuarioLogeado, setUsuarioLogeado] = useState(false);
    const [fechasNoDisponibles, setFechasNoDisponibles] = useState([])
    const [fechasListas, setFechasListas] = useState(false)
    let fechas = []
    
    let { id } = useParams();
    const [prod, setProd] = useState({
        id: id,
        nombre: "",
        descripcion: "",
        latitud: null,
        longitud: null,
        categoria: { id: null, titulo: "", descripcion: "", url_imagen: "" },
        ciudad: { id: null, nombre: "", pais: "" },
        imagen: [{ id: null, titulo: "", url_imagen: "", producto: null }],
        caracteristicas: [{ id: null, nombre: "", icono: null }],
        reservas: [{id: 1, horaLlegada: '', fechaInicio: '', fechaFinal: '', producto: null,usuario: null}],
    });
    
    
    useEffect(() => {

        if (JSON.parse(localStorage.getItem("logueado"))!=null) {
            setUsuarioLogeado(JSON.parse(localStorage.getItem("logueado")))
        }
        
        axios
        .get(`http://${url.hostUrl}:8080/productos/${id}`)
        .then((response) => {
            setProd(response.data);
            response.data.reservas.forEach(e => {
                fechas.push([e.fechaInicio,e.fechaFinal])
                setFechasNoDisponibles(fechas) /*TODO: Usar hook para actualizar (simil al += 1)*/
                if (response.data.reservas.indexOf(e) === response.data.reservas.length - 1){
                    setFechasListas(true)
                }
            })
            setLoading(false);
        })

    }, [id]);

    return (
        <div className="div-detalle">
            {loading ? (
                <p>Loading Data...</p>
            ) :
                <>
                    <div className="heading">
                        <Link to="/"><i className="fas fa-chevron-left flecha-atras"></i></Link>
                        <span>
                            <p className="categoria-producto">{prod.categoria.titulo}</p>
                            <h1 className="titulo-producto">{prod.nombre}</h1>
                        </span>
                    </div>

                    <div className="ubicacion">
                        <img className="vector-destino" src="../images/vectorDeDestino.png" alt="destino" />
                        <span className="span-ubicacion">
                            <p>{prod.ciudad.nombre}, {prod.ciudad.pais}<span className="salto-linea">A 940m del centro</span></p>
                        </span>
                    </div>

                    <div className="bloque-imagenes">

                        <div className="detalles-iconos">
                            <i className="fas fa-share-alt compartir"></i>
                            <i className="far fa-heart"></i>
                        </div>

                        <Imagenes imagenes={prod.imagen} />

                    </div>

                    <div className="div-detalles-descripcion">
                        <h3>Alojate en el corazon de {prod.ciudad.nombre}</h3>
                        <p>{prod.descripcion}</p>
                    </div>

                    <DetallesCaracteristicas caracteristicas={prod.caracteristicas} />
                    { fechasListas ? <DetallesFecha id={prod.id} logueado={usuarioLogeado} fechasOcupadas={generarFechas(fechasNoDisponibles)}/> : <DetallesFecha id={prod.id} logueado={usuarioLogeado} fechasOcupadas={[]}/>}
                    {prod.latitud !== null && prod.longitud !== null ?
                        <DetallesMapa nombre={prod.nombre} ciudad={prod.ciudad} latitud={prod.latitud} longitud={prod.longitud} />
                        : <></>}
                    <DetallesNormas />
                </>
            }
        </div>
    )
}
//<DetallesNormas />
export default Detalle;