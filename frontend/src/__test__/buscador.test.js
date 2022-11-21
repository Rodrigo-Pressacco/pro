import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Buscador from '../components/Buscador'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<Buscador />', () => {
    let buscador
    let setDatos = jest.fn();
    let setDestinoAEleccion = jest.fn(); 
    let setDestinoAEleccionShow = jest.fn(); 
    let useEffect = jest.fn();

    beforeEach(() => {
        buscador = shallow(<Buscador    setDestinoAEleccion={setDestinoAEleccion} 
                                        setDestinoAEleccionShow={setDestinoAEleccionShow}
                                        setDatos={setDatos}
                                        useEffect={useEffect} />)
    });

    it("Deberia mostrar <Buscador/> correctamente", () => {
        expect(buscador).toMatchSnapshot();
    });

    it("Deberia retornar 1 etiqueta h1", () => {
        let node = buscador.find("h1")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 1 etiqueta button", () => {
        let node = buscador.find("button")
        expect(node.length).toEqual(1)
    });

})