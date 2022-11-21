import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Registro from '../components/Registro'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<Registro />', () => {
    let registro
    let onSubmit = jest.fn() 
    let checkPassword = jest.fn() 
    let checkNombre = jest.fn() 
    let checkEmail = jest.fn()
    let checkApellido = jest.fn() 
    let checkConfirmPass = jest.fn()
    let validarFormulario = jest.fn() 
    let handleError = jest.fn() 
    let handleClean = jest.fn()   
    let existingErrors = jest.fn()   
    let cambiarBotones = jest.fn(); 
    
    beforeEach(() => {
        registro = shallow(<Registro    onSubmit={onSubmit}
                                        checkPassword={checkPassword}
                                        checkNombre={checkNombre}
                                        checkEmail={checkEmail}
                                        checkApellido={checkApellido}
                                        checkConfirmPass={checkConfirmPass}
                                        validarFormulario={validarFormulario}
                                        handleError={handleError}
                                        handleClean={handleClean}
                                        existingErrors={existingErrors}
                                        cambiarBotones={cambiarBotones} />)
    });

    it("Deberia mostrar <Registro/> correctamente", () => {
        expect(registro).toMatchSnapshot();
    });

})