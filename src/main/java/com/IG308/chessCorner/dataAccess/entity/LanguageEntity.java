package com.IG308.chessCorner.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="supported_language")
public class LanguageEntity {

    @Id
    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    public LanguageEntity(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
