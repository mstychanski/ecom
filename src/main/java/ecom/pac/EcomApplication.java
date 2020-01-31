package ecom.pac;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ecom.pac.model.Product;
import ecom.pac.service.ProductService;
import ecom.pac.utils.ResponseUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/products.json");
			try {
				ResponseUtil response = mapper.readValue(inputStream, ResponseUtil.class);
				productService.save(response.items);
				System.out.println("Products loaded");
			} catch (IOException e) {
				System.out.println("Products failed to load" + e.getMessage());
			}
		};
	}
}
