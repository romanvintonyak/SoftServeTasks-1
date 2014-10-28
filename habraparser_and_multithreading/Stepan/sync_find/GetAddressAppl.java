package com.jimmy.getAddressList;


public class GetAddressAppl {
    public static void main(String[] args) {
        Holder holder = new Holder();
        new SetAddress(holder);
        new GetAddress(holder);
    }
}
