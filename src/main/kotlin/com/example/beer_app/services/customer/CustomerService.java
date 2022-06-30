package com.example.beer_app.services.customer;

import com.example.beer_app.web.data.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
