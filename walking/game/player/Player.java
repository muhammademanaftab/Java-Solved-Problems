package walking.game.player;
import walking.game.util.Direction;

public class Player{

    //Fields bnani sab
    private int score;
    protected Direction direction = Direction.UP;

    //Getter wagaiaara sab
    public int getScore(){
        return score;
    } 

    public Direction getDirection() {
        return direction;
    }

    public void Player() {
        this.score = 0;
    }
    //score ko add krne ke liay function
    public void addToScore(int score) {
        this.score = this.score + score;
    }

    //yeh turn function ha parent ka jo child main bhi sue hoga.
    public void turn() {
        if (direction == Direction.UP)
        {
            direction = Direction.RIGHT;
        }
        else if (direction == Direction.DOWN) 
        {
            direction = Direction.LEFT;
        }
        else if (direction == Direction.LEFT)
        {
            direction = Direction.UP;
        }
        else 
        {
            direction = Direction.DOWN;
        }
    }
}