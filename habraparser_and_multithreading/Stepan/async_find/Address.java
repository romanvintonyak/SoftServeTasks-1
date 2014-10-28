package com.jimmy.getAddresslist;


public class Address {
    private String linkName;
    private String linkUrl;

    public Address(String linkName, String linkUrl){
        this.linkName = linkName;
        this.linkUrl = linkUrl;
    }

    public String getLinkName() {
        return linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    @Override
    public String toString() {
        return "["+this.getLinkName()+", "+this.getLinkUrl()+"]";
    }
}
