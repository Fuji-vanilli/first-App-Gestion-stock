package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.CustomerMapping;
import com.gestionStock.stockgestion.DTOs.request.CustomerRequest;
import com.gestionStock.stockgestion.DTOs.response.CustomerResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Customer;
import com.gestionStock.stockgestion.repositories.CustomerRepository;
import com.gestionStock.stockgestion.service.CustomerService;
import com.gestionStock.stockgestion.validator.CustomerValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapping customerMapping;

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        List<String> errors= CustomerValidator.validate(customerRequest);

        if(!errors.isEmpty()){
            log.error("the customer is not valid");
            throw new InvalidEntityException(
                    "the customer is not valid",
                    ErrorCode.CUSTOMER_NOT_VALID,
                    errors
            );
        }

        Customer customer= customerMapping.customerRequestToCustomer(customerRequest);

        customer.setId(UUID.randomUUID().toString());

        return customerMapping.customerToCustomerResponse(
                customerRepository.save(customer)
        );
    }

    @Override
    public CustomerResponse getById(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return null;
        }

        Optional<Customer> customer= customerRepository.findById(id);

        CustomerResponse customerResponse= customerMapping.customerToCustomerResponse(customer.get());

        return Optional.of(customerResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "customer with the id: "+id+" doesn't exist in the database",
                        ErrorCode.CUSTOMER_NOT_FOUND
            )
        );
    }

    @Override
    public CustomerResponse getByEmail(String email) {
        if(!StringUtils.hasLength(email)){
            log.error("email doesn't null");
            return null;
        }

        Optional<Customer> customer= customerRepository.findByEmail(email);

        CustomerResponse customerResponse= customerMapping.customerToCustomerResponse(customer.get());

        return Optional.of(customerResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "customer with the email: "+email+" doesn't exist int the database",
                        ErrorCode.CUSTOMER_NOT_FOUND
                )
        );
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer-> customerMapping.customerToCustomerResponse(customer))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return false;
        }
        customerRepository.deleteById(id);
        return true;
    }
}
