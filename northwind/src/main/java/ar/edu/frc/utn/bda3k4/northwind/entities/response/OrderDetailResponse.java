package ar.edu.frc.utn.bda3k4.northwind.entities.response;

import ar.edu.frc.utn.bda3k4.northwind.entities.OrderDetail;

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
