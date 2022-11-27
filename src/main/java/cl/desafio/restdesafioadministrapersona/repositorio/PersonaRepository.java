package cl.desafio.restdesafioadministrapersona.repositorio;

import org.springframework.data.repository.CrudRepository;

import cl.desafio.restdesafioadministrapersona.entity.PersonaEntity;

public interface PersonaRepository extends CrudRepository<PersonaEntity,Integer>{

    
    
}
