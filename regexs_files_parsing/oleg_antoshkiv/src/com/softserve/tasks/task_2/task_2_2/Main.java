//FIXME commit packages into GitHub. The whole structure should be committed. Not only classes, but packages too.
package com.softserve.tasks.task_2.task_2_2;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Olavin on 20.10.2014.
 */
public class Main {

	//There is a lot of abstraction(wrappers, etc.) for such simple task. Try to avoid redundant abstract layers if there is no really need.
    public static void main(String[] args) {

        List<String> inputStrings;
        Set<StringEntity> entities = createStringEntities();

        IDataReader fileReader = new InputDataReader("com/softserve/tasks/task_2/task_2_2/data_for_parsing.txt", ";");

        try {
            // read input strings and split by semicolon
            inputStrings = fileReader.getStrings();

            // match input strings to entities
            for (String stringToMatch : inputStrings) {
                for (StringEntity entity : entities) {
                    entity.addIfSuitable(stringToMatch);
                }
            }

            // show collected strings
            showStringEntities(entities);

        } catch (IOException exception) {
            System.out.println("Can't read source file");
        }
    }

    public static Set<StringEntity> createStringEntities(){

        Set<StringEntity> entities = new HashSet<StringEntity>();

        entities.add(new StringEntity("Phone numbers",
        		//FIXME regexp should be moved to the constants or separate property file
                new RegExpValidator("^\\+?3?8?\\(?0[3-9][0-9]\\)?\\d{3}-?\\d{2}-?\\d{2}$")));

        entities.add(new StringEntity("IP addresses",
                new RegExpValidator("(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)")));
                //new RegExpValidator("^((1?[0-9]?[0-9]\\.)|(2?[0-4]?[0-9]\\.)|(2?5?[0-5]\\.)){3}((1?[0-9]?[0-9]$)|(2?[0-4]?[0-9]$)|(2?5?[0-5]$))")));

        entities.add(new StringEntity("E-mails",
                new RegExpValidator("^\\w[\\w-]*(\\.(\\w[\\w-]*)+)*@([a-zA-Z0-9]([-a-zA-Z0-9]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z][a-zA-Z]+$")));

        entities.add(new StringEntity("Addresses",
                new RegExpValidator("^(вул.|просп.|бул.).+$")));

        return entities;
    }

    // show collected strings
    public static void showStringEntities(Set<StringEntity> entities){
        for (StringEntity entity : entities) {
            System.out.println(entity.getName());
            for (String string : entity.values()) {
                System.out.print(" - ");
                System.out.println(string);
            }
            System.out.println();

        }
    }

}
