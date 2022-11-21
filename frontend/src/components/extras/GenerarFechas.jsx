export default function generarFechas(arrayDeFechas) {
    let fechasOcupadas = []
    arrayDeFechas.forEach(([fechaI,fechaF]) => {        
        for (var d = new Date(fechaI + ' 00:00:00'); d <= new Date(fechaF + ' 00:00:00'); d.setDate(d.getDate() + 1)) {
            fechasOcupadas.push(new Date(d));
        }
    });
  return fechasOcupadas;
}


