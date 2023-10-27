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
    private Integer id;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "ContactName")
    private String contactName;

    @Column(name = "ContactTitle")
    private String contactTitle;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Region")
    private String region;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "HomePage")
    private String homePage;

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