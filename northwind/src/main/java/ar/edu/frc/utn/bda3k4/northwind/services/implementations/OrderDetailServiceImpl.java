package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.Order;
import ar.edu.frc.utn.bda3k4.northwind.entities.OrderDetail;
import ar.edu.frc.utn.bda3k4.northwind.entities.Product;
import ar.edu.frc.utn.bda3k4.northwind.repositories.OrderDetailRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.OrderDetailService;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.OrderService;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.ProductService;
import ar.edu.frc.utn.bda3k4.northwind.support.OrderDetailPK;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderService orderService;
    private final ProductService productService;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, OrderService orderService, ProductService productService) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public OrderDetail add(OrderDetail entity) {
        Order order = this.orderService.findById(entity.getId().getOrderId());
        Product product = this.productService.findById(entity.getId().getProductId());
        return this.orderDetailRepository.save(entity);
    }

    @Override
    public OrderDetail update(OrderDetail entity) {
        OrderDetail orderDetail = this.orderDetailRepository.findById(entity.getId()).orElseThrow(
                () -> new IllegalArgumentException("No se encontró el OrderDetail con id suministrado"));
        orderDetail.setUnitPrice(entity.getUnitPrice());
        orderDetail.setQuantity(entity.getQuantity());
        orderDetail.setDiscount(entity.getDiscount());
        return this.orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail delete(OrderDetailPK orderDetailPK) {
        OrderDetail orderDetail = this.orderDetailRepository.findById(orderDetailPK).orElse(null);
        if (orderDetail != null) {this.orderDetailRepository.delete(orderDetail);}
        return orderDetail;
    }

    @Override
    public OrderDetail findById(OrderDetailPK orderDetailPK) {
        return this.orderDetailRepository.findById(orderDetailPK).orElseThrow(
                () -> new IllegalArgumentException("No se encontró el OrderDetail con id suministrado"));
    }

    @Override
    public List<OrderDetail> findAll() {
        return this.orderDetailRepository.findAll();
    }
}
