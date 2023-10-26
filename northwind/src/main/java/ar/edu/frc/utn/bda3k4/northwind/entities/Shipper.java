package ar.edu.frc.utn.bda3k4.northwind.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Shippers")
@NoArgsConstructor
@AllArgsConstructor
public class Shipper {
}
