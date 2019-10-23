package assignment;

import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class BoggleDictionaryIterator implements Iterator {

    Stack<String> futureWords = new Stack();

    public BoggleDictionaryIterator(LetterNode root) {
        Stack<LetterNode> iteration = new Stack();
        iteration.add(root);
        while (!iteration.isEmpty()){
            LetterNode nextNode = iteration.pop();
            if (nextNode.isValidEnd){
                futureWords.push(nextNode.wordOfNode);
            }
            for (Character key : nextNode.subsequentLetters.keySet()){
                iteration.push(nextNode.subsequentLetters.get(key));
            }
        }
    }

    @Override
    public boolean hasNext() {
        return futureWords.size() != 0;
    }

    @Override
    public Object next() {
        return futureWords.pop();
    }
}
