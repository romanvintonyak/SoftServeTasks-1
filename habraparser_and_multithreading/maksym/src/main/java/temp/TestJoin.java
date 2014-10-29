package temp;

import task3_1.Article;

import java.util.Iterator;

/**
 * Created by maks on 17.10.2014.
 */
public class TestJoin {
    public static void main(String[] args) {
//        JoinThread jt1 = new JoinThread("First");
//        JoinThread jt2 = new JoinThread("Second");
//        jt1.start();
//
//
//        try {
//            jt1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        jt2.start();
        ArticleContainer articleContainer = new ArticleContainer();
        articleContainer.add(new Article("asdf", "zxcvzxb"));
        articleContainer.add(new Article("asdf23", "zxcvzxb35446"));
        articleContainer.add(new Article("asdf4", "zxcvzxb4"));
        articleContainer.add(new Article("asdf", "zxcvzxb"));
        Iterator<Article> iterator =articleContainer.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(Thread.currentThread().getName());
    }
}
