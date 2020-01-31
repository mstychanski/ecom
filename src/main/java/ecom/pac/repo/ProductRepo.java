package ecom.pac.repo;

import ecom.pac.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, String> { }