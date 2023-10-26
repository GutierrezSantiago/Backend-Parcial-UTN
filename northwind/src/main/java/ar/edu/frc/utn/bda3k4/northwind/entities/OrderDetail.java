package ar.edu.frc.utn.bda3k4.northwind.entities;

import ar.edu.frc.utn.bda3k4.northwind.support.OrderDetailPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Order Details")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderDetailPK.class)
public class OrderDetail {
    @EmbeddedId
    private OrderDetailPK id;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Discount")
    private Double discount;

}
