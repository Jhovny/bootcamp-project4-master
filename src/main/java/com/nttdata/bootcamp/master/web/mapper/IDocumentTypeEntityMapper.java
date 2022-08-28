package com.nttdata.bootcamp.master.web.mapper;

import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import com.nttdata.bootcamp.master.persistence.model.document.DocumentType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDocumentTypeEntityMapper {
    @Mappings({

            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
    })
    DocumentTypeEntity toDocumentTypeEntity(DocumentType documentType);

    List<DocumentTypeEntity> toDocumentTypeEntityList(List<DocumentType> documentTypes);

    @InheritInverseConfiguration
    DocumentType toDocumentType(DocumentTypeEntity documentTypeEntity);
}
