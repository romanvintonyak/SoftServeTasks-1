package temp;

import java.util.Iterator;

/**
 * Created by maks on 18.10.2014.
 */
public class Reader extends Thread {
    private ArticleContainer articles;
    private int ind = 0;
    private int current;

    public Reader(ArticleContainer articleContainer) {
        articles = articleContainer;
    }

    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        synchronized (articles) {
            Iterator iterator = articles.iterator();

            System.out.println(articles.size()+"  in synch block Reader");
            /**  for(int i=0; i<10; i++) {
             while (iterator.hasNext()) {
             System.out.println(iterator.next());
             }
             System.out.println("reader notify articless!!");
             System.out.println(articles.size());
             articles.notify();
             }*/
            if(articles.size()==0) {
                while (articles.isReady == false) {
                    try {
                        System.out.println("reader  while before white!!");

                        articles.wait();
                        System.out.println("reder wecap");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            while (articles.isReady) {
                System.out.println("in reader while...");

                view();
                articles.notifyAll();
                try {
                    articles.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    private void view() {
        System.out.println("int view!!");
//        if (articles.size() != 0) {
            while (current <articles.getCurrent()) {
                System.out.println(articles.getElement(current++));
            }
//        }
        System.out.println("size articles == 0 "+articles.size());
    }

}
