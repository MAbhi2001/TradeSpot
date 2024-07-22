package com.TradeSpot.services;

import com.TradeSpot.DTO.CategoryDTO;
import com.TradeSpot.entities.ApiResponse;
import com.TradeSpot.entities.Category;
import com.TradeSpot.repositories.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper mapper;

    public Category saveCategory(CategoryDTO categoryDTO) {

        Category category=mapper .map(categoryDTO, Category.class);
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
