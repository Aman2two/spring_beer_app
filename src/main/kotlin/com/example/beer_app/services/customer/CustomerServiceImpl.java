package com.example.beer_app.services.customer;

import com.example.beer_app.web.data.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().customerId(customerId).customerName("Aman").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().customerId(customerDto.getCustomerId()).customerName(customerDto.getCustomerName()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        CustomerDto.builder().customerId(customerId).customerName(customerDto.getCustomerName());
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Delete user customer id-- "+ customerId);
    }
}
