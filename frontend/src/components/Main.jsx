import React, { createContext, useState } from "react";
import Listado from "./Listado";
import Buscador from "./Buscador"
import Categorias from "./Categorias";
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import Header from "./Header";
import Registro from "./Registro";
import Login from "./Login";
import Detalle from "./Detalle";
import Reserva from "./Reserva";
import fechasContext from "../contexts/fechasContext";


function Main() {

    /*states para header*/
    const [headerIniciarSesion, setHeaderIniciarSesion] = useState(false);
    const [headerRegistrarse, setHeaderRegistrarse] = useState(false);
    const [headerLogeado, setHeaderLogeado] = useState(false);
    const [datosUsuario, setDatosUsuario] = useState([{
        nombre: "hola",
        apellido: "hola"
    }, false]);

    /*states para filtros*/
    const [filtCat, setFiltCat] = useState(false)
    const [filtCity, setFiltCity] = useState(false)
    const [filterCategoria, setFilterCategoria] = useState();
    const [filterDestino, setFilterDestino] = useState();
    const [listCategoria, setListCategoria] = useState();
    const [listDestino, setListDestino] = useState();

    /*states para card*/
    const [dataCard, setDataCard] = useState(["",false])

    /*State para detalle para ir a reserva*/
    const [estoyLoguado, setEstoyLoguado] = useState(false)

    // States para Context de Fechas
    const [fechaInicial,setFechaInicial] = useState(new Date())
    const [fechaFinal,setFechaFinal] = useState(new Date())

    const handleClickChange = (datos) => {
        if (datos === 1) {
            setHeaderIniciarSesion(false)
            setHeaderRegistrarse(false)
        }
        if (datos === 2) {
            setHeaderRegistrarse(true)
            setHeaderIniciarSesion(false)
        }
        if (datos === 3) {
            setHeaderIniciarSesion(true)
            setHeaderRegistrarse(false)
        }
    }

    const handleSelected = (datos) => {
        setHeaderLogeado(true)

    };

    const handleDestinos = (name) => {
        setFilterDestino(name)
        setFiltCat(false)

    }

    const handleCategorias = (name) => {
        setFilterCategoria(name)
    }
    const handleListCategoria = (list) => {
        setListCategoria(list)
        setFiltCat(true)
    }
    const handleListDestino = (list) => {
        setListDestino(list)
        setFiltCity(true)
    }

    const handleRemoveFilter = () => {
        setFiltCat(false)
        setFiltCity(false)
    }

    const handleData = (data) =>{
        setDataCard([data , true]);
    }

    const handleLogeado = (data) =>{
        setEstoyLoguado(data)
    }

    const handleDatosUsuario = (data) =>{
        setDatosUsuario([data,true])
    }

    return (

        <div className="body">
                <BrowserRouter >
                    <Header header={{ headerIniciarSesion, headerRegistrarse, headerLogeado, datosUsuario}} cambiarBotton={handleClickChange} />
                    <Switch>
                        <Route exact path="/" render={() =>
                            <>
                                <Buscador onSelect={handleDestinos} onSelect2={handleListDestino} />
                                <Categorias onSelect={handleCategorias} onSelect2={handleListCategoria} />
                                <Listado filterCategory={filterCategoria} filterLocation={filterDestino}
                                        filterCategoryList={[listCategoria, filtCat]} filterLocationList={[listDestino, filtCity]}
                                        onFilter={handleRemoveFilter} handleDataCard={handleData} />
                            </>
                        } />
                        <Route exact path="/login" render={() =>
                            <Login cambiarBotton={handleClickChange} onSelect={handleSelected} logeado={handleLogeado} dataUsuario={handleDatosUsuario} />
                        } />
                        <Route exact path="/registrarme" render={() =>
                            <Registro cambiarBotton={handleClickChange} />
                        } />
                            <Route exact path="/detalle/:id" render={() =>
                                <fechasContext.Provider value={{fechaInicial,setFechaInicial,fechaFinal,setFechaFinal}}>
                                    < Detalle datos={dataCard} />
                                </fechasContext.Provider>
                            } />
                            <Route path="/detalle/:id/reserva" render={() =>
                                <fechasContext.Provider value={{fechaInicial,setFechaInicial,fechaFinal,setFechaFinal}}>
                                    < Reserva />
                                </fechasContext.Provider>
                            } />
                    </Switch>

                </BrowserRouter>
        </div>
    )
}
export default Main;