package ecom.pac.ctrl;

import ecom.pac.dao.ProductDao;
import ecom.pac.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductCtrl {

    @Autowired
    private ProductDao dataAccessObject;

    @PostMapping("/addProduct")
    public String addProduct(Product product) {
        dataAccessObject.save(product);
        return "Added product: " + product.toString();
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return (List<Product>) dataAccessObject.findAll();
    }
}
