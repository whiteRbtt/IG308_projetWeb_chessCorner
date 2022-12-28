package com.IG308.chessCorner.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productid")
    private Integer productId;

    @Column(name="price")
    private Double price;

    @OneToMany(mappedBy="productEntity", fetch=FetchType.LAZY)
    private Collection<TranslationEntity> productTranslations;

    public ProductEntity(){

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Collection<TranslationEntity> getProductTranslations() {
        return productTranslations;
    }

    public void setProductTranslations(Collection<TranslationEntity> productTranslations) {
        this.productTranslations = productTranslations;
    }
}
