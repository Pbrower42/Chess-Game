import java.util.ArrayList;

public class Knight extends Piece{
	
	private String name;
	
	private int value = 25;
	
	public Knight(String pTeam, String pPosition, int n) {
		super(pTeam, pPosition);
		name = pTeam + " Knight " + n;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	//A method that returns all possible positions a given white Knight can travel
	public ArrayList [] getWPositions(Knight theKnight, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces) {
		ArrayList [] positions = new ArrayList[2];
		int rowIdx = 0;
		int columnIdx = 0;
		for(int i = 0; i < theBoard.getBoard().length; ++i) {
			for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
				if(theKnight.getPosition().equals(theBoard.getBoard()[i][j])) {
					rowIdx = i;
					columnIdx = j;
				}
			}
		}
		ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
		boolean validPosition = false; //To be used to get proper input for a user's choice in position
		ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
		
		//Add possible positions a knight can travel. Keep base cases in mind (Ex: can't travel right if at rightmost column
		if(rowIdx != 7 && (columnIdx != 6 && columnIdx != 7)) {
			rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx + 2]);
		}
		if((rowIdx != 6 && rowIdx != 7) && columnIdx != 7) {
			rPositions.add(theBoard.getBoard()[rowIdx + 2][columnIdx + 1]);
		}
		if(rowIdx != 7 && (columnIdx != 1 && columnIdx != 0)) {
			rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx - 2]);
		}
		if((rowIdx != 6 && rowIdx != 7) && columnIdx != 0) {
			rPositions.add(theBoard.getBoard()[rowIdx + 2][columnIdx - 1]);
		}
		if(rowIdx != 0 && (columnIdx != 6 && columnIdx != 7)) {
			rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx + 2]);
		}
		if((rowIdx != 1 && rowIdx != 0) && columnIdx != 7) {
			rPositions.add(theBoard.getBoard()[rowIdx - 2][columnIdx + 1]);
		}
		if(rowIdx != 0 && (columnIdx != 1 && columnIdx != 0)) {
			rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx - 2]);
		}
		if((rowIdx != 1 && rowIdx != 0) && columnIdx != 0) {
			rPositions.add(theBoard.getBoard()[rowIdx - 2][columnIdx - 1]);
		}
		
		//Check that there are no white pieces in the knight's possible positions
		for(int i = 0; i < wPieces.size(); ++i) {
			for(int j = 0; j < rPositions.size(); ++j) {
				if(rPositions.get(j).equals(wPieces.get(i).getPosition())) {
					rPositions.remove(j);
				}
			}
		}
		
		//Check for possible black pieces that can be captured
		for(int i = 0; i < bPieces.size(); ++i) {
			for(int j = 0; j < rPositions.size(); ++j) {
				if(rPositions.get(j).equals(bPieces.get(i).getPosition())) {
					rPositions.remove(j);
					cPieces.add(bPieces.get(i));	
				}
			}
		}
		positions[0] = rPositions;
		positions[1] = cPieces;
		return positions;
	}
	//A method that returns all possible positions a given black Knight can travel
		public ArrayList [] getBPositions(Knight theKnight, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces) {
			ArrayList [] positions = new ArrayList[2];
			int rowIdx = 0;
			int columnIdx = 0;
			for(int i = 0; i < theBoard.getBoard().length; ++i) {
				for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
					if(theKnight.getPosition().equals(theBoard.getBoard()[i][j])) {
						rowIdx = i;
						columnIdx = j;
					}
				}
			}
			ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
			boolean validPosition = false; //To be used to get proper input for a user's choice in position
			ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
			
			//Add possible positions a knight can travel. Keep base cases in mind (Ex: can't travel right if at rightmost column
			if(rowIdx != 7 && (columnIdx != 6 && columnIdx != 7)) {
				rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx + 2]);
			}
			if((rowIdx != 6 && rowIdx != 7) && columnIdx != 7) {
				rPositions.add(theBoard.getBoard()[rowIdx + 2][columnIdx + 1]);
			}
			if(rowIdx != 7 && (columnIdx != 1 && columnIdx != 0)) {
				rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx - 2]);
			}
			if((rowIdx != 6 && rowIdx != 7) && columnIdx != 0) {
				rPositions.add(theBoard.getBoard()[rowIdx + 2][columnIdx - 1]);
			}
			if(rowIdx != 0 && (columnIdx != 6 && columnIdx != 7)) {
				rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx + 2]);
			}
			if((rowIdx != 1 && rowIdx != 0) && columnIdx != 7) {
				rPositions.add(theBoard.getBoard()[rowIdx - 2][columnIdx + 1]);
			}
			if(rowIdx != 0 && (columnIdx != 1 && columnIdx != 0)) {
				rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx - 2]);
			}
			if((rowIdx != 1 && rowIdx != 0) && columnIdx != 0) {
				rPositions.add(theBoard.getBoard()[rowIdx - 2][columnIdx - 1]);
			}
			
			//Check that there are no black pieces in the knight's possible positions
			for(int i = 0; i < bPieces.size(); ++i) {
				for(int j = 0; j < rPositions.size(); ++j) {
					if(rPositions.get(j).equals(bPieces.get(i).getPosition())) {
						rPositions.remove(j);
					}
				}
			}
			
			//Check for possible white pieces that can be captured
			for(int i = 0; i < wPieces.size(); ++i) {
				for(int j = 0; j < rPositions.size(); ++j) {
					if(rPositions.get(j).equals(wPieces.get(i).getPosition())) {
						rPositions.remove(j);
						cPieces.add(wPieces.get(i));	
					}
				}
			}
			positions[0] = rPositions;
			positions[1] = cPieces;
			return positions;
		}
	
}
