package ar.edu.frc.utn.bda3k4.northwind;

import ar.edu.frc.utn.bda3k4.northwind.controllers.CustomerController;
import ar.edu.frc.utn.bda3k4.northwind.entities.Customer;
import ar.edu.frc.utn.bda3k4.northwind.entities.request.CustomerRequest;
import ar.edu.frc.utn.bda3k4.northwind.repositories.CustomerRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.implementations.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;

public class CustomerControllerTest {
    private CustomerController customerController;
    private CustomerRepository customerRepository;
    private final Customer CUSTOMER = new Customer("AAAA", "Aluminio",
            "Maria Anders", "Sales Representative", "Obere Str. 57",
            "Berlin", null, "12209", "Germany", "030-0074321",
            "030-0076545");

    @BeforeEach
    public void setup() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        customerController = new CustomerController(customerService);
    }

    @Test
    void testFindAll() {
        List<Customer> customers = new ArrayList<>();
        customers.add(CUSTOMER);
        Mockito.when(customerRepository.findAll()).thenReturn(customers);
        Assertions.assertEquals(
                HttpStatus.OK,
                customerController.findAll().getStatusCode()
        );
    }

    @Test
    void testFindAllEmpty() {
        Mockito.when(customerRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(
                HttpStatus.NO_CONTENT,
                customerController.findAll().getStatusCode()
        );
    }

    @Test
    void testFindById() {
        Mockito.when(customerRepository.findById(anyString())).thenReturn(Optional.of(CUSTOMER));

        Assertions.assertEquals(
                HttpStatus.OK,
                customerController.findOne("AAAA").getStatusCode()
        );
    }

    @Test
    void testFindByIdNotFound() {
        Mockito.when(customerRepository.findById(anyString())).thenReturn(Optional.empty());

        Assertions.assertEquals(
                HttpStatus.NOT_FOUND,
                customerController.findOne("AAAA").getStatusCode()
        );
    }

    @Test
    void testAdd() {
        Mockito.when(customerRepository.existsById(anyString())).thenReturn(true);

        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(CUSTOMER);
        Mockito.when(customerRepository.saveAndFlush(any(Customer.class))).thenReturn(CUSTOMER);

        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(CUSTOMER);
        Mockito.when(customerRepository.saveAndFlush(any(Customer.class))).thenReturn(CUSTOMER);

        Assertions.assertEquals(
                HttpStatus.CREATED,
                customerController.add(new CustomerRequest()).getStatusCode()
        );
    }

    @Test
    void testUpdate() {
        Mockito.when(customerRepository.findById(anyString())).thenReturn(Optional.of(CUSTOMER));

        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(CUSTOMER);
        Mockito.when(customerRepository.saveAndFlush(any(Customer.class))).thenReturn(CUSTOMER);

        Assertions.assertEquals(
                HttpStatus.ACCEPTED,
                customerController.update(new CustomerRequest()).getStatusCode()
        );
    }

    @Test
    void testUpdateNotFound() {
        Mockito.when(customerRepository.findById(anyString())).thenReturn(Optional.empty());

        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(CUSTOMER);
        Mockito.when(customerRepository.saveAndFlush(any(Customer.class))).thenReturn(CUSTOMER);

        IllegalArgumentException thrown =  Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> customerController.update(new CustomerRequest()),
                "Se espera ResourceNotFoundException");

        Assertions.assertEquals(thrown.getMessage(), "Customer not found");
    }

    @Test
    void testDelete() {
        Mockito.when(customerRepository.existsById(anyString())).thenReturn(true);

        Assertions.assertEquals(
                HttpStatus.NO_CONTENT,
                customerController.delete("AAAA").getStatusCode()
        );
    }

    @Test
    void testDeleteNotFound() {
        Mockito.when(customerRepository.existsById(anyString())).thenReturn(false);

        Assertions.assertEquals(
                HttpStatus.NOT_FOUND,
                customerController.delete("AAAA").getStatusCode()
        );
    }

}
