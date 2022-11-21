import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Card from '../components/Card'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<Card />', () => {
    let card
    
    let e = {
        numero : 1,
        calificacion : 8,
        star1: 'start',
        star2: 'start',
        star3: 'start',
        star4: 'start',
        star5: 'start'
    }
        
    let categoria = {
        toUpperCase : jest.fn()
    }

    beforeEach(() => {
        card = shallow(<Card {...e} categoria={categoria} />)
    });

    it("Deberia mostrar <Card/> correctamente", () => {
        expect(card).toMatchSnapshot();
    });

})