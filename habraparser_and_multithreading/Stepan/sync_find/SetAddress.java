package com.jimmy.getAddressList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SetAddress implements Runnable {

    private final String URL = "http://habrahabr.ru/";
    private final String USER_AGENT =  "Mozilla";
    private final String LINK_CLASS = "a.post_title";

    Holder holder;
    List<Address> addressList;

    public SetAddress(Holder hol){
        this.holder = hol;
        new Thread(this,"setter").start();
    }

    @Override
    public void run() {
        while (true){
            addressList = new ArrayList<Address>();
            try{
                Document doc = Jsoup.connect(URL).userAgent(USER_AGENT).get();
                Elements links = doc.select(LINK_CLASS);
                for (Element link : links){
                    String linkUrl = link.attr("abs:href");
                    String linkName = link.text();
                    addressList.add(new Address(linkName,linkUrl));
                }

            } catch (IOException exp ) { /*NOP*/ }

            System.out.println("PutAddress"+addressList.toString());
            holder.setCache(addressList);

            try{
                Thread.sleep(5000);
            } catch (InterruptedException exp){ /*NOP*/ }
        }
    }
}
