package dbc.Classes;

public class Ressourses {
    private int id;
    private String name;
    private float price;
    private int quantity;
    private int id_or;
    private int camp_id;



    public Ressourses(int id, String name, float price, int quantity, int id_or, int camp_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id_or = id_or;
        this.camp_id = camp_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId_or() {
        return id_or;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId_or(int id_or) {
        this.id_or = id_or;
    }

    public int getCamp_id() {
        return camp_id;
    }
}
