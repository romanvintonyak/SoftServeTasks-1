package com.jimmy.getAddressList;


import java.util.List;

public class GetAddress implements Runnable{

    Holder holder;
    List<Address> addressList;


    public GetAddress (Holder hol){
        this.holder = hol;
        new Thread(this,"getter").start();
    }


    @Override
    public void run() {
        while(true){
                addressList = holder.getCache();
                System.out.println("GetAddress"+addressList);
        }
    }
}
