/**
 * Resumen.
 * Objeto                   : DocumentTypeDao.java
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
import com.nttdata.bootcamp.master.persistence.model.document.DocumentType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

/**
 * Clase de interface dao para obtener los datos de la base de datos.
 */
public interface DocumentTypeDao extends ReactiveMongoRepository<DocumentType, String> {

    /**
     * Método que obtiene los datos del document Client
     * @return Mono retorna el DocumentType, tipo Mono
     */
    Mono<DocumentType> findByCode(String code);

}
