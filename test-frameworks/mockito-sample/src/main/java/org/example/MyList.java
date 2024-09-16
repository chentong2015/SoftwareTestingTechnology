package org.example;

import java.util.List;

public class MyList {

    public String testListParameters(List<List<String>> values) {
        String value = "result";
        return value + values.get(0).get(0);
    }
}
