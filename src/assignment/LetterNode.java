package assignment;

import java.util.HashMap;
import java.util.TreeMap;

public class LetterNode {
    char letter;
    String wordOfNode;
    //Is this node the end of a word according to the dictionary E.G. in the word WALKING K and G would be valid ends
    // b/c WALK and WALKING are words
    boolean isValidEnd = false;
    //Each letter node stores possible letters that can follow it in subsequent letters. This creates a tree structure for
    //storing words
    TreeMap<Character, LetterNode> subsequentLetters = new TreeMap();

    public LetterNode(){

    }

    //Sets letter at letternode to a given parameter
    public LetterNode(char letterSet){
        letter = letterSet;
    }

    //Sets letter at letternode and the word being built (essentially this letter node plus all the letter nodes before it)
    public LetterNode(char letterSet, String word){
        letter = letterSet;
        wordOfNode = word;
    }

    //Adds a word by creating additional letter nodes or traversing existing letter nodes for each letter of the word (this
    //is done recursively
    public void addWord(String word){
        //Recursive based case to end the building of the word
        if (word.length() == 0){
            isValidEnd = true;
        }
        else{
            //If the letter is not contained in the tree structure, then a new node is added
            if (!subsequentLetters.containsKey(word.charAt(0))){
                if (letter != 0){
                    subsequentLetters.put(word.charAt(0), new LetterNode(word.charAt(0), wordOfNode + word.charAt(0)));
                }
                else{
                    subsequentLetters.put(word.charAt(0), new LetterNode(word.charAt(0), word.charAt(0)+""));
                }
                subsequentLetters.get(word.charAt(0)).addWord(word.substring(1));
            }
            else {
                subsequentLetters.get(word.charAt(0)).addWord(word.substring(1));
            }
        }
    }

    public String toString(){
        return letter + "";
    }

    //Sees if this word is contained in the tree structure, meaning do the correct nodes exist and is the word a valid word (not just a prefix)
    public boolean contains(String word){
        if (word.length() == 0 && isValidEnd){
            return true;
        }
        else if (word.length() == 0 && !isValidEnd){
            return false;
        }
        return subsequentLetters.containsKey(word.charAt(0)) && subsequentLetters.get(word.charAt(0)).contains(word.substring(1));
    }

    //Sees if it is possible to travel in the tree using each letter of the prefix. Essentially is asking are there words that
    //start with the prefix in the tree structure
    public boolean isPrefix(String prefix){
        if (prefix.length() == 0){
            return true;
        }
        return subsequentLetters.containsKey(prefix.charAt(0)) && subsequentLetters.get(prefix.charAt(0)).isPrefix(prefix.substring(1));
    }

}
