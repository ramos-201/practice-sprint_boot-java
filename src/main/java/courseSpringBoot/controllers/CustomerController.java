package courseSpringBoot.controllers;

import courseSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class CustomerController {

    private final List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Andres Ramos", "andres.ramos", "andres_password"),
            new Customer(2, "Raul Perez", "raul.perez", "raul_password"),
            new Customer(3, "Juan Gonzales", "juan.gonzales", "juan_password"),
            new Customer(4, "Saul Silva", "saul.silva", "saul_password")
    ));

    @GetMapping("clients")
    public List<Customer> getCustomers()
    {
        return customers;
    }
}