// NIKOLETA TOUROUNOGLOU AM:5106
import java.util.Scanner;
public class Game{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Give the board size: ");
        int size = input.nextInt();
        
        System.out.println("Give the number of mines: ");
        int mines = input.nextInt();
        
        System.out.println("Give the names of the players: ");
        String name1 = input.next();
        String name2 = input.next();
        
        
        MineSweeper minesweeper = new MineSweeper(size, mines, name1, name2);
        minesweeper.play();

    }
}