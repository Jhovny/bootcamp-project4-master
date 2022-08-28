package com.nttdata.bootcamp.master.domain.repository;



import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface IDocumentTypeRedisRepository {
    List<DocumentTypeEntity> findAll();
    DocumentTypeEntity findById(String id);
    Optional<DocumentTypeEntity> findByCode(String code);
    void save(DocumentTypeEntity afiliado);
    void delete(String id);
}
