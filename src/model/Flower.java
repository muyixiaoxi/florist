package model;

import java.io.Serializable;

public class Flower {
    private int id;
    private String name;
    private String kind;
    private String price;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Flower(int id, String name, String kind, String price, String path) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.path = path;
    }


    public Flower() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
