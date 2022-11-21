import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Main from '../components/Main'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<Main />', () => {
    let main
    let handleClickChange = jest.fn(); 
    let handleSelected = jest.fn();
    let handleDestinos = jest.fn();
    let handleCategorias = jest.fn();
    let handleListCategoria = jest.fn();
    let handleListDestino = jest.fn();
    let handleRemoveFilter = jest.fn();
    let handleData = jest.fn();
    let handleLogeado = jest.fn();
    let handleDatosUsuario = jest.fn();

    
    beforeEach(() => {
        main = shallow(<Main    handleClickChange={handleClickChange}
                                handleSelected={handleSelected}
                                handleDestinos={handleDestinos}
                                handleCategorias={handleCategorias}
                                handleListCategoria={handleListCategoria}
                                handleListDestino={handleListDestino}
                                handleRemoveFilter={handleRemoveFilter}
                                handleData={handleData}
                                handleLogeado={handleLogeado}
                                handleDatosUsuario={handleDatosUsuario}
                                 />)
    });

    it("Deberia mostrar <Main/> correctamente", () => {
        expect(main).toMatchSnapshot();
    });

})