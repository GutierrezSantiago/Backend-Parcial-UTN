package ar.edu.frc.utn.bda3k4.northwind.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Shippers")
@NoArgsConstructor
@AllArgsConstructor
public class Shipper {
    @Id
    @TableGenerator(name = "Shippers", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Shippers",
            initialValue=1, allocationSize=1)
    @Column(name = "CustomerID")
    private Integer id;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "Phone")
    private String phone;
}