/**
 * Resumen.
 * Objeto                   : DocumentTypeServiceImpl.java
 * Descripción              : Clase para los métodos de la implementación de
 *                              servicio de la cuenta.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * --------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * -------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar
 *                              la creación de un método nuevo.
 */

package com.nttdata.bootcamp.master.persistence.service.impl;

import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import com.nttdata.bootcamp.master.domain.repository.IDocumentTypeRepository;
import com.nttdata.bootcamp.master.persistence.mapper.IDocumentTypeMapper;
import com.nttdata.bootcamp.master.persistence.model.dao.DocumentTypeDao;
import com.nttdata.bootcamp.master.persistence.model.document.DocumentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase para los métodos de la implementación de servicio del tipo de documento.
 */
@Service
public class DocumentTypeServiceImpl implements IDocumentTypeRepository {

    /** Declaración de la variable de log */
    private static final Logger log = LoggerFactory.getLogger(DocumentTypeServiceImpl.class);

    /** Declaración de la clase dao */
    @Autowired
    private DocumentTypeDao documentTypeDao;
    @Autowired
    private IDocumentTypeMapper mapper;


    @Override
    public Mono<DocumentTypeEntity> save(DocumentTypeEntity documentTypeEntity) {


        Mono<DocumentType> documentTypeMono=      documentTypeDao.save( mapper.mapToModel(documentTypeEntity) )
                .doFirst(() -> log.info("Begin Insert DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert DocumentType"));

        return  mapper.mapMonoToViewModel(documentTypeMono);
    }

    @Override
    public Mono<DocumentTypeEntity> update(DocumentTypeEntity documentTypeEntity) {

       DocumentType documentType=mapper.mapToModel(documentTypeEntity);

        return mapper.mapMonoToViewModel( documentTypeDao.findById(documentType.getId())
                .doFirst(() -> log.info("Begin Update DocumentType"))
                .map(t -> documentType)
                .flatMap(this.documentTypeDao::save)
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish Update DocumentType")));
    }

    @Override
    public Mono<Void> delete(String id) {
        return documentTypeDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete DocumentType"));


    }

    @Override
    public Mono<DocumentTypeEntity> findById(String id) {
        return  mapper.mapMonoToViewModel( documentTypeDao.findById(id)
                .doFirst(() -> log.info("Begin Find DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish Find DocumentType")));
    }

    @Override
    public Mono<DocumentTypeEntity> findByCode(String code) {


       Mono<DocumentType> documentTypeMono=  documentTypeDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode DocumentType"))
                ;

       return mapper.mapMonoToViewModel(documentTypeMono);
    }

    @Override
    public Flux<DocumentTypeEntity> findAll() {

        return  mapper.mapFluxToViewModel( documentTypeDao.findAll()
                .doFirst(() -> log.info("Begin FindAll DocumentType"))
                .doOnNext(d -> log.info(d.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll DocumentType")));


    }

}
