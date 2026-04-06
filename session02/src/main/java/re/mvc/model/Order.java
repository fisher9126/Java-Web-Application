package re.mvc.model;

import java.util.Date;

public class Order {
    private String id;
    private String productName;
    private double total;
    private Date orderDate;

    public Order(String id, String productName, double total, Date orderDate) {
        this.id = id;
        this.productName = productName;
        this.total = total;
        this.orderDate = orderDate;
    }

    public String getId() { return id; }
    public String getProductName() { return productName; }
    public double getTotal() { return total; }
    public Date getOrderDate() { return orderDate; }
}