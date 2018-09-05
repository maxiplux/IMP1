package cs544.imp1.problemB.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 3:18
 */
@Entity
@DiscriminatorValue("cd")
public class Cd extends  Product {
    String  artist;

    public Cd(String artist) {
        this.artist = artist;

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
