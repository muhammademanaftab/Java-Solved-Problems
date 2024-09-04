package walking.game;

public class main {

    public static void main(String[] args) {
         int[][] array2d = {{1, 2, 3, 4, 5},
                            {6, 7, 8, 9, 10, 11},
                            {12, 13},
                            {14, 15, 16, 17},
                            {18, 19, 20, 21, 22, 23, 24},
                            {25, 26, 27, 28}};  

        WalkingBoardWithPlayers wb = new WalkingBoardWithPlayers(array2d,5);
        int[] scores = wb.walk(5, 4, 3, 2, 4, 1, 6, 3,2,1);
        int[][] board = wb.getTiles();

         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0 ; i< scores.length; i++) {
            System.out.print (scores[i] + "  ");
        }
        
       
    }
}
