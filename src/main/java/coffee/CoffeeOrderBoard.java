package coffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.List;

public class CoffeeOrderBoard {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    private final List<Order> orders = new LinkedList<>();
    private int nextOrderNumber = 1;

    // Додавання нового замовлення з автоматичним присвоєнням номера
    public void add(String clientName) {
        if (clientName == null || clientName.trim().isEmpty()) {
            IllegalArgumentException ex = new IllegalArgumentException("Client name cannot be empty");
            logger.error("Failed to add order: invalid customer name", ex);
            throw ex;
        }

        Order order = new Order(nextOrderNumber++, clientName);
        orders.add(order);
        logger.info("Successfully added new order: {} | Total orders in queue: {}", order, orders.size());
    }

    // Видача найближчого замовлення (першого в черзі)
    public Order deliver() {
        if (orders.isEmpty()) {
            logger.warn("Attempted to deliver an order, but the queue is empty");
            return null;
        }

        Order deliveredOrder = orders.remove(0);
        logger.info("Delivered next systematic order: {}", deliveredOrder);
        return deliveredOrder;
    }

    // Видача замовлення за конкретним номером (експрес-видача)
    public Order deliver(int orderNumber) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getNumber() == orderNumber) {
                orders.remove(i);
                logger.info("Delivered custom order out of turn: {}", order);
                return order;
            }
        }

        logger.warn("Order with number {} was not found in the queue", orderNumber);
        return null;
    }

    // Виведення поточного стану черги в консоль
    public void draw() {
        logger.info("Displaying the current state of the order board. Queue size: {}", orders.size());
        System.out.println("Num | Name");
        System.out.println("-----------");
        for (Order order : orders) {
            System.out.printf("%-3d | %s%n", order.getNumber(), order.getClientName());
        }
    }
}