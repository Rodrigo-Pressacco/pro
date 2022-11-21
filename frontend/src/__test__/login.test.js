import React from "react";
import { shallow } from "enzyme";
import "@testing-library/jest-dom";
import Login from '../components/Login'

import Enzyme from 'enzyme';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import { createSerializer } from 'enzyme-to-json';
Enzyme.configure({ adapter: new Adapter() });
expect.addSnapshotSerializer(createSerializer({ mode: 'deep' }));

describe('<Login />', () => {
    let login
    let handleChangeEmail = jest.fn(); 
    let handleChangePassword = jest.fn(); 
    let blurEmail = jest.fn(); 
    let blurPassword = jest.fn();
    let handleClickButton = jest.fn();
    let onSubmitForm = jest.fn();
    let cambiarBotenes = jest.fn();
    
    beforeEach(() => {
        login = shallow(<Login  handleChangeEmail={handleChangeEmail} 
                                handleChangePassword={handleChangePassword} 
                                blurEmail={blurEmail}
                                blurPassword={blurPassword}
                                handleClickButton={handleClickButton}
                                onSubmitForm={onSubmitForm}
                                cambiarBotenes={cambiarBotenes} />)
    });

    it("Deberia mostrar <Login/> correctamente", () => {
        expect(login).toMatchSnapshot();
    });

})