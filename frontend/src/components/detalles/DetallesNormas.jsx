import React from 'react';
import Normas from '../../utils/Normas.json'
import "../../styles/detalles/DetallesCaracteristicas.css";


function ElementosNormas(props) {
    return (
        <li>
            <p> {props.element.norma} </p>
        </li>
    )
}

function ElementosSys (props) {
    return (
        <li>
            <p> {props.element.sys} </p>
        </li>
    )
}


const DetallesNormas = () => {

    return (

        <div className="div-detalles-caracteristicas">
            <div className="div-detalles-h3">
                <h3>Que tenés que saber</h3>
            </div>
                <div className="columnaNormas">
                    <div className="columnax3"> 
                        <h4 className="tituloNorma">Normas de la Casa</h4>
                            {Normas.map((element) => (<ElementosNormas key={element.id} element={element}/>))}
                    </div>

                    <div className="columnax3">
                        <h4 className="tituloNorma">Salud y seguridad</h4>
                            {Normas.map((element) => (<ElementosSys key={element.id} element={element}/>))}
                    </div>
                
                    <div className="columnax3">
                        <h4 className="tituloNorma">Política de cancelación</h4>
                            <p className="textoNorma textoNormaEspecifico"> Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.</p>
                    </div>
                </div>
        </div>
    )
}


export default DetallesNormas;