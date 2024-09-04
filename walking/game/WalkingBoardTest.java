package walking.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import walking.game.util.Direction;



public class WalkingBoardTest {
    
    @ParameterizedTest
    @CsvSource({
        "0,0,3", "0,1,3", "0,2,3", "1,0,3", "1,1,3", "1,2,3", "2,0,3","2,1,3","2,2,3"
    })
    public void testSimpleInit(int x, int y ,int expected) {


        //Check using First Constructor using Get-Tile Function;
        WalkingBoard wb = new WalkingBoard(3);
        assertEquals(expected, wb.getTile(x, y));


        //Mannual Check-up Using Get-Tiles Function;
        int[][] expect = {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};
        int[][] actual = wb.getTiles();        
        assertArrayEquals(expect, actual);

       
    }

    @ParameterizedTest
    @CsvSource({
        "0,0,3", "0,1,3", "0,2,4", "1,0,3", "1,1,3", "1,2,5", "2,0,4", "2,1,3"
    })
    public void testCustomInit(int x, int y, int expected) {

        //Checking Second Constructor by giving him Custom 2d Array;
        int[][] array2d = {{1, 2, 4}, {3, 2, 5}, {4, 2}};
        WalkingBoard wb = new WalkingBoard(array2d);
        assertEquals(expected, wb.getTile(x, y));


        //Now Changing value of 2darray and it will not effect the board like on 0,0 still we have 3 instead of 5 now;
        array2d[0][0] = 5;
        assertEquals(3, wb.getTile(0, 0));

        //Now making 2darray by using board and giving this 2darray the value of board by using Get-Tiles function;
        int[][] wbTiles = wb.getTiles();
        //Now Changing value of 2darray and again checking that it will not give any harm to our board;
        wbTiles[0][0] = 4;
        assertEquals(3, wb.getTile(0,0));
    }    


    @Test
    public void testMoves() {

        //Making board by our first constructor;
        WalkingBoard wb = new WalkingBoard (5);

        //Now moving player outside of board, boundaries and our function which is of Walking Board, should return 0 and score on our tile should be 3;
        assertEquals(0 , wb.moveAndSet(Direction.UP, 5));
        //Checking first most position;
        assertArrayEquals(new int[] {0,0}, wb.getPosition());
        //Checking that after moving the player outside boundaries its value should not change;
        assertEquals(3, wb.getTile(0,0));

        //Moving the player right, and checking that first it will 3 value and then set 5 instead of 3 but should return 3;
        assertEquals(3 , wb.moveAndSet(Direction.RIGHT, 5));
        //Checking that isthe position of player changed;
        assertArrayEquals(new int[] {0,1}, wb.getPosition());
        //Checking after moving is the score of tile changed;
        assertEquals(5, wb.getTile(0,1));

        //Playing Second Move
        assertEquals(3 , wb.moveAndSet(Direction.DOWN, 4));
        //Again checking is the player moved
        assertArrayEquals(new int[] {1,1}, wb.getPosition());
        //Again Checking is the score of player changed or not?
        assertEquals(4, wb.getTile(1,1));

        //Now Applying Multiple Steps and checking

        assertEquals(3 , wb.moveAndSet(Direction.LEFT, 2));        
        assertArrayEquals(new int[] {1,0}, wb.getPosition());
        assertEquals(2, wb.getTile(1,0));


        assertEquals(3 , wb.moveAndSet(Direction.UP, 6));        
        assertArrayEquals(new int[] {0,0}, wb.getPosition());
        assertEquals(6, wb.getTile(0,0));       
         
    }
}
