package com.calculopedido.pedido;

import com.calculopedido.pedido.entities.Order;
import com.calculopedido.pedido.services.OrderService;
import com.calculopedido.pedido.services.OrderServiceImpl;
import com.calculopedido.pedido.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PedidoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Order order = new Order(1034, 100, 10);
		ShippingService shippingService = new ShippingService();
		OrderService orderService = new OrderServiceImpl(shippingService);

		double total = orderService.total(order);
		double freight = orderService.freight(order);
		double basicValue = orderService.basicValue(order);

		System.out.println("Valor do pedido sem desconto e sem frete: R$ " + basicValue);
		System.out.println("Valor do frete: R$ " + freight);
		System.out.println("Total: R$ " + total);
	}
}
