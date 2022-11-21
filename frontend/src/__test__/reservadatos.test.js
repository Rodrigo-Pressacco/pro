import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import ReservaDatos from '../components/reserva/ReservaDatos'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<ReservaDatos />', () => {
    let reservaDatos
    let useEffect = jest.fn(); 
    

    beforeEach(() => {
        reservaDatos = shallow(<ReservaDatos useEffect={useEffect} />)
    });

    it("Deberia mostrar <ReservaDatos/> correctamente", () => {
        expect(reservaDatos).toMatchSnapshot();
    });

    it("Deberia retornar 8 etiquetas label", () => {
        let node = reservaDatos.find("label")
        expect(node.length).toEqual(8)
    });

    it("Deberia retornar 6 etiquetas input", () => {
        let node = reservaDatos.find("input")
        expect(node.length).toEqual(6)
    });

    it("Deberia retornar 1 etiqueta textarea", () => {
        let node = reservaDatos.find("textarea")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 1 etiqueta p", () => {
        let node = reservaDatos.find("p")
        expect(node.length).toEqual(1)
    })

})