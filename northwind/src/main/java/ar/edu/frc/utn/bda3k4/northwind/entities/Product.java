package ar.edu.frc.utn.bda3k4.northwind.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Suppliers")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "SupplierID")
    Integer id;

    @Column(name = "ProductName")
    String name;

    // No olvidar las ref a objetos

    @Column(name = "QuantityPerUnit")
    String quantityPerUnit;

    @Column(name = "UnitPrice")
    Double unitPrice;

    @Column(name = "UnitsInStock")
    Integer unitsInStock;

    @Column(name = "UnitsOnOrder")
    Integer unitsOnOrder;

    @Column(name = "ReorderLevel")
    Integer reorderLevel;

    @Column(name = "Discontinued")
    boolean discontinued;
}


