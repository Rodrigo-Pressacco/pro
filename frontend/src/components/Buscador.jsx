import React, { useState,useEffect } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "../styles/Buscador.css";
import axios from 'axios';
import url from "../utils/datosInicio.json"

// los details es cambiado por el array de lugares

const Buscador = (props) => {

    //destino seleccionado
    const [datos, setDatos] = useState([null, false]);
    const [destinoAEleccion, setDestinoAEleccion] = useState("");
    const [destinoAEleccionShow, setDestinoAEleccionShow] = useState(false);

    const [dateRange, setDateRange] = useState([null, null]);
    const [startDate, endDate] = dateRange;

    useEffect(()=>{
        axios.get(`http://${url.hostUrl}:8080/ciudades/todos`)
        .then(res => {
            const persons = res.data;
            if (datos[1]===false) {
                setDatos([persons, true])                  
            }
        })
    })
    

    //metodo a cambiar cuando entren las categorias
    let arrayDeLugaresFiltrados = null;
    if(datos[1]){
        arrayDeLugaresFiltrados = datos[0].filter(lugar => lugar.nombre.toLocaleLowerCase()
                                                            .includes(destinoAEleccion.toLocaleLowerCase())
        )
    }

    //Setea el destino a eleccion y lo muestra
    const handleChange = e => {
        setDestinoAEleccion(e.target.value);
        if (e.target.value === "") {
            setDestinoAEleccionShow(false);
        }
        else {
            setDestinoAEleccionShow(true);
        }
    }

    //accionar de las opciones de ayuda
    const handleClickDeLaAyudaBuscadorDestino = e => {
        e.preventDefault()
        setDestinoAEleccion(e.target.innerText)
        setDestinoAEleccionShow(false)
        document.getElementById("buscadorDestino").value = e.target.innerText;
    }

    //Crea la lista de Opciones de ayuda o autocompletado
    function searchList() {
        if (destinoAEleccionShow) {
            return (
                <ul className="buscador-ul">
                    {datos[1]?arrayDeLugaresFiltrados.map((element, i) =>
                        <li onClick={handleClickDeLaAyudaBuscadorDestino} className="buscador-li" key={element.nombre + i}><img src="../images/vectorDeDestino.png" alt="vectorDeDestino" />               {element.nombre}, {element.pais}</li>
                    ):<></>}
                </ul>
            )
        }
    }


    //Evento a modificar cuando el buscar tenga que hacer algo
    function handleClickButton(destino) {
        document.getElementById("buscadorDestino").value = "";
        setDestinoAEleccion("")
        setDateRange([null, null])
        props.onSelect(destino)

        if(startDate== null||endDate == null){
            axios.get(`http://${url.hostUrl}:8080/productos/buscarPorCiudad/${destinoAEleccion.split(",")[0]}`)
            .then(res => {
                const persons = res.data;
                props.onSelect2(persons)
            })
        }else if(destinoAEleccion==""){
            axios.get(`http://${url.hostUrl}:8080/productos/buscarPorCiudadFecha/${startDate.toISOString().substring(0,10)}/${endDate.toISOString().substring(0,10)}`)
            .then(res => {
                const persons = res.data;
                props.onSelect2(persons)
            })
        }else{
            axios.get(`http://${url.hostUrl}:8080/productos/buscarPorCiudadFecha/${startDate.toISOString().substring(0,10)}/${endDate.toISOString().substring(0,10)}?ciudad=${destinoAEleccion.split(",")[0]}`)
            .then(res => {
                const persons = res.data;
                props.onSelect2(persons)
            }) 
        }

        

    }
    

    return (
        <div className="Buscador">
            <h1>Buscar ofertas en hoteles, casas y mucho más</h1>
            <div className="div-Buscador">
                <div className="div-buscarLugar">
                    <input type="search" placeholder="  ¿A donde vamos?" className="form-buscadorDestino"
                        onChange={handleChange} name="buscadorDestino" id="buscadorDestino" />
                    {searchList()}

                </div>
                <div className="div-calendario">
                    <DatePicker
                        selectsRange={true}
                        startDate={startDate}
                        endDate={endDate}

                        monthsShown={2}
                        dateFormat=" dd 'de' MMM. yyyy"
                        className="form-calendarDate"
                        placeholderText="   Check in - Check out"
                        onChange={(update) => setDateRange(update)}
                        minDate={new Date()}
                        shouldCloseOnSelect={false}
                        //excludeDates={[new Date(), subDays(new Date(), 1)]} asi se excluyen

                    />
                </div>

                <button className="form-button" onClick={()=>handleClickButton(destinoAEleccion)}>Buscar</button>
            </div>
        </div>

    )
}

export default Buscador;