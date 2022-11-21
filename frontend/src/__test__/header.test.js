import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Header from '../components/Header'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<Header />', () => {
    let header
    let cambiarBotones = jest.fn(); 
    let handleCerrarSesion = jest.fn() 
    let headerLogeado = jest.fn() 
    let headerRegistrarse = jest.fn() 
    let headerIniciarSesion = jest.fn() 
    //localStorage.setItem

    beforeEach(() => {
        header = shallow(<Header header={{headerIniciarSesion,headerRegistrarse,headerLogeado}} cambiarBotones={cambiarBotones} handleCerrarSesion={handleCerrarSesion} />)
    });

    it("Deberia mostrar <Header/> correctamente", () => {
        expect(header).toMatchSnapshot();
    });

})