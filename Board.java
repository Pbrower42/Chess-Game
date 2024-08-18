
public class Board {
	
	private String [][] board = new String [8][8];
	
	public Board() {
		int rowCount = 0;
		for(int row = 0; row < board.length; ++row) {
			++rowCount;
			for(int column = 0; column < board[row].length; ++column) {
				if(column == 0) {
					board [row][column] = rowCount + "A";
				}
				else if(column == 1) {
					board [row][column] = rowCount + "B";
				}
				else if(column == 2) {
					board [row][column] = rowCount + "C";
				}
				else if(column == 3) {
					board [row][column] = rowCount + "D";
				}
				else if(column == 4) {
					board [row][column] = rowCount + "E";
				}
				else if(column == 5) {
					board [row][column] = rowCount + "F";
				}
				else if(column == 6) {
					board [row][column] = rowCount + "G";
				}
				else if(column == 7) {
					board [row][column] = rowCount + "H";
				}
			}
		}
	
	}
	
	public String[][] getBoard(){
		return board;
	}
}
