package temp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import task3_1.Article;

/**
 * Created by maks on 17.10.2014.
 */
public class Parser extends Thread {
    public ArticleContainer getArticles() {
        return articles;
    }

//    public Document getDocument() {
//        return document;
//    }

    private ArticleContainer articles = new ArticleContainer();
    private Document document;
    private Elements elements;

    public void run() {
        try {
            document = Jsoup.connect("http://habrahabr.ru/").get();
            Elements elements = document.getElementsByClass("post_title");

            for (Element element : elements) {

                System.out.println("                        in Parser"+articles.size());
//                System.out.println(nL);
                synchronized (articles) {
                    articles.add(new Article(element.text(), element.attr("href")));
//                    System.out.println(element.text() +" + " +element.attr("href"));
                    System.out.println("Parser begin wait");
//                    articles.notifyAll();
                    articles.wait();
                }

            }

//            // simulation internet DELETE
//            System.out.println("in parser");
//
//            synchronized (articles) {
//                for (int i = 0; i < 10; i++) {
//                    articles.add(new Article("name " + i, "link " + i * 12));
//                    articles.wait();
//                    articles.notifyAll();
//                }
//                articles.isReady=false;
//
//            }
//            System.out.println(articles.size()+" parser mast ded");
////        } catch (IOException e) {
////            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
