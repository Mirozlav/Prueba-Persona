package com.api.persona.contracts.util;

import com.api.persona.contracts.PersonaContract;
import com.api.persona.model.Persona;

public class ContractToModel {

    public static Persona toModel(PersonaContract contract) {
        Persona model = new Persona();
        model.setDni(contract.getDni());
        model.setApellidos(contract.getApellidos());
        model.setNombre(contract.getNombre());
        model.setEmpleado(contract.isEmpleado());
        return model;
    }
}
