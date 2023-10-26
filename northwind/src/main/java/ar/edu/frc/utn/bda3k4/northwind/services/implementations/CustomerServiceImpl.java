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
    public Customer update(Customer entity) {

        Customer customer = this.customerRepository.findById(entity.getId()).orElseThrow(()->
                new IllegalArgumentException("Customer not found"));
        customer.setCompanyName(entity.getCompanyName());
        customer.setContactName(entity.getContactName());
        customer.setContactTitle(entity.getContactTitle());
        customer.setAddress(entity.getAddress());
        customer.setCity(entity.getCity());
        customer.setRegion(entity.getRegion());
        customer.setPostalCode(entity.getPostalCode());
        customer.setCountry(entity.getCountry());
        customer.setPhone(entity.getPhone());
        customer.setFax(entity.getFax());
        return this.customerRepository.save(customer);

    }

    @Override
    public Customer delete(String s) {
        Customer customer = this.customerRepository.findById(s).orElse(null);
        if(customer != null){
            this.customerRepository.delete(customer);
            return customer;
        }
        throw new IllegalArgumentException("Customer not found");
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
