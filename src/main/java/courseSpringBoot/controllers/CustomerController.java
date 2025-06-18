package courseSpringBoot.controllers;

import courseSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/clients")
    public List<Customer> getCustomers()
    {
        return customers;
    }

    @GetMapping("/clients/{username}")
    public Customer getClient(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping("/clients")
    public Customer postClient(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @PutMapping("/clients")
    public Customer putClient(@RequestBody Customer customer) {
        for (Customer c : customers){
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return customer;
            }
        }
        return null;
    }

    @DeleteMapping("/clients/{id}")
    public Customer deleteClient(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
                return c;
            }
        }
        return null;
    }
}
