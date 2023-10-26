package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.Supplier;
import ar.edu.frc.utn.bda3k4.northwind.repositories.SupplierRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.SupplierService;
import lombok.val;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    public SupplierServiceImpl(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }
    @Override
    public Supplier add(Supplier entity) {
        this.supplierRepository.save(entity);
        return entity;
    }

    @Override
    public Supplier update(Supplier entity) {
        Supplier existingSupplier = this.supplierRepository.findById(entity.getId()).orElseThrow(() -> new IllegalArgumentException("Supplier does not exist"));
        existingSupplier.update(entity.getCompanyName(), entity.getContactName(), entity.getContactTitle(), entity.getAddress(), entity.getCity(), entity.getRegion(), entity.getPostalCode(), entity.getCountry(), entity.getPhone(), entity.getFax(), entity.getHomePage());
        this.supplierRepository.save(existingSupplier);
        return existingSupplier;
    }

    @Override
    public Supplier delete(Integer id) {
        Supplier supplier = this.supplierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Supplier does not exist"));
        this.supplierRepository.delete(supplier);
        return supplier;

    }

    @Override
    public Supplier findById(Integer id) {
        Supplier supplier = this.supplierRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Supplier doesn not exist"));
        return supplier;
    }

    @Override
    public List<Supplier> findAll() {
        return this.supplierRepository.findAll();
    }
}
