/**
 * Resumen.
 * Objeto                   : PersonDao.java
 * Descripción              : Clase de interface dao para obtener los datos de la base de datos.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.master.persistence.model.dao;


import com.nttdata.bootcamp.master.persistence.model.document.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Clase de interface dao para obtener los datos de la base de datos.
 */
public interface PersonDao extends ReactiveMongoRepository<Person, String> {

    /**
     * Método que obtiene los datos del document Person
     * @return Mono retorna el Person, tipo Mono
     */
    Mono<Person> findByCode(String code);

}
