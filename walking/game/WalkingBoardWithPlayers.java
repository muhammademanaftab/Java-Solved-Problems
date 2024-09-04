package walking.game;
import walking.game.player.Player;
import walking.game.player.MadlyRotatingBuccaneer;

public class WalkingBoardWithPlayers extends WalkingBoard { // extend se parent class ko call krty hwauy matla ke oska extend kr rhay han

    private Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;

    public WalkingBoardWithPlayers(int[][] board, int playerCount) { // Constructor parent ka call kr rhy han baki khud initialize kr rhy han
        super(board);
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int size, int playerCount) {  // yahan bhi same constrcuctor parent ka
        super(size);
        initPlayers(playerCount);
    }

    private void initPlayers(int playerCount) { // Check kai ke player count 2 ha ya nai
        if (playerCount < 2) {
            throw new IllegalArgumentException();
        }
        players = new Player[playerCount];
        players[0] = new MadlyRotatingBuccaneer();
        for (int i = 1; i < playerCount; i++) {
            players[i] = new Player();
        }
    }

    public int[] walk(int... stepCounts) { 
        int[] playerScores = new int[players.length];   //Player kee length lee     
        for (int steps : stepCounts) // steps variable ne stepCounts pr chaala
        {
            for (int i=0;i<players.length; i++) 
            {
                Player currentParticipant = players[i];
                currentParticipant.turn();
                int score=0;

                for (int j = 0; j < steps; j++)
                {
                    score+=moveAndSet(currentParticipant.getDirection(), Math.min(SCORE_EACH_STEP, steps)); // naya score plus krty huway, adding new score
                    
                }
                currentParticipant.addToScore(score);    // adding score in player            
                playerScores[i] += score; // giving value to ith position in array.
            }
        }
        return playerScores;
    }

}
