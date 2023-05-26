package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("John")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Paul")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Alice")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(),customer1);
        customerMap.put(customer2.getId(),customer2);
        customerMap.put(customer3.getId(),customer3);
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        log.debug("Get Customer id in service was called. Id : " + id.toString());
        return customerMap.get(id);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {

        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .name(customer.getName())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;


    }

    @Override
    public void updateBeerById(UUID id, Customer customer) {
        Customer existing = customerMap.get(id);
        existing.setName(customer.getName());

        customerMap.put(existing.getId(), existing);
    }

    @Override
    public void deleteById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID id, Customer customer) {
        Customer existing = customerMap.get(id);

        if (StringUtils.hasText(customer.getName())){
            existing.setName(customer.getName());
        }
    }
}
