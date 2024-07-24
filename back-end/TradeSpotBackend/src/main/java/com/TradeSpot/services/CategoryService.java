package com.TradeSpot.services;

import com.TradeSpot.DTO.CategoryDTO;
import com.TradeSpot.entities.Category;
import com.TradeSpot.repositories.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private  Imageservices imageservices;

    public Category saveCategory(CategoryDTO categoryDTO, MultipartFile file) throws IOException {

        String imgPath=imageservices.uploadFile(file, "Category");

//
        Category category= Category.builder().name(categoryDTO.getName())
                .categoryImgPath(imgPath).build();
        return categoryRepo.save(category);
    }

    public List<CategoryDTO> findAllCategories() {

        List<Category> categories=categoryRepo.findAll();
        return categories.stream().map(category -> mapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }

    public CategoryDTO findCategory(Long id) {

        Category category=categoryRepo.findById(id).orElseThrow();
        return mapper.map(category, CategoryDTO.class);
    }

    public String DeleteCategory(long id) {
        Category category=categoryRepo.findById(id).orElseThrow();
        categoryRepo.deleteById(id);
        return "Deleted successfully";


    }

    public Category findByName(String name){
        return categoryRepo.findByName(name);
    }
}
