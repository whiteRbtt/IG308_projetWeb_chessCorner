package com.IG308.chessCorner.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="translation")
public class TranslationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="translationid")
    private Integer translationId;

    @Column(name="productname")
    private String productName;

    @Column(name="productdescription")
    private String productDescription;

    @JoinColumn(name="productid", referencedColumnName="productid")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity productEntity;

    @JoinColumn(name="languagecode", referencedColumnName="code")
    @ManyToOne(fetch = FetchType.LAZY)
    private LanguageEntity languageEntity;

    public TranslationEntity(){
    }

    public Integer getTranslationId() {
        return translationId;
    }

    public void setTranslationId(Integer translationId) {
        this.translationId = translationId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public LanguageEntity getLanguageEntity() {
        return languageEntity;
    }

    public void setLanguageEntity(LanguageEntity languageEntity) {
        this.languageEntity = languageEntity;
    }
}
