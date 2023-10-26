package ar.edu.frc.utn.bda3k4.northwind.entities.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class OrderDetailRequest {
    @NotBlank(message = "orderId is mandatory")
    private Integer orderId;
    @NotBlank(message = "productId is mandatory")
    private Integer productId;
    @NotBlank(message = "unitPrice is mandatory")
    private Double unitPrice;
    @NotBlank(message = "quantity is mandatory")
    private Integer quantity;
    @NotBlank(message = "discount is mandatory")
    private Double discount;
}
