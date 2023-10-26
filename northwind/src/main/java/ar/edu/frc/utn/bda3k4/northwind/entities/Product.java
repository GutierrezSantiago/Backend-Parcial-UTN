package ar.edu.frc.utn.bda3k4.northwind.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "ProductID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Products")
    @TableGenerator(name = "Products", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Products",
            initialValue=1, allocationSize=1)
    Integer id;

    @Column(name = "ProductName")
    String name;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SupplierID")
    Supplier supplier;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CategoryID")
    Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderDetail> orderDetails;
}


