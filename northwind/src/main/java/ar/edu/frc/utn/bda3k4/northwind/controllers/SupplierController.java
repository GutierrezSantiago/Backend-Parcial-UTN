package ar.edu.frc.utn.bda3k4.northwind.controllers;

import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.SupplierService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/supplier")
@RestController
public class SupplierController {
    private final SupplierService supplierService;
    public SupplierController (SupplierService supplierService)
    {
        this.supplierService = supplierService;
    }
}
