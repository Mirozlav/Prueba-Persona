package com.api.persona.service.intf;

import com.api.persona.model.Persona;

import java.util.Optional;


public interface PersonaService {
    Persona Save(Persona persona);

    Persona Update(Persona persona);

    Optional<Persona> findById(Long id);

    void deleteById(Long id);
    Iterable<Persona> getAll();
}
