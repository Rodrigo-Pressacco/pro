import React, { useContext,useEffect,useState } from "react";
import { Link} from "react-router-dom";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "../../styles/detalles/DetallesFechas.css";
import actualizarFechas from "../extras/ActualizarFechas";
import fechasContext from "../../contexts/fechasContext";

const DetallesFecha = (props) => {
    const hoy = new Date()
    let maximaFecha = new Date(hoy)
    maximaFecha.setDate(hoy.getDate() + 365) // Al igual que con vuelos, lo maximo de anticipado que se puede elegir es un anio
    
    const [dateRange, setDateRange] = useState([null, null]);
    const [startDate, endDate] = dateRange;
    const [minDate, setMinDate] = useState(hoy)
    const [maxDate, setMaxDate] = useState(maximaFecha)
    const context = useContext(fechasContext)
    
    return (
        <div className="div-general">
            <h3>Fechas Disponibles</h3>
            <div className="div-calendario-boton">
                <div className="div-detalles-calendario">
                    <DatePicker
                        selectsRange={true}
                        startDate={startDate}
                        endDate={endDate}
                        monthsShown={2}
                        dateFormat=" dd 'de' MMM. "
                        className="form-calendarDate"
                        onChange={(update) => {
                            setDateRange(update)
                            if (update[1] === null) {
                                setMinDate(update[0]);
                                setMaxDate(actualizarFechas(props.fechasOcupadas, update[0]));
                                context.setFechaInicial(hoy);
                                context.setFechaFinal(hoy);
                            } else {
                                setMinDate(hoy)
                                setMaxDate(maximaFecha)
                                context.setFechaInicial(update[0]);
                                context.setFechaFinal(update[1]);
                            }
                            // Al seleccionar una fecha, se eliminan todas las fechas anteriores, cuando completo el rango, se vuelve a la normalidad
                            // update[1] === null ? setMinDate(update[0]) : setMinDate(hoy)
                            // Al Seleccionar una fecha, se eliminan todas las fechas posteriores a la primer reserva despues de la fecha, cuando completo el rango, se vuelve a la normalidad
                            // update[1] === null ? setMaxDate(actualizarFechas(props.fechasOcupadas, update[0])) : setMaxDate(maximaFecha)
                            }
                        }
                        minDate={minDate}
                        maxDate={maxDate}
                        excludeDates={props.fechasOcupadas}
                        inline

                    />
                </div>
                <div className="div-detallesFecha-button">
                    <p>Agrega tus fechas de viaje para obtener precios exactos</p>
                    {props.logueado?<Link to={`/detalle/${props.id}/reserva`} datos={props.id} >Iniciar reserva</Link>:
                    <Link to={`/login`} >Iniciar reserva</Link>}
                    
                </div>
            </div>
        </div>
    )
}

export default DetallesFecha;
