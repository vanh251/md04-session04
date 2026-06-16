package ra.edu.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor

public class OrderController {
    private final ProductFeign productFeign;
    private final DiscoveryClient discoveryClient;

    @GetMapping
    public ArrayList<String> getProductsFromProductService() {
        //b1
        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
        //b2
        if(instances == null || instances.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Product Service is not available");
        }
//        //b3
//        ServiceInstance serviceInstance = instances.get(0);
//        //b4 lay url goc
//        String baseUrl = serviceInstance.getUri().toString();
//        //b5 noi chuoi de tao url cuoi cung
//        String url = baseUrl + "/api/products";
        //b6 goi rest template
//        return restTemplate.getForObject(url, ArrayList.class);
        return productFeign.getProducts();
    }
}
