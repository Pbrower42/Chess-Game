import java.util.ArrayList;

public class King extends Piece{
	
	private String name;
	
	private int value = 500;
	
	public King(String pTeam, String pPosition) {
		super(pTeam, pPosition);
		name = pTeam + " King";
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	//A method that returns all possible positions a given white Queen can travel
			public ArrayList [] getWPositions(King theKing, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces) {
				ArrayList [] positions = new ArrayList[2];
				int rowIdx = 0;
				int columnIdx = 0;
				
				for(int i = 0; i < theBoard.getBoard().length; ++i) {
					for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
						if(theKing.getPosition().equals(theBoard.getBoard()[i][j])) {
							rowIdx = i;
							columnIdx = j;
						}
					}
				}
				ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
				boolean validPosition = false; //To be used to get proper input for a user's choice in position
				ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
				
				//Make note of all possible positions a king can make. Keep base cases in mind
				if(rowIdx != 7) {
					//Move up
					rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx]);
				}
				if(rowIdx != 0) {
					//Move down
					rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx]);
				}
				if(columnIdx != 7) {
					//Move right
					rPositions.add(theBoard.getBoard()[rowIdx][columnIdx + 1]);
				}
				
				if(columnIdx != 0) {
					//Move left
					rPositions.add(theBoard.getBoard()[rowIdx][columnIdx - 1]);
				}
				
				if(rowIdx != 7 && columnIdx != 7) {
					//Move right then up
					rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx + 1]);
				}
				
				if(rowIdx != 7 && columnIdx != 0) {
					//Move left then up
					rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx - 1]);
				}
				
				if(rowIdx != 0 && columnIdx != 7) {
					//Move right then down
					rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx + 1]);
				}
				
				if(rowIdx != 0 && columnIdx != 0) {
					//Move left then down
					rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx - 1]);
				}
				
				//Make sure no black or white pieces are in any of the possible positions
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
			
			//A method that returns all possible positions a given white Queen can travel
			public ArrayList [] getBPositions(King theKing, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces) {
				ArrayList [] positions = new ArrayList[2];
				int rowIdx = 0;
				int columnIdx = 0;
				
				for(int i = 0; i < theBoard.getBoard().length; ++i) {
					for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
						if(theKing.getPosition().equals(theBoard.getBoard()[i][j])) {
							rowIdx = i;
							columnIdx = j;
						}
					}
				}
				ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
				boolean validPosition = false; //To be used to get proper input for a user's choice in position
				ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
				
				//Make note of all possible positions a king can make. Keep base cases in mind
				if(rowIdx != 7) {
					//Move up
					rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx]);
				}
				if(rowIdx != 0) {
					//Move down
					rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx]);
				}
				if(columnIdx != 7) {
					//Move right
					rPositions.add(theBoard.getBoard()[rowIdx][columnIdx + 1]);
				}
				
				if(columnIdx != 0) {
					//Move left
					rPositions.add(theBoard.getBoard()[rowIdx][columnIdx - 1]);
				}
				
				if(rowIdx != 7 && columnIdx != 7) {
					//Move right then up
					rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx + 1]);
				}
				
				if(rowIdx != 7 && columnIdx != 0) {
					//Move left then up
					rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx - 1]);
				}
				
				if(rowIdx != 0 && columnIdx != 7) {
					//Move right then down
					rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx + 1]);
				}
				
				if(rowIdx != 0 && columnIdx != 0) {
					//Move left then down
					rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx - 1]);
				}
				
				//Make sure no black or white pieces are in any of the possible positions
				for(int i = 0; i < bPieces.size(); ++i) {
					for(int j = 0; j < rPositions.size(); ++j) {
						if(rPositions.get(j).equals(bPieces.get(i).getPosition())) {
							rPositions.remove(j);
						}
					}
				}
				
				//Check for possible black pieces that can be captured
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
