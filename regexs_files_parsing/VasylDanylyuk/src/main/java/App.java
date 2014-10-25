//FIXME commit packages into GitHub. The whole structure should be committed. Not only classes, but packages too. 
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by BAXA on 18.10.2014.
 */
//FIXME Give more understadable name for the main class.
public class App {
	//FIXME Handle excaptions at least here. Don't throw it from main method.
    public static void main(String[] args) throws IOException {
        RegExpsContainer regExps = new ManualRegExpsContainer();

        Parser parser = new FileParser(regExps, ";", "src\\com\\softserve\\tasks\\task_2\\task_2_2\\data_for_parsing.txt");

        Map<String, List<String>> parsedStrings = parser.getParsed();

        Set<String> keys = parsedStrings.keySet();
        for(String key : keys){
            System.out.println(key);
            System.out.println("----------------------------------------------------------------");
            for(String currentString: parsedStrings.get(key)){
                System.out.println(currentString);
            }
            System.out.println("----------------------------------------------------------------");
        }
    }

}
