package com.TradeSpot.controllers;


import com.TradeSpot.DTO.CategoryDTO;
import com.TradeSpot.entities.ApiResponse;
import com.TradeSpot.entities.Category;
import com.TradeSpot.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;

    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(@RequestBody CategoryDTO categoryDTO){
        Category category=categoryServices.saveCategory(categoryDTO);
        if(category!= null){
            return  ResponseEntity.ok().body(new ApiResponse("Category added successfully"));
        }

        else {
            return  ResponseEntity.status(500).body(new ApiResponse("Unsuccessful: Category not added"));
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categoryDTOS = categoryServices.findAllCategories();
        if(categoryDTOS!= null){
            return  ResponseEntity.ok( categoryDTOS);
        }

        else {
            return  ResponseEntity.status(500).build();
        }

    }

    @GetMapping( path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDTO> getAllCategories(@PathVariable long id){
        CategoryDTO categoryDTO = categoryServices.findCategory(id);
        if(categoryDTO!= null){
            return  ResponseEntity.ok( categoryDTO);
        }

        else {
            return  ResponseEntity.status(500).build();
        }

    }

    @DeleteMapping( path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable long id){

         return ResponseEntity.ok().body(new ApiResponse(categoryServices.DeleteCategory(id)));


    }




}
