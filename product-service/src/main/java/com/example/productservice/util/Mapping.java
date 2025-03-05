package com.example.productservice.util;

import com.example.productservice.dto.impl.ProductDTO;
import com.example.productservice.entity.impl.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    private ModelMapper modelMapper;

    public Mapping(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //product mapping
    public Product toProductEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO,Product.class);
    }

    public ProductDTO toProductDTO(Product product){
        return modelMapper.map(product,ProductDTO.class);
    }

    public List<Product> toProductEntityList(List<ProductDTO> productDTOs){
        return modelMapper.map(productDTOs,new TypeToken<Product>() {}.getType());
    }

    public List<ProductDTO> toProductDTOList(List<Product> products){
        return modelMapper.map(products,new TypeToken<ProductDTO>() {}.getType());
    }
}
