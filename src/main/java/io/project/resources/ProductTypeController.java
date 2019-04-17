package io.project.resources;

import io.project.model.ProductType;
import io.project.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductTypeController {

    @Autowired
    private ProductTypeService service;

    @GetMapping(path = "/types")
    public List<ProductType> getTypes() {
        return service.findAll();
    }

    @PostMapping(path = "/types/")
    public ProductType addType(@Valid @RequestBody ProductType body) {
        return service.save(1L, body);
    }
}
