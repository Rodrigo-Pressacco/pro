import React, { useState, useEffect } from "react";
import Categoria from './Categoria.jsx';
import "../styles/Categorias.css";
import axios from 'axios';
import url from "../utils/datosInicio.json"


const Categorias = (props) => {

    let categoriaFiltrada;
   
    
    
    const [datos, setDatos] = useState([null, false])
    // const [datosPorCategoria, setDatosPorCategoria] = useState()
    
    const handleClick = (nombre)=>{
        props.onSelect(nombre)
        categoriaFiltrada=nombre
        
        fetchAxios()
        
    }
    const fetchAxios =() =>{
        axios.get(`http://${url.hostUrl}:8080/productos/buscarPorCategoria/${categoriaFiltrada}`)
        .then( res => {
            const persons = res.data;
            props.onSelect2(persons)   
    })}
    
   
    /*Aca ya implemente para que la categoria se renderize desde la api y no modifique nada mas*/
    useEffect(()=>{
        axios.get(`http://${url.hostUrl}:8080/categorias/todos`)
        .then(res => {
            const persons = res.data;
            if (datos[1]===false) {
                setDatos([persons, true])                  
            }
        })
    })


   

    return (
        <div className="container">
            <div className="row">
                <h2>Buscar por tipo de alojamiento</h2>
                    <div className="col-md-4">
                    {datos[1] ? datos[0].map((e, index)=> (
                            <div onClick={()=>handleClick(e.titulo)} className="categoria" key={e.id}> 
                                <Categoria  nombre={e.titulo} image={e.url_imagen} cant={e.descripcion} />
                            </div>
                        )):<></>}
                    </div>
                        
            </div>
        </div>
    )
}

export default Categorias;
