package walking.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import walking.game.util.Direction;



public class WalkingBoardWithPlayersTest {
    
    @Test 
    public void walk1() {
        WalkingBoardWithPlayers wb = new WalkingBoardWithPlayers(new int[10][5], 3);
        int[] scores = wb.walk(5, 4, 2,19,21);

        //Har kisi kee custom check krne ke liay nichay functions.
        //Checking Scores
        assertEquals(126, scores[0]);
        assertEquals(68, scores[1]);
        assertEquals(12, scores[2]);   

        //Checking Board Score
        //1st Row
        assertEquals(13 ,wb.getTile(0,0));
        assertEquals(5 ,wb.getTile(0,1));
        assertEquals(5 ,wb.getTile(0,2));
        assertEquals(5 ,wb.getTile(0,3));
        assertEquals(5 ,wb.getTile(0,4));

        //2nd Row
        assertEquals(13 ,wb.getTile(1,0));
        assertEquals(3 ,wb.getTile(1,1));
        assertEquals(3 ,wb.getTile(1,2));
        assertEquals(3 ,wb.getTile(1,3));
        assertEquals(4 ,wb.getTile(1,4));

        //3rd Row
        assertEquals(13 ,wb.getTile(2,0));
        assertEquals(3 ,wb.getTile(2,1));
        assertEquals(3 ,wb.getTile(2,2));
        assertEquals(3 ,wb.getTile(2,3));
        assertEquals(4 ,wb.getTile(2,4));

        //4th Row
        assertEquals(13 ,wb.getTile(3,0));
        assertEquals(3 ,wb.getTile(3,1));
        assertEquals(3 ,wb.getTile(3,2));
        assertEquals(3 ,wb.getTile(3,3));
        assertEquals(4 ,wb.getTile(3,4));

        //5th Row
        assertEquals(13 ,wb.getTile(4,0));
        assertEquals(3 ,wb.getTile(4,1));
        assertEquals(3 ,wb.getTile(4,2));
        assertEquals(3 ,wb.getTile(4,3));
        assertEquals(4 ,wb.getTile(4,4));

        //6th Row
        assertEquals(13 ,wb.getTile(5,0));
        assertEquals(3 ,wb.getTile(5,1));
        assertEquals(3 ,wb.getTile(5,2));
        assertEquals(3 ,wb.getTile(5,3));
        assertEquals(4 ,wb.getTile(5,4));

        //7th Row 
        assertEquals(13 ,wb.getTile(6,0));
        assertEquals(3 ,wb.getTile(6,1));
        assertEquals(3 ,wb.getTile(6,2));
        assertEquals(3 ,wb.getTile(6,3));
        assertEquals(4 ,wb.getTile(6,4));

        //8th Row
        assertEquals(13 ,wb.getTile(7,0));
        assertEquals(3 ,wb.getTile(7,1));
        assertEquals(3 ,wb.getTile(7,2));
        assertEquals(3 ,wb.getTile(7,3));
        assertEquals(4 ,wb.getTile(7,4));

        //9th Row
        assertEquals(13 ,wb.getTile(8,0));
        assertEquals(2 ,wb.getTile(8,1));
        assertEquals(2 ,wb.getTile(8,2));
        assertEquals(2 ,wb.getTile(8,3));
        assertEquals(4 ,wb.getTile(8,4));

        //10 Row
        assertEquals(13 ,wb.getTile(9,0));
        assertEquals(13 ,wb.getTile(9,1));
        assertEquals(13 ,wb.getTile(9,2));
        assertEquals(13 ,wb.getTile(9,3));
        assertEquals(13 ,wb.getTile(9,4));
    }


    @Test
    public void walk2() {

        int[][] array2d = {{1, 2, 3, 4, 5},
                            {6, 7, 8, 9, 10, 11},
                            {12, 13},
                            {14, 15, 16, 17},
                            {18, 19, 20, 21, 22, 23, 24}};  // Custom tiles ko bnaaa kr board main initialize krne ke liay

        WalkingBoardWithPlayers wb = new WalkingBoardWithPlayers(array2d,5); 
        int[] scores = wb.walk(5, 4, 3, 2, 4, 1, 6, 3,2,1); // Board ko walk kraaya
        int[][] array = wb.getTiles(); // New array bnaa kr gettiles chalaya
        int[][] expected = {{3, 2, 2, 2, 2},{3, 3, 3, 3, 1, 11},{3, 13},{3, 15, 16, 17},{6, 6, 6, 6, 6, 6, 6}}; // yeh expected array ha is se compare krna ha.

        for (int i=0; i< array.length ; i++) {
            for (int j=0; j<array[i].length; j++) {
                assertEquals(expected[i][j], array[i][j]);
            }
        }

        int[] expected_Score = {94 ,155 ,60 ,0, 0}; // Score ko compare krne ke liay.

        for (int i = 0; i< scores.length ; i++) {
            assertEquals (expected_Score[i],scores[i]);
        }

    }
}
