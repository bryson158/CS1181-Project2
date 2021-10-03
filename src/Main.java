import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
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

        //Will close and exit the program if the x on the window is pressed
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Creates the labels for the 0's sets all of the labels to not visible
        JButton button1 = new JButton();
        for(int i = 0; i <= 5; i++){

        }

        //Creates a virtual grid to keep track of the players moved where
        char[][] grid = new char[3][3];
        for(int i = 0; i <= 2; i++){
            for(int p = 0; p <= 2; p++){
                grid[i][p] = 'e';
            }
        }

        gamePanel.setLayout(new GridLayout(3, 3));

        gameFrame.add(gamePanel);
        gameFrame.setSize(600,600);
        gameFrame.setVisible(true);

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

        //Game loops
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
    public boolean legalMove(){
        return true;
    }

}
