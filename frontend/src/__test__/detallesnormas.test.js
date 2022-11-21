import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import DetallesNormas from '../components/detalles/DetallesNormas'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<DetallesNormas />', () => {
    let normas
    let ElementosNormas = jest.fn()
    let ElementosSys = jest.fn()

    beforeEach(() => {
        normas = shallow(<DetallesNormas ElementosNormas={ElementosNormas} ElementosSys={ElementosSys} />)
    });

    it("Deberia mostrar <DetallesNormas/> correctamente", () => {
        expect(normas).toMatchSnapshot();
    });

    it("Deberia retornar 1 etiqueta h3", () => {
        let node = normas.find("h3")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 3 etiquetas h4", () => {
        let node = normas.find("h4")
        expect(node.length).toEqual(3)
    });

    it("Deberia retornar 1 etiqueta p", () => {
        let node = normas.find("p")
        expect(node.length).toEqual(1)
    });

})