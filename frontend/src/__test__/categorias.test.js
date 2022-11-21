import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Categorias from '../components/Categorias'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<Categorias />', () => {
    let categorias
    let handleClick = jest.fn(); 
    let useEffect = jest.fn(); 

    beforeEach(() => {
        categorias = shallow(<Categorias handleClick={handleClick} useEffect={useEffect} />)
    });

    it("Deberia mostrar <Categorias/> correctamente", () => {
        expect(categorias).toMatchSnapshot();
    });

})