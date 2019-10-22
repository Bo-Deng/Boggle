package assignment;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args) throws IOException {
        Dictionary dic = new Dictionary();
        dic.loadDictionary("test.txt");
        System.out.println(dic.contains("lion"));
        System.out.println(dic.contains("Jacobian"));
        System.out.println(dic.isPrefix("lio"));
        System.out.println(dic.isPrefix("Jacobi"));
    }
}
