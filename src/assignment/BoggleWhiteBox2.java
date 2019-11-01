package assignment;

import assignment.Boggle;
import assignment.GameDictionary;
import assignment.GameManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class BoggleWhiteBox2 {

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

    

}
