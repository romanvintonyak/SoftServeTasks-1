package com.softserve.entities;

import javax.persistence.*;

@Entity
@Table(name = "activities")
public class Activity{
    @Id
    @GeneratedValue
    @Column(name = "activity_id")
    private int activity_id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;
    @Column(name = "operation_type")
    private int operation_type;
    @Column(name = "activity_desc")
    private String activity_desc;

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public int getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(int operation_type) {
        this.operation_type = operation_type;
    }

    public String getActivity_desc() {
        return activity_desc;
    }

    public void setActivity_desc(String activity_desc) {
        this.activity_desc = activity_desc;
    }
}