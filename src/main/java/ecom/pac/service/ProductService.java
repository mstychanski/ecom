package ecom.pac.service;

import ecom.pac.model.Product;
import ecom.pac.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Iterable<Product> list() {
        return productRepo.findAll();
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Iterable<Product> save(List<Product> products) {
        return productRepo.saveAll(products);
    }
}