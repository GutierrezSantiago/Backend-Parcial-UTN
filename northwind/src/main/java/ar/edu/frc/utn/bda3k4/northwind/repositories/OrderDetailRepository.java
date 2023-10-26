package ar.edu.frc.utn.bda3k4.northwind.repositories;

import ar.edu.frc.utn.bda3k4.northwind.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
