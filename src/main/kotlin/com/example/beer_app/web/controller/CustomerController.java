package com.example.beer_app.web.controller;


import com.example.beer_app.services.customer.CustomerService;
import com.example.beer_app.web.data.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId){
        return  new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity saveCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer=customerService.saveCustomer(customerDto);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("location",savedCustomer.getCustomerId().toString());
        return  new ResponseEntity(httpHeaders.getLocation(),HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateCustomer(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDto customerDto ){
        customerService.updateCustomer(customerId,customerDto);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable("customerId") UUID customerId ){
        customerService.deleteCustomer(customerId);
    }

}
