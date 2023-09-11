package be.thomasmore.party.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Client {
    @Id
    private Integer id;
    private String name;
    private int nrOfOrders;
    private double totalAmount;
    private double discountTaken;

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrOfOrders() {
        return nrOfOrders;
    }

    public void setNrOfOrders(int nrOfOrders) {
        this.nrOfOrders = nrOfOrders;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmountOfOrders) {
        this.totalAmount = totalAmountOfOrders;
    }

    public double getDiscountTaken() {
        return discountTaken;
    }

    public void setDiscountTaken(double discountTaken) {
        this.discountTaken = discountTaken;
    }
}
