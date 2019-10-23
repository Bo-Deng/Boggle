package assignment;

import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

public class TestMain {
    public static void main(String[] args) throws IOException {
        String test = "test&%%$&";
        System.out.println(test.matches("\\w+"));

    }
}
