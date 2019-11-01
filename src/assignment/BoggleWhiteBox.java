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


}
