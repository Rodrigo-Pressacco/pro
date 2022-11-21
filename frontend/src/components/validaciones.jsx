import React from 'react';
import login from '../utils/login.json';

const Login = ()=>{

}
const checkPassword = (password) =>{ 
    return password.length >6;
}

const checkEmail =(email) =>{
    const regex = /\w+@[A-z]+.[A-z]{2,3}(.[a-z]{2,3})?/
    return regex.test(email);
}
const checkCredentials = (email,password) =>{
    login.forEach((user,index)=>user.email)
}
// Validaciones en inputs: El formulario debe validar que el campo de email sea un email válido y que la password tenga más de 6 caracteres.
// Botón: Al dar click que funcione la validación de ser correcta que compare los datos con un email y una password de prueba creadas en un objeto.
// Credenciales inválidas: El formulario indique “Por favor, vuelva a intentarlo sus credenciales son inválidas”.
// Credenciales válidas: Se simulará que el usuario está logueado desaparecerá el formulario de login volveremos a la Home inicial pero en el header a la derecha, en vez de ver los botones de inicio de sesión y registro veremos: Hola [nombre_de_usuario], un link de cerrar sesión y un avatar circular con las iniciales del usuario.