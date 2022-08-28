/**
 * Resumen.
 * Objeto                   : ProductController.java
 * Descripción              : Clase de controladora para invocar a métodos CRUD con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.master.web.controller;

import com.nttdata.bootcamp.master.persistence.model.document.Person;
import com.nttdata.bootcamp.master.persistence.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    /** Declaración de la clase service */
    @Autowired
    private PersonService personService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Person, tipo Mono
     */
    @PostMapping
    public Mono<ResponseEntity<Person>> create(@RequestBody Person person){
        return this.personService.insert(person)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Person, tipo Mono
     */
    @PutMapping
    public Mono<ResponseEntity<Person>> update(@RequestBody Person person){
        return this.personService.update(person)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return this.personService.delete(id)
                .map(v -> new ResponseEntity<>(v, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Person, tipo String
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Person>> find(@PathVariable String id){
        return this.personService.find(id)
                .map(person -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(person));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Person, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<ResponseEntity<Person>> findByCode(@PathVariable String code){
        return this.personService.findByCode(code)
                .map(person -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(person));
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el Person, tipo Flux
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<Person>>> findAll(){
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.personService.findAll()));
    }

}
