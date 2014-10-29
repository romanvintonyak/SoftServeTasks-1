package temp;

/**
 * Created by maks on 18.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        ArticleContainer articles ;
        Parser parser = new Parser();
        articles = parser.getArticles();
        Reader reader = new Reader(articles);
        parser.start();
        reader.start();


    }
}
