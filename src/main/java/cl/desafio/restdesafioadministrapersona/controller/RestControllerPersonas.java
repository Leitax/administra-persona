package cl.desafio.restdesafioadministrapersona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import cl.desafio.restdesafioadministrapersona.entity.PersonaEntity;
import cl.desafio.restdesafioadministrapersona.repositorio.PersonaRepository;

@Controller
@RequestMapping(path="/personas") //ruta para poder usar el metodo
public class RestControllerPersonas {

    private static Logger log = Logger.getLogger(RestControllerPersonas.class);
    @Autowired //Para llamar las funcionalidades del repository
    private PersonaRepository personaRepository;
    
    private RestControllerPersonas(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    @PostMapping(path ="/agregar")
    public @ResponseBody String addNewPersona (@RequestParam String nombre, @RequestParam Integer edad){
        
        PersonaEntity persona = new PersonaEntity();
        persona.setNombre(nombre);
        persona.setEdad(edad);
        personaRepository.save(persona);
        log.info("Persona Guardada");
        return "Guardado";
    }

    @GetMapping(path = "lista")
    public @ResponseBody Iterable<PersonaEntity> obtenerListaPersonas(){
        return personaRepository.findAll();
    }
}
