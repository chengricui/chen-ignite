package io.project.services;


import io.project.exceptions.ResourceNotFoundException;
import io.project.model.ProductType;
import io.project.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{

    @Autowired
    private ProductTypeRepository repository;


    @Override
    public List<ProductType> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductType findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public ProductType save(Long id, ProductType productType) {
        return repository.save(id, productType);
    }

    @Override
    public ProductType update(Long id, ProductType body) {
        ProductType productType = repository.findOne(id);
        productType.setName(body.getName());
        productType.setDescription(body.getDescription());
        return repository.save(productType);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        ProductType productType = repository.findOne(id);
        repository.delete(productType);
        return ResponseEntity.ok().build();
    }

    private ResourceNotFoundException errorHandler(Long id) {
        return  new ResourceNotFoundException("Product Not Found with id " +  id);
    }
}
