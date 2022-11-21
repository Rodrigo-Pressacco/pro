import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import DetallesCaracteristicas from '../components/detalles/DetallesCaracteristicas'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<DetallesCaracteristicas />', () => {
    let component, caracteristicas
    let useEffect = jest.fn(); 
    
    beforeEach(()=> {
        caracteristicas = {
            map : jest.fn()
            
        };
    })

    beforeEach(() => {
        component = shallow(<DetallesCaracteristicas useEffect={useEffect} caracteristicas={caracteristicas} />)
    });

    it("Deberia mostrar <DetallesCaracteristicas/> correctamente", () => {
        expect(component).toMatchSnapshot();
    });

    it("Deberia retornar 1 etiqueta h3", () => {
        let node = component.find("h3")
        expect(node.length).toEqual(1)
    });

})