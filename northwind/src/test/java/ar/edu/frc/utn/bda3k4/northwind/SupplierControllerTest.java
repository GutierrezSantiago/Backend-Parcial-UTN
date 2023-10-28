package ar.edu.frc.utn.bda3k4.northwind;


import ar.edu.frc.utn.bda3k4.northwind.controllers.SupplierController;
import ar.edu.frc.utn.bda3k4.northwind.entities.Supplier;
import ar.edu.frc.utn.bda3k4.northwind.repositories.SupplierRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.implementations.SupplierServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class SupplierControllerTest {
    private SupplierController supplierController;
    private SupplierRepository supplierRepository;

    private final Supplier supplier = new Supplier(1 ,, "Aluminio",
            "Maria Anders", "Sales Representative", "Obere Str. 57",
            "Berlin", null, "12209", "Germany", "030-0074321",
            "030-0076545", "homePage", null);

    @BeforeEach
    public void setup(){
        supplierRepository = Mockito.mock(SupplierRepository.class);
        SupplierServiceImpl shipperService = new SupplierServiceImpl(supplierRepository);
        supplierController = new SupplierController(shipperService);
    }
}
