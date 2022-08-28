/**
 * Resumen.
 * Objeto                   : DocumentType.java
 * Descripción              : Clase de tipo document para obtener o establecer los datos de cada atributo.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un campo nuevo.
 */

package com.nttdata.bootcamp.master.persistence.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@ToString
@Document(collection="document_type")
public class DocumentType {

    /** Identificador del Tipo de Documento */
    @Id
    private String id;

    /** Código del Tipo de Documento */
    private String code;

    /** Nombre del Tipo de Documento */
    private String name;

    /** Descripción del Tipo de Documento */
    private String description;

    /** Estado del registro */
    private boolean state;

}
