package ar.edu.frc.utn.bda3k4.northwind;


import ar.edu.frc.utn.bda3k4.northwind.controllers.SupplierController;
import ar.edu.frc.utn.bda3k4.northwind.entities.Supplier;
import ar.edu.frc.utn.bda3k4.northwind.entities.request.SupplierRequest;
import ar.edu.frc.utn.bda3k4.northwind.repositories.SupplierRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.implementations.SupplierServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class SupplierControllerTest {
    private SupplierController supplierController;
    private SupplierRepository supplierRepository;

    private final Supplier supplier = new Supplier(1 , "Aluminio",
            "Maria Anders", "Sales Representative", "Obere Str. 57",
            "Berlin", null, "12209", "Germany", "030-0074321",
            "030-0076545", "homePage", null);

    @BeforeEach
    public void setup(){
        supplierRepository = Mockito.mock(SupplierRepository.class);
        SupplierServiceImpl shipperService = new SupplierServiceImpl(supplierRepository);
        supplierController = new SupplierController(shipperService);
    }

    @Test
    void testFindAll(){
        List<Supplier> suppliers = new ArrayList<>();
        suppliers.add(supplier);
        Mockito.when(supplierRepository.findAll()).thenReturn(suppliers);
        Assertions.assertEquals(
                HttpStatus.OK,
                supplierController.findAll().getStatusCode()
        );
    }

    @Test
    void testFindAllEmpty(){
        Mockito.when(supplierRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(
                HttpStatus.NO_CONTENT,
                supplierController.findAll().getStatusCode()
        );
    }

    @Test
    void testFindById(){
        Mockito.when(supplierRepository.findById(1)).thenReturn(java.util.Optional.of(supplier));
        Assertions.assertEquals(
                HttpStatus.OK,
                supplierController.findOne(1).getStatusCode()
        );
    }

    @Test
    void testFindByIdNotFound(){
        Mockito.when(supplierRepository.findById(1)).thenReturn(java.util.Optional.empty());
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND,
                supplierController.findOne(1).getStatusCode()
        );
    }

    @Test
    void testAdd(){
        Mockito.when(supplierRepository.save(supplier)).thenReturn(supplier);
        Assertions.assertEquals(
                HttpStatus.CREATED,
                supplierController.add(new SupplierRequest()).getStatusCode()
        );
    }

    @Test
    void testUpdate(){
        Mockito.when(supplierRepository.findById(1)).thenReturn(java.util.Optional.of(supplier));
        Mockito.when(supplierRepository.save(supplier)).thenReturn(supplier);
        Assertions.assertEquals(
                HttpStatus.OK,
                supplierController.update(1, new SupplierRequest()).getStatusCode()
        );
    }

    @Test
    void testUpdateNotFound(){
        Mockito.when(supplierRepository.findById(1)).thenReturn(java.util.Optional.empty());
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND,
                supplierController.update(1, new SupplierRequest()).getStatusCode()
        );
    }

    @Test
    void testDelete(){
        Mockito.when(supplierRepository.findById(1)).thenReturn(java.util.Optional.of(supplier));
        Assertions.assertEquals(
                HttpStatus.OK,
                supplierController.delete(1).getStatusCode()
        );
    }

    @Test
    void testDeleteNotFound(){
        Mockito.when(supplierRepository.findById(1)).thenReturn(java.util.Optional.empty());
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND,
                supplierController.delete(1).getStatusCode()
        );
    }
}
