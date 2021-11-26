package com.api.persona.service.impl;

import com.api.persona.model.Persona;
import com.api.persona.repository.PersonaRepository;
import com.api.persona.service.intf.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona Save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona Update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Iterable<Persona> getAll() {
        return personaRepository.findAll();
    }
}
