package com.nttdata.bootcamp.master.domain.repository;



import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public interface IDocumentTypeRepository {

    Flux<DocumentTypeEntity> findAll();
    Mono<DocumentTypeEntity> findById(String id);
    Mono<DocumentTypeEntity> findByCode(String code);
    Mono<DocumentTypeEntity> save(DocumentTypeEntity documentTypeEntity);
    Mono<DocumentTypeEntity> update(DocumentTypeEntity documentTypeEntity);

    Mono<Void> delete(String id);

}
