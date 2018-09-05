package cs544.imp1.problemB.models;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 11:52
 */



import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name="order_date")
    private LocalDate date = LocalDate.now();


    @OneToMany(cascade = CascadeType.PERSIST)
    private List<OrderLine> lines = new ArrayList<>();



    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer ;

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Order() {
    }

    public void addLine(OrderLine line) {
      this.lines.add(line);
    }
}
