package ar.edu.frc.utn.bda3k4.northwind.entities;

import ar.edu.frc.utn.bda3k4.northwind.support.LocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "Employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(name = "EmployeeID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Employees")
    @TableGenerator(name = "Employees", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Employees",
            initialValue=1, allocationSize=1)
    private Integer id;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "Title")
    private String title;

    @Column(name = "TitleOfCourtesy")
    private String titleOfCourtesy;

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "BirthDate")
    private LocalDateTime birthDate;

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "HireDate")
    private LocalDateTime hireDate;

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

    @Column(name = "HomePhone")
    private String homePhone;

    @Column(name = "Extension")
    private String extension;

    @Column(name = "Photo")
    private Byte[] photo;

    @Column(name = "Notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "ReportsTo")
    private Employee superior;

    @Column(name = "PhotoPath")
    private String photoPath;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders;
}
