package dbc.Classes;

import java.util.Date;

public class Note {
    private int id;
    private String description;
    private Date date;
    private String color;
    private int org_id;

    public Note(int id, String description, Date date, String color, int org_id) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.color = color;
        this.org_id = org_id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getColor() {
        return color;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
