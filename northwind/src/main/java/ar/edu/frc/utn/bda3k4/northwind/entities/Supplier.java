package ar.edu.frc.utn.bda3k4.northwind.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "Suppliers")
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @Column(name = "SupplierID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Suppliers")
    @TableGenerator(name = "Suppliers", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Suppliers",
            initialValue=1, allocationSize=1)
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

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;

    public void update(Supplier supplier){
        this.companyName = supplier.companyName;
        this.contactName = supplier.contactName;
        this.contactTitle = supplier.contactTitle;
        this.address = supplier.address;
        this.city = supplier.city;
        this.region = supplier.region;
        this.postalCode = supplier.postalCode;
        this.country = supplier.country;
        this.phone = supplier.phone;
        this.fax = supplier.fax;
        this.homePage = supplier.homePage;
    }
}