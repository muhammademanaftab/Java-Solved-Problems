package walking.game;
import walking.game.util.Direction;
import java.util.Arrays;

public class WalkingBoard{
    //yeh sab bhi fields han nicahy wali
    private int[][] tiles;
    private int x;
    private int y;
    public static final int BASE_TILE_SCORE = 3;


    //tiles ka constructior jo deep copy bnata ha
    public int[][] getTiles(){

       int[][] newArr = new int[tiles.length][];
        for (int i = 0; i < tiles.length; i++) 
        {
            newArr[i] = Arrays.copyOf(tiles[i], tiles[i].length);
        }
        return newArr;
    }

    //Pehla constructor jo fix size kee array bnata ha
    public WalkingBoard(int size) {
    this.tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.tiles[i][j] = BASE_TILE_SCORE;
            }
        }
    }


    //Dusra constructor jo custom array size ka board bnata ha.
    public WalkingBoard(int[][] tiles) 
    {
        this.tiles = new int[tiles.length][];
        for (int i = 0; i < tiles.length; i++) {
            this.tiles[i] = new int[tiles[i].length];
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] > BASE_TILE_SCORE) 
                {
                    this.tiles[i][j] = tiles[i][j];
                } 
                else 
                {
                    this.tiles[i][j] = BASE_TILE_SCORE;
                }
            }
        }
    }

    //Method jo makhsus postion return krta ha
    public int[] getPosition()
    {
        int[] p = {this.x, this.y};
        return p;
    }

    //Function jo valid position ka btata ha
    public boolean isValidPosition (int x, int y) 
    {
        boolean isValid = false;
        if (x>=0 && y >=0 && x < this.tiles.length && y < this.tiles[x].length) //Check krna ke x or y within board hon
        {
            isValid = true;
        } 
        return isValid;
    }

    public int getTile (int x, int y) 
    {
        if (isValidPosition(x,y)){
            return tiles[x][y];
        }
        throw new IllegalArgumentException(); // Agar position valid nai to exception throw krni ha
    }

    public static int getXStep(Direction direction) 
    { // X pr hum column chal rhay han
        if (direction == Direction.UP || direction == Direction.DOWN) {
            return (direction == Direction.UP) ? -1 : 1;
        } 
        else {
            return 0;
        } 
    }
    

    public static int getYStep(Direction direction) 
    {
        if (direction == Direction.RIGHT || direction == Direction.LEFT) { // Y pr hum row chal rhay han

            return (direction == Direction.LEFT) ? -1 : 1;
        } 
        else {
            return 0;
        }
    }

    public int moveAndSet(Direction TODOname, int value) 
    {
        int nextX = this.x + getXStep(TODOname);
        int nextY = this.y + getYStep(TODOname);

        if (isValidPosition(nextX, nextY)) //yeh dekha ke valid psotion ha ke nai nextX or nextY pr
        {
            int oldValue = getTile(nextX, nextY);
            this.tiles[nextX][nextY] = value;
            this.x = nextX; 
            this.y = nextY; 
            return oldValue;
        }
        else // Agar nai to 0 return krdaih
        {
            return 0;
        }


        
    }
}

