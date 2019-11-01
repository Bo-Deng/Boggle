package assignment;

import assignment.Boggle;
import assignment.GameDictionary;
import assignment.GameManager;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class BoggleWhiteBox2 {

    // Tests that the GameManager's deepCopy method actually produces a
    // deep copy (modifying the original doesn't modify the copy and vice versa)
    @Test
    public void testDeepCopy() {
        GameManager gm = new GameManager();

        for (int size = 1; size <= 10; size++) {
            int[][] visited = new int[size][size];

            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    visited[r][c] = r * size + c;
                }
            }

            int[][] deepCopy = gm.deepCopyVisitedArray(visited);

            assertTrue(Arrays.deepEquals(deepCopy, visited));

            deepCopy[0][0] = 999;
            assertTrue(!Arrays.deepEquals(deepCopy, visited));

            deepCopy[0][0] = 123;
            visited[0][0] = 123;
            assertTrue(Arrays.deepEquals(deepCopy, visited));
        }
    }

    // Tests that the setGame method correctly sets the game board and disallows non-square boards
    @Test
    public void testSetGame() throws IOException {
        GameManager gm = new GameManager();
        gm.newGame(4, 2, "cubes.txt", new GameDictionary());
        int size = 4;
        char[][] newBoard = new char[size][size];

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                newBoard[r][c] = (char)(r * size + c);
            }
        }
        gm.setGame(newBoard);

        assertTrue(Arrays.deepEquals(newBoard, gm.getBoard()));

        newBoard = new char[4][5];

        assertFalse(Arrays.deepEquals(newBoard, gm.getBoard()));

        gm.setGame(newBoard);

        assertFalse(Arrays.deepEquals(newBoard, gm.getBoard()));

    }



}
