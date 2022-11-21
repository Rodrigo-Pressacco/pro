import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import ReservaFecha from '../components/reserva/ReservaFecha'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<ReservaFecha />', () => {
    let reservaFecha, fechas
    
    beforeEach(()=> {
        fechas = ["", ""]
    })
    

    beforeEach(() => {
        reservaFecha = shallow(<ReservaFecha /*handleSelect={handleSelect}*/ fechas={fechas} />)
    });

    it("Deberia mostrar <ReservaFecha/> correctamente", () => {
        expect(reservaFecha).toMatchSnapshot();
    });


})