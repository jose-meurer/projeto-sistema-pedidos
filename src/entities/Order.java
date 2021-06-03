package entities;

import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private Integer id;
    private String name;
    private Double price;
    private Date moment;
    private OrderStatus status;

    public Order() {
    }

    public Order(Integer id, String name, Double price, Date moment, OrderStatus status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.moment = moment;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
        return id
                + ", "
                + name
                + ", "
                + String.format("R$ %.2f, ", price)
                + format1.format(moment)
                + ", "
                + status;
    }
}
