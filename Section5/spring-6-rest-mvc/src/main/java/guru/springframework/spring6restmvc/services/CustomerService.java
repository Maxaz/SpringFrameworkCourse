package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateBeerById(UUID id, Customer customer);

    void deleteById(UUID customerId);

    void patchCustomerById(UUID id, Customer customer);
}
