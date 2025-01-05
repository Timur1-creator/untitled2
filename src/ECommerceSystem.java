


public class ECommerceSystem {
    public static void main(String[] args) {
        Admin admin1 = new Admin(1, "Alice", "alice@example.com");
        Customer customer1 = new Customer(2, "Bob", "bob@example.com", "123 Main St");
        Product product1 = new Product("P001", "Laptop", 1200.00, 10);

        admin1.addProduct(product1);
        customer1.placeOrder(product1, 2);

        admin1.displayDetails();
        customer1.displayDetails();
        product1.displayDetails();
    }
}
