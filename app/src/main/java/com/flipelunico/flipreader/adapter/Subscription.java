package com.flipelunico.flipreader.adapter;

/**
 * Created by Flipelunico on 12-10-16.
 */

public class Subscription {
    private String id;
    private String title;
    private String website;
    private String category_id;
    private String category_label;
    private String updated;

    public String get_id(){
        return id;
    }

    public void set_id(String value){
        this.id = value;
    }

    public String get_title(){
        return title;
    }

    public void set_title(String value){
        this.title = value;
    }

    public String get_website(){
        return website;
    }

    public void set_website(String value){
        this.website = value;
    }

    public String get_category_id(){
        return category_id;
    }

    public void set_category_id(String value){
        this.category_id = value;
    }

    public String get_category_label(){
        return category_label;
    }

    public void set_category_label(String value){
        this.category_label = value;
    }

    public String get_updated(){
        return updated;
    }

    public void set_updated(String value){
        this.updated = value;
    }
}
