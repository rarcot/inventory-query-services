package com.sapient.controller; /**
 * Created by rarcot on 8/8/2016.
 */
import com.sapient.dao.category.ProductDAO;
import com.sapient.domain.Category;
import com.sapient.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/cat/{catId}/products",method = RequestMethod.GET)
    public List<Product> getCategoryProduct(@PathVariable("catId") String categoryId){
        return null;
    }

    @RequestMapping(value="/product/{id}")
    public HttpEntity<? extends Object> getProductById(@PathVariable("id") String productId){
        try{
            return new ResponseEntity(productDAO.getProductById(productId), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
