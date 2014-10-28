package com.jimmy.getAddressList;


import java.util.List;

public class Holder {
    List<Address> cache;
    boolean setAddress = false;

    public synchronized void setCache(List<Address> addr){
        while (setAddress){
            try{
                wait();
            } catch (InterruptedException exp) { /*NOP*/}
        }
            this.cache = addr;
            setAddress = true;
            notify();
    }

    public synchronized List<Address> getCache(){
        while (!setAddress){
            try{
                wait();
            } catch (InterruptedException exp) { /*NOP*/ }
        }
        this.setAddress = false;
        notify();
        return this.cache;
    }

}
