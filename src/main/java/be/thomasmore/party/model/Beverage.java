package be.thomasmore.party.model;

public class Beverage {
    private Integer id;
    private String name;
    private String type;
    private int price;
    private  String suggested;


    public Beverage(Integer id, String name, String type, int price, String suggested) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.suggested = suggested;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSuggested() {
        return suggested;
    }

    public void setSuggested(String suggested) {
        this.suggested = suggested;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public void setName(String name) {
        this.name = name;
    }
}
