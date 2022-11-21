import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Listado from '../components/Listado'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<Listado />', () => {
    let listado
    let useEffect = jest.fn(); 
    
    beforeEach(() => {
        listado = shallow(<Listado useEffect={useEffect} />)
    });

    it("Deberia mostrar <Listado/> correctamente", () => {
        expect(listado).toMatchSnapshot();
    });

})