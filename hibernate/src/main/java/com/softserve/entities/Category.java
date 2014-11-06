package com.softserve.entities;


import javax.persistence.*;

@Entity
@Table(name= "categories")
public class Category{

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int category_id;
    @Column(name = "category_name")
    private String category_name;
    @Column(name = "category_desc")
    private String category_desc;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_desk() {
        return category_desc;
    }

    public void setCategory_desk(String category_desk) {
        this.category_desc = category_desk;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", category_desc='" + category_desc + '\'' +
                '}';
    }
}