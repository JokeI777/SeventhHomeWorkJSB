package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TodoController {

    private final CustomerRepository customerRepository;

    public TodoController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/user")
    public List<Customer> getUsers(){
        List<Customer> customers = new ArrayList<>();

        customerRepository.findAll()
                .forEach(customers::add);
        return customers;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody CustomerInput customerInput){
        var customer = new Customer();
        customer.setName(customerInput.getName());
        customer.setEvents(customerInput.getEvents());
        customerRepository.save(customer);
    }

    static class CustomerInput {
        private Long customerId;
        private String name;
        private List<String> events;

        public CustomerInput(Long customerId, String name, List<String> events){
            this.customerId = customerId;
            this.name = name;
            this.events = events;
        }

        public List<String> getEvents() {
            return events;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setEvents(List<String> events) {
            this.events = events;
        }
    }
}
