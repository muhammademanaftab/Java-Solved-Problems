package walking.game.player;
import walking.game.player.Player;

public class MadlyRotatingBuccaneer extends Player {
    private int turnCount;

    public MadlyRotatingBuccaneer () {
        //Parent constructor ko bulanay ke liay
        super();
        //Turn count ko barhanay ke liay.
        turnCount=0;

    }

    public void turn() {
    //Loop ko sirf makhsus ilakoh pr chalan ha, 0 pr miss krna ha bakioh pr 1 dafa lakin 2 pr 2 dafa chalana ha.
        for (int i = 1; i <= turnCount; i++) {
            super.turn();
        }

        //turncount ko increase krne ke liay increment.
        turnCount++;
    }
    
}