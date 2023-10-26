package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.Customer;
import ar.edu.frc.utn.bda3k4.northwind.repositories.CustomerRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.CustomerService;

import java.util.List;

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
    public Customer update(Customer entity) {
        Customer customer = this.customerRepository.findById(entity.getId()).orElse(null);
        return null;
    }

    @Override
    public Customer delete(String s) {
        Customer customer = this.customerRepository.findById(s).orElse(null);
        if(customer != null){
            this.customerRepository.delete(customer);
            return customer;
        }
        return null;
    }

    @Override
    public Customer findById(String s) {
        return this.customerRepository.findById(s).orElseThrow(()->
                new IllegalArgumentException("Customer not found"));
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }
}
