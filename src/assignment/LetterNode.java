package assignment;

import java.util.HashMap;
import java.util.TreeMap;

public class LetterNode {
    char letter;
    String wordOfNode;
    boolean isValidEnd = false;
    TreeMap<Character, LetterNode> subsequentLetters = new TreeMap();

    public LetterNode(){

    }

    public LetterNode(char letterSet){
        letter = letterSet;
    }

    public LetterNode(char letterSet, String word){
        letter = letterSet;
        wordOfNode = word;
    }

    public void addWord(String word){
        if (word.length() == 0){
            isValidEnd = true;
        }
        else{
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

    public boolean contains(String word){
        System.out.println(wordOfNode);
        if (word.length() == 0 && isValidEnd){
            return true;
        }
        else if (word.length() == 0 && !isValidEnd){
            return false;
        }
        return subsequentLetters.containsKey(word.charAt(0)) && subsequentLetters.get(word.charAt(0)).contains(word.substring(1));
    }

    public boolean isPrefix(String prefix){
        if (prefix.length() == 0){
            return true;
        }
        return subsequentLetters.containsKey(prefix.charAt(0)) && subsequentLetters.get(prefix.charAt(0)).isPrefix(prefix.substring(1));
    }

}
