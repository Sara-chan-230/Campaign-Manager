package dbc.Classes;

public class ToDoList {
    private int id;
    private String content;
    private Boolean completed;
    private String color;
    private int iD_O;

    public ToDoList(int id, String content, Boolean completed, String color, int iD_O) {
        this.id = id;
        this.content = content;
        this.completed = completed;
        this.color = color;
        this.iD_O = iD_O;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getColor() {
        return color;
    }

    public int getiD_O() {
        return iD_O;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setiD_O(int iD_O) {
        this.iD_O = iD_O;
    }
}
