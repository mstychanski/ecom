package ecom.pac.ctrl;

import ecom.pac.model.Product;
import ecom.pac.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/products")
public class ProductCtrl {

    private ProductService productService;

    public ProductCtrl(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    @ResponseBody
    public String addProduct(@RequestBody Product product) {
        productService.save(product);

        return "Added product: " + product.toString();
    }

    @GetMapping()
    @ResponseBody
    public Iterable<Product> list(@RequestParam(required = false) String category) {

        Iterable<Product> products;

        if (category != null) {
            products = () -> StreamSupport.stream(productService.list().spliterator(), false)
                    .filter(product -> product.getCategory().equals(category))
                    .iterator();
        }
        else {
            products = productService.list();
        }

        return products;
    }
}