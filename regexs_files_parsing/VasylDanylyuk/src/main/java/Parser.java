import java.io.IOException;
import java.util.*;

/**
 * @author Vasyl Danylyuk
 *
 * Used to parse text to pieces by patterns
 */
public abstract class Parser {
    protected List<String> sourceStrings;
    private Map<String, StringValidator> stingValidators;

    protected Parser(RegExpsContainer regExpsContainer) {
        this.stingValidators = StringValidatorBuilder.getStringValidators(regExpsContainer);
        this.sourceStrings = new LinkedList<String>();
    }

    /**
     *
     * @return Map that consist from name of pattern as key and list of strings that satisfy this pattern
     */
    public Map<String, List<String>> getParsed(){
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        Set<String> keys = stingValidators.keySet();
        for(String key: keys){
            List<String> value = new LinkedList<String>();
            Iterator<String> listIterator = this.sourceStrings.iterator();
            while (listIterator.hasNext()){
                String currentString = listIterator.next();
                if(this.stingValidators.get(key).validate(currentString)){
                    value.add(currentString);
                    listIterator.remove();
                }
            }
            result.put(key,value);
        }
        return result;
    };

    /**
     * Used for loading text for parsing from external source
     * @throws IOException
     */
    protected abstract void loadSource() throws IOException;
}
