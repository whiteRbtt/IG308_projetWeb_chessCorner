package com.IG308.chessCorner.dataAccess.util;

import com.IG308.chessCorner.dataAccess.entity.*;
import com.IG308.chessCorner.model.*;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setMailAddress(user.getUsername());
        userEntity.setHashedPwd(user.getPassword());
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = mapper.map(userEntity, User.class);
        user.setUsername(userEntity.getMailAddress());
        user.setPassword(userEntity.getHashedPwd());
        return user;
    }

    public ProductEntity productModelToProductEntity(Product product) {
        ProductEntity productEntity = mapper.map(product, ProductEntity.class);
        return productEntity;
    }

    public Product productEntityToProductModel(ProductEntity productEntity) {
        Product product = mapper.map(productEntity, Product.class);

        ArrayList<ProductTranslation> productTranslations = new ArrayList<>();
        for (TranslationEntity translationEntity : productEntity.getProductTranslations()) {
            ProductTranslation productTranslation = translationEntityToTranslationModel(translationEntity);
            productTranslation.setProduct(product);
            productTranslations.add(productTranslation);
        }
        product.setProductTranslations(productTranslations);

        return product;
    }

//    public LanguageEntity languageModelToLanguageEntity(Language language) {
//        LanguageEntity languageEntity = mapper.map(language, LanguageEntity.class);
//        return languageEntity;
//    }

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        Language language = mapper.map(languageEntity, Language.class);
        return language;
    }

//    public TranslationEntity translationModelToTranslationEntity(ProductTranslation productTranslation) {
//        TranslationEntity translationEntity = mapper.map(productTranslation, TranslationEntity.class);
//        translationEntity.setProductEntity(productModelToProductEntity(productTranslation.getProduct()));
//        translationEntity.setLanguageEntity(languageModelToLanguageEntity(productTranslation.getLanguage()));
//        return translationEntity;
//    }

    public ProductTranslation translationEntityToTranslationModel(TranslationEntity translationEntity) {
        ProductTranslation productTranslation = mapper.map(translationEntity, ProductTranslation.class);
        productTranslation.setLanguage(languageEntityToLanguageModel(translationEntity.getLanguageEntity()));
        return productTranslation;
    }

    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = mapper.map(orderLine, OrderLineEntity.class);
        orderLineEntity.setProductEntity(productModelToProductEntity(orderLine.getProduct()));
        orderLineEntity.setOrderEntity(orderModelToOrderEntity(orderLine.getOrder()));
        return orderLineEntity;
    }

    public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity) {
        OrderLine orderLine = mapper.map(orderLineEntity, OrderLine.class);
        orderLine.setProduct(productEntityToProductModel(orderLineEntity.getProductEntity()));
        orderLine.setOrder(orderEntityToOrderModel(orderLineEntity.getOrderEntity()));
        return orderLine;
    }

    public OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = mapper.map(order, OrderEntity.class);
        orderEntity.setOrderId(order.getOrderId());
        orderEntity.setUserEntity(userModelToUserEntity(order.getUser()));
        orderEntity.setOrderDate(new java.sql.Date(order.getOrderDate().getTime()));
        return orderEntity;
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        Order order = mapper.map(orderEntity, Order.class);
        order.setUser(userEntityToUserModel(orderEntity.getUserEntity()));
        return order;
    }
}
