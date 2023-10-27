package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.Customer;
import ar.edu.frc.utn.bda3k4.northwind.repositories.CustomerRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer add(Customer entity) {
        return this.customerRepository.save(entity);
    }

    @Override
    public Customer update(String id, Customer entity) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Customer not found"));
        customer.update(entity);
        return this.customerRepository.save(customer);

    }

    @Override
    public Customer delete(String s) {
        Customer customer = this.customerRepository.findById(s).orElseThrow(()->
                new IllegalArgumentException("Customer not found"));
        this.customerRepository.delete(customer);
        return customer;
    }

    @Override
    public Customer findById(String s) {
        return this.customerRepository.findById(s).orElseThrow(()->
                new IllegalArgumentException("Customer not found"));
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = this.customerRepository.findAll();
        if(customers.isEmpty()){throw new IllegalArgumentException("No customers found");}
        return customers;
    }
}
