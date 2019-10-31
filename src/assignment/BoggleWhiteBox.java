package assignment;

import assignment.Boggle;
import assignment.GameDictionary;
import assignment.GameManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Iterator;

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
            assertTrue(it.next().equals(match));
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
        String cubesFile = "testdice.txt";
        dc.loadDictionary("words.txt");
        gameBoard.newGame(3,2, cubesFile,dc);
        assertEquals(3, gameBoard.getBoard().length);
        assertEquals(3, gameBoard.getBoard()[0].length);
        gameBoard.newGame(0,2, cubesFile,dc);
        assertEquals(0, gameBoard.getBoard().length);
        gameBoard.newGame(6,2, cubesFile,dc);
        assertEquals(6, gameBoard.getBoard().length);
        assertEquals(6, gameBoard.getBoard()[0].length);
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
                System.out.println(gameBoard.getBoard()[i][j]);
            }
        }
    }

    @Test
    public void testScoring() throws IOException{

    }

    @Test
    public void testBoardSearching() throws IOException{
        GameManager gameBoard = new GameManager();
        GameDictionary dc = new GameDictionary();
        String cubesFile = "testdice.txt";
        dc.loadDictionary("words.txt");
        gameBoard.newGame(4, 2, cubesFile, dc);
        char[][] testBoard = {{'A','G','G','R'}, {'I','S','S','E'}, {'V','E','N','E'}, {'S','E','S','S'}};
        //char[][] testBoard = {{'a','g','g','r'}, {'i','s','s','e'}, {'v','e','n','e'}, {'s','e','s','s'}};
        gameBoard.setGame(testBoard);
        System.out.println(testBoard[0][0]);
        gameBoard.addWord("aggressivenesses", 0);
        gameBoard.addWord("AGGRESSIVENESSES", 0);
        assertEquals(gameBoard.getScores()[0], 13);
    }

    @Test
    public void testNewGameInput() throws IOException {
        GameManager gameBoard = new GameManager();
        GameDictionary dc = new GameDictionary();
        String cubesFile = "testdice.txt";
        dc.loadDictionary("words.txt");
        //Tests invalid array sizes (e.g. negative nums, zero)
        assertThrows(Exception.class, () -> {
            gameBoard.newGame(-5, 2, cubesFile, dc);
        });
        //assertThrows(Exception.class, () -> {
        gameBoard.newGame(0, 2, cubesFile, dc);
        //});
        //gameBoard.addWord("hello", 0);
        assertThrows(Exception.class, () -> {
            gameBoard.newGame(1,2,"nonexistentfile", dc);
        });
    }


}
