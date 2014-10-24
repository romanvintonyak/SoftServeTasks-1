
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by BAXA on 18.10.2014.
 */
public class App {
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
