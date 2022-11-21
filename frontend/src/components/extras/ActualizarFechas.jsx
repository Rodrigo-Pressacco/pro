export default function actualizarFechas(arrayDeFechas,fechaInicial){
    // Defino variables iniciales
    let fecha = new Date(fechaInicial)
    fecha.setDate(fecha.getDate() + 365)
    
    // Hago un Sort de las fechas
    arrayDeFechas.sort( (a,b) => {
        return a-b
    })

    // Encuentro la primera fecha de reserva despues de la fecha seleccionada
    // Uso For en lugar de forEach, para evitar iterar por todos (hago uso del break)
    for (let index = 0; index < arrayDeFechas.length; index++) {
        const element = arrayDeFechas[index];
        if (fechaInicial < element){
            fecha = element
            break
        }
    }
    return fecha
}
