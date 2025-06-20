package courseSpringBoot.service;

import courseSpringBoot.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsServiceImpl implements ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "laptop", 799.99, 10),
            new Product(2, "Tablet", 499.99, 25),
            new Product(3, "Smartphone", 599.99, 60),
            new Product(4, "Smartwatch", 299.99, 1)
    ));

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
