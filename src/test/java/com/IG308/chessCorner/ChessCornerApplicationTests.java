package com.IG308.chessCorner;

import com.IG308.chessCorner.dataAccess.dao.ProductDAO;
import com.IG308.chessCorner.dataAccess.dao.ProductDataAccess;
import com.IG308.chessCorner.dataAccess.dao.UserDAO;
import com.IG308.chessCorner.dataAccess.dao.UserDataAccess;
import com.IG308.chessCorner.dataAccess.entity.LanguageEntity;
import com.IG308.chessCorner.dataAccess.entity.ProductEntity;
import com.IG308.chessCorner.dataAccess.entity.TranslationEntity;
import com.IG308.chessCorner.dataAccess.entity.UserEntity;
import com.IG308.chessCorner.dataAccess.repository.ProductRepository;
import com.IG308.chessCorner.dataAccess.repository.UserRepository;
import com.IG308.chessCorner.dataAccess.util.ProviderConverter;
import com.IG308.chessCorner.model.Language;
import com.IG308.chessCorner.model.Product;
import com.IG308.chessCorner.model.ProductTranslation;
import com.IG308.chessCorner.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ChessCornerApplicationTests {

	private ProductDataAccess productDAO;
	private UserDataAccess userDAO;
	private ProviderConverter providerConverter;

	@Mock
	private ProductRepository productRepository;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	public void setUp(){
		providerConverter = new ProviderConverter();
		productDAO = new ProductDAO(productRepository, providerConverter);
		userDAO = new UserDAO(userRepository, providerConverter);
	}

	@Test
	public void getProductById() {

		ProductEntity mockedProductEntity = new ProductEntity();
		mockedProductEntity.setProductId(15);
		mockedProductEntity.setPrice(14.99);

		LanguageEntity mockedLanguageEntity = new LanguageEntity();
		mockedLanguageEntity.setCode("fr");
		mockedLanguageEntity.setName("Français");

		ArrayList<TranslationEntity> mockedTranslations = new ArrayList<>();
		TranslationEntity mockedTranslationEntity = new TranslationEntity();
		mockedTranslationEntity.setProductName("Lunettes");
		mockedTranslationEntity.setProductDescription("De jolies lunettes");
		mockedTranslationEntity.setLanguageEntity(mockedLanguageEntity);
		mockedTranslationEntity.setProductEntity(mockedProductEntity);
		mockedTranslations.add(mockedTranslationEntity);

		mockedProductEntity.setProductTranslations(mockedTranslations);

		when(productRepository.getById(15)).thenReturn(mockedProductEntity);

		Language language = new Language();
		language.setCode("fr");
		language.setName("Français");

		Product product = new Product();
		product.setProductId(15);
		product.setPrice(14.99);

		ArrayList<ProductTranslation> translations = new ArrayList<>();
		ProductTranslation productTranslation = new ProductTranslation();
		productTranslation.setProductName("Lunettes");
		productTranslation.setProductDescription("De jolies lunettes");
		productTranslation.setLanguage(language);
		productTranslation.setProduct(product);

		translations.add(productTranslation);
		product.setProductTranslations(translations);

		Assert.assertEquals(productDAO.getProductById(15), product);
	}

	@Test
	public void getUserById() {

		Date birthdate = new Date(1999, 12, 31);

		UserEntity mockedUserEntity = new UserEntity();
		mockedUserEntity.setMailAddress("johndoe@pm.me");
		mockedUserEntity.setFirstName("John");
		mockedUserEntity.setLastName("Doe");
		mockedUserEntity.setHashedPwd("123456789");
		mockedUserEntity.setPhoneNumber("0123456789");
		mockedUserEntity.setAddress("1 rue de la paix");
		mockedUserEntity.setBirthDate(birthdate);

		when(userRepository.findByMailAddress("johndoe@pm.me")).thenReturn(mockedUserEntity);

		User user = new User();
		user.setUsername("johndoe@pm.me");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setPassword("123456789");
		user.setPhoneNumber("0123456789");
		user.setAddress("1 rue de la paix");
		user.setBirthDate(birthdate);

		Assert.assertEquals(userDAO.findByMailAddress("johndoe@pm.me"), user);
	}
}
