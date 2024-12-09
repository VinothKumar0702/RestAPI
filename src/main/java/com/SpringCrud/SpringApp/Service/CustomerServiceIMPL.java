package com.SpringCrud.SpringApp.Service;

import com.SpringCrud.SpringApp.CustomerRepository.CustomerRepository;
import com.SpringCrud.SpringApp.DTO.CustomerDTO;
import com.SpringCrud.SpringApp.DTO.CustomerSaveDTO;
import com.SpringCrud.SpringApp.DTO.CustomerUpdateDTO;
import com.SpringCrud.SpringApp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customer = new Customer(
                customerSaveDTO.getCustomername(),
                customerSaveDTO.getCustomeraddress(),
                customerSaveDTO.getMobile()
        );
        Customer savedCustomer = customerRepository.save(customer);
        return "Customer added successfully with ID: " + savedCustomer.getCustomerid();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerid(),
                    customer.getCustomername(),
                    customer.getCustomeraddress(),
                    customer.getMobile()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String updateCustomers(CustomerUpdateDTO customerUpdateDTO) {
        Optional<Customer> customerOptional = customerRepository.findById(customerUpdateDTO.getCustomerid());

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setCustomername(customerUpdateDTO.getCustomername());
            customer.setCustomeraddress(customerUpdateDTO.getCustomeraddress());
            customer.setMobile(customerUpdateDTO.getMobile());
            customerRepository.save(customer);
            return "Customer updated successfully with ID: " + customer.getCustomerid();
        } else {
            throw new RuntimeException("Customer ID not found: " + customerUpdateDTO.getCustomerid());
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Customer ID not found: " + id);
        }
    }
}
