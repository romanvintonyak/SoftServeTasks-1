import java.util.Map;

/**
 * @author Vasyl Danylyuk
 *
 * <p>Used for containing patterns that use for parsing text</p>
 *
 */
public abstract class RegExpsContainer {
    private Map<String, String> RegExpMap;

    protected RegExpsContainer() {
        RegExpMap = loadRegExps();
    }

    /**
     *
     * @return Map that consists from names of patterns and patterns
     */
    public Map<String, String> getRegExpMap() {
        return RegExpMap;
    }

    /**
     *
     * Used for loading patterns from external resource
     */
    protected abstract Map<String, String> loadRegExps();
}
