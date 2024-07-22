package com.TradeSpot.services;

import com.TradeSpot.DTO.ProductDTO;
import com.TradeSpot.customException.CustomException;
import com.TradeSpot.entities.Category;
import com.TradeSpot.entities.Product;
import com.TradeSpot.entities.User;
import com.TradeSpot.repositories.ProductRepo;
import com.TradeSpot.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CategoryServices categoryServices;

    @Autowired
    private UserRepo userRepo;


    public Product saveProduct(ProductDTO productDTO, String categoryName, Long userId) {

        Category category=categoryServices.findByName(categoryName);
        User user = userRepo.findById(userId).orElseThrow();

        Product product=mapper.map(productDTO, Product.class);
        product.setCategory(category);
        product.setUser(user);
        return productRepo.save(product);




    }

    public List<ProductDTO> getALlProducts() {

        List<Product> productList=productRepo.findAll();
        return productList.stream().map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }

    public ProductDTO getProductById(long productId) throws CustomException {
        Product product = productRepo.findById(productId)
                                     .orElseThrow(()-> new CustomException("Product not found with id : "+ productId));

        return mapper.map(product, ProductDTO.class);

    }

    public String deleteProduct(long productId) throws CustomException {
        Product product = productRepo.findById(productId)
                                     .orElseThrow(()-> new CustomException("Product not found with id : "+ productId));
        product.setUser(null);
        product.setCategory(null);
        productRepo.deleteById(productId);
        return "Product deleted successfully";


    }
}
