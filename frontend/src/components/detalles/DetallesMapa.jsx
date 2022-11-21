import { useState } from 'react';
import { GoogleMap, LoadScript, Marker, InfoWindow } from '@react-google-maps/api';
import "../../styles/detalles/DetallesMapa.css";





const DetallesMapa = (props) => {

  const center = { lat: props.latitud, lng: props.longitud };
  const containerStyle = { width: '100%', height: '540px' };
  const [visiblePopUp, setVisiblePopUp] = useState(false);
  const divStyle = { background: `white`, padding: 15 }

  return (
    <div>
      {console.log()}
      <div className="div-detalles-h3">
        <h3 className="div-mapa-h3">¿Donde vas a estar?</h3>
      </div>
      <div className="div-nombre-mapa">
        <h4>{props.ciudad.nombre}, {props.ciudad.pais}</h4>
        <div className="div-mapa">
          <LoadScript googleMapsApiKey="AIzaSyDjmQN7EeUNEHpE3WuoXRcTbwkUj1LFYzk" loadingElement={<p>Cargando</p>}>
            <GoogleMap
              mapContainerStyle={containerStyle}
              center={center}
              zoom={15}
              onClick={() => setVisiblePopUp(false)}
            >
              { /* Child components, such as markers, info windows, etc. */}
              <Marker position={{ lat: props.latitud, lng: props.longitud }} onClick={() => setVisiblePopUp(!visiblePopUp)} />
              {visiblePopUp ?
                <InfoWindow position={{ lat: props.latitud, lng: props.longitud }} onCloseClick={() => setVisiblePopUp(!visiblePopUp)}>
                  <div style={divStyle}>
                    <h1>{props.nombre}</h1>
                    <p>{props.ciudad.nombre}</p>
                  </div>
                </InfoWindow>
                : null}
            </GoogleMap>
          </LoadScript>
        </div>
      </div>
    </div>
  )
}
export default DetallesMapa;

/* const { isLoaded } = useJsApiLoader({
  id: 'google-map-script',
  googleMapsApiKey: "AIzaSyDjmQN7EeUNEHpE3WuoXRcTbwkUj1LFYzk"
}) */