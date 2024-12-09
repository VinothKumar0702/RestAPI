package com.SpringCrud.SpringApp.Service;

import com.SpringCrud.SpringApp.DTO.CustomerDTO;
import com.SpringCrud.SpringApp.DTO.CustomerSaveDTO;
import com.SpringCrud.SpringApp.DTO.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    String addCustomer(CustomerSaveDTO customerSaveDTO);

    List<CustomerDTO> getAllCustomers();

    String updateCustomers(CustomerUpdateDTO customerUpdateDTO);

    boolean deleteCustomer(int id);
}
