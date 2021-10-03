public class Player {
    private boolean firstMove;
    private int wins = 0;
    boolean isMove;

    //Empty constructor for the player object
    public Player(){
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
        if(firstMove){
            this.isMove = true;
        }
        else {
            this.isMove = false;
        }
    }

    //Get/setter methods
    public void increaseWins(){
        this.wins++;
    }

    public int getWins(){
        return this.wins;
    }
}
