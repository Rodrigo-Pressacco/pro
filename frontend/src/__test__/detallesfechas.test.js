import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import DetallesFecha from '../components/detalles/DetallesFecha'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<DetallesFecha />', () => {
    let fechas

    beforeEach(() => {
        fechas = shallow(<DetallesFecha />)
    });

    it("Deberia mostrar <DetallesFecha/> correctamente", () => {
        expect(fechas).toMatchSnapshot();
    });

    it("Deberia retornar 1 etiqueta h3", () => {
        let node = fechas.find("h3")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 1 etiqueta p", () => {
        let node = fechas.find("p")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 1 etiqueta Link", () => {
        let node = fechas.find("Link")
        expect(node.length).toEqual(1)
    });

})