package com.example.beer_app.services.customer;

import com.example.beer_app.web.data.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().customerId(customerId).customerName("Aman").build();
    }
}
