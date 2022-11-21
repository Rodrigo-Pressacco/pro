import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Categoria from '../components/Categoria'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<Categoria />', () => {
    let categoria
    
    beforeEach(() => {
        categoria = shallow(<Categoria />)
    });

    it("Deberia mostrar <Categoria/> correctamente", () => {
        expect(categoria).toMatchSnapshot();
    });

})