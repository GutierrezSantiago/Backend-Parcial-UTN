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
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /*public ResponseEntity<List<OrderDetailResponse>> findAlumnos() {
        return alumnos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(alumnos);
    }*/
}
