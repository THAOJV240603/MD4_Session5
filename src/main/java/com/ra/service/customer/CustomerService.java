package com.ra.service.customer;

import com.ra.model.dto.customer.CustomerRequestDTO;
import com.ra.model.dto.customer.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDTO> findAll();
    CustomerResponseDTO create(CustomerRequestDTO customerRequestDTO);
}
