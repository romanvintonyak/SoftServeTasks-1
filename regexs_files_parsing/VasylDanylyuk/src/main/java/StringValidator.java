package com.softserve.tasks.task_2.task_2_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vasyl Danylyuk
 *
 * <p>Used for validation strings by {@see java.util.regex.Pattern}</p>
 */
public class StringValidator {
    private Pattern regExpPattern;

    /**
     *
     * @param regExp string that description pattern
     */
    public StringValidator(String regExp) {
        this.regExpPattern = Pattern.compile(regExp);
    }

    /**
     *
     * @param sourceString string that yoy want to validate
     * @return true if sourceString is valid for your pattern
     */
    public boolean validate(String sourceString){
        Matcher result = regExpPattern.matcher(sourceString);
        return result.matches();
    }
}
