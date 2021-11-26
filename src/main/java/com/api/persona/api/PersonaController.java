package com.api.persona.api;

import com.api.persona.contracts.PersonaContract;
import com.api.persona.contracts.util.ContractToModel;
import com.api.persona.contracts.util.ModelToContract;
import com.api.persona.model.Persona;
import com.api.persona.service.intf.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/personas")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        List<PersonaContract> contracts = new ArrayList<>();
        try {
            Iterable<Persona> personas = personaService.getAll();
            personas.forEach(model -> contracts.add(ModelToContract.toContract(model)));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTutorialById(@PathVariable("id") long id) {
        Optional<Persona> persona = personaService.findById(id);

        if (persona.isPresent()) {
            return new ResponseEntity<>(ModelToContract.toContract(persona.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody PersonaContract contrato) {
        try {
            Persona persona = personaService.Save(ContractToModel.toModel(contrato));
            return new ResponseEntity<>(ModelToContract.toContract(persona), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody PersonaContract contrato) {
        Optional<Persona> persona = personaService.findById(id);

        if (persona.isPresent()) {
            Persona _persona = persona.get();//dato recuperado

            _persona.setDni(contrato.getDni());
            _persona.setApellidos(contrato.getApellidos());
            _persona.setNombre(contrato.getNombre());
            _persona.setEmpleado(contrato.isEmpleado());
            Persona modificado = personaService.Save(_persona);

            return new ResponseEntity<>(ModelToContract.toContract(modificado), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            personaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}