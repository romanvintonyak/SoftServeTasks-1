import java.util.HashMap;
import java.util.Map;

/**
 * {@inheritDoc}
 * <p>Used for creating RegExpContainer manually</p>
 *
 */
public class ManualRegExpsContainer extends RegExpsContainer {

    /**
     *
     * {@inheritDoc}
     */
    @Override
    protected Map<String, String> loadRegExps() {
        Map<String, String > result = new HashMap<String, String>(5,0.9f);
        
        result.put("Phone numbers","^\\+?3?8?\\(?0[3-9][0-9]\\)?\\d{3}-?\\d{2}-?\\d{2}$");
        result.put("IP addresses","^((1?[0-9]?[0-9]\\.)|(2?[0-4]?[0-9]\\.)|(2?5?[0-5]\\.)){3}((1?[0-9]?[0-9]$)|(2?[0-4]?[0-9]$)|(2?5?[0-5]$))");
        result.put("E-mails","^\\w[\\w-]*(\\.(\\w[\\w-]*)+)*@([a-zA-Z0-9]([-a-zA-Z0-9]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z][a-zA-Z]+$");
        result.put("Addresses","^(вул.|просп.|бул.).+$");

        return result;
    }
}
