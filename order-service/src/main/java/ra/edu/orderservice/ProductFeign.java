package ra.edu.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@FeignClient(name = "product-service")
public interface ProductFeign {
    @GetMapping("/api/products")
    ArrayList<String> getProducts();
}
