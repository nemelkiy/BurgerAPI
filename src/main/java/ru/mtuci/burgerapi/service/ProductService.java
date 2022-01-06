package ru.mtuci.burgerapi.service;

import ru.mtuci.burgerapi.model.Product;

import java.util.List;

public interface ProductService {
    Product get(Long id);
    List<Product> getAll();
    Product save(Product product);
    Product update(Product product, Product updatedProduct);
    void delete(Long id);
}
