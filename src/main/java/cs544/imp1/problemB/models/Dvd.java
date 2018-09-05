package cs544.imp1.problemB.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 3:18
 */
@Entity
@DiscriminatorValue("dvd")
public class Dvd extends  Product {
    String  title;

    public Dvd(String title) {
        this.title = title;
        this.setName(this.title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
