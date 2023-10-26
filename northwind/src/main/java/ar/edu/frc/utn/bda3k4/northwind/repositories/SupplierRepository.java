package ar.edu.frc.utn.bda3k4.northwind.repositories;

import ar.edu.frc.utn.bda3k4.northwind.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
