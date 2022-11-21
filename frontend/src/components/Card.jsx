import React, { useEffect, useState} from "react";
import "../styles/Card.css";
import { Icon } from '@material-ui/core';
import { Link } from 'react-router-dom';


const Card = ({ id, url, categoria, nombre, ubicacion, descripcion, caracteristicas, e, handleData }) => {

  const[rating, setRating] = useState({
    numero: null,
    calificacion: null,
    star1: null,
    star2: null,
    star3: null,
    star4: null,
    star5: null
  })

  useEffect (() => {
    setRating(e)
  });

  return (
    <div className="card-alojamiento">
      <div className="contenedor-imagen">
        <img src={url} alt="HOTEL" />
        <i className="far fa-heart"></i>
      </div>
      <div className="descripcion">
        <p id="numberRating">{rating.numero}</p>
        <p id="calificacion">{rating.calificacion}</p>

        <p id='Categoria'>{categoria.toUpperCase()}
          <Icon className="ratingStar">{e.star1}</Icon>
          <Icon className="ratingStar">{e.star2}</Icon>
          <Icon className="ratingStar">{e.star3}</Icon>
          <Icon className="ratingStar">{e.star4}</Icon>
          <Icon className="ratingStar">{e.star5}</Icon>

        </p>
        <p id='Nombre'>{nombre}</p>


        <p id='Ubicacion'><Icon>room</Icon> {ubicacion} </p>

        <ul className="iconos">
          {caracteristicas.map((e, i) => <i className={e.icono} key={i}></i>)}
        </ul>

        <p id="Desc">{descripcion.substr(0, 120)}...</p>
        <Link to={`/detalle/${id}`} className="verMas" /* onClick={handleClick} */ >Ver Detalle</Link>
      </div>
    </div>
  )
}

/*<button className="verMas">Ver Detalle</button>*/

export default Card