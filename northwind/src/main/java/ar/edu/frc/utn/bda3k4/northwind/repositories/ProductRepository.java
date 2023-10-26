package ar.edu.frc.utn.bda3k4.northwind.repositories;

import ar.edu.frc.utn.bda3k4.northwind.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
