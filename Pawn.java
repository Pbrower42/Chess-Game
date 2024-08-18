import java.util.ArrayList;

public class Pawn extends Piece {
	
	private String name;
	
	private int rank;
	
	private int value = 10;
	
	
	public Pawn(String pTeam, String pPosition, int n) {
		super(pTeam, pPosition);
		name = pTeam + " Pawn " + n;
		rank = 2;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int r) {
		rank = r;
	}
	
	public void addRank(int r) {
		rank = rank + r;
	}
	
	public int getValue() {
		return value;
	}
	
	//A method that returns all possible positions a given white pawn can travel
	public ArrayList [] getWPositions(Pawn thePawn, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces){
		ArrayList [] positions = new ArrayList[3];
		int rowIdx = 0;
		int columnIdx = 0;
		for(int i = 0; i < theBoard.getBoard().length; ++i) {
			for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
				if(thePawn.getPosition().equals(theBoard.getBoard()[i][j])) {
					rowIdx = i;
					columnIdx = j;
				}
			}
		}
		ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
		ArrayList <String> cPositions = new ArrayList(); //Represents capture positions
		rPositions.add(theBoard.getBoard()[rowIdx+1][columnIdx]); 
		ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
		boolean rankBy1 = true;
		boolean rankBy2 = true;
		
		//Check if any white pieces are in front of the the current pawn
		for(int i = 0; i < wPieces.size();++i) {
			if(wPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx+1][columnIdx]) == true) {
				rPositions.remove(0);
				rankBy1 = false;
				break;
			}
		}
		//Check if any black pieces are in front of current pawn
		if(rPositions.isEmpty() == false) {
			for(int i = 0; i < bPieces.size();++i) {
				if(bPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx+1][columnIdx]) == true) {
					rPositions.remove(0);
					rankBy1 = false;
					break;
				}
			}
		}
		//If the pawn is in the start position, allow it to move two additional spaces
		if(thePawn.getRank() == 2 && rankBy1 == true) {
			rPositions.add(theBoard.getBoard()[rowIdx+2][columnIdx]);
		}
		else {
			rankBy2 = false;
		}
		
		//Check to see if other white pieces are two spaces ahead of the pawn
		if(thePawn.getRank() == 2 && rankBy1 == true) {
		for(int i = 0; i < wPieces.size();++i) {
			if(wPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx+2][columnIdx]) == true) {
				if(rPositions.size() == 1) {
					rPositions.remove(0);
					rankBy2 = false;
				}
				else if (rPositions.size() == 2) {
					rPositions.remove(1);
					rankBy2 = false;
				}
				
			}
		}
		}
		//Check if any black pieces are two spaces in front of current pawn
		if(thePawn.getRank() == 2) {
		for(int i = 0; i < bPieces.size();++i) {
			if(bPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx+2][columnIdx]) == true) {
				if(rPositions.size() == 1) {
					rPositions.remove(0);
					rankBy2 = false;;
				}
				else if (rPositions.size() == 2) {
					rPositions.remove(1);
					rankBy2 = false;
				}
				
			}
		}
		
		}
		
		//Make note of the pawns capture positions. Since they capture diagonally, move up a row and go either to the left or right column
		if(columnIdx != 7) {
			cPositions.add(theBoard.getBoard()[rowIdx+1][columnIdx+1]);
		}
		if(columnIdx != 0) {
			cPositions.add(theBoard.getBoard()[rowIdx+1][columnIdx-1]);
		}
		
		//Check if there are any black pieces in the pawn's capture positions
		int count = 0;
		for(int i = 0; i < bPieces.size(); ++i) {
			if(cPositions.size() == 1) {
				if(bPieces.get(i).getPosition().equals(cPositions.get(0)) == true) {
					cPieces.add(bPieces.get(i));
				}
			}
			else if(cPositions.size() == 2) {
				if(bPieces.get(i).getPosition().equals(cPositions.get(0)) == true || bPieces.get(i).getPosition().equals(cPositions.get(1)) == true) {
					cPieces.add(bPieces.get(i));
				}
			}
			
		}
		positions[0] = rPositions;
		positions[1] = cPieces;
		ArrayList <Boolean> ranks = new ArrayList <Boolean>();
		ranks.add(rankBy1);
		ranks.add(rankBy2);
		positions[2] = ranks;
		return positions;
	}
	
	//A method that returns all possible positions a given black pawn can travel
		public ArrayList [] getBPositions(Pawn thePawn, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces){
			ArrayList [] positions = new ArrayList[3];
			int rowIdx = 0;
			int columnIdx = 0;
			for(int i = 0; i < theBoard.getBoard().length; ++i) {
				for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
					if(thePawn.getPosition().equals(theBoard.getBoard()[i][j])) {
						rowIdx = i;
						columnIdx = j;

					}
				}
			}
			ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
			ArrayList <String> cPositions = new ArrayList(); //Represents capture positions
			rPositions.add(theBoard.getBoard()[rowIdx-1][columnIdx]); 
			ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
			boolean rankBy1 = true;
			boolean rankBy2 = true;
			
			//Check if any black pieces are in front of the the current pawn
			for(int i = 0; i < bPieces.size();++i) {
				if(bPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx-1][columnIdx]) == true) {
					rPositions.remove(0);
					rankBy1 = false;
					break;
				}
			}
			//Check if any white pieces are in front of current pawn
			if(rPositions.isEmpty() == false) {
				for(int i = 0; i < wPieces.size();++i) {
					if(wPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx-1][columnIdx]) == true) {
						rPositions.remove(0);
						rankBy1 = false;
						break;
					}
				}
			}
			//If the pawn is in the start position, allow it to move two additional spaces
			if(thePawn.getRank() == 2) {
				rPositions.add(theBoard.getBoard()[rowIdx-2][columnIdx]);
			}
			else {
				rankBy2 = false;
			}
			//Check to see if other black pieces are two spaces ahead of the pawn
			if(thePawn.getRank() == 2 && rankBy1 == true) {
			for(int i = 0; i < bPieces.size();++i) {
				if(bPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx-2][columnIdx]) == true) {
					if(rankBy1 == false) {
						rPositions.remove(0);
						rankBy2 = false;
						break;
					}
					else {
						rPositions.remove(1);
						rankBy2 = false;
						break;
					}
					
				}
			}
			}
			//Check if any white pieces are two spaces in front of current pawn
			if(thePawn.getRank() == 2 && rankBy1 == true) {
			for(int i = 0; i < wPieces.size();++i) {
				if(wPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx-2][columnIdx]) == true) {
					if(rPositions.size() == 1) {
						rPositions.remove(0);
						rankBy2 = false;;
					}
					else if (rPositions.size() == 2) {
						rPositions.remove(1);
						rankBy2 = false;
					}
					
				}
			}
			
			}
			
			//Make note of the pawns capture positions. Since they capture diagonally, move up a row and go either to the left or right column
			if(columnIdx != 7) {
				cPositions.add(theBoard.getBoard()[rowIdx-1][columnIdx+1]);
			}
			if(columnIdx != 0) {
				cPositions.add(theBoard.getBoard()[rowIdx-1][columnIdx-1]);
			}
			
			//Check if there are any white pieces in the pawn's capture positions
			int count = 0;
			for(int i = 0; i < wPieces.size(); ++i) {
				if(cPositions.size() == 1) {
					if(wPieces.get(i).getPosition().equals(cPositions.get(0)) == true) {
						cPieces.add(wPieces.get(i));
					}
				}
				else if(cPositions.size() == 2) {
					if(wPieces.get(i).getPosition().equals(cPositions.get(0)) == true || wPieces.get(i).getPosition().equals(cPositions.get(1)) == true) {
						cPieces.add(wPieces.get(i));
					}
				}
				
			}
			positions[0] = rPositions;
			positions[1] = cPieces;
			ArrayList <Boolean> ranks = new ArrayList <Boolean>();
			ranks.add(rankBy1);
			ranks.add(rankBy2);
			positions[2] = ranks;
			return positions;
		}
	
}
