package ar.edu.frc.utn.bda3k4.northwind.repositories;

import ar.edu.frc.utn.bda3k4.northwind.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
