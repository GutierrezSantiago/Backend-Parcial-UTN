package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.Supplier;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.SupplierService;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    @Override
    public Supplier add(Supplier entity) {
        return null;
    }

    @Override
    public Supplier update(Supplier entity) {
        Supplier existingSupplier = this.getById(entity.getId());

        return null;
    }

    @Override
    public Supplier delete(Integer integer) {
        return null;
    }

    @Override
    public Supplier findById(Integer integer) {
        return null;
    }

    @Override
    public List<Supplier> findAll() {
        return null;
    }
}
