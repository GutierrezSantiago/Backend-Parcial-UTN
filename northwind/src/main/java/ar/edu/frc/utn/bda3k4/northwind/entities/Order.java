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
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "OrderID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Orders")
    @TableGenerator(name = "Orders", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Orders",
            initialValue=1, allocationSize=1)
    private Integer id;

    @Column(name = "OrderDate")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime orderDate;

    @Column(name = "RequiredDate")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime requiredDate;

    @Column(name = "ShippedDate")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime shippedDate;

    @Column(name = "Freight")
    private Double freight;

    @Column(name = "ShipName")
    private String shipName;

    @Column(name = "ShipAddress")
    private String shipAddress;

    @Column(name = "ShipCity")
    private String shipCity;

    @Column(name = "ShipRegion")
    private String shipRegion;

    @Column(name = "ShipPostalCode")
    private String shipPostalCode;

    @Column(name = "ShipCountry")
    private String shipCountry;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ShipVia")
    private Shipper shipper;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderDetail> orderDetails;
}
