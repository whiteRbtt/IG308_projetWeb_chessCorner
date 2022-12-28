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
    public String toString() {
    	return "Language [code=" + code + ", name=" + name + "]";
    }
}
