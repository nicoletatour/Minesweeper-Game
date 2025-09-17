// NIKOLETA TOUROUNOGLOU AM:5106
import java.util.Random;

public class MineField {
	private int size;
	private int mines;
	private Cell[][] cellinos;
	private Random random = new Random();

	public MineField(int size, int mines) {
        this.size = size;
        this.mines = mines;
        this.cellinos = new Cell[size][size];
		this.initializeCells();
		this.initializeMines();
	}

	public int getSize(){
		return size;
	}

	public int getMines(){
		return mines;
	}

	public Cell getCell(int i, int j) {
        return cellinos[i][j];
    }

	public void initializeCells() {

		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				Cell cellino = new Cell(row, column);
				cellinos[row][column] = cellino;
			}
		}

		for (int i = 0; i < size;i++) {
			for (int j= 0; j< size; j++) {
				//prwta tis gwnies pou exoun 3 geitones
				if(i== 0 && j == 0){
					cellinos[i][j].addNeighbour(cellinos[i][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j]);				
				}else if(i == 0 && j == size-1){
					cellinos[i][j].addNeighbour(cellinos[i][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j]);
				}else if(i == size-1 && j == size-1){
					cellinos[i][j].addNeighbour(cellinos[i-1][j]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i][j-1]);
				}else if(i == size-1 && j == 0){
					cellinos[i][j].addNeighbour(cellinos[i][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j+1]);

				//meta ta kelia pou einai panw stis akres kai exoun 5 geitones
				}else if(i == 0 && j>=1 && j<=size-2){
					cellinos[i][j].addNeighbour(cellinos[i][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i][j+1]);
				}else if(i == size-1 && j>=1 && j<=size-2){
					cellinos[i][j].addNeighbour(cellinos[i][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i][j+1]);
				}else if(i>=1 && i<=size-2 && j==0){
					cellinos[i][j].addNeighbour(cellinos[i-1][j]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j]);
				}else if(i>=1 && i<=size-2 && j==size-1){
					cellinos[i][j].addNeighbour(cellinos[i-1][j]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j]);
				//kai telos ta upoloipa pou exoun 8 geitones
				}else{
					cellinos[i][j].addNeighbour(cellinos[i+1][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j]);
					cellinos[i][j].addNeighbour(cellinos[i+1][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j]);
					cellinos[i][j].addNeighbour(cellinos[i-1][j+1]);
					cellinos[i][j].addNeighbour(cellinos[i][j-1]);
					cellinos[i][j].addNeighbour(cellinos[i][j+1]);

				}

			}
		}

		
	}

	private void initializeMines() {
        int counter = 0;
        while (counter < mines) {
            int i = random.nextInt(size);
            int j = random.nextInt(size);
            if (!cellinos[i][j].containsMine()) {
                cellinos[i][j].addMine();
				// cells[i][j].open();
                counter++;
            }

        }
    }

    public void print() {
        System.out.print("\t");
        for (int j = 0; j < size; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < size; j++) {
                System.out.print(cellinos[i][j].toString() + "\t");
            }
            System.out.println();
        }
    }

	public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(2023);
        MineField mineField = new MineField(8, 24);

        mineField.print();
		for (int row = 0; row < mineField.getSize(); row++) {
			for (int column = 0; column < mineField.getSize(); column++) {
				mineField.cellinos[row][column].open();

			}
		}
		mineField.print();
		
    }

}
