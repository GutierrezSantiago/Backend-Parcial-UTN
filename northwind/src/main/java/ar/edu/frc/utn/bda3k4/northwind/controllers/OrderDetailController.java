package ar.edu.frc.utn.bda3k4.northwind.controllers;

import ar.edu.frc.utn.bda3k4.northwind.entities.OrderDetail;
import ar.edu.frc.utn.bda3k4.northwind.entities.response.OrderDetailResponse;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.OrderDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {
    private final OrderDetailService service;

    public OrderDetailController(OrderDetailService service) {
        this.service = service;
    }

    public ResponseEntity<List<OrderDetailResponse>> findAlumnos() {
        List<OrderDetail> details = service.findAll();
        return alumnos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(alumnos);
    }
}
