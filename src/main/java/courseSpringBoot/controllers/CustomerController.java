package courseSpringBoot.controllers;

import courseSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/clients")
public class CustomerController {

    private final List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Andres Ramos", "andres.ramos", "andres_password"),
            new Customer(2, "Raul Perez", "raul.perez", "raul_password"),
            new Customer(3, "Juan Gonzales", "juan.gonzales", "juan_password"),
            new Customer(4, "Saul Silva", "saul.silva", "saul_password")
    ));

    @RequestMapping(method = RequestMethod.GET)
    // @GetMapping
    public List<Customer> getCustomers()
    {
        return customers;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    // @GetMapping("/{username}")
    public Customer getClient(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }


    @RequestMapping(method = RequestMethod.POST)
    // @PostMapping
    public Customer postClient(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @RequestMapping(method = RequestMethod.PUT)
    // @PutMapping
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    // @DeleteMapping("/{id}")
    public Customer deleteClient(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    // @PatchMapping
    public Customer patchClient(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }

                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }

                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }

                return c;
            }
        }
        return null;
    }
}
