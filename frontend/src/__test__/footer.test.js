import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Footer from '../components/Footer'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));


describe('<Footer/>', () => {
    let footer; 

    beforeEach(() => {
        footer = shallow(<Footer />)
    });

    it("Deberia mostrar <Footer/> correctamente", () => {
        expect(footer).toMatchSnapshot();
    });

    it("Deberia retornar 1 etiqueta p", () => {
        let node = footer.find("p")
        expect(node.length).toEqual(1)
    });

    it("Deberia retornar 1 etiqueta ul", () => {
        let node = footer.find("ul")
        expect(node.length).toEqual(1)
    });
    
    it("Deberia retornar 4 etiquetas li", () => {
        let node = footer.find("li")
        expect(node.length).toEqual(4)
    });

    it("Deberia retornar 4 etiquetas img", () => {
        let node = footer.find("img")
        expect(node.length).toEqual(4)
    });

});



