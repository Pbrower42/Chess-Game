import java.util.ArrayList;

public class Rook extends Piece{
	
	private String name;
	
	private int value = 100;
	
	public Rook(String pTeam, String pPosition, int n) {
		super(pTeam, pPosition);
		name = pTeam + " Rook " + n;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	//A method that returns all possible positions a given white Rook can travel
	public ArrayList [] getWPositions(Rook theRook, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces) {
		ArrayList [] positions = new ArrayList[2];
		int rowIdx = 0;
		int columnIdx = 0;
		for(int i = 0; i < theBoard.getBoard().length; ++i) {
			for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
				if(theRook.getPosition().equals(theBoard.getBoard()[i][j])) {
					rowIdx = i;
					columnIdx = j;
				}
			}
		}
		ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
		boolean validPosition = false; //To be used to get proper input for a user's choice in position
		ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
		//Create booleans to represent directions
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		
		//Create counters for rows and columns to keep track of diagonal positions
		int rookRow = rowIdx;
		int rookColumn = columnIdx;
		
		while(up == false) {
			if(rookRow != 7) {
				++rookRow;
				String pos = theBoard.getBoard()[rookRow][rookColumn];
				rPositions.add(pos);
				for(int i = 0; i < rPositions.size() ; ++i) {
					for(int j = 0; j < wPieces.size(); ++j) {
						if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
							rPositions.remove(i);
							up = true;
							break;
						}
					}
				}
				for(int i = 0; i < rPositions.size(); ++i) {
					for(int j = 0; j < bPieces.size(); ++j) {
						if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
							cPieces.add(bPieces.get(j));
							rPositions.remove(i);
							up = true;
							break;
						}
					}
				}
			}
			else {
				up = true;
			}
		}
		
		//Reset row and column for new direction
		rookRow = rowIdx;
		rookColumn = columnIdx;
		while(down == false) {
			if(rookRow != 0) {
				--rookRow;
				String pos = theBoard.getBoard()[rookRow][rookColumn];
				rPositions.add(pos);
				for(int i = 0; i < rPositions.size() ; ++i) {
					for(int j = 0; j < wPieces.size(); ++j) {
						if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
							rPositions.remove(i);
							down = true;
							break;
						}
					}
				}
				for(int i = 0; i < rPositions.size(); ++i) {
					for(int j = 0; j < bPieces.size(); ++j) {
						if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
							cPieces.add(bPieces.get(j));
							rPositions.remove(i);
							down = true;
							break;
						}
					}
				}
			}
			else {
				down = true;
			}
		}
		
		rookRow = rowIdx;
		rookColumn = columnIdx;
		while(right == false) {
			if(rookColumn != 7) {
				++rookColumn;
				String pos = theBoard.getBoard()[rookRow][rookColumn];
				rPositions.add(pos);
				for(int i = 0; i < rPositions.size() ; ++i) {
					for(int j = 0; j < wPieces.size(); ++j) {
						if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
							rPositions.remove(i);
							right = true;
							break;
						}
					}
				}
				for(int i = 0; i < rPositions.size(); ++i) {
					for(int j = 0; j < bPieces.size(); ++j) {
						if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
							cPieces.add(bPieces.get(j));
							rPositions.remove(i);
							right = true;
							break;
						}
					}
				}
			}
			else {
				right = true;
			}
		}
		
		rookRow = rowIdx;
		rookColumn = columnIdx;
		while(left == false) {
			if(rookColumn != 0) {
				--rookColumn;
				String pos = theBoard.getBoard()[rookRow][rookColumn];
				rPositions.add(pos);
				for(int i = 0; i < rPositions.size() ; ++i) {
					for(int j = 0; j < wPieces.size(); ++j) {
						if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
							rPositions.remove(i);
							left = true;
							break;
						}
					}
				}
				for(int i = 0; i < rPositions.size(); ++i) {
					for(int j = 0; j < bPieces.size(); ++j) {
						if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
							cPieces.add(bPieces.get(j));
							rPositions.remove(i);
							left = true;
							break;
						}
					}
				}
			}
			else {
				left = true;
			}
		}
		positions[0] = rPositions;
		positions[1] = cPieces;
		return positions;
	}
	//A method that returns all possible positions a given black Rook can travel
		public ArrayList [] getBPositions(Rook theRook, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces) {
			ArrayList [] positions = new ArrayList[2];
			int rowIdx = 0;
			int columnIdx = 0;
			for(int i = 0; i < theBoard.getBoard().length; ++i) {
				for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
					if(theRook.getPosition().equals(theBoard.getBoard()[i][j])) {
						rowIdx = i;
						columnIdx = j;
					}
				}
			}
			ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
			boolean validPosition = false; //To be used to get proper input for a user's choice in position
			ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
			//Create booleans to represent directions
			boolean up = false;
			boolean down = false;
			boolean left = false;
			boolean right = false;
			
			//Create counters for rows and columns to keep track of diagonal positions
			int rookRow = rowIdx;
			int rookColumn = columnIdx;
			
			while(up == false) {
				if(rookRow != 7) {
					++rookRow;
					String pos = theBoard.getBoard()[rookRow][rookColumn];
					rPositions.add(pos);
					for(int i = 0; i < rPositions.size() ; ++i) {
						for(int j = 0; j < bPieces.size(); ++j) {
							if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
								rPositions.remove(i);
								up = true;
								break;
							}
						}
					}
					for(int i = 0; i < rPositions.size(); ++i) {
						for(int j = 0; j < wPieces.size(); ++j) {
							if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
								cPieces.add(wPieces.get(j));
								rPositions.remove(i);
								up = true;
								break;
							}
						}
					}
				}
				else {
					up = true;
				}
			}
			
			//Reset row and column for new direction
			rookRow = rowIdx;
			rookColumn = columnIdx;
			while(down == false) {
				if(rookRow != 0) {
					--rookRow;
					String pos = theBoard.getBoard()[rookRow][rookColumn];
					rPositions.add(pos);
					for(int i = 0; i < rPositions.size() ; ++i) {
						for(int j = 0; j < bPieces.size(); ++j) {
							if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
								rPositions.remove(i);
								down = true;
								break;
							}
						}
					}
					for(int i = 0; i < rPositions.size(); ++i) {
						for(int j = 0; j < wPieces.size(); ++j) {
							if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
								cPieces.add(wPieces.get(j));
								rPositions.remove(i);
								down = true;
								break;
							}
						}
					}
				}
				else {
					down = true;
				}
			}
			
			rookRow = rowIdx;
			rookColumn = columnIdx;
			while(right == false) {
				if(rookColumn != 7) {
					++rookColumn;
					String pos = theBoard.getBoard()[rookRow][rookColumn];
					rPositions.add(pos);
					for(int i = 0; i < rPositions.size() ; ++i) {
						for(int j = 0; j < bPieces.size(); ++j) {
							if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
								rPositions.remove(i);
								right = true;
								break;
							}
						}
					}
					for(int i = 0; i < rPositions.size(); ++i) {
						for(int j = 0; j < wPieces.size(); ++j) {
							if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
								cPieces.add(wPieces.get(j));
								rPositions.remove(i);
								right = true;
								break;
							}
						}
					}
				}
				else {
					right = true;
				}
			}
			
			rookRow = rowIdx;
			rookColumn = columnIdx;
			while(left == false) {
				if(rookColumn != 0) {
					--rookColumn;
					String pos = theBoard.getBoard()[rookRow][rookColumn];
					rPositions.add(pos);
					for(int i = 0; i < rPositions.size() ; ++i) {
						for(int j = 0; j < bPieces.size(); ++j) {
							if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
								rPositions.remove(i);
								left = true;
								break;
							}
						}
					}
					for(int i = 0; i < rPositions.size(); ++i) {
						for(int j = 0; j < wPieces.size(); ++j) {
							if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
								cPieces.add(wPieces.get(j));
								rPositions.remove(i);
								left = true;
								break;
							}
						}
					}
				}
				else {
					left = true;
				}
			}
			positions[0] = rPositions;
			positions[1] = cPieces;
			return positions;
		}
}
