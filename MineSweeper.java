// NIKOLETA TOUROUNOGLOU AM:5106
public class MineSweeper{
    private MineField minefield;
    private Player player1, player2;
    private int minesFound, minesLeft;

    public MineSweeper(int size, int mines, String name1, String name2){
        minefield = new MineField(size,mines);
        player1 = new Player(name1);
        player2 = new Player(name2);
    } 

    public int getMinesFound(){
        return minesFound;
    }
    
    public int getMinesLeft(){
        return minesLeft;
    }

    public String getName1(){
        return this.player1.getName();
    }

    public String getName2(){
        return this.player2.getName();

    }

    public void play(){
        minefield.print();
        minesLeft = minefield.getMines();

        while(minesLeft!=0){
            player1.play(minefield);
            minefield.print();
            if(minefield.getCell(player1.getRow(),player1.getColumn()).containsMine()){
                minesFound++;
                minesLeft--;
            }
            this.scorekeeper();
            player2.play(minefield);
            minefield.print();
            if(minefield.getCell(player2.getRow(),player2.getColumn()).containsMine()){
                minesFound++;
                minesLeft--;
            }
            this.scorekeeper();

        }
        System.out.println("Game Over...");
        if(player1.getScore() > player2.getScore()){
            System.out.println(player1.getName() + " has won MineSweeper!");
        }else if(player2.getScore() > player1.getScore()){
            System.out.println(player2.getName() + " has won MineSweeper!");
        }else{
            System.out.println("It's a tie!");
        }

    }

    public void scorekeeper(){
        System.out.println(this.getMinesFound() + " mines found " + this.getMinesLeft() + " mines left");
        System.out.println("Player " + this.getName1() + ": " + this.player1.getScore() + " mines found");
        System.out.println("Player " + this.getName2() + ": " + this.player2.getScore() + " mines found");
    }

    public static void main(String[] args){
        MineSweeper minesweeper = new MineSweeper(4,6,"Netronio","Nicoleta");
        minesweeper.play();
    }

}
