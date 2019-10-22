package assignment;

import java.util.HashMap;

public class LetterNode {
    char letter;
    boolean isValidEnd = false;
    HashMap<Character, LetterNode> subsequentLetters = new HashMap();

    public LetterNode(){

    }

    public LetterNode(char letterSet){
        letter = letterSet;
    }

    public void addWord(String word){
        if (word.length() == 0){
            isValidEnd = true;
        }
        else{
            if (!subsequentLetters.containsKey(word.charAt(0))){
                subsequentLetters.put(word.charAt(0), new LetterNode(word.charAt(0)));
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
