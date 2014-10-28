package com.jimmy.getAddresslist;


import java.util.List;

public class Holder {
    List<Address> cache;

    private volatile boolean updatedData = false;

    public boolean isUpdatedData() {
        return updatedData;
    }

    public synchronized void setCache(List<Address> addr){
            this.cache = addr;
            updatedData = true;
    }


    public synchronized List<Address> getCache(){
        this.updatedData = false;
        return this.cache;
    }

}
