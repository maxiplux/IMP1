package cs544.imp1.problemB.models;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 2:02
 */



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 11:51
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firtsName;
    private String lastName;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Order> orders = new ArrayList<Order>();

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addOrder(Order order) {
        order.setCustomer(this);

        this.orders.add(order);
    }
}
