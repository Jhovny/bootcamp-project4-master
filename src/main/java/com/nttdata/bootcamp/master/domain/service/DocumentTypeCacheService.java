package com.nttdata.bootcamp.master.domain.service;

import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import com.nttdata.bootcamp.master.domain.repository.IDocumentTypeRedisRepository;
import com.nttdata.bootcamp.master.redis.DocumentTypeCacheRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeCacheService {

    @Autowired
    private DocumentTypeCacheRepositoryImpl iDocumentTypeRedisRepository;



    public List<DocumentTypeEntity> findAll() {
        return iDocumentTypeRedisRepository.findAll();
    }


    public DocumentTypeEntity findById(String id) {
        return iDocumentTypeRedisRepository.findById( id);
    }
    public Optional<DocumentTypeEntity> findByCode(String code) {
        return iDocumentTypeRedisRepository.findByCode( code);
    }

    public void save(DocumentTypeEntity documentTypeEntity) {

        iDocumentTypeRedisRepository.save(documentTypeEntity);
    }


    public void delete(String id) {
        iDocumentTypeRedisRepository.delete(id);

    }

}
