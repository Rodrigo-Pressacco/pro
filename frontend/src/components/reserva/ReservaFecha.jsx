import React, { useContext, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "../../styles/reserva/ReservaFechas.css";
import fechasContext from "../../contexts/fechasContext";
import actualizarFechas from "../extras/ActualizarFechas";

const ReservaFecha = (props) => {
    const hoy = new Date()
    let maximaFecha = new Date(hoy)
    maximaFecha.setDate(hoy.getDate() + 365) // Al igual que con vuelos, lo maximo de anticipado que se puede elegir es un anio
    const context = useContext(fechasContext)
    //console.log([context.fechaInicial, context.fechaFinal]);
    const [dateRange, setDateRange] = useState([context.fechaInicial, context.fechaFinal]);
    const [startDate, endDate] = dateRange;
    const [minDate, setMinDate] = useState(hoy)
    const [maxDate, setMaxDate] = useState(maximaFecha)

    

    const handleSelect = () => {
        props.fechas(dateRange)

    }
    // console.log(context.fechasOcupadas)
    return (
        <div className="div-reserva-calendario">
            {/* {console.log(props.fechasOcupadas)} */}
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
                        context.setFechaInicial(hoy);
                    } else {
                        setMinDate(hoy)
                        setMaxDate(maximaFecha)
                        context.setFechaInicial(update[0]);
                        context.setFechaInicial(update[1]);
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
                onSelect={handleSelect()}

            />
        </div>
    )
}

export default ReservaFecha;