import React, { useState, useEffect } from "react";
import {useForm} from "react-hook-form"
import axios from 'axios';
import "../styles/Registro.css";
import {Link} from 'react-router-dom'
import url from "../utils/datosInicio.json"


const Registro = (props) => {

  const confirmacionEmail = {
    subject: "Confirmacion de Registro NeoTravel",
    body: "Te has registrado correctamente en nuestro servicio. Gracias por unirte a NeoTravel, "
  }

  // const [registroBoton,setRegistroBoton] = useState(true)
  const {register,formState:{errors},getValues, handleSubmit}= useForm( {mode: "onChange"});
  const onSubmit = (data,e) =>{
    e.preventDefault();
    console.log(data)
    return data
  }

  const [datosUsuarioTraidos, setdatosUsuarioTraidos] = useState([{
    id: null,
    email: null
}]);

useEffect(() => {
    if (datosUsuarioTraidos[0].email === null) {
        axios.get(`http://${url.hostUrl}:8080/usuarios/todos`)
            .then((response) => {
                setdatosUsuarioTraidos(response.data)
            })
    }
});

  const [formOk,setFormOk] = useState(true)
  const checkPassword = (password) =>{ 
    return password.length >6;
  }
  const checkNombre = (password) =>{ 
    return password.length >2;
  }

  const checkEmail =(email) =>{
    let arra=[]
    datosUsuarioTraidos.filter((e)=>{
      if (e.email===email) {
        arra.push(e)
      }
    })
    const regex = /\w+@[A-z]+.[A-z]{2,3}(.[a-z]{2,3})?/
    if(arra.length===0 && regex.test(email)){
      
      return true
    }else{
      return false;
    }   
    
  }
  const checkApellido = (apellido) =>{ 
    return apellido.length >2;
  }
  
  const checkConfirmPass = (password,confirm) => {
    return password === confirm && confirm.length > 6
  }
  

  const validarFormulario = () => {
    let status = true

    status *= checkNombre(document.getElementById('registro-nombre').value)
    status *= checkApellido(document.getElementById('registro-apellido').value)
    status *= checkEmail(document.getElementById('registro-email').value)
    status *= checkPassword(document.getElementById('registro-password').value)
    status *= checkConfirmPass(document.getElementById('registro-password').value,document.getElementById('registro-confirmPass').value)
    
    if (status === 1){
      setFormOk(false)
    } else {
      setFormOk(true)
    }

  }

  const handleError = (id) => {
    let el = document.getElementById(id);
    if(el.value.length ===0){
    el.classList.add("registro-error")
    }
    else{
      el.classList.remove("registro-error")
    }
  }
  const handleClean = (id) => {
    let el = document.getElementById(id);
     el.classList.remove("registro-error")
  }
  const existingErrors =()=>{
    return Object.keys(errors).length >0
  }

  const cambiarBotenes = (datos)=>{
    props.cambiarBotton(datos)
    //console.log(datos);

    axios.post(`http://${url.hostUrl}:8080/usuarios/nuevo`, {
      nombre: document.getElementById('registro-nombre').value,
      apellido: document.getElementById('registro-apellido').value,
      email: document.getElementById('registro-email').value,
      password: document.getElementById('registro-password').value
  })
    .then((response) => {
      axios.post(`http://${url.hostUrl}:8080/email/verificacion/${response.data.email}/${confirmacionEmail.subject}/${confirmacionEmail.body}`)
      console.log(response)
  })
} 

  return (
    <div className="div-registro">
      <h1>Crear Cuenta</h1>
      {console.log()}
      <form action="" method="POST" className="form-registro" onSubmit={handleSubmit(onSubmit)} onMouseOver={validarFormulario}>
        <div className="divGeneral-nombre-apellido">
          <div className="divParticular-nombre-apellido">
            <label >Nombre</label>
            <input type="text" className="input-nombre-apellido" {...register("registronombre", {required: "Campo obligatorio"})} id="registro-nombre" onBlur={()=>handleError("registro-nombre")} onFocus={()=>handleClean("registro-nombre")}/>
            {errors.registronombre && <span className="errorsForm">{errors.registronombre.message}</span>}
          </div>
          <div className="divParticular-nombre-apellido">
            <label >Apellido</label>
            <input type="text" className="input-nombre-apellido" {...register("registroapellido", {required: "Campo obligatorio"})} id="registro-apellido" onBlur={()=>handleError("registro-apellido")} onFocus={()=>handleClean("registro-apellido")}/>
            {errors.registroapellido && <span className="errorsForm">{errors.registroapellido.message}</span>}
          </div>
        </div>
        <div className="div-email-password">
          <div className="divParticular-email-password">
            <label >Email</label>
            <input type="email" className="input-email-password" {...register("registroemail", 
            { pattern: { value:/\w+@[A-z]+.[A-z]{2,3}(.[a-z]{2,3})?/,
                         message:"Email no válido"},
              required:"Campo obligatorio"
              })} id="registro-email" onBlur={()=>handleError("registro-email")} onFocus={()=>handleClean("registro-email")}/>
          {errors.registroemail && <span className="errorsForm">{errors.registroemail.message}</span>}
          </div>
          <div className="divParticular-email-password">
            <label >Contraseña</label>
            <input type="password" className="input-email-password" {...register("registropassword",
            {required:"Campo Obligatorio",
            minLength:{
                value:6,
                message:"La contraseña debe contener al menos 6 caracteres"}})} id="registro-password" onBlur={()=>handleError("registro-password")} onFocus={()=>handleClean("registro-password")}/>
            {errors.registropassword && <span className="errorsForm">{errors.registropassword.message}</span>}
          </div>
          <div className="divParticular-email-password">
            <label >Repetir Contraseña</label>
            <input type="password" className="input-email-password" {...register("registrorepetirPassword",{required:"Confirmar contraseña", validate:{
              checkPasswordsMatch :(repeatedPass)=>{
                const {registropassword} = getValues()
                return registropassword === repeatedPass || "Las contraseñas no coinciden"
              }}})} id="registro-confirmPass" onBlur={()=>handleError("registro-confirmPass")} onFocus={()=>handleClean("registro-confirmPass")}/>
            {errors.registrorepetirPassword && <span className="errorsForm">{errors.registrorepetirPassword.message}</span>}
          </div>
        </div>
        <div className="div-button">
          {formOk ? <button disabled="disabled">Crear Cuenta</button>: <Link to="/login" onClick={()=>cambiarBotenes(3)} className="register-button">Crear Cuenta</Link>}
          <p>¿Ya tenienes una cuenta? <Link to="/login" onClick={()=>cambiarBotenes(3)} >Iniciar Sesion</Link> </p>
        </div>
      </form>
    </div>

  )
}

export default Registro;