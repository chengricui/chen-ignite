package io.project.services;

import io.project.model.ProductType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductTypeService {

    List<ProductType> findAll();

    ProductType findOne(Long id);

    ProductType save(Long id, ProductType productType);

    ProductType update(Long id, ProductType productType);

    ResponseEntity<?> delete(Long id);
}
