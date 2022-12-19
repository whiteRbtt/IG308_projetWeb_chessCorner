package com.IG308.chessCorner.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productId")
    private Integer productId;

    @Column(name="price")
    private Double price;

    @OneToMany(mappedBy="productEntity", fetch=FetchType.LAZY)
    private Collection<TranslationEntity> productTranslations;

    public ProductEntity(){

    }
}
