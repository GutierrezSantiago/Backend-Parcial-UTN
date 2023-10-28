package ar.edu.frc.utn.bda3k4.northwind.controllers;

import ar.edu.frc.utn.bda3k4.northwind.entities.*;
import ar.edu.frc.utn.bda3k4.northwind.entities.request.OrderRequest;
import ar.edu.frc.utn.bda3k4.northwind.entities.response.OrderResponse;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.CustomerService;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.EmployeeService;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.OrderService;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.ShipperService;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final ShipperService shipperService;
    private final EmployeeService employeeService;
    public OrderController(OrderService orderService, CustomerService customerService, ShipperService shipperService, EmployeeService employeeService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.shipperService = shipperService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val orders = orderService.findAll()
                    .stream()
                    .map(OrderResponse::from)
                    .toList();
            return ResponseEntity.ok(orders);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody OrderRequest aRequest) {
        try{
            Customer customer = customerService.findById(aRequest.getCustomerId());
            Shipper shipper = this.validateShipper(aRequest.getShippedDate(), aRequest.getShipVia());
            Employee employee = employeeService.findById(aRequest.getEmployeeId());
            Order order = aRequest.toOrder();
            order.setCustomer(customer);
            order.setShipper(shipper);
            order.setEmployee(employee);
            order = orderService.add(order);
            return ResponseEntity.ok(OrderResponse.from(order));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody OrderRequest aRequest) {
        try {
            Order modifications = aRequest.toOrder();
            Shipper shipper = this.validateShipper(aRequest.getShippedDate(), aRequest.getShipVia());
            modifications.setShipper(shipper);
            Order order = orderService.update(id, modifications);
            return ResponseEntity.accepted().body(OrderResponse.from(order));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Order order = orderService.delete(id);
            return ResponseEntity.accepted().body(OrderResponse.from(order));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Integer id) {
        try {
            val order = orderService.findById(id);
            return ResponseEntity.ok(OrderResponse.from(order));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    private Shipper validateShipper(String shippedDate, Integer shipper){
        if(!shippedDate.isBlank() && shipper != null)return shipperService.findById(shipper);
        else if(shippedDate.isBlank() && shipper == null)return null;
        else throw new IllegalArgumentException("Shipped date and shipper must be both null or not null");
    }

}
