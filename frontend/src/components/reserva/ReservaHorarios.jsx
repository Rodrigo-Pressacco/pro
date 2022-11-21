import React, { useState } from "react";
import "../../styles/reserva/ReservaHorarios.css";

const ReservaHorarios = (props) => {

    const horarioPosible = ["10:00", "11:00", "12:00", "13:00", "14:00", 
                            "15:00", "16:00", "17:00",  "18:00",
                            "19:00", "20:00", "21:00",  "22:00", "23:00"]
    
    const [horaAEleccionShow, setHoraAEleccionShow] = useState(false);
    const [horaAEleccion, setHoraAEleccion] = useState("");

    const handleClick = (e) => {
        e.preventDefault()
        if (horaAEleccionShow) {
            setHoraAEleccionShow(false)
        }else{
            setHoraAEleccionShow(true)
        }
    }

    const handleClickDelHorario = (e) =>{
        e.preventDefault()
        setHoraAEleccion(e.target.textContent)
        props.horario(e.target.textContent)
        setHoraAEleccionShow(false)
    }

    const showHorarios = () => {
        if (horaAEleccionShow) {
            return(
                <ul className="reservas-ul">
                    {horarioPosible.map((e,i)=><li key={e} onClick={handleClickDelHorario}>{e}</li>)}
                </ul>
            )
            
        }
    }


    return (
        <div className="div-horarios">
            <p><i className="far fa-check-circle"></i> Tu habitación va a estar lista para el check-in entre las 10:00 AM y las 11:00 PM</p>
            <label>Indique el horario de llegada:</label>
            <div className="show-horarios">
            <input type="text" name="" id="" onFocus={handleClick} value={horaAEleccion} readOnly placeholder="* Seleccionar hora"/>
            {showHorarios()}
            </div>

        </div>
    )
}
export default ReservaHorarios;