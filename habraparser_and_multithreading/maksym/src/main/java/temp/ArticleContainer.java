package temp;

import task3_1.Article;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by maks on 17.10.2014.
 */
public class ArticleContainer implements Iterable {
    private int current;
    public static boolean isReady = false;
    private ArrayList<Article> articles = new ArrayList<Article>();


    public ArticleContainer() {
    }
    /**return list articles*/
    public ArrayList<Article> get() {
        return articles;
    }


    synchronized public void add(Article article) {
        articles.add(article);
        current++;
        isReady = true;
    }

    @Override
    public Iterator iterator() {
        return articles.iterator();
    }
    /**Return element by index*/
    public Article getElement(int index){
        return articles.get(index);
    }

    /**
     * This method return current current index
     */
    public int getCurrent() {
        return  current;
    }
    /** return size of array*/
    public int size() {
        return articles.size();
    }
}
