package ar.edu.frc.utn.bda3k4.northwind.controllers;

import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/product")
@RestController
public class ProductController {
    private final ProductService productService;
    public ProductController (ProductService productService){
        this.productService = productService;
    }
}
