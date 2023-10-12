import java.util.HashMap;
import java.util.Map;

// Abstract Builder
interface OrderBuilder {
    OrderBuilder setCustomer(String customerName);

    OrderBuilder addProduct(String productName, int quantity);

    OrderBuilder setShippingAddress(String address);

    OrderBuilder setPaymentMethod(String paymentMethod);

    Order build();
}

// Director
class OrderDirector {
    private OrderBuilder builder;

    public OrderDirector(OrderBuilder builder) {
        this.builder = builder;
    }

    public Order construct() {
        builder.setCustomer("John Doe")
                .addProduct("Product A", 2)
                .addProduct("Product B", 1)
                .setShippingAddress("123 Main St")
                .setPaymentMethod("Credit Card");
        return builder.build();
    }
}

// Concrete Builder
class ConcreteOrderBuilder implements OrderBuilder {
    private Order order;

    public ConcreteOrderBuilder() {
        this.order = new Order();
    }

    public OrderBuilder setCustomer(String customerName) {
        order.setCustomerName(customerName);
        return this;
    }

    public OrderBuilder addProduct(String productName, int quantity) {
        order.setProducts(productName, quantity);
        return this;
    }

    public OrderBuilder setShippingAddress(String address) {
        order.setShippingAddress(address);
        return this;
    }

    public OrderBuilder setPaymentMethod(String paymentMethod) {
        order.setPaymentMethod(paymentMethod);
        return this;
    }

    public Order build() {
        return order;
    }
}

// Product
class Order {
    private String customerName;
    private Map<String, Integer> products;
    private String shippingAddress;
    private String paymentMethod;

    Order() {
        this.products = new HashMap<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(String productName, int qty) {
        this.products.put(productName, qty);
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        OrderBuilder builder = new ConcreteOrderBuilder();
        OrderDirector director = new OrderDirector(builder);

        Order order = director.construct();
        System.out.println(order.getProducts());
    }
}