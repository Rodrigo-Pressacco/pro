import React, { useState } from 'react';
import AnchoPantalla from '../extras/AnchoPantalla'
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import { Carousel } from 'react-responsive-carousel';
import '../../styles/detalles/Imagenes.css';

const Imagenes = (props) => {

    


    const [mostrarCarrusel, setMostrarCarrusel] = useState(false);

    const activarCarrusel = () => {
        setMostrarCarrusel(true);
    }

    const desactivarCarrusel = () => {
        setMostrarCarrusel(false);
    }

    const statusFormat = (currentItem, total) => {
        return `${currentItem}/${total}`;
    }




    return (
        <div className="container-img">
            <div className="imagenes">
                <div className="img-principal">
                    <img src={props.imagenes.filter(im =>im.titulo.includes("Portada"))[0].url_imagen} alt="imagen1" />
                </div>

                <div className="grid-imagenes">

                    <ul className="img-lista">

                        {props.imagenes.map((e, i) => {
                            return (
                                <li className="imagen" key={i}>
                                    <div className="img-sec">
                                        <img src={e.url_imagen} alt="imagen2" />
                                    </div>

                                </li>
                            )
                        })}
                    </ul>
                </div>


                <button onClick={activarCarrusel} className="btn-ver-mas"  >Ver más</button>

            </div>

            <div className={`carrusel ${mostrarCarrusel ? "carrusel-activo" : ""}`}>


                <Carousel className="carrusel-img" infiniteLoop={true} statusFormatter={statusFormat} thumbWidth={150} emulateTouch={false} swipeable={true} autoPlay={AnchoPantalla() <= 800 ? true : false}>

                    {props.imagenes.map((e, i) => {
                        return (
                            <div className="img-carousel" key={i}>
                                <img src={e.url_imagen} alt="imagen1" />
                            </div>
                        )
                    })}


                </Carousel>

                <button onClick={desactivarCarrusel} className="cerrarCarrusel">X</button>

            </div>

        </div >
    )
}

export default Imagenes;
