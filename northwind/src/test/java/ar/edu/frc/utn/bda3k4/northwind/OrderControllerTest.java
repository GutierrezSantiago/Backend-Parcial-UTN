package ar.edu.frc.utn.bda3k4.northwind;

import ar.edu.frc.utn.bda3k4.northwind.controllers.OrderController;
import ar.edu.frc.utn.bda3k4.northwind.entities.Order;
import ar.edu.frc.utn.bda3k4.northwind.entities.request.OrderRequest;
import ar.edu.frc.utn.bda3k4.northwind.repositories.CustomerRepository;
import ar.edu.frc.utn.bda3k4.northwind.repositories.EmployeeRepository;
import ar.edu.frc.utn.bda3k4.northwind.repositories.OrderRepository;
import ar.edu.frc.utn.bda3k4.northwind.repositories.ShipperRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.implementations.CustomerServiceImpl;
import ar.edu.frc.utn.bda3k4.northwind.services.implementations.EmployeeServiceImpl;
import ar.edu.frc.utn.bda3k4.northwind.services.implementations.OrderServiceImpl;
import ar.edu.frc.utn.bda3k4.northwind.services.implementations.ShipperServiceImpl;
import ar.edu.frc.utn.bda3k4.northwind.support.LocalDateTimeAttributeConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderControllerTest {
    private OrderController orderController;
    private OrderRepository orderRepository;
    private ShipperRepository shipperRepository;
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;
    private LocalDateTimeAttributeConverter localDateTimeAttributeConverter = new LocalDateTimeAttributeConverter();
    private final Order ORDER = new Order(
            1,
            localDateTimeAttributeConverter.convertToEntityAttribute("1948-12-08"),
            localDateTimeAttributeConverter.convertToEntityAttribute("1960-05-01"),
            localDateTimeAttributeConverter.convertToEntityAttribute("1960-05-01"),
            2.0,
            "ShipName",
            "ShipAddress",
            "ShipCity",
            "ShipRegion",
            "ShipPostalCode",
            "ShipCountry",
            null,
            null,
            null,
            null
    );

    @BeforeEach
    void setup(){
        orderRepository = Mockito.mock(OrderRepository.class);
        customerRepository = Mockito.mock(CustomerRepository.class);
        shipperRepository = Mockito.mock(ShipperRepository.class);
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        ShipperServiceImpl shipperService = new ShipperServiceImpl(shipperRepository);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
        orderController = new OrderController(orderService,
                customerService,
                shipperService,
                employeeService);
    }

    @Test
    void testFindAll(){
        List<Order> orders = new ArrayList<>();
        orders.add(ORDER);
        Mockito.when(orderRepository.findAll()).thenReturn(orders);
        Assertions.assertEquals(
                HttpStatus.OK,
                orderController.findAll().getStatusCode()
        );
    }

    @Test
    void testFindAllEmpty(){
        Mockito.when(orderRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(
                HttpStatus.NO_CONTENT,
                orderController.findAll().getStatusCode()
        );
    }

    @Test
    void testFindById(){
        Mockito.when(orderRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(ORDER));
        Assertions.assertEquals(
                HttpStatus.OK,
                orderController.findOne(1).getStatusCode()
        );
    }

    @Test
    void testFindByIdNotFound(){
        Mockito.when(orderRepository.findById(1)).thenReturn(java.util.Optional.empty());
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND,
                orderController.findOne(1).getStatusCode()
        );
    }

    @Test
    void testAdd(){
        Mockito.when(orderRepository.save(ORDER)).thenReturn(ORDER);
        Assertions.assertEquals(
                HttpStatus.CREATED,
                orderController.add(new OrderRequest()).getStatusCode()
        );
    }

    @Test
    void testUpdate(){
        Mockito.when(orderRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(ORDER));
        Mockito.when(orderRepository.save(ORDER)).thenReturn(ORDER);
        Assertions.assertEquals(
                HttpStatus.ACCEPTED,
                orderController.update(1, new OrderRequest()).getStatusCode()
        );
    }

    @Test
    void testDelete(){
        Mockito.when(orderRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(ORDER));
        Mockito.when(orderRepository.save(ORDER)).thenReturn(ORDER);
        Assertions.assertEquals(
                HttpStatus.ACCEPTED,
                orderController.delete(1).getStatusCode()
        );
    }

    @Test
    void testDeleteNotFound(){
        Mockito.when(orderRepository.findById(1)).thenReturn(java.util.Optional.empty());
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND,
                orderController.delete(1).getStatusCode()
        );
    }

    @Test
    void testUpdateNotFound(){
        Mockito.when(orderRepository.findById(1)).thenReturn(java.util.Optional.empty());
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND,
                orderController.update(1, new OrderRequest()).getStatusCode()
        );
    }

}
