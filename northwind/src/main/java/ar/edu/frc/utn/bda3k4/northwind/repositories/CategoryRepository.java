package ar.edu.frc.utn.bda3k4.northwind.repositories;

import ar.edu.frc.utn.bda3k4.northwind.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
