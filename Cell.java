// NIKOLETA TOUROUNOGLOU AM:5106
import java.util.ArrayList;

public class Cell {
	private int row;
	private int column;
	private boolean hasMine;
	private boolean isOpen;
	private int cellCounter;
	ArrayList<Cell> neighbours = new ArrayList<Cell>();


	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
		this.hasMine = false;
		this.isOpen = false;	
	}
	
	public int getCellCounter() {
		return this.cellCounter;
	}

	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
		
	public void addNeighbour(Cell other) {
		if(!neighbours.contains(other)){
			this.neighbours.add(other);
			other.neighbours.add(this);
		}
	}
	
	public void addMine() {
		hasMine = true;
		for(Cell element: neighbours) {
			if(!element.hasMine) {
				element.cellCounter++;
			}
		}
	}
	
	public void open() {
		this.isOpen = true;
	}
	
	public boolean isOpen() {
		return isOpen; 
	}
	
	public boolean containsMine() {
		return hasMine;
	}
	
	public String toString() {
		if(this.isOpen == false) {
			return "-";
		} else if (this.isOpen && this.hasMine) {
			return "*";
		}else {
			return "" + this.getCellCounter() ;
		}
	}

	public static void main(String[] args) {
		Cell cellino = new Cell(1,1);
		Cell cell = new Cell(0,0);

		cellino.addNeighbour(cell);
		
		System.out.println(cellino);
		cellino.addMine();
		System.out.println(cellino);
		cellino.open();
		System.out.println(cellino);
		cell.open();
		System.out.println(cell);


	}
	
	
	
	
	

}