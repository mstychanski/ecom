package ecom.pac.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import ecom.pac.model.Product;

import java.util.List;

public class ResponseUtil {

    @JsonProperty("items")
    public List<Product> items;

    public ResponseUtil() {
    }
}