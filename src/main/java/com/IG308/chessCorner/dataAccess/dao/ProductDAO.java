package com.IG308.chessCorner.dataAccess.dao;

import com.IG308.chessCorner.dataAccess.repository.ProductRepository;
import com.IG308.chessCorner.dataAccess.util.ProviderConverter;
import com.IG308.chessCorner.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO implements ProductDataAccess{
    private ProductRepository productRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public ProductDAO(ProductRepository productRepository, ProviderConverter providerConverter) {
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;
    }

    public Product getProductById(int id){
        return providerConverter.productEntityToProductModel(productRepository.getById(id));
    }

    @Override
    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(productEntity -> products.add(providerConverter.productEntityToProductModel(productEntity)));
        return products;
    }
}
