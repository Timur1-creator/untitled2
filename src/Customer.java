import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import java.util.ArrayList;
import java.util.List;

class Customer extends User {
    private List<Order> orders;
    private String shippingAddress;

    public Customer(int userId, String name, String email, String shippingAddress) {
        super(userId, name, email);
        this.orders = new ArrayList<>();
        this.shippingAddress = shippingAddress;
    }

    public void placeOrder(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            product.reduceStock(quantity);
            Order order = new Order(UUID.randomUUID().toString(), this, product, quantity, product.getPrice() * quantity, "Placed");
            orders.add(order);
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Insufficient stock for product: " + product.getName());
        }
    }

    public void cancelOrder(Order order) {
        if (orders.contains(order)) {
            order.cancelOrder();
            System.out.println("Order cancelled successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Shipping Address: " + shippingAddress);
        System.out.println("Orders: " + orders.size());
    }
}