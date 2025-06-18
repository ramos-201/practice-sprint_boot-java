package courseSpringBoot.controllers;

import courseSpringBoot.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers()
    {
        return ResponseEntity.ok(customers);
    }

    // @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public ResponseEntity<?> getClient(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Client with username: '" + username + "' not found.");
    }


    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> postClient(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Client: '" + customer.getName() + "' created successfully.");
    }

    // @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> putClient(@RequestBody Customer customer) {
        for (Customer c : customers){
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return ResponseEntity.ok("Client: '" + customer.getName() + "' updated successfully.");
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Client with id: '" + customer.getId() + "' not found.");
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body("Client with id: '" + c.getId() + "' deleted successfully.");
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Client with id: '" + id + "' not found.");
    }

    // @RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public ResponseEntity<?> patchClient(@RequestBody Customer customer) {
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

                return ResponseEntity.ok("Client whit id: '" +  c.getId() + "' updated successfully.");
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Client with id: '" + customer.getId() + "' not found.");
    }
}
