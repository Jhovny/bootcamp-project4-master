/**
 * Resumen.
 * Objeto                   : PersonServiceImpl.java
 * Descripción              : Clase para los métodos de la implementación de servicio de la cuenta.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.master.persistence.service.impl;

import com.nttdata.bootcamp.master.persistence.model.dao.PersonDao;

import com.nttdata.bootcamp.master.persistence.model.document.Person;
import com.nttdata.bootcamp.master.persistence.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase para los métodos de la implementación de servicio de la persona.
 */
@Service
public class PersonServiceImpl implements PersonService {

    /** Declaración de la variable de log */
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    /** Declaración de la clase dao */
    @Autowired
    private PersonDao personDao;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Person, tipo Mono
     */
    @Override
    public Mono<Person> insert(Person person) {
        return personDao.save(person)
                .doFirst(() -> log.info("Begin Insert Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert Person"));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Person, tipo Mono
     */
    @Override
    public Mono<Person> update(Person person) {
        return personDao.findById(person.getId())
                .doFirst(() -> log.info("Begin Update Person"))
                .map(p -> person)
                .flatMap(this.personDao::save)
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Update Person"));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @Override
    public Mono<Void> delete(String id) {
        return personDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete Person"));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Person, tipo String
     */
    @Override
    public Mono<Person> find(String id) {
        return personDao.findById(id)
                .doFirst(() -> log.info("Begin Find Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Find Person"));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Person, tipo String
     */
    @Override
    public Mono<Person> findByCode(String code) {
        return personDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode Person"));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Mono retorna el Person, tipo String
     */
    @Override
    public Flux<Person> findAll() {
        return personDao.findAll()
                .doFirst(() -> log.info("Begin FindAll Person"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll Person"));
    }

}
