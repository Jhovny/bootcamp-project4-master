/**
 * Resumen.
 * Objeto                   : Person.java
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

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@ToString
@Document(collection="person")
public class Person {

    /** Identificador de la Persona */
    @Id
    private String id;

    /** Código de la Persona */
    private String code;

    /** Nombre de la Persona */
    private String name;

    /** Apellido de la Persona */
    private String lastName;

    /** Código de Tipo de Documento */
    private String codeDocumentType;

    /** Número de Documento */
    private String documentNumber;

    /** Número de Teléfono */
    private String phoneNumber;

    /** Correo Electrónico */
    private String email;

    /** Estado de registro */
    private boolean state;

}
