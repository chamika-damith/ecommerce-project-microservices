package com.example.productservice.controller;

import com.example.productservice.customstatus.ErrorStatus;
import com.example.productservice.customstatus.SuccessStatus;
import com.example.productservice.dto.CustomStatus;
import com.example.productservice.dto.impl.ProductDTO;
import com.example.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomStatus saveProduct(@RequestBody ProductDTO productDTO){
        if (productDTO == null){
            return new ErrorStatus(204, "Error saving product");
        }

        productService.save(productDTO);
        return new SuccessStatus(201,"Product saved successfully!");
    }

    @PutMapping(value = "/{productId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomStatus updateProduct(@RequestBody ProductDTO productDTO,@PathVariable Long productId){
        if (productDTO == null){
            return new ErrorStatus(204, "Error update product");
        }

        productService.update(productId,productDTO);
        return new SuccessStatus(201,"Product update successfully!");
    }

    @GetMapping(value = "/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO getProduct(@PathVariable Long productId){
        return productService.get(productId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getAllProducts(){
        return productService.getAll();
    }

    @DeleteMapping(value = "/{productId}")
    public CustomStatus deleteProduct(@PathVariable Long productId){
        if (productId == null){
            return new ErrorStatus(204, "Error delete product");
        }

        productService.delete(productId);
        return new SuccessStatus(200, "Success delete product");
    }



}
