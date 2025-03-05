package com.example.productservice.service.impl;

import com.example.productservice.dao.ProductDao;
import com.example.productservice.dto.impl.ProductDTO;
import com.example.productservice.entity.impl.Product;
import com.example.productservice.service.ProductService;
import com.example.productservice.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final Mapping productMapper;

    public ProductServiceImpl(ProductDao productDao, Mapping productMapper) {
        this.productDao = productDao;
        this.productMapper = productMapper;
    }

    @Override
    public void save(ProductDTO dto) {
        Product productEntity = productMapper.toProductEntity(dto);
        productDao.save(productEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<Product> byId = productDao.findById(id);
        if (byId.isPresent()){
            productDao.deleteById(id);
        }
    }

    @Override
    public void update(Long id, ProductDTO dto) {
        Optional<Product> byId = productDao.findById(id);
        if(byId.isPresent()) {
            Product product = byId.get();

            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setStock(dto.getStock());

            productDao.save(product);
        }
    }

    @Override
    public ProductDTO get(Long id) {
        if(productDao.existsById(id)){
            Product referenceById = productDao.getReferenceById(id);

            return productMapper.toProductDTO(referenceById);
        }
        return null;
    }

    @Override
    public List<ProductDTO> getAll() {
        return productMapper.toProductDTOList(productDao.findAll());
    }
}
