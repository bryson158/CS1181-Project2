import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        gameGUI();
        //Creates rng
        Random rng = new Random();

        //Creates the player and computer objects and determines which of the two goes first
        Computer computer = new Computer(rng.nextBoolean());
        Player player = new Player();
        if(computer.getFirstMove()){
            player.setFirstMove(false);
        }
        else {
            player.setFirstMove(true);
        }

        //Booleans for the game loops one tracks if the user wishes to quit after a completed game or to keep going
        boolean quit = false;

        //If not winner or if the players tied this will be changed to true and the user will be asked if they want to start a new game
        boolean winner = false;

        //Creates a virtual grid to keep track of the players moved where
        char[][] grid = new char[2][2];
        for(int i = 0; i < 2; i++){
            for(int p = 0; p < 2; p++){
                grid[i][p] = 'e';
            }
        }


        while (!quit){
            while (!winner){
                //If it is the computers move
                if(computer.isMove()){
                    computer.move(grid, rng);
                }
                else {

                }
            }
        }

    }

    private static void gameGUI(){
        //Creates the frame and panel for the game
        JFrame gameFrame = new JFrame("Tic-Tac-Toe");
        JPanel gamePanel = new JPanel();

        Random rng = new Random();


        //Creates the player and computer objects and determines which of the two goes first
        Computer computer = new Computer(rng.nextBoolean());
        Player player = new Player();

        //Will close and exit the program if the x on the window is pressed
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Button buttons[][] = new Button[3][3];

        //Creates a virtual grid to keep track of the players moved where and adds all the buttons to the grid
        char[][] grid = new char[3][3];
        for(int i = 0; i <= 2; i++){
            for(int p = 0; p <= 2; p++){
                grid[i][p] = 'e';
                buttons[i][p] = new Button();
                gamePanel.add(buttons[i][p]);
                buttons[i][p].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(computer.isMove){
                        }
                    }
                });
            }
        }

        gamePanel.setLayout(new GridLayout(3, 3));

        gameFrame.add(gamePanel);
        gameFrame.setSize(600,600);
        gameFrame.setVisible(true);

        if(computer.getFirstMove()){
            player.setFirstMove(false);
        }
        else {
            player.setFirstMove(true);
        }

        //Booleans for the game loops one tracks if the user wishes to quit after a completed game or to keep going
        boolean quit = false;

        //If not winner or if the players tied this will be changed to true and the user will be asked if they want to start a new game
        boolean winner = false;

        //Game loops
        while (!quit){
            while (!winner){
                boolean moveFinished = false;

                while (!moveFinished) {
                    if (computer.isMove()) {
                        int [] computerMove = computer.move(grid, rng);

                        //Makes sure the move is legal
                        if (legalMove(grid, computerMove)){
                            updateButtons(grid, buttons);
                            moveFinished = true;
                        }
                    }
                    //Its the humans player
                    else {

                    }
                }
            }
        }
    }

    //Method for determining if either player has won the game
    public boolean gameWon(){
        return false;
    }

    //Method that changes who goes first
    public static void changeGoFirst(Computer computer, Player player){
        if(computer.getFirstMove()){
            computer.setFirstMove(false);
            player.setFirstMove(computer.getFirstMove());
        }
    }

    //Checks that the move a user is trying to make is okay
    public static boolean legalMove(char[][] grid, int[] newMove){
        if (grid[newMove[0]][newMove[1]] == 'e') {
            return true;
        }
        else {
            return false;
        }
    }

    //Resets the board
    public void resetBoard(char[][] grid, int[] newMove){
        //TODO- finish this
    }

    public static void updateButtons(char[][] grid, Button buttons[][]){
        for(int i = 0; i<3; i++){
            for(int p = 0; p<3; p++){
                buttons[i][p].setImaIcon(grid);
            }
        }
    }
}