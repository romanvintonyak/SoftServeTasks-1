package com.softserve.tasks.task_2.task_2_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olavin on 20.10.2014.
 */
public class InputDataReader implements IDataReader {
    private File fileForParsing;
    private String separator;

    InputDataReader(String fileName, String separator) {
        this.fileForParsing = new File(fileName);
        this.separator = separator;
    }

    public List<String> getStrings() throws IOException {
        BufferedReader reader = null;
        String sourceString;
        List<String> result = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader(this.fileForParsing.getAbsoluteFile()));
            while ((sourceString = reader.readLine()) != null) {
                String[] splittedString = sourceString.split(separator);
                for (String currentString : splittedString) {
                    currentString = currentString.trim();
                    result.add(currentString);
                }
            }
        } finally {
            if (reader != null) reader.close();
        }
        return result;
    }
}
