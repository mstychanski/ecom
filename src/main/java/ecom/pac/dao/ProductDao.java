package ecom.pac.dao;

import ecom.pac.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {

}
