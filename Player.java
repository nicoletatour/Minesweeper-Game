// NIKOLETA TOUROUNOGLOU AM:5106
import java.util.Scanner;
public class Player {
    private String name;
    private int score, row, column;

    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public void printStatus(){
        System.out.println("Name: " + this.getName());
        System.out.println("Score: " + this.getScore());
    }

    public boolean play(MineField minefield ){
        Scanner input = new Scanner(System.in);
        System.out.println("Hey Player " + this.getName() + ", give the coordinates for the cell you want to open:");
        row = input.nextInt();
        column = input.nextInt();

        while(minefield.getCell(row,column).isOpen()){
            System.out.println("Hey there again " + this.getName() + ", give the coordinates for the cell you want to open:");
            row = input.nextInt();
            column = input.nextInt();
        }

        minefield.getCell(row, column).open();

        if(minefield.getCell(row, column).containsMine()){
            System.out.println("Mine found!");
            this.score++;
            return true;      
        }else{
            return false;
        }

    }

    public static void main(String[] args){
        Player nicoletonio = new Player("Nicoletonio like protonio, netronio ");
        MineField m = new MineField(4,6);
        nicoletonio.printStatus();
        nicoletonio.play(m);
        nicoletonio.printStatus();
        nicoletonio.play(m);
        nicoletonio.printStatus();
        nicoletonio.play(m);
        nicoletonio.printStatus();
        
    }
}