package ar.edu.frc.utn.bda3k4.northwind.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetailPK implements Serializable {
    private Integer orderId;
    private Integer productId;
}
