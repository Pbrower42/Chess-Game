import java.util.ArrayList;

public class Queen extends Piece{
	
	private String name;
	
	private int value = 250;
	
	public Queen(String pTeam, String pPosition) {
		super(pTeam, pPosition);
		name = pTeam + " Queen";
	}
	
	public Queen(String pTeam, String pPosition, int n) {
		super(pTeam, pPosition);
		name = pTeam + " Queen " + n;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	//A method that returns all possible positions a given white Queen can travel
		public ArrayList [] getWPositions(Queen theQueen, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces) {
			ArrayList [] positions = new ArrayList[2];
			int rowIdx = 0;
			int columnIdx = 0;
			
			for(int i = 0; i < theBoard.getBoard().length; ++i) {
				for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
					if(theQueen.getPosition().equals(theBoard.getBoard()[i][j])) {
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
			
			boolean rightUp = false;
			boolean leftUp = false;
			boolean rightDown = false;
			boolean leftDown = false;
			
			//Create counters for rows and columns to keep track of diagonal positions
			int queenRow = rowIdx;
			int queenColumn = columnIdx;
			while(up == false) {
				if(queenRow != 7) {
					++queenRow;
					String pos = theBoard.getBoard()[queenRow][queenColumn];
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
			queenRow = rowIdx;
			queenColumn = columnIdx;
			while(down == false) {
				if(queenRow != 0) {
					--queenRow;
					String pos = theBoard.getBoard()[queenRow][queenColumn];
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
			
			queenRow = rowIdx;
			queenColumn = columnIdx;
			while(right == false) {
				if(queenColumn != 7) {
					++queenColumn;
					String pos = theBoard.getBoard()[queenRow][queenColumn];
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
			
			queenRow = rowIdx;
			queenColumn = columnIdx;
			while(left == false) {
				if(queenColumn != 0) {
					--queenColumn;
					String pos = theBoard.getBoard()[queenRow][queenColumn];
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
			
			queenRow = rowIdx;
			queenColumn = columnIdx;
			while(rightUp == false) {
				if(queenRow != 7 && queenColumn != 7 ) {
					++queenRow;
					++queenColumn;
					String pos = theBoard.getBoard()[queenRow][queenColumn];
					rPositions.add(pos);
					for(int i = 0; i < rPositions.size() ; ++i) {
						for(int j = 0; j < wPieces.size(); ++j) {
							if(rPositions.get(i).equals(wPieces.get(j).getPosition())) {
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
			queenRow = rowIdx;
			queenColumn = columnIdx;
			while(leftUp == false) {
				if(queenRow != 7 && queenColumn != 0) {
					++queenRow;
					--queenColumn;
					String pos = theBoard.getBoard()[queenRow][queenColumn];
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
			
			queenRow = rowIdx;
			queenColumn = columnIdx;
			while(rightDown == false) {
				if(queenRow != 0 && queenColumn != 7) {
					--queenRow;
					++queenColumn;
					String pos = theBoard.getBoard()[queenRow][queenColumn];
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
			
			queenRow = rowIdx;
			queenColumn = columnIdx;
			while(leftDown == false) {
				if(queenRow != 0 && queenColumn != 0) {
					--queenRow;
					--queenColumn;
					String pos = theBoard.getBoard()[queenRow][queenColumn];
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
		
		//A method that returns all possible positions a given black Queen can travel
				public ArrayList [] getBPositions(Queen theQueen, Board theBoard, ArrayList <Piece> wPieces, ArrayList <Piece> bPieces) {
					ArrayList [] positions = new ArrayList[2];
					int rowIdx = 0;
					int columnIdx = 0;
					
					for(int i = 0; i < theBoard.getBoard().length; ++i) {
						for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
							if(theQueen.getPosition().equals(theBoard.getBoard()[i][j])) {
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
					
					boolean rightUp = false;
					boolean leftUp = false;
					boolean rightDown = false;
					boolean leftDown = false;
					
					//Create counters for rows and columns to keep track of diagonal positions
					int queenRow = rowIdx;
					int queenColumn = columnIdx;
					
					while(up == false) {
						if(queenRow != 7) {
							++queenRow;
							String pos = theBoard.getBoard()[queenRow][queenColumn];
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
					queenRow = rowIdx;
					queenColumn = columnIdx;
					while(down == false) {
						if(queenRow != 0) {
							--queenRow;
							String pos = theBoard.getBoard()[queenRow][queenColumn];
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
					
					queenRow = rowIdx;
					queenColumn = columnIdx;
					while(right == false) {
						if(queenColumn != 7) {
							++queenColumn;
							String pos = theBoard.getBoard()[queenRow][queenColumn];
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
					
					queenRow = rowIdx;
					queenColumn = columnIdx;
					while(left == false) {
						if(queenColumn != 0) {
							--queenColumn;
							String pos = theBoard.getBoard()[queenRow][queenColumn];
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
					
					queenRow = rowIdx;
					queenColumn = columnIdx;
					while(rightUp == false) {
						if(queenRow != 7 && queenColumn != 7 ) {
							++queenRow;
							++queenColumn;
							String pos = theBoard.getBoard()[queenRow][queenColumn];
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
					queenRow = rowIdx;
					queenColumn = columnIdx;
					while(leftUp == false) {
						if(queenRow != 7 && queenColumn != 0) {
							++queenRow;
							--queenColumn;
							String pos = theBoard.getBoard()[queenRow][queenColumn];
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
					
					queenRow = rowIdx;
					queenColumn = columnIdx;
					while(rightDown == false) {
						if(queenRow != 0 && queenColumn != 7) {
							--queenRow;
							++queenColumn;
							String pos = theBoard.getBoard()[queenRow][queenColumn];
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
					
					queenRow = rowIdx;
					queenColumn = columnIdx;
					while(leftDown == false) {
						if(queenRow != 0 && queenColumn != 0) {
							--queenRow;
							--queenColumn;
							String pos = theBoard.getBoard()[queenRow][queenColumn];
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

}
