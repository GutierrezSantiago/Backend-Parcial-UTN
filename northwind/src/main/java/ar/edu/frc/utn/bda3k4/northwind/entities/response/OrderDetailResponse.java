package ar.edu.frc.utn.bda3k4.northwind.entities.response;

import ar.edu.frc.utn.bda3k4.northwind.entities.OrderDetail;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetailResponse {
    private Integer orderId;
    private Integer productId;
    private Double unitPrice;
    private Integer quantity;
    private Double discount;

    public OrderDetailResponse(OrderDetail detail){
        orderId = detail.getOrderId();
        productId = detail.getProductId();
        unitPrice = detail.getUnitPrice();
        quantity = detail.getQuantity();
        discount = detail.getDiscount();
    }
}
