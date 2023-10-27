package ar.edu.frc.utn.bda3k4.northwind.entities.response;

import ar.edu.frc.utn.bda3k4.northwind.entities.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private String name;
    private String quantityPerUnit;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Boolean discontinued;

    public static ProductResponse from(Product aProduct) {
        return ProductResponse.builder()
                .name(aProduct.getName())
                .quantityPerUnit(aProduct.getQuantityPerUnit())
                .unitPrice(aProduct.getUnitPrice())
                .unitsInStock(aProduct.getUnitsInStock())
                .unitsOnOrder(aProduct.getUnitsOnOrder())
                .reorderLevel(aProduct.getReorderLevel())
                .discontinued(aProduct.getDiscontinued())
                .build();
    }
}
