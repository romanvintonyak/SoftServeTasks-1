package com.softserve.tasks.task_2.task_2_2;

import java.io.IOException;
import java.util.List;

/**
 * Created by Olavin on 20.10.2014.
 */
public interface IDataReader {
    List<String> getStrings() throws IOException;
}
