package cl.desafio.restdesafioadministrapersona.controller;

import cl.desafio.restdesafioadministrapersona.entity.Persona;
import cl.desafio.restdesafioadministrapersona.request.PersonaRequest;
import cl.desafio.restdesafioadministrapersona.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/personas") //ruta para poder usar el metodo
public class RestControllerPersonas {

    private static Logger LOGGER = LoggerFactory.getLogger(RestControllerPersonas.class);

    private RestControllerPersonas(){

    }

    @PostMapping(path ="/agregar")
    public @ResponseBody String addNewPersona (@RequestBody PersonaRequest request){
        
        if (!Util.detectarVuln(request.getNombre())) {
            LOGGER.info("Variables de entrada: Nombre:  " + request.getNombre() + ", Edad: " + request.getEdad());
            return "Persona Guardada";
        }
        return "No se guarda Persona, Variable nombre con Vulnerabilidad";
    }

    @GetMapping(path = "persona")
    public @ResponseBody Persona obtenerPersona(@RequestParam String nombre){

        if (!Util.detectarVuln(nombre)) {
            LOGGER.info("Variables de entrada: Nombre:  " + nombre);
            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setEdad(31);
            return persona;
        }
        return null;
    }
}
