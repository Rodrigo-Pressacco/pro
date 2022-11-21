import React from 'react';
import "../styles/Categorias.css";

const Categoria = ({nombre, image, cant}) => {


    return (
        
        <div>
            <div className="categoria-body">
                <img src={image} alt="Categoria" />
                <h2>{nombre}</h2>
                <p>{cant}</p>

            </div>
        </div>
    )
}

export default Categoria;

