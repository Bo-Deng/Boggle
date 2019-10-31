package assignment;


import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class BoggleDictionaryIterator implements Iterator {

    //Queue contained all words in order from the dictionary initally.
    Queue<String> futureWords = new ArrayDeque();

    public BoggleDictionaryIterator(LetterNode root) {
        Stack<LetterNode> iteration = new Stack();
        iteration.add(root);
        //Traverses tree and adds all words in reverse alphabetical order to futureWords
        while (!iteration.isEmpty()){
            LetterNode nextNode = iteration.pop();
            if (nextNode.isValidEnd){
                futureWords.add(nextNode.wordOfNode);
            }
            for (Character key : nextNode.subsequentLetters.descendingKeySet()){
                iteration.push(nextNode.subsequentLetters.get(key));
            }
        }
    }

    //Checks if more words are in the Queue
    @Override
    public boolean hasNext() {
        return futureWords.size() != 0;
    }

    //Pops the word from the top of the queue. Since alphabetically earlier words are added earlier, FIFO means alphabetically
    //early words are popped first
    @Override
    public Object next() {
        return futureWords.poll();
    }
}
