package cs544.imp1.problemB.models;

import javax.persistence.*;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 11:52
 */
@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;

    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
