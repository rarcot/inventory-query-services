package com.sapient.controller;

import com.sapient.dao.category.CategoryDAO;
import com.sapient.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by rarcot on 8/8/2016.
 */



@Controller
@RequestMapping("/")
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "categories",method = RequestMethod.GET)
    public HttpEntity<List<Category>> listCategories(){
       return new ResponseEntity<List<Category>>(categoryDAO.getAllCategories(), HttpStatus.OK);
    }
}
