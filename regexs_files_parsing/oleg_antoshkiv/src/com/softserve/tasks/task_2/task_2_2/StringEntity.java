package com.softserve.tasks.task_2.task_2_2;

import java.util.ArrayList;

/**
 * Created by Olavin on 20.10.2014.
 */
public class StringEntity {
    private IValidator validator;
    private String name;
    private ArrayList<String> entityList = null;

    StringEntity(String name, IValidator validator) {
        this.name = name;
        this.validator = validator;
        entityList = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public boolean addIfSuitable(String value) {
        if (validator.validate(value)) {
            entityList.add(value);
            return true;
        } else return false;//FIXME use curly brackets for 'else' block too for better code readability
    }

    public ArrayList<String> values() {
        return entityList;
    }

}
