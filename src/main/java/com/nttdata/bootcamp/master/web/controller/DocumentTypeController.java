/**
 * Resumen.
 * Objeto                   : DocumentTypeController.java
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

import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import com.nttdata.bootcamp.master.domain.service.DocumentTypeCacheService;
import com.nttdata.bootcamp.master.domain.service.DocumentTypeService;
import com.nttdata.bootcamp.master.persistence.model.document.DocumentType;
import com.nttdata.bootcamp.master.web.mapper.IDocumentTypeEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/documenttypes")
public class DocumentTypeController {

    /** Declaración de la clase service */
    @Autowired
    private DocumentTypeService documentTypeService;
    @Autowired
    private DocumentTypeCacheService documentTypeCacheService;

    @Autowired
    private IDocumentTypeEntityMapper documentTypeEntityMapper;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el DocumentType, tipo Mono
     */
    @PostMapping
    public Mono<ResponseEntity<DocumentTypeEntity>> create(@RequestBody DocumentTypeEntity documentTypeEntity){
        return   this.documentTypeService.save(documentTypeEntity)
                .map(d -> new ResponseEntity<>(d, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el DocumentType, tipo Mono
     */
    @PutMapping
    public Mono<ResponseEntity<DocumentTypeEntity>> update(@RequestBody DocumentTypeEntity documentTypeEntity){
        return this.documentTypeService.update(documentTypeEntity)
                .map(d -> new ResponseEntity<>(d, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return this.documentTypeService.delete(id).map(v -> new ResponseEntity<>(v, HttpStatus.OK));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el DocumentType, tipo String
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<DocumentTypeEntity>> find(@PathVariable String id){
        return this.documentTypeService.findById(id)
                .map(documentType -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(documentType));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el DocumentType, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public ResponseEntity<Mono<DocumentTypeEntity>> findByCode(@PathVariable String code){

        Optional<DocumentTypeEntity> documentTypeEntityOptional=documentTypeCacheService.findByCode(code);
        Mono<DocumentTypeEntity> documentTypeEntityFlux=Mono.just(documentTypeEntityOptional.orElse(new DocumentTypeEntity()));
        if(!documentTypeEntityOptional.isPresent()) {
            documentTypeEntityFlux= this.documentTypeService.findByCode(code);
            documentTypeEntityFlux.subscribe(s -> documentTypeCacheService.save(s));
        }
        return  ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(documentTypeEntityFlux) ;
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el DocumentType, tipo Flux
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<DocumentTypeEntity>>> findAll() {

        List<DocumentTypeEntity> documentTypeEntityList=documentTypeCacheService.findAll();
        Flux<DocumentTypeEntity> documentTypeEntityFlux=Flux.fromIterable(documentTypeEntityList);

        if(documentTypeEntityList.isEmpty()){
            documentTypeEntityFlux=this.documentTypeService.findAll();
            documentTypeEntityFlux.subscribe(d -> documentTypeCacheService.save(d));
        }
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(documentTypeEntityFlux)
        );

    }
}
