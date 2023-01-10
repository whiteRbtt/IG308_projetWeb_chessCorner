package com.IG308.chessCorner.model;

public class Language {

    private String code;
    private String name;

    public Language(){

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

    @Override
    public boolean equals(Object l){
        if(l instanceof Language){
            Language language = (Language) l;
            return language.getCode().equals(this.getCode()) && language.getName().equals(this.getName());
        }
        return false;
    }
}
