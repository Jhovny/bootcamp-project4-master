package com.nttdata.bootcamp.master.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeEntity {

    private String code;

    private String name;

    private String description;

}
