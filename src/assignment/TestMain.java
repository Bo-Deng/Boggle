package assignment;

import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

public class TestMain {
    public static void main(String[] args) throws IOException {
        Dictionary dic = new Dictionary();
        dic.loadDictionary("test.txt");
        Iterator it = dic.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
