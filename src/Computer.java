import java.util.Random;

public class Computer {
    private boolean firstMove;
    private int wins = 0;
    boolean isMove;

    //Constructor for the computer object
    public Computer(boolean first){
        firstMove = first;
        if(first){
            this.isMove = true;
        }
        else {
            this.isMove = false;
        }
    }

    //Method for determining the move for the computer
    public int[][] move(char[][] grid, Random rng){
        return new int[rng.nextInt(3)][rng.nextInt(3)];
    }


    //Get/setter methods
    public boolean getFirstMove(){
        return firstMove;
    }

    public void increaseWins(){
        this.wins++;
    }

    public int getWins(){
        return this.wins;
    }

    public boolean isMove(){
        return this.isMove;
    }

    public void setFirstMove(Boolean firstMove){
        this.firstMove = firstMove;
    }
}
