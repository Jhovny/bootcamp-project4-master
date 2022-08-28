package com.nttdata.bootcamp.master.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeCache implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String code;
    private String name;
    private String description;
    private boolean state;

}
