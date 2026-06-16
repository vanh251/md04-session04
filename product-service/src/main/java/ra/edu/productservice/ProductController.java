package ra.edu.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @GetMapping()
    public ArrayList<String> getProducts() {
        return new ArrayList<String>() {{;
            add("Product 1");
            add("Product 2");
            add("Product 3");
        }};
    }
}
