package courseSpringBoot.controllers;

import courseSpringBoot.domain.Product;
import courseSpringBoot.service.ProductsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductsServiceImpl productsService = new ProductsServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }
}
