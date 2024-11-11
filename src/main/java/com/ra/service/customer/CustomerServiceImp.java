package com.ra.service.customer;

import com.ra.model.dto.customer.CustomerRequestDTO;
import com.ra.model.dto.customer.CustomerResponseDTO;
import com.ra.model.entity.Customer;
import com.ra.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponseDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        //convert entity --> DTO
        List<CustomerResponseDTO> responseDTOS = new ArrayList<>();
        customers.forEach(customer -> responseDTOS
                .add(CustomerResponseDTO.builder()
                        .id(customer.getId())
                        .fullName(customer.getFullName())
                        .email(customer.getEmail())
                        .birthday(customer.getBirthday())
                        .build()));
        return responseDTOS;
    }

    @Override
    public CustomerResponseDTO create(CustomerRequestDTO customerRequestDTO) {
        Customer customer = Customer.builder()
                .fullName(customerRequestDTO.getFullName())
                .email(customerRequestDTO.getEmail())
                .password(customerRequestDTO.getPassword())
                .birthday(customerRequestDTO.getBirthday())
                .build();

        //convert entity --> DTO
        Customer customerNew = customerRepository.save(customer);
        CustomerResponseDTO responseDTO = CustomerResponseDTO.builder()
                .id(customerNew.getId())
                .fullName(customerNew.getFullName())
                .email(customerNew.getEmail())
                .birthday(customer.getBirthday())
                .build();
        return responseDTO;
    }
}
