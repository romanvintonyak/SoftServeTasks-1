package com.jimmy.getAddresslist;


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
                if(holder.isUpdatedData()){
                addressList = holder.getCache();
                System.out.println("GetAddress"+addressList);
                } else {
                    System.out.println("GetAddress wait");
                    try{
                        Thread.sleep(2000);
                    } catch (InterruptedException exp){ /*NOP*/ }
                }
        }
    }
}
