import java.io.*;

/**
 * {@inheritDoc}
 *
 * Used for parsing files
 */
public class FileParser extends Parser {
    private File fileForParsing;
    private String separator;

    /**
     *
     * @param regExpsContainer {@see RegExpsContainer}
     * @param separator string that divide text into smaller parts
     * @param fileName path to file that contains text for parsing
     * @throws IOException
     */
    public FileParser(RegExpsContainer regExpsContainer, String separator, String fileName) throws IOException {
        super(regExpsContainer);
        this.separator = separator;
        this.fileForParsing = new File(fileName);
        loadSource();
    }

    /**
     * Used to load text that should be parsed from file
     * @throws IOException
     */
    @Override
    protected void loadSource() throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(this.fileForParsing.getAbsoluteFile()));
            String sourceString;
            while ((sourceString = reader.readLine()) != null){
                String[] arrayString =  sourceString.split(separator);
                for (String currentString : arrayString){
                    currentString = currentString.trim();
                    this.sourceStrings.add(currentString);
                }
            }
        }
        finally {
            if(reader != null) reader.close();
        }
    }
}
