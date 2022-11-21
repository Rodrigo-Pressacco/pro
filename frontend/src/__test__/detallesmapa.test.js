import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import DetallesMapa from '../components/detalles/DetallesMapa'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<DetallesMapa />', () => {
    let mapa, ciudad
     
    beforeEach(()=> {
        ciudad = {
            id: 1,
            nombre: 'Cleveland',
            pais: 'Estados Unidos'
            
        };
    })

    beforeEach(() => {
        mapa = shallow(<DetallesMapa ciudad={ciudad} />)
    });

    it("Deberia mostrar <DetallesMapa/> correctamente", () => {
        expect(mapa).toMatchSnapshot();
    });

    it("Deberia retornar 1 etiqueta h3", () => {
        let node = mapa.find("h3")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 1 etiqueta h4", () => {
        let node = mapa.find("h4")
        expect(node.length).toEqual(1)
    });

})