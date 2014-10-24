import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author  Vasyl Danylyuk
 *
 * <p>Used to create map of {@see StringValidator}</p>
 */
public class StringValidatorBuilder {
    /**
     *
     * @param regExps {@see RegExpsContainer}
     * @return Map that you can use for validation strings
     */
    public static Map<String, StringValidator> getStringValidators(RegExpsContainer regExps){
        Set<String> keys = regExps.getRegExpMap().keySet();
        Map<String, StringValidator> result = new HashMap<String, StringValidator>(5,0.9f);
        for(String key: keys){
            result.put(key, new StringValidator(regExps.getRegExpMap().get(key)));
        }
        return result;
    }
}
