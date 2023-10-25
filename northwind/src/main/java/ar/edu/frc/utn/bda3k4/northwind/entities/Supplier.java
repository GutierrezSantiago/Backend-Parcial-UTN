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
public class Supplier {
    @Id
    @Column(name = "SupplierID")
    Integer id;

    @Column(name = "CompanyName")
    String companyName;

    @Column(name = "ContactName")
    String contactName;

    @Column(name = "ContactTitle")
    String contactTitle;

    @Column(name = "Address")
    String address;

    @Column(name = "City")
    String city;

    @Column(name = "Region")
    String region;

    @Column(name = "PostalCode")
    String postalCode;

    @Column(name = "Country")
    String country;

    @Column(name = "Phone")
    String phone;

    @Column(name = "Fax")
    String fax;

    @Column(name = "HomePage")
    String homePage;
}
