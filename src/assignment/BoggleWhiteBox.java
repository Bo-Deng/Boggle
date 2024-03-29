package assignment;

import assignment.Boggle;
import assignment.GameDictionary;
import assignment.GameManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class BoggleWhiteBox {

    // Test that the dictionary correctly iterates in lexicographical order
    @Test
    public void testDictionaryOrder() throws Exception {
        GameDictionary testDictionary = new GameDictionary();
        testDictionary.loadDictionary("iteratortest.txt");
        Iterator it = testDictionary.iterator();
        int letter = 97;
        int count = 1;
        while (it.hasNext()){
            String match = "";
            for (int i = 0; i < count; i++){
                match += (char)(letter);
            }
            String next = ((String) it.next()).toUpperCase();
            assertTrue(next.equals(match.toUpperCase()));
            if (count == 5){
                count = 1;
                letter++;
            }
            else{
                count++;
            }
        }

    }


    @Test
    public void boardSizing() throws Exception{
        GameManager gameBoard = new GameManager();
        GameDictionary dc = new GameDictionary();
        //Tests boards of non-standard sizes can be properly created
        String cubesFile = "cubes.txt";
        dc.loadDictionary("words.txt");
        for (int i = 1; i < 100; i++){
            gameBoard.newGame(i, 2, cubesFile, dc);
            assertEquals(gameBoard.getBoard().length, i);
            assertEquals(gameBoard.getBoard()[0].length, i);
        }
    }


    // Test that cubes of special and non-English characters can be loaded in correctly
    @Test
    public void testSpecialInput() throws IOException{
        GameManager gameBoard = new GameManager();
        GameDictionary dc = new GameDictionary();
        String cubesFile = "specialcharactercubes.txt";
        dc.loadDictionary("words.txt");
        gameBoard.newGame(4, 2, cubesFile, dc);
        gameBoard.addWord("aggressivenesses", 0);
        for (int i = 0; i < gameBoard.getBoard().length; i++){
            for (int j = 0; j < gameBoard.getBoard()[0].length; j++){
                assertTrue(gameBoard.getBoard()[i][j] != 0);
            }
        }
    }

    // Test that the addWord method can find long words on the board and not find
    // words that aren't on the board
    @Test
    public void testBoardSearching() throws IOException{
        GameManager gameBoard = new GameManager();
        GameDictionary dc = new GameDictionary();
        String cubesFile = "cubes.txt";
        dc.loadDictionary("words.txt");
        gameBoard.newGame(4, 2, cubesFile, dc);
        char[][] testBoard = {{'A','G','G','R'}, {'I','S','S','E'}, {'V','E','N','E'}, {'S','E','S','S'}};
        //char[][] testBoard = {{'a','g','g','r'}, {'i','s','s','e'}, {'v','e','n','e'}, {'s','e','s','s'}};
        gameBoard.setGame(testBoard);
        gameBoard.addWord("AGGRESSIVENESSES", 0);
        assertEquals(gameBoard.getScores()[0], 13);

        gameBoard.newGame(4,2,cubesFile,dc);
        gameBoard.setGame(testBoard);
        gameBoard.addWord("aggressivenesses", 0);
        assertEquals(gameBoard.getScores()[0], 13);

        //Score should not change for words that are not present or words of improper length
        gameBoard.addWord("dog", 0);
        assertEquals(gameBoard.getScores()[0], 13);
        gameBoard.addWord("boggle", 0);
        assertEquals(gameBoard.getScores()[0], 13);
        gameBoard.addWord("aggression", 0);
        assertEquals(gameBoard.getScores()[0], 13);
        gameBoard.addWord("aggressivenessesa", 0);
        assertEquals(gameBoard.getScores()[0], 13);
        gameBoard.addWord("agg", 0);
        assertEquals(gameBoard.getScores()[0], 13);
    }


    @Test
    public void testNewGameInput() throws IOException {
        GameManager gameBoard = new GameManager();
        GameDictionary dc = new GameDictionary();
        String cubesFile = "cubes.txt";
        dc.loadDictionary("words.txt");
        //Tests invalid array sizes (e.g. negative nums, zero)
        assertThrows(IllegalArgumentException.class, () -> {
            gameBoard.newGame(-5, 2, cubesFile, dc);
        });
        assertThrows(IllegalArgumentException.class, () -> {
        gameBoard.newGame(0, 2, cubesFile, dc);
        });
        assertThrows(IOException.class, () -> {
            gameBoard.newGame(4,2,"nonexistentfile", dc);
        });
    }

    // Test that the board and dictionary search produce identical results
    @Test
    public void testBoardAndDictionarySearch() throws IOException{
        GameManager gameBoard = new GameManager();
        GameDictionary dc = new GameDictionary();
        String cubesFile = "cubes.txt";
        dc.loadDictionary("words.txt");
        for (int i = 1; i < 12; i++){
            gameBoard.newGame(i, 2, cubesFile, dc);
            gameBoard.setSearchTactic(BoggleGame.SearchTactic.SEARCH_BOARD);
            gameBoard.getAllWords();
            int score1 = gameBoard.getScores()[0];
            gameBoard.clearScores();
            gameBoard.clearFoundTiles();
            gameBoard.setSearchTactic(BoggleGame.SearchTactic.SEARCH_DICT);
            gameBoard.getAllWords();
            int score2 = gameBoard.getScores()[0];
            assertTrue(score1 == score2);
        }
    }

    @Test
    public void testIsPrefix() throws IOException {
        GameDictionary dc = new GameDictionary();
        dc.loadDictionary("words.txt");
        //Case 1: Empty String is a prefix always
        assertTrue(dc.isPrefix(""));

        //Case 2: Words in the dictionary
        //Three letter words, despite being invalid for scoring should still be treated as usual in the dictioanry
        assertTrue(dc.isPrefix("CAT"));
        assertTrue(dc.isPrefix("cat"));
        //Case 3: Prefixes in the Dictionary
        assertTrue(dc.isPrefix("transf"));
        assertTrue(dc.isPrefix("hippop"));
        assertTrue(dc.isPrefix("lio"));
        //Case 4: Non existant words/prefixes
        assertFalse(dc.isPrefix("qwerty"));
        assertFalse(dc.isPrefix("hiperp"));
        assertFalse(dc.isPrefix("bogglegame"));
    }

    @Test
    public void testContains() throws IOException{
        GameDictionary dc = new GameDictionary();
        dc.loadDictionary("words.txt");

        //Case 1: Empty String is not in the dictionary
        assertFalse(dc.contains(""));
        //Case 2: Words in the dictionary
        assertTrue(dc.contains("DOG"));
        assertTrue(dc.contains("dog"));
        //Case 3: Non existant words
        //Note the dictionary used does not contain single letter words
        assertFalse(dc.contains("i"));
        assertFalse(dc.contains("bonjour"));
        assertFalse(dc.contains("aggressivenesset"));
    }

    @Test
    public void testAddWord(){
        LetterNode testNode = new LetterNode();
        //Word is not present until after it is added
        //Case 1: Nonexistant word before and after add
        assertFalse(testNode.contains("potato"));
        testNode.addWord("potato");
        assertTrue(testNode.contains("potato"));
        //Case 2: Word similar to already existing word
        assertFalse(testNode.contains("potata"));
        testNode.addWord("potata");
        assertTrue(testNode.contains("potata"));
        //Case 3: Whitespace
        assertFalse(testNode.contains(""));
        testNode.addWord("");
        assertTrue(testNode.contains(""));

    }

    @Test
    public void testIteratorHasNext() throws IOException {
        GameDictionary gd = new GameDictionary();
        Iterator it = gd.iterator();
        //No next element exists
        assertFalse(it.hasNext());
        gd.loadDictionary("words.txt");
        it = gd.iterator();
        assertTrue(it.hasNext());
    }

    // Test that the scoring of a word is equal to its length - 3
    @Test
    public void testScoring() throws IOException{
        GameDictionary gd = new GameDictionary();
        gd.loadDictionary("controlleddictionary");
        GameManager gm = new GameManager();
        gm.newGame(4, 2, "controlleddice", gd);
        String word = "A";
        for (int i = 1; i <= 16; i++){
            gm.clearScores();
            gm.addWord(word, 0);
            assertEquals(gm.getScores()[0], Math.max(0, i-3));
            word += "A";
        }
    }


}
