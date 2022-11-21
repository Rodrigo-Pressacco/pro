import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import ReservaHorarios from '../components/reserva/ReservaHorarios'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<ReservaHorarios />', () => {
    let reservaHorarios;
    let handleClick = jest.fn(); 
    let handleClickDelHorario = jest.fn();
    let showHorarios = jest.fn();

    beforeEach(() => {
        reservaHorarios = shallow(<ReservaHorarios handleClick={handleClick} handleClickDelHorario={handleClickDelHorario} showHorarios={showHorarios} />)
    });

    it("Deberia mostrar <ReservaHorarios/> correctamente", () => {
        expect(reservaHorarios).toMatchSnapshot();
    });

    it("Deberia retornar 1 etiqueta p", () => {
        let node = reservaHorarios.find("p")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 1 etiqueta i", () => {
        let node = reservaHorarios.find("i")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 1 etiqueta label", () => {
        let node = reservaHorarios.find("label")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 1 etiqueta input", () => {
        let node = reservaHorarios.find("input")
        expect(node.length).toEqual(1)
    });

})