package ru.mtuci.burgerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.mtuci.burgerapi.dao.ProductRepo;
import ru.mtuci.burgerapi.model.Product;

import java.util.List;

@Service
public class ProductServiceImplode implements ProductService{

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImplode(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product get(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product update(Product product, Product updatedProduct) {
        product.setName(updatedProduct.getName());
        product.setWeight(updatedProduct.getWeight());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        return productRepo.save(product);
    }


}
