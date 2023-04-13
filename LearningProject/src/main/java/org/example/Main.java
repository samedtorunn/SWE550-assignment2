package org.example;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        TestExecutor executor = new TestExecutor(LinkTitleConsistencyTest.class);
        Result result = executor.execute(true);
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
    }
}


