package com.SpringCrud.SpringApp.CustomerController;

import com.SpringCrud.SpringApp.DTO.CustomerDTO;
import com.SpringCrud.SpringApp.DTO.CustomerSaveDTO;
import com.SpringCrud.SpringApp.DTO.CustomerUpdateDTO;
import com.SpringCrud.SpringApp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Save customer
    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO) {
        String id = customerService.addCustomer(customerSaveDTO);
        return "Customer added with ID: " + id;
    }

    // Get all customers
    @GetMapping(path = "/getAllCustomers")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Update customer
    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String result = customerService.updateCustomers(customerUpdateDTO);
        return result != null ? result : "Customer update failed: ID not found.";
    }

    // Delete customer
    @DeleteMapping(path = "/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        return isDeleted ? "Customer deleted successfully." : "Customer ID not found.";
    }
}
