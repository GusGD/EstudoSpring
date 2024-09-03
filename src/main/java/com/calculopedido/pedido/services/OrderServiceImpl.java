package com.calculopedido.pedido.services;

import com.calculopedido.pedido.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
  private final ShippingService shippingService;

  @Autowired
  public OrderServiceImpl(ShippingService shippingService) {
    this.shippingService = shippingService;
  }

  @Override
  public double basicValue(Order order) {
    return order.getBasic();
  }

  @Override
  public double freight(Order order) {
    return shippingService.shipment(order);
  }

  @Override
  public double total(Order order) {
    double discountAmount = order.getBasic() * (order.getDiscount() / 100);
    double basicTotal = order.getBasic() - discountAmount;
    double shipment = shippingService.shipment(order);
    return basicTotal + shipment;
  }
}
