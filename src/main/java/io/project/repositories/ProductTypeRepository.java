package io.project.repositories;


import io.project.model.Flight;
import io.project.model.ProductType;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryConfig(cacheName = "ProductTypeCache")
@Component
@Repository
public interface ProductTypeRepository extends IgniteRepository<ProductType, Long> {
    @Override
    List<ProductType> findAll();

    @Override
    ProductType findOne(Long id);
}
