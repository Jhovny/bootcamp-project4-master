package com.nttdata.bootcamp.master.domain.service;

import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import com.nttdata.bootcamp.master.domain.repository.IDocumentTypeRepository;
import com.nttdata.bootcamp.master.redis.DocumentTypeCacheRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DocumentTypeService {

    @Autowired
    private IDocumentTypeRepository iDocumentTypeRepository;



    public Flux<DocumentTypeEntity> findAll() {
        return iDocumentTypeRepository.findAll();
    }


    public Mono<DocumentTypeEntity> findById(String id) {
        return iDocumentTypeRepository.findById( id);
    }
    public Mono<DocumentTypeEntity> findByCode(String code) {
        return iDocumentTypeRepository.findByCode( code);
    }

    public Mono<DocumentTypeEntity> save(DocumentTypeEntity documentTypeEntity) {

       return iDocumentTypeRepository.save(documentTypeEntity);
    }
    public Mono<DocumentTypeEntity> update(DocumentTypeEntity documentTypeEntity) {

       return iDocumentTypeRepository.save(documentTypeEntity);
    }

    public Mono<Void> delete(String id) {
     return   iDocumentTypeRepository.delete(id);

    }

}
