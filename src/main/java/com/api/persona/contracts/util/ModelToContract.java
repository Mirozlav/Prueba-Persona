package com.api.persona.contracts.util;

import com.api.persona.contracts.PersonaContract;
import com.api.persona.model.Persona;

public class ModelToContract {

    public static PersonaContract toContract(Persona model) {
        PersonaContract contrato = new PersonaContract();
        contrato.setDni(model.getDni());
        contrato.setApellidos(model.getApellidos());
        contrato.setNombre(model.getNombre());
        contrato.setEmpleado(model.isEmpleado());

        return contrato;
    }
}
