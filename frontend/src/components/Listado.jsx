import React, { useState, useEffect } from "react";
import "../styles/Listado.css"
import alojamientos from '../utils/Alojamientos.json'
import Card from './Card';
import axios from 'axios';
import url from "../utils/datosInicio.json"



const Listado = (props) => {


  const [datos, setDatos] = useState([null, false])

  useEffect(() => {
    axios.get(`http://${url.hostUrl}:8080/productos/todos`)
      .then(res => {
        const persons = res.data;
        if (datos[1] === false) {
          setDatos([persons, true])
        }
      })
  })



  let filtro = datos[0];
  if (props.filterCategoryList[1] || props.filterLocationList[1]) {
    if (props.filterCategoryList[1] && props.filterLocationList[1]) {
      filtro = datos[0].filter((e) => e.ciudad.nombre.concat(", ", e.ciudad.pais) === props.filterLocation && e.categoria.titulo === props.filterCategory);
      // console.log(1,props.filterLocation)
    } else if (props.filterCategoryList[1]) {
      filtro = props.filterCategoryList[0]
      // console.log(2,props.filterCategoryList)
    } else if (props.filterLocationList[1]) {
      filtro = props.filterLocationList[0]
      // console.log(3,props.filterLocationList)
    }
  }

  let h3 = '';
  if (filtro === datos[0]) {
    h3 = "Recomendaciones"
  }
  else {
    if (props.filterCategoryList[1] && props.filterLocationList[1]) {
      if (filtro.length === 0) {
        h3 = 'No se encontraron resultados';
      } else {
        h3 = "Resultados para: " + props.filterCategory + " en " + props.filterLocation
      }
    } else if (props.filterCategoryList[1]) {
      h3 = "Resultados para: " + props.filterCategory
    } else if (props.filterLocationList[1]) {
      h3 = "Resultados para alojamientos en: " + props.filterLocation
    }
  }

  const handleDatacard = (data) => {
    props.handleDataCard(data)
  }

  function handleClick(boolean) {
    props.onFilter(boolean)
  }

  return (
    <div className="div-General-h3">
      <div className="titulo-filter" >
        <h3>
          {h3}
        </h3>
        {(props.filterCategoryList[1] || props.filterLocationList[1]) ? <button className="cancelar-filtros" onClick={() => handleClick(true)}>x Quitar filtros</button> : ''}
      </div>
      <div className="contenedor-listado">
        {datos[1] ? filtro.map((e, index) =>
          <Card id={e.id} url={e.imagen.filter(im => im.titulo.includes("Portada"))[0].url_imagen} categoria={e.categoria.titulo} nombre={e.nombre}
            ubicacion={e.ciudad.nombre} descripcion={e.descripcion} caracteristicas={e.caracteristicas}
            e={alojamientos[e.id - 1]} key={index} handleData={handleDatacard} />) : <></>}
      </div>
    </div>
  )
}

export default Listado