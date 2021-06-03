package entities;

import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {

    private Integer id;
    private String name;
    private Double value;
    private Date moment;
    private OrderStatus status;

    public Order(){

    }

    public Order(Integer id, String name,Double value, Date moment, OrderStatus status) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public Double getValue() {
        return value;
    }

    public static void showList(List<Order> list){
        System.out.println();
        System.out.println("Lista de pedidos: ");
        for (Order x : list){
            System.out.println(x);
        }
    }

    @Override
    public String toString(){
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
        return id
                + ", "
                + name
                + ", "
                + String.format("R$ %.2f, ", value)
                + format1.format(moment)
                + ", "
                + status;
    }
}
