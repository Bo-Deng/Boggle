package assignment;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Dictionary implements BoggleDictionary {

    public LetterNode root;

    public Dictionary() {
        root = new LetterNode();
    }

    @Override
    public void loadDictionary(String filename) throws IOException {
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNext()) {
            root.addWord(sc.next());
        }
    }

    @Override
    public boolean isPrefix(String prefix) {
        return root.isPrefix(prefix);
    }

    @Override
    public boolean contains(String word) {
        return root.contains(word);
    }

    @Override
    public Iterator<String> iterator() {
        return new BoggleDictionaryIterator(root);
    }
}
