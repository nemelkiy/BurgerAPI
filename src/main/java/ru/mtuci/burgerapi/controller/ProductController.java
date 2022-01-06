package ru.mtuci.burgerapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.burgerapi.model.Product;
import ru.mtuci.burgerapi.service.ProductService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = ProductController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    public static final String REST_URL = "api/v1/product";

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Take product by Id
    @GetMapping(value = "/{id}")
    public Product get(@PathVariable("id") Long id) {
        log.info("get" + id);
        return productService.get(id);
    }
    //Take all Id
    @GetMapping
    public List<Product> getAll() {
        log.info("getAllId");
        return productService.getAll();
    }
    //Insert new raw in DB
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product save(@RequestBody Product product) {
        log.info("New product saved");
        return productService.save(product);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete " + id);
        productService.delete(id);
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product update(@PathVariable("id") Long id, @RequestBody Product product) {
        log.info("updated " + product);
        Product oldProduct = productService.get(id);
        if (oldProduct != null) {
            return productService.update(oldProduct, product);
        } else {
            return null;
        }
    }
}
