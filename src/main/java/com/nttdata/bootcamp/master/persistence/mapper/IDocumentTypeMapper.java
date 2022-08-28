package com.nttdata.bootcamp.master.persistence.mapper;

import com.nttdata.bootcamp.master.domain.DocumentTypeEntity;
import com.nttdata.bootcamp.master.persistence.model.document.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDocumentTypeMapper {

    @Mappings({
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description")
    })
    DocumentType mapToModel(DocumentTypeEntity viewModel);

    @Mappings({
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description")
    })
    DocumentTypeEntity mapToViewModel(DocumentType model);

    List<DocumentType> mapListToModel(List<DocumentTypeEntity> viewModels);

    List<DocumentTypeEntity> mapListToViewModel(List<DocumentType> models);

    default Mono<DocumentType> mapMonoToModel(Mono<DocumentTypeEntity> viewModel) {
        return viewModel.map(this::mapToModel);
    }

    default Mono<DocumentTypeEntity> mapMonoToViewModel(Mono<DocumentType> model) {
        return model.map(this::mapToViewModel);
    }

    default Flux<DocumentType> mapFluxToModel(Flux<DocumentTypeEntity> viewModels) {
        return viewModels.map(this::mapToModel);
    }

    default Flux<DocumentTypeEntity> mapFluxToViewModel(Flux<DocumentType> models) {
        return models.map(this::mapToViewModel);
    }
}
