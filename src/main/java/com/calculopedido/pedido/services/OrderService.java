package com.calculopedido.pedido.services;

import com.calculopedido.pedido.entities.Order;

public interface OrderService {
  double total(Order order);
  double basicValue(Order order);
  double freight(Order order);
}
