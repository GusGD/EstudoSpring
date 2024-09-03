package com.calculopedido.pedido.services;

import com.calculopedido.pedido.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
  public double shipment(Order order){
    double basicValue = order.getBasic();
    if(basicValue < 100) return 20.00;
    if(basicValue < 200) return 12.00;
    return 0;
  }
}
