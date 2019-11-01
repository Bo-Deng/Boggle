package assignment;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class GameDictionary implements BoggleDictionary {

    public LetterNode root;

    public GameDictionary() {
        root = new LetterNode();
    }

    @Override
    public void loadDictionary(String filename) throws IOException {
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNext()) {
            root.addWord(sc.next().toUpperCase());
        }
    }

    @Override
    public boolean isPrefix(String prefix) {
        return root.isPrefix(prefix.toUpperCase());
    }

    @Override
    public boolean contains(String word) {
        return root.contains(word.toUpperCase());
    }

    @Override
    public Iterator<String> iterator() {
        return new BoggleDictionaryIterator(root);
    }
}
