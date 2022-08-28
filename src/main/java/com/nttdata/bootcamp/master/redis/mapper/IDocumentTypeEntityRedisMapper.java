package com.nttdata.bootcamp.master.redis.mapper;

import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import com.nttdata.bootcamp.master.redis.entity.DocumentTypeCache;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDocumentTypeEntityRedisMapper {
    @Mappings({
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description")
    })
    DocumentTypeEntity toDocumentTypeEntity(DocumentTypeCache documentTypeCache);

    List<DocumentTypeEntity> toDocumentTypeEntityList(List<DocumentTypeCache> documentTypes);

    @InheritInverseConfiguration
    DocumentTypeCache toDocumentTypeCache(DocumentTypeEntity documentTypeEntity);
}
