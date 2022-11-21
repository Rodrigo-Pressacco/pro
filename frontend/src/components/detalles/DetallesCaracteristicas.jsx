import React from "react";
import "../../styles/detalles/DetallesCaracteristicas.css";

const DetallesCaracteristicas = (props) => {

    return (
        <div className="div-detalles-caracteristicas">
            <div className="div-detalles-h3">
                <h3>¿Que ofrece este lugar?</h3>
            </div>
            <div className="div-datosCar">
                {props.caracteristicas.map((e, i) =>
                    <div className="div-datoUnico" key={i}>
                        <i className={e.icono}></i>
                        <p>{e.nombre}</p>
                    </div>)}
            </div>
        </div>
    )
}

export default DetallesCaracteristicas;