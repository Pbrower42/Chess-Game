import java.util.ArrayList;

public class Bishop extends Piece{
	
	private String name;
	
	private int value = 50;
	
	public Bishop(String pTeam, String pPosition, int n) {
		super(pTeam, pPosition);
		name = pTeam + " Bishop " + n;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	//A method that returns all possible positions a given black bishop can travel
	public ArrayList [] getBPositions(Bishop theBishop, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces){
		ArrayList [] positions = new ArrayList[2];
		int rowIdx = 0;
		int columnIdx = 0;
		for(int i = 0; i < theBoard.getBoard().length; ++i) {
			for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
				if(theBishop.getPosition().equals(theBoard.getBoard()[i][j])) {
					rowIdx = i;
					columnIdx = j;
				}
			}
		}
		ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
		ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
		//Create booleans to represent directions
		boolean rightUp = false;
		boolean leftUp = false;
		boolean rightDown = false;
		boolean leftDown = false;
		
		//Create counters for rows and columns to keep track of diagonal positions
		int bishopRow = rowIdx;
		int bishopColumn = columnIdx;
		
		while(rightUp == false) {
			if(bishopRow != 7 && bishopColumn != 7) {
				++bishopRow;
				++bishopColumn;
				String pos = theBoard.getBoard()[bishopRow][bishopColumn];
				rPositions.add(pos);
				for(int i = 0; i < rPositions.size() ; ++i) {
					for(int j = 0; j < bPieces.size(); ++j) {
						if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
							rPositions.remove(i);
							rightUp = true;
							break;
						}
					}
				}
				for(int i = 0; i < rPositions.size(); ++i) {
					for(int j = 0; j < wPieces.size(); ++j) {
						if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
							cPieces.add(wPieces.get(j));
							rPositions.remove(i);
							rightUp = true;
							break;
						}
					}
				}
			}
			else {
				rightUp = true;
			}
		}
		
		//Reset row and column for new diagonal direction
		bishopRow = rowIdx;
		bishopColumn = columnIdx;
		while(leftUp == false) {
			if(bishopRow != 7 && bishopColumn != 0) {
				++bishopRow;
				--bishopColumn;
				String pos = theBoard.getBoard()[bishopRow][bishopColumn];
				rPositions.add(pos);
				for(int i = 0; i < rPositions.size() ; ++i) {
					for(int j = 0; j < bPieces.size(); ++j) {
						if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
							rPositions.remove(i);
							leftUp = true;
							break;
						}
					}
				}
				for(int i = 0; i < rPositions.size(); ++i) {
					for(int j = 0; j < wPieces.size(); ++j) {
						if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
							cPieces.add(wPieces.get(j));
							rPositions.remove(i);
							leftUp = true;
							break;
						}
					}
				}
			}
			else {
				leftUp = true;
			}
		}
		
		bishopRow = rowIdx;
		bishopColumn = columnIdx;
		while(rightDown == false) {
			if(bishopRow != 0 && bishopColumn != 7) {
				--bishopRow;
				++bishopColumn;
				String pos = theBoard.getBoard()[bishopRow][bishopColumn];
				rPositions.add(pos);
				for(int i = 0; i < rPositions.size() ; ++i) {
					for(int j = 0; j < bPieces.size(); ++j) {
						if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
							rPositions.remove(i);
							rightDown = true;
							break;
						}
					}
				}
				for(int i = 0; i < rPositions.size(); ++i) {
					for(int j = 0; j < wPieces.size(); ++j) {
						if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
							cPieces.add(wPieces.get(j));
							rPositions.remove(i);
							rightDown = true;
							break;
						}
					}
				}
			}
			else {
				rightDown = true;
			}
		}
		
		bishopRow = rowIdx;
		bishopColumn = columnIdx;
		while(leftDown == false) {
			if(bishopRow != 0 && bishopColumn != 0) {
				--bishopRow;
				--bishopColumn;
				String pos = theBoard.getBoard()[bishopRow][bishopColumn];
				rPositions.add(pos);
				for(int i = 0; i < rPositions.size() ; ++i) {
					for(int j = 0; j < bPieces.size(); ++j) {
						if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
							rPositions.remove(i);
							leftDown = true;
							break;
						}
					}
				}
				for(int i = 0; i < rPositions.size(); ++i) {
					for(int j = 0; j < wPieces.size(); ++j) {
						if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
							cPieces.add(wPieces.get(j));
							rPositions.remove(i);
							leftDown = true;
							break;
						}
					}
				}
			}
			else {
				leftDown = true;
			}
		}
		positions[0] = rPositions;
		positions[1] = cPieces;
		return positions;
	}
	//A method that returns all possible positions a given white bishop can travel
		public ArrayList [] getWPositions(Bishop theBishop, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces){
			ArrayList [] positions = new ArrayList[2];
			int rowIdx = 0;
			int columnIdx = 0;
			for(int i = 0; i < theBoard.getBoard().length; ++i) {
				for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
					if(theBishop.getPosition().equals(theBoard.getBoard()[i][j])) {
						rowIdx = i;
						columnIdx = j;
					}
				}
			}
			ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
			ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
			//Create booleans to represent directions
			boolean rightUp = false;
			boolean leftUp = false;
			boolean rightDown = false;
			boolean leftDown = false;
			
			//Create counters for rows and columns to keep track of diagonal positions
			int bishopRow = rowIdx;
			int bishopColumn = columnIdx;
			
			while(rightUp == false) {
				if(bishopRow != 7 && bishopColumn != 7) {
					++bishopRow;
					++bishopColumn;
					String pos = theBoard.getBoard()[bishopRow][bishopColumn];
					rPositions.add(pos);
					for(int i = 0; i < rPositions.size() ; ++i) {
						for(int j = 0; j < wPieces.size(); ++j) {
							if(rPositions.get(i).equals(wPieces.get(j).getPosition()) == true) {
								rPositions.remove(i);
								rightUp = true;
								break;
							}
						}
					}
					for(int i = 0; i < rPositions.size(); ++i) {
						for(int j = 0; j < bPieces.size(); ++j) {
							if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
								cPieces.add(bPieces.get(j));
								rPositions.remove(i);
								rightUp = true;
								break;
							}
						}
					}
				}
				else {
					rightUp = true;
				}
			}
			
			//Reset row and column for new diagonal direction
			bishopRow = rowIdx;
			bishopColumn = columnIdx;
			while(leftUp == false) {
				if(bishopRow != 7 && bishopColumn != 0) {
					++bishopRow;
					--bishopColumn;
					String pos = theBoard.getBoard()[bishopRow][bishopColumn];
					rPositions.add(pos);
					for(int i = 0; i < rPositions.size() ; ++i) {
						for(int j = 0; j < wPieces.size(); ++j) {
							if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
								rPositions.remove(i);
								leftUp = true;
								break;
							}
						}
					}
					for(int i = 0; i < rPositions.size(); ++i) {
						for(int j = 0; j < bPieces.size(); ++j) {
							if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
								cPieces.add(bPieces.get(j));
								rPositions.remove(i);
								leftUp = true;
								break;
							}
						}
					}
				}
				else {
					leftUp = true;
				}
			}
			
			bishopRow = rowIdx;
			bishopColumn = columnIdx;
			while(rightDown == false) {
				if(bishopRow != 0 && bishopColumn != 7) {
					--bishopRow;
					++bishopColumn;
					String pos = theBoard.getBoard()[bishopRow][bishopColumn];
					rPositions.add(pos);
					for(int i = 0; i < rPositions.size() ; ++i) {
						for(int j = 0; j < wPieces.size(); ++j) {
							if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
								rPositions.remove(i);
								rightDown = true;
								break;
							}
						}
					}
					for(int i = 0; i < rPositions.size(); ++i) {
						for(int j = 0; j < bPieces.size(); ++j) {
							if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
								cPieces.add(bPieces.get(j));
								rPositions.remove(i);
								rightDown = true;
								break;
							}
						}
					}
				}
				else {
					rightDown = true;
				}
			}
			
			bishopRow = rowIdx;
			bishopColumn = columnIdx;
			while(leftDown == false) {
				if(bishopRow != 0 && bishopColumn != 0) {
					--bishopRow;
					--bishopColumn;
					String pos = theBoard.getBoard()[bishopRow][bishopColumn];
					rPositions.add(pos);
					for(int i = 0; i < rPositions.size() ; ++i) {
						for(int j = 0; j < wPieces.size(); ++j) {
							if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
								rPositions.remove(i);
								leftDown = true;
								break;
							}
						}
					}
					for(int i = 0; i < rPositions.size(); ++i) {
						for(int j = 0; j < bPieces.size(); ++j) {
							if(rPositions.get(i).equals(bPieces.get(j).getPosition())) {
								cPieces.add(bPieces.get(j));
								rPositions.remove(i);
								leftDown = true;
								break;
							}
						}
					}
				}
				else {
					leftDown = true;
				}
			}
			positions[0] = rPositions;
			positions[1] = cPieces;
			return positions;
		}

}
