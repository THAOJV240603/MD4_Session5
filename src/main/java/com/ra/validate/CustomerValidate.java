package com.ra.validate;

import com.ra.repository.CustomerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component: bao gồm service, controller, repository
@Component
public class CustomerValidate implements ConstraintValidator<CustomerUnique, String> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !customerRepository.existsCustomerByEmail(value);
    }
}
