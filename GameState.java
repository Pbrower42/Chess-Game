import java.util.ArrayList;

public class GameState {
	
	private ArrayList <Piece> [] theState;
	
	//A constructor method to represent the current state of the game via the positions of white and black pieces
	public GameState(ArrayList <Piece> wPieces, ArrayList <Piece> bPieces) {
		theState = new ArrayList[2];
		theState[0] = new ArrayList<Piece>(wPieces); //White pieces are in first index of the array
		theState[1] = new ArrayList<Piece>(bPieces); //Black pieces are in second index of the array
	}
	
	//A method that returns an array list of all the possible moves of the current game state
	public ArrayList<GameState> getWMoves(GameState gState){
		ArrayList <GameState> theMoves = new ArrayList();//Represents the list of all possible moves
		//Loop through white pieces and find every possible move
		for(int i = 0; i < gState.getState()[0].size(); ++i) {
			Board theBoard = new Board();
//			System.out.println(gState.getState()[0].get(i).getName());
//			System.out.println(gState.getState()[0].get(i).getPosition());
			if(gState.getState()[0].get(i).getName().startsWith("White Pawn") == true) {
				Pawn thePawn = (Pawn)gState.getState()[0].get(i);
				String orPos = gState.getState()[0].get(i).getPosition();
				ArrayList [] positions = thePawn.getWPositions(thePawn, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				boolean rankBy1 = (boolean) positions[2].get(0);
				boolean rankBy2 = (boolean) positions[2].get(1);
				if(rPositions.isEmpty() == false) {
						if(rankBy1 == true && rankBy2 == true) {
							ArrayList <Piece> fWPieces = new ArrayList<Piece>();
							int pawnCount = 0;
							int knightCount = 0;
							int bishopCount = 0;
							int rookCount = 0;
							int promKCount = 0;
							int promBCount = 0;
							int promRCount = 0;
							int promQCount = 0;
							//Make a deep copy of the white pieces
							for(int k = 0; k < gState.getState()[0].size(); ++k) {
								if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
									++pawnCount;
									Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
									nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
									fWPieces.add(nPawn);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
									++knightCount;
									Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
									fWPieces.add(nKnight);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
									++promKCount;
									Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
									fWPieces.add(nKnight);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
									++bishopCount;
									Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
									fWPieces.add(nBishop);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
									++promBCount;
									Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
									fWPieces.add(nBishop);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
									++rookCount;
									Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
									fWPieces.add(nRook);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
									++promRCount;
									Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
									fWPieces.add(nRook);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
									Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
									fWPieces.add(nQueen);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
									++promQCount;
									Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
									fWPieces.add(nQueen);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
									King nKing = new King("White", gState.getState()[0].get(k).getPosition());
									fWPieces.add(nKing);
								}
							}
							((Pawn)fWPieces.get(i)).setPosition(rPositions.get(0));
							((Pawn)fWPieces.get(i)).addRank(1);
							
							GameState newBoard = new GameState(new ArrayList<Piece>(fWPieces), gState.getState()[1]);
							theMoves.add(newBoard);
							ArrayList <Piece> fWPieces2 = new ArrayList<Piece>();
							pawnCount = 0;
							knightCount = 0;
							bishopCount = 0;
							rookCount = 0;
							promKCount = 0;
							promBCount = 0;
							promRCount = 0;
							promQCount = 0;
							//Make a deep copy of the white pieces
							for(int k = 0; k < gState.getState()[0].size(); ++k) {
								if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
									++pawnCount;
									Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
									nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
									fWPieces2.add(nPawn);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
									++knightCount;
									Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
									fWPieces2.add(nKnight);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
									++promKCount;
									Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
									fWPieces2.add(nKnight);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
									++bishopCount;
									Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
									fWPieces2.add(nBishop);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
									++promBCount;
									Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
									fWPieces2.add(nBishop);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
									++rookCount;
									Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
									fWPieces2.add(nRook);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
									++promRCount;
									Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
									fWPieces2.add(nRook);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
									Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
									fWPieces2.add(nQueen);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
									++promQCount;
									Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
									fWPieces2.add(nQueen);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
									King nKing = new King("White", gState.getState()[0].get(k).getPosition());
									fWPieces2.add(nKing);
								}
							}
							((Pawn)fWPieces2.get(i)).setPosition(rPositions.get(1));
							((Pawn)fWPieces2.get(i)).addRank(2);
							GameState newBoard2 = new GameState(new ArrayList<Piece>(fWPieces2), gState.getState()[1]);
							theMoves.add(newBoard2);
						}
						else if(rankBy1 == true && rankBy2 == false) {
							ArrayList <Piece> fWPieces = new ArrayList<Piece>();
							int pawnCount = 0;
							int knightCount = 0;
							int bishopCount = 0;
							int rookCount = 0;
							int promKCount = 0;
							int promBCount = 0;
							int promRCount = 0;
							int promQCount = 0;
							//Make a deep copy of the white pieces
							for(int k = 0; k < gState.getState()[0].size(); ++k) {
								if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
									++pawnCount;
									Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
									nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
									fWPieces.add(nPawn);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
									++knightCount;
									Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
									fWPieces.add(nKnight);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
									++promKCount;
									Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
									fWPieces.add(nKnight);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
									++bishopCount;
									Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
									fWPieces.add(nBishop);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
									++promBCount;
									Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
									fWPieces.add(nBishop);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
									++rookCount;
									Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
									fWPieces.add(nRook);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
									++promRCount;
									Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
									fWPieces.add(nRook);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
									Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
									fWPieces.add(nQueen);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
									++promQCount;
									Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
									fWPieces.add(nQueen);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
									King nKing = new King("White", gState.getState()[0].get(k).getPosition());
									fWPieces.add(nKing);
								}
							}
							((Pawn)fWPieces.get(i)).setPosition(rPositions.get(0));
							((Pawn)fWPieces.get(i)).addRank(1);
							//Check for piece promotion
							if(((Pawn)fWPieces.get(i)).getRank() == 8){
								int pawnCount2 = 0;
								int knightCount2 = 0;
								int bishopCount2 = 0;
								int rookCount2 = 0;
								int promKCount2 = 0;
								int promBCount2 = 0;
								int promRCount2 = 0;
								int promQCount2 = 0;
			
									ArrayList <Piece> fWKPieces = new ArrayList<Piece>(); //Make new list for promotions
									//Create a deep copy of white pieces to safely create new game states after a promotion
									for(int k = 0; k < fWPieces.size(); ++k) {
										if(fWPieces.get(k).getName().startsWith("White Pawn") == true) {
											++pawnCount2;
											Pawn nPawn = new Pawn("White", fWPieces.get(k).getPosition(), pawnCount2);
											nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
											fWKPieces.add(nPawn);
										}
										else if(fWPieces.get(k).getName().startsWith("White Knight") == true) {
											++knightCount2;
											Knight nKnight = new Knight("White", fWPieces.get(k).getPosition(), knightCount2);
											fWKPieces.add(nKnight);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Knight") == true) {
											++promKCount2;
											Knight nKnight = new Knight("White Promoted", fWPieces.get(k).getPosition(), promKCount2);
											fWKPieces.add(nKnight);
										}
										else if(fWPieces.get(k).getName().startsWith("White Bishop") == true) {
											++bishopCount2;
											Bishop nBishop = new Bishop("White", fWPieces.get(k).getPosition(), bishopCount2);
											fWKPieces.add(nBishop);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Bishop") == true) {
											++promBCount2;
											Rook nBishop = new Rook("White Promoted", fWPieces.get(k).getPosition(), promBCount2);
											fWKPieces.add(nBishop);
										}
										else if(fWPieces.get(k).getName().startsWith("White Rook") == true) {
											++rookCount2;
											Rook nRook = new Rook("White", fWPieces.get(k).getPosition(), rookCount2);
											fWKPieces.add(nRook);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Rook") == true) {
											++promRCount2;
											Rook nRook = new Rook("White Promoted", fWPieces.get(k).getPosition(), promRCount2);
											fWKPieces.add(nRook);
										}
										else if(fWPieces.get(k).getName().startsWith("White Queen") == true) {
											Queen nQueen = new Queen("White", fWPieces.get(k).getPosition());
											fWKPieces.add(nQueen);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Queen") == true) {
											++promQCount2;
											Queen nQueen = new Queen("White Promoted", fWPieces.get(k).getPosition(), promQCount2);
											fWKPieces.add(nQueen);
										}
										else if(fWPieces.get(k).getName().startsWith("White King") == true) {
											King nKing = new King("White", fWPieces.get(k).getPosition());
											fWKPieces.add(nKing);
										}
									}
									Knight promKnight = new Knight("White Promoted", fWPieces.get(i).getPosition(), promKCount2 + 1);
									fWKPieces.set(i, promKnight);
									GameState newBoardK = new GameState(new ArrayList<Piece>(fWKPieces), gState.getState()[1]);
									theMoves.add(newBoardK);
									//Reset counters
									pawnCount2 = 0;
									knightCount2 = 0;
									bishopCount2 = 0;
									rookCount2 = 0;
									promKCount2 = 0;
									promBCount2 = 0;
									promRCount2 = 0;
									promQCount2 = 0;
									ArrayList <Piece> fWBPieces = new ArrayList<Piece>(); //Make new list for promotions
									//Create new deep copy for next promotion. Repeat till all promotions are completed
									for(int k = 0; k < fWPieces.size(); ++k) {
										if(fWPieces.get(k).getName().startsWith("White Pawn") == true) {
											++pawnCount2;
											Pawn nPawn = new Pawn("White", fWPieces.get(k).getPosition(), pawnCount2);
											nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
											fWBPieces.add(nPawn);
										}
										else if(fWPieces.get(k).getName().startsWith("White Knight") == true) {
											++knightCount2;
											Knight nKnight = new Knight("White", fWPieces.get(k).getPosition(), knightCount2);
											fWBPieces.add(nKnight);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Knight") == true) {
											++promKCount2;
											Knight nKnight = new Knight("White Promoted", fWPieces.get(k).getPosition(), promKCount2);
											fWBPieces.add(nKnight);
										}
										else if(fWPieces.get(k).getName().startsWith("White Bishop") == true) {
											++bishopCount2;
											Bishop nBishop = new Bishop("White", fWPieces.get(k).getPosition(), bishopCount2);
											fWBPieces.add(nBishop);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Bishop") == true) {
											++promBCount2;
											Rook nBishop = new Rook("White Promoted", fWPieces.get(k).getPosition(), promBCount2);
											fWBPieces.add(nBishop);
										}
										else if(fWPieces.get(k).getName().startsWith("White Rook") == true) {
											++rookCount2;
											Rook nRook = new Rook("White", fWPieces.get(k).getPosition(), rookCount2);
											fWBPieces.add(nRook);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Rook") == true) {
											++promRCount2;
											Rook nRook = new Rook("White Promoted", fWPieces.get(k).getPosition(), promRCount2);
											fWBPieces.add(nRook);
										}
										else if(fWPieces.get(k).getName().startsWith("White Queen") == true) {
											Queen nQueen = new Queen("White", fWPieces.get(k).getPosition());
											fWBPieces.add(nQueen);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Queen") == true) {
											++promQCount2;
											Queen nQueen = new Queen("White Promoted", fWPieces.get(k).getPosition(), promQCount2);
											fWBPieces.add(nQueen);
										}
										else if(fWPieces.get(k).getName().startsWith("White King") == true) {
											King nKing = new King("White", fWPieces.get(k).getPosition());
											fWBPieces.add(nKing);
										}
									}
									Bishop promBishop = new Bishop("White Promoted", fWPieces.get(i).getPosition(), promBCount2 + 1);
									fWBPieces.set(i, promBishop);
									GameState newBoardB = new GameState(new ArrayList<Piece>(fWBPieces), gState.getState()[1]);
									theMoves.add(newBoardB);
									//Reset counters
									pawnCount2 = 0;
									knightCount2 = 0;
									bishopCount2 = 0;
									rookCount2 = 0;
									promKCount2 = 0;
									promBCount2 = 0;
									promRCount2 = 0;
									promQCount2 = 0;
									ArrayList <Piece> fWRPieces = new ArrayList<Piece>(); //Make new list for promotions
									//Create new deep copy for next promotion. Repeat till all promotions are completed
									for(int k = 0; k < fWPieces.size(); ++k) {
										if(fWPieces.get(k).getName().startsWith("White Pawn") == true) {
											++pawnCount2;
											Pawn nPawn = new Pawn("White", fWPieces.get(k).getPosition(), pawnCount2);
											nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
											fWRPieces.add(nPawn);
										}
										else if(fWPieces.get(k).getName().startsWith("White Knight") == true) {
											++knightCount2;
											Knight nKnight = new Knight("White", fWPieces.get(k).getPosition(), knightCount2);
											fWRPieces.add(nKnight);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Knight") == true) {
											++promKCount2;
											Knight nKnight = new Knight("White Promoted", fWPieces.get(k).getPosition(), promKCount2);
											fWRPieces.add(nKnight);
										}
										else if(fWPieces.get(k).getName().startsWith("White Bishop") == true) {
											++bishopCount2;
											Bishop nBishop = new Bishop("White", fWPieces.get(k).getPosition(), bishopCount2);
											fWRPieces.add(nBishop);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Bishop") == true) {
											++promBCount2;
											Rook nBishop = new Rook("White Promoted", fWPieces.get(k).getPosition(), promBCount2);
											fWRPieces.add(nBishop);
										}
										else if(fWPieces.get(k).getName().startsWith("White Rook") == true) {
											++rookCount2;
											Rook nRook = new Rook("White", fWPieces.get(k).getPosition(), rookCount2);
											fWRPieces.add(nRook);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Rook") == true) {
											++promRCount2;
											Rook nRook = new Rook("White Promoted", fWPieces.get(k).getPosition(), promRCount2);
											fWRPieces.add(nRook);
										}
										else if(fWPieces.get(k).getName().startsWith("White Queen") == true) {
											Queen nQueen = new Queen("White", fWPieces.get(k).getPosition());
											fWRPieces.add(nQueen);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Queen") == true) {
											++promQCount2;
											Queen nQueen = new Queen("White Promoted", fWPieces.get(k).getPosition(), promQCount2);
											fWRPieces.add(nQueen);
										}
										else if(fWPieces.get(k).getName().startsWith("White King") == true) {
											King nKing = new King("White", fWPieces.get(k).getPosition());
											fWRPieces.add(nKing);
										}
									}
									Rook promRook = new Rook("White Promoted", fWPieces.get(i).getPosition(), promBCount2 + 1);
									fWRPieces.set(i, promBishop);
									GameState newBoardR = new GameState(new ArrayList<Piece>(fWRPieces), gState.getState()[1]);
									theMoves.add(newBoardR);
									
									//Reset counters
									pawnCount2 = 0;
									knightCount2 = 0;
									bishopCount2 = 0;
									rookCount2 = 0;
									promKCount2 = 0;
									promBCount2 = 0;
									promRCount2 = 0;
									promQCount2 = 0;
									ArrayList <Piece> fWQPieces = new ArrayList<Piece>(); //Make new list for promotions
									//Create new deep copy for next promotion. Repeat till all promotions are completed
									for(int k = 0; k < fWPieces.size(); ++k) {
										if(fWPieces.get(k).getName().startsWith("White Pawn") == true) {
											++pawnCount2;
											Pawn nPawn = new Pawn("White", fWPieces.get(k).getPosition(), pawnCount2);
											nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
											fWQPieces.add(nPawn);
										}
										else if(fWPieces.get(k).getName().startsWith("White Knight") == true) {
											++knightCount2;
											Knight nKnight = new Knight("White", fWPieces.get(k).getPosition(), knightCount2);
											fWQPieces.add(nKnight);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Knight") == true) {
											++promKCount2;
											Knight nKnight = new Knight("White Promoted", fWPieces.get(k).getPosition(), promKCount2);
											fWQPieces.add(nKnight);
										}
										else if(fWPieces.get(k).getName().startsWith("White Bishop") == true) {
											++bishopCount2;
											Bishop nBishop = new Bishop("White", fWPieces.get(k).getPosition(), bishopCount2);
											fWQPieces.add(nBishop);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Bishop") == true) {
											++promBCount2;
											Rook nBishop = new Rook("White Promoted", fWPieces.get(k).getPosition(), promBCount2);
											fWQPieces.add(nBishop);
										}
										else if(fWPieces.get(k).getName().startsWith("White Rook") == true) {
											++rookCount2;
											Rook nRook = new Rook("White", fWPieces.get(k).getPosition(), rookCount2);
											fWQPieces.add(nRook);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Rook") == true) {
											++promRCount2;
											Rook nRook = new Rook("White Promoted", fWPieces.get(k).getPosition(), promRCount2);
											fWQPieces.add(nRook);
										}
										else if(fWPieces.get(k).getName().startsWith("White Queen") == true) {
											Queen nQueen = new Queen("White", fWPieces.get(k).getPosition());
											fWQPieces.add(nQueen);
										}
										else if(fWPieces.get(k).getName().startsWith("White Promoted Queen") == true) {
											++promQCount2;
											Queen nQueen = new Queen("White Promoted", fWPieces.get(k).getPosition(), promQCount2);
											fWQPieces.add(nQueen);
										}
										else if(fWPieces.get(k).getName().startsWith("White King") == true) {
											King nKing = new King("White", fWPieces.get(k).getPosition());
											fWQPieces.add(nKing);
										}
									}
									Queen promQueen = new Queen("White Promoted", fWPieces.get(i).getPosition(), promBCount2 + 1);
									fWQPieces.set(i, promBishop);
									GameState newBoardQ = new GameState(new ArrayList<Piece>(fWQPieces), gState.getState()[1]);
									theMoves.add(newBoardQ);
									
							}
							else {
							GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
							theMoves.add(newBoard);
							}
						}
						else if(rankBy1 == false && rankBy2 == true) {
							ArrayList <Piece> fWPieces = new ArrayList<Piece>();
							int pawnCount = 0;
							int knightCount = 0;
							int bishopCount = 0;
							int rookCount = 0;
							int promKCount = 0;
							int promBCount = 0;
							int promRCount = 0;
							int promQCount = 0;
							//Make a deep copy of the white pieces
							for(int k = 0; k < gState.getState()[0].size(); ++k) {
								if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
									++pawnCount;
									Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
									nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
									fWPieces.add(nPawn);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
									++knightCount;
									Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
									fWPieces.add(nKnight);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
									++promKCount;
									Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
									fWPieces.add(nKnight);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
									++bishopCount;
									Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
									fWPieces.add(nBishop);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
									++promBCount;
									Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
									fWPieces.add(nBishop);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
									++rookCount;
									Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
									fWPieces.add(nRook);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
									++promRCount;
									Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
									fWPieces.add(nRook);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
									Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
									fWPieces.add(nQueen);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
									++promQCount;
									Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
									fWPieces.add(nQueen);
								}
								else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
									King nKing = new King("White", gState.getState()[0].get(k).getPosition());
									fWPieces.add(nKing);
								}
							}
							((Pawn)fWPieces.get(i)).setPosition(rPositions.get(0));
							((Pawn)fWPieces.get(i)).addRank(2);
							GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
							theMoves.add(newBoard);
						}
						
					}
				if(cPieces.isEmpty() == false) {
					for(int j = 0;  j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Pawn)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						((Pawn)fWPieces.get(i)).addRank(1);
						
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						if(((Pawn)fWPieces.get(i)).getRank() == 8){
							int pawnCount2 = 0;
							int knightCount2 = 0;
							int bishopCount2 = 0;
							int rookCount2 = 0;
							int promKCount2 = 0;
							int promBCount2 = 0;
							int promRCount2 = 0;
							int promQCount2 = 0;
		
								ArrayList <Piece> fWKPieces = new ArrayList<Piece>(); //Make new list for promotions
								//Create a deep copy of white pieces to safely create new game states after a promotion
								for(int k = 0; k < fWPieces.size(); ++k) {
									if(fWPieces.get(k).getName().startsWith("White Pawn") == true) {
										++pawnCount2;
										Pawn nPawn = new Pawn("White", fWPieces.get(k).getPosition(), pawnCount2);
										nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
										fWKPieces.add(nPawn);
									}
									else if(fWPieces.get(k).getName().startsWith("White Knight") == true) {
										++knightCount2;
										Knight nKnight = new Knight("White", fWPieces.get(k).getPosition(), knightCount2);
										fWKPieces.add(nKnight);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Knight") == true) {
										++promKCount2;
										Knight nKnight = new Knight("White Promoted", fWPieces.get(k).getPosition(), promKCount2);
										fWKPieces.add(nKnight);
									}
									else if(fWPieces.get(k).getName().startsWith("White Bishop") == true) {
										++bishopCount2;
										Bishop nBishop = new Bishop("White", fWPieces.get(k).getPosition(), bishopCount2);
										fWKPieces.add(nBishop);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Bishop") == true) {
										++promBCount2;
										Rook nBishop = new Rook("White Promoted", fWPieces.get(k).getPosition(), promBCount2);
										fWKPieces.add(nBishop);
									}
									else if(fWPieces.get(k).getName().startsWith("White Rook") == true) {
										++rookCount2;
										Rook nRook = new Rook("White", fWPieces.get(k).getPosition(), rookCount2);
										fWKPieces.add(nRook);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Rook") == true) {
										++promRCount2;
										Rook nRook = new Rook("White Promoted", fWPieces.get(k).getPosition(), promRCount2);
										fWKPieces.add(nRook);
									}
									else if(fWPieces.get(k).getName().startsWith("White Queen") == true) {
										Queen nQueen = new Queen("White", fWPieces.get(k).getPosition());
										fWKPieces.add(nQueen);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Queen") == true) {
										++promQCount2;
										Queen nQueen = new Queen("White Promoted", fWPieces.get(k).getPosition(), promQCount2);
										fWKPieces.add(nQueen);
									}
									else if(fWPieces.get(k).getName().startsWith("White King") == true) {
										King nKing = new King("White", fWPieces.get(k).getPosition());
										fWKPieces.add(nKing);
									}
								}
								Knight promKnight = new Knight("White Promoted", fWPieces.get(i).getPosition(), promKCount2 + 1);
								fWKPieces.set(i, promKnight);
								GameState newBoardK = new GameState(new ArrayList<Piece>(fWKPieces), fBPieces);
								theMoves.add(newBoardK);
								//Reset counters
								pawnCount2 = 0;
								knightCount2 = 0;
								bishopCount2 = 0;
								rookCount2 = 0;
								promKCount2 = 0;
								promBCount2 = 0;
								promRCount2 = 0;
								promQCount2 = 0;
								ArrayList <Piece> fWBPieces = new ArrayList<Piece>(); //Make new list for promotions
								//Create new deep copy for next promotion. Repeat till all promotions are completed
								for(int k = 0; k < fWPieces.size(); ++k) {
									if(fWPieces.get(k).getName().startsWith("White Pawn") == true) {
										++pawnCount2;
										Pawn nPawn = new Pawn("White", fWPieces.get(k).getPosition(), pawnCount2);
										nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
										fWBPieces.add(nPawn);
									}
									else if(fWPieces.get(k).getName().startsWith("White Knight") == true) {
										++knightCount2;
										Knight nKnight = new Knight("White", fWPieces.get(k).getPosition(), knightCount2);
										fWBPieces.add(nKnight);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Knight") == true) {
										++promKCount2;
										Knight nKnight = new Knight("White Promoted", fWPieces.get(k).getPosition(), promKCount2);
										fWBPieces.add(nKnight);
									}
									else if(fWPieces.get(k).getName().startsWith("White Bishop") == true) {
										++bishopCount2;
										Bishop nBishop = new Bishop("White", fWPieces.get(k).getPosition(), bishopCount2);
										fWBPieces.add(nBishop);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Bishop") == true) {
										++promBCount2;
										Rook nBishop = new Rook("White Promoted", fWPieces.get(k).getPosition(), promBCount2);
										fWBPieces.add(nBishop);
									}
									else if(fWPieces.get(k).getName().startsWith("White Rook") == true) {
										++rookCount2;
										Rook nRook = new Rook("White", fWPieces.get(k).getPosition(), rookCount2);
										fWBPieces.add(nRook);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Rook") == true) {
										++promRCount2;
										Rook nRook = new Rook("White Promoted", fWPieces.get(k).getPosition(), promRCount2);
										fWBPieces.add(nRook);
									}
									else if(fWPieces.get(k).getName().startsWith("White Queen") == true) {
										Queen nQueen = new Queen("White", fWPieces.get(k).getPosition());
										fWBPieces.add(nQueen);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Queen") == true) {
										++promQCount2;
										Queen nQueen = new Queen("White Promoted", fWPieces.get(k).getPosition(), promQCount2);
										fWBPieces.add(nQueen);
									}
									else if(fWPieces.get(k).getName().startsWith("White King") == true) {
										King nKing = new King("White", fWPieces.get(k).getPosition());
										fWBPieces.add(nKing);
									}
								}
								Bishop promBishop = new Bishop("White Promoted", fWPieces.get(i).getPosition(), promBCount2 + 1);
								fWBPieces.set(i, promBishop);
								GameState newBoardB = new GameState(new ArrayList<Piece>(fWBPieces), fBPieces);
								theMoves.add(newBoardB);
								//Reset counters
								pawnCount2 = 0;
								knightCount2 = 0;
								bishopCount2 = 0;
								rookCount2 = 0;
								promKCount2 = 0;
								promBCount2 = 0;
								promRCount2 = 0;
								promQCount2 = 0;
								ArrayList <Piece> fWRPieces = new ArrayList<Piece>(); //Make new list for promotions
								//Create new deep copy for next promotion. Repeat till all promotions are completed
								for(int k = 0; k < fWPieces.size(); ++k) {
									if(fWPieces.get(k).getName().startsWith("White Pawn") == true) {
										++pawnCount2;
										Pawn nPawn = new Pawn("White", fWPieces.get(k).getPosition(), pawnCount2);
										nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
										fWRPieces.add(nPawn);
									}
									else if(fWPieces.get(k).getName().startsWith("White Knight") == true) {
										++knightCount2;
										Knight nKnight = new Knight("White", fWPieces.get(k).getPosition(), knightCount2);
										fWRPieces.add(nKnight);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Knight") == true) {
										++promKCount2;
										Knight nKnight = new Knight("White Promoted", fWPieces.get(k).getPosition(), promKCount2);
										fWRPieces.add(nKnight);
									}
									else if(fWPieces.get(k).getName().startsWith("White Bishop") == true) {
										++bishopCount2;
										Bishop nBishop = new Bishop("White", fWPieces.get(k).getPosition(), bishopCount2);
										fWRPieces.add(nBishop);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Bishop") == true) {
										++promBCount2;
										Rook nBishop = new Rook("White Promoted", fWPieces.get(k).getPosition(), promBCount2);
										fWRPieces.add(nBishop);
									}
									else if(fWPieces.get(k).getName().startsWith("White Rook") == true) {
										++rookCount2;
										Rook nRook = new Rook("White", fWPieces.get(k).getPosition(), rookCount2);
										fWRPieces.add(nRook);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Rook") == true) {
										++promRCount2;
										Rook nRook = new Rook("White Promoted", fWPieces.get(k).getPosition(), promRCount2);
										fWRPieces.add(nRook);
									}
									else if(fWPieces.get(k).getName().startsWith("White Queen") == true) {
										Queen nQueen = new Queen("White", fWPieces.get(k).getPosition());
										fWRPieces.add(nQueen);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Queen") == true) {
										++promQCount2;
										Queen nQueen = new Queen("White Promoted", fWPieces.get(k).getPosition(), promQCount2);
										fWRPieces.add(nQueen);
									}
									else if(fWPieces.get(k).getName().startsWith("White King") == true) {
										King nKing = new King("White", fWPieces.get(k).getPosition());
										fWRPieces.add(nKing);
									}
								}
								Rook promRook = new Rook("White Promoted", fWPieces.get(i).getPosition(), promBCount2 + 1);
								fWRPieces.set(i, promBishop);
								GameState newBoardR = new GameState(new ArrayList<Piece>(fWRPieces), fBPieces);
								theMoves.add(newBoardR);
								
								//Reset counters
								pawnCount2 = 0;
								knightCount2 = 0;
								bishopCount2 = 0;
								rookCount2 = 0;
								promKCount2 = 0;
								promBCount2 = 0;
								promRCount2 = 0;
								promQCount2 = 0;
								ArrayList <Piece> fWQPieces = new ArrayList<Piece>(); //Make new list for promotions
								//Create new deep copy for next promotion. Repeat till all promotions are completed
								for(int k = 0; k < fWPieces.size(); ++k) {
									if(fWPieces.get(k).getName().startsWith("White Pawn") == true) {
										++pawnCount2;
										Pawn nPawn = new Pawn("White", fWPieces.get(k).getPosition(), pawnCount2);
										nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
										fWQPieces.add(nPawn);
									}
									else if(fWPieces.get(k).getName().startsWith("White Knight") == true) {
										++knightCount2;
										Knight nKnight = new Knight("White", fWPieces.get(k).getPosition(), knightCount2);
										fWQPieces.add(nKnight);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Knight") == true) {
										++promKCount2;
										Knight nKnight = new Knight("White Promoted", fWPieces.get(k).getPosition(), promKCount2);
										fWQPieces.add(nKnight);
									}
									else if(fWPieces.get(k).getName().startsWith("White Bishop") == true) {
										++bishopCount2;
										Bishop nBishop = new Bishop("White", fWPieces.get(k).getPosition(), bishopCount2);
										fWQPieces.add(nBishop);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Bishop") == true) {
										++promBCount2;
										Rook nBishop = new Rook("White Promoted", fWPieces.get(k).getPosition(), promBCount2);
										fWQPieces.add(nBishop);
									}
									else if(fWPieces.get(k).getName().startsWith("White Rook") == true) {
										++rookCount2;
										Rook nRook = new Rook("White", fWPieces.get(k).getPosition(), rookCount2);
										fWQPieces.add(nRook);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Rook") == true) {
										++promRCount2;
										Rook nRook = new Rook("White Promoted", fWPieces.get(k).getPosition(), promRCount2);
										fWQPieces.add(nRook);
									}
									else if(fWPieces.get(k).getName().startsWith("White Queen") == true) {
										Queen nQueen = new Queen("White", fWPieces.get(k).getPosition());
										fWQPieces.add(nQueen);
									}
									else if(fWPieces.get(k).getName().startsWith("White Promoted Queen") == true) {
										++promQCount2;
										Queen nQueen = new Queen("White Promoted", fWPieces.get(k).getPosition(), promQCount2);
										fWQPieces.add(nQueen);
									}
									else if(fWPieces.get(k).getName().startsWith("White King") == true) {
										King nKing = new King("White", fWPieces.get(k).getPosition());
										fWQPieces.add(nKing);
									}
								}
								Queen promQueen = new Queen("White Promoted", fWPieces.get(i).getPosition(), promBCount2 + 1);
								fWQPieces.set(i, promBishop);
								GameState newBoardQ = new GameState(new ArrayList<Piece>(fWQPieces), fBPieces);
								theMoves.add(newBoardQ);
								
						}
						else {
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
						}
					}
				}
				
			}
			else if(gState.getState()[0].get(i).getName().startsWith("White Knight") == true) {
				Knight theKnight = (Knight)gState.getState()[0].get(i);
				ArrayList [] positions = theKnight.getWPositions(theKnight, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						((Knight)fWPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Knight)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			
			else if(gState.getState()[0].get(i).getName().startsWith("White Promoted Knight") == true) {
				Knight theKnight = (Knight)gState.getState()[0].get(i);
				ArrayList [] positions = theKnight.getWPositions(theKnight, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						((Knight)fWPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Knight)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			
			else if(gState.getState()[0].get(i).getName().startsWith("White Bishop")) {
				Bishop theBishop = (Bishop)gState.getState()[0].get(i);
				ArrayList [] positions = theBishop.getWPositions(theBishop, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Bishop)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			
			else if(gState.getState()[0].get(i).getName().startsWith("White Promoted Bishop")) {
				Bishop theBishop = (Bishop)gState.getState()[0].get(i);
				ArrayList [] positions = theBishop.getWPositions(theBishop, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Bishop)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			
			else if(gState.getState()[0].get(i).getName().startsWith("White Rook")) {
				Rook theRook = (Rook)gState.getState()[0].get(i);
				ArrayList [] positions = theRook.getWPositions(theRook, theBoard, gState.getState()[0],gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						((Rook)fWPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Rook)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			
			else if(gState.getState()[0].get(i).getName().startsWith("White Promoted Rook")) {
				Rook theRook = (Rook)gState.getState()[0].get(i);
				ArrayList [] positions = theRook.getWPositions(theRook, theBoard, gState.getState()[0],gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						((Rook)fWPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Rook)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			
			else if(gState.getState()[0].get(i).getName().startsWith("White Queen")) {
				Queen theQueen = (Queen)gState.getState()[0].get(i);
				ArrayList [] positions = theQueen.getWPositions(theQueen, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						((Queen)fWPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Queen)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			
			else if(gState.getState()[0].get(i).getName().startsWith("White Promoted Queen")) {
				Queen theQueen = (Queen)gState.getState()[0].get(i);
				ArrayList [] positions = theQueen.getWPositions(theQueen, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						((Queen)fWPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Queen)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			else if(gState.getState()[0].get(i).getName().startsWith("White King")) {
				King theKing = (King)gState.getState()[0].get(i);
				ArrayList [] positions = theKing.getWPositions(theKing, theBoard,gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						((King)fWPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(fWPieces, gState.getState()[1]);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((King)fWPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fBPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fBPieces.get(k).getName())) { //If capture piece is found in list
								fBPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			
		}
		return theMoves;
	}
	
	public ArrayList<GameState> getBMoves(GameState gState){
		ArrayList <GameState> theMoves = new ArrayList(); ; //Represents the list of all possible moves
		//Loop through white pieces and find every possible move
		for(int i = 0; i < gState.getState()[1].size(); ++i) {
			Board theBoard = new Board();
//			System.out.println(gState.getState()[1].get(i).getName());
//			System.out.println(gState.getState()[1].get(i).getPosition());
			if(gState.getState()[1].get(i).getName().startsWith("Black Pawn") == true) {
				Pawn thePawn = (Pawn)gState.getState()[1].get(i);
				ArrayList [] positions = thePawn.getBPositions(thePawn, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				boolean rankBy1 = (boolean) positions[2].get(0);
				boolean rankBy2 = (boolean) positions[2].get(1);
				if(rPositions.isEmpty() == false) {
						if(rankBy1 == true && rankBy2 == true) {
							ArrayList <Piece> fBPieces = new ArrayList<Piece>();
							int pawnCountB = 0;
							int knightCountB = 0;
							int bishopCountB = 0;
							int rookCountB = 0;
							int promKCountB = 0;
							int promBCountB = 0;
							int promRCountB = 0;
							int promQCountB = 0;
							//Make a deep copy of the black pieces
							for(int k = 0; k < gState.getState()[1].size(); ++k) {
								if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
									++pawnCountB;
									Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
									nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
									fBPieces.add(nPawn);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
									++knightCountB;
									Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
									fBPieces.add(nKnight);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
									++promKCountB;
									Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
									fBPieces.add(nKnight);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
									++bishopCountB;
									Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
									fBPieces.add(nBishop);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
									++promBCountB;
									Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
									fBPieces.add(nBishop);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
									++rookCountB;
									Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
									fBPieces.add(nRook);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
									++promRCountB;
									Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
									fBPieces.add(nRook);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
									Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
									fBPieces.add(nQueen);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
									++promQCountB;
									Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
									fBPieces.add(nQueen);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
									King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
									fBPieces.add(nKing);
								}
							}
							((Pawn)fBPieces.get(i)).setPosition(rPositions.get(0));
							((Pawn)fBPieces.get(i)).addRank(1);
							
							GameState newBoard = new GameState(gState.getState()[0], fBPieces);
							theMoves.add(newBoard);
							ArrayList <Piece> fBPieces2 = new ArrayList<Piece>();
							int pawnCountB2 = 0;
							int knightCountB2 = 0;
							int bishopCountB2 = 0;
							int rookCountB2 = 0;
							int promKCountB2 = 0;
							int promBCountB2 = 0;
							int promRCountB2 = 0;
							int promQCountB2 = 0;
							//Make a deep copy of the black pieces
							for(int k = 0; k < gState.getState()[1].size(); ++k) {
								if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
									++pawnCountB2;
									Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB2);
									nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
									fBPieces2.add(nPawn);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
									++knightCountB2;
									Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB2);
									fBPieces2.add(nKnight);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
									++promKCountB2;
									Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(),  promKCountB2);
									fBPieces2.add(nKnight);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
									++bishopCountB2;
									Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB2);
									fBPieces2.add(nBishop);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
									++promBCountB2;
									Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(),  promBCountB2);
									fBPieces2.add(nBishop);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
									++rookCountB2;
									Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB2);
									fBPieces2.add(nRook);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
									++promRCountB2;
									Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(),  promRCountB2);
									fBPieces2.add(nRook);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
									Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
									fBPieces2.add(nQueen);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
									++promQCountB2;
									Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB2);
									fBPieces2.add(nQueen);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
									King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
									fBPieces2.add(nKing);
								}
							}
							((Pawn)fBPieces2.get(i)).setPosition(rPositions.get(1));
							((Pawn)fBPieces2.get(i)).addRank(2);
							GameState newBoard2 = new GameState(gState.getState()[0], new ArrayList<Piece>(fBPieces2));
							theMoves.add(newBoard2);
						}
						else if(rankBy1 == true && rankBy2 == false) {
							ArrayList <Piece> fBPieces = new ArrayList<Piece>();
							int pawnCountB = 0;
							int knightCountB = 0;
							int bishopCountB = 0;
							int rookCountB = 0;
							int promKCountB = 0;
							int promBCountB = 0;
							int promRCountB = 0;
							int promQCountB = 0;
							//Make a deep copy of the black pieces
							for(int k = 0; k < gState.getState()[1].size(); ++k) {
								if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
									++pawnCountB;
									Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
									nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
									fBPieces.add(nPawn);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
									++knightCountB;
									Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
									fBPieces.add(nKnight);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
									++promKCountB;
									Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
									fBPieces.add(nKnight);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
									++bishopCountB;
									Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
									fBPieces.add(nBishop);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
									++promBCountB;
									Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
									fBPieces.add(nBishop);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
									++rookCountB;
									Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
									fBPieces.add(nRook);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
									++promRCountB;
									Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
									fBPieces.add(nRook);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
									Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
									fBPieces.add(nQueen);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
									++promQCountB;
									Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
									fBPieces.add(nQueen);
								}
								else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
									King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
									fBPieces.add(nKing);
								}
							}
							((Pawn)fBPieces.get(i)).setPosition(rPositions.get(0));
							((Pawn)fBPieces.get(i)).addRank(1);
							if(((Pawn)fBPieces.get(i)).getRank() == 8){
								int pawnCount2 = 0;
								int knightCount2 = 0;
								int bishopCount2 = 0;
								int rookCount2 = 0;
								int promKCount2 = 0;
								int promBCount2 = 0;
								int promRCount2 = 0;
								int promQCount2 = 0;
			
									ArrayList <Piece> fBKPieces = new ArrayList<Piece>(); //Make new list for promotions
									//Create a deep copy of white pieces to safely create new game states after a promotion
									for(int k = 0; k < fBPieces.size(); ++k) {
										if(fBPieces.get(k).getName().startsWith("Black Pawn") == true) {
											++pawnCount2;
											Pawn nPawn = new Pawn("Black", fBPieces.get(k).getPosition(), pawnCount2);
											nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
											fBKPieces.add(nPawn);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Knight") == true) {
											++knightCount2;
											Knight nKnight = new Knight("Black", fBPieces.get(k).getPosition(), knightCount2);
											fBKPieces.add(nKnight);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Knight") == true) {
											++promKCount2;
											Knight nKnight = new Knight("Black Promoted", fBPieces.get(k).getPosition(), promKCount2);
											fBKPieces.add(nKnight);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Bishop") == true) {
											++bishopCount2;
											Bishop nBishop = new Bishop("Black", fBPieces.get(k).getPosition(), bishopCount2);
											fBKPieces.add(nBishop);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Bishop") == true) {
											++promBCount2;
											Rook nBishop = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promBCount2);
											fBKPieces.add(nBishop);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Rook") == true) {
											++rookCount2;
											Rook nRook = new Rook("Black", fBPieces.get(k).getPosition(), rookCount2);
											fBKPieces.add(nRook);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Rook") == true) {
											++promRCount2;
											Rook nRook = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promRCount2);
											fBKPieces.add(nRook);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Queen") == true) {
											Queen nQueen = new Queen("Black", fBPieces.get(k).getPosition());
											fBKPieces.add(nQueen);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Queen") == true) {
											++promQCount2;
											Queen nQueen = new Queen("Black Promoted", fBPieces.get(k).getPosition(), promQCount2);
											fBKPieces.add(nQueen);
										}
										else if(fBPieces.get(k).getName().startsWith("Black King") == true) {
											King nKing = new King("Black", fBPieces.get(k).getPosition());
											fBKPieces.add(nKing);
										}
									}
									Knight promKnight = new Knight("Black Promoted", fBPieces.get(i).getPosition(), promKCount2 + 1);
									fBKPieces.set(i, promKnight);
									GameState newBoardK = new GameState(gState.getState()[0], new ArrayList<Piece>(fBKPieces));
									theMoves.add(newBoardK);
									//Reset counters
									pawnCount2 = 0;
									knightCount2 = 0;
									bishopCount2 = 0;
									rookCount2 = 0;
									promKCount2 = 0;
									promBCount2 = 0;
									promRCount2 = 0;
									promQCount2 = 0;
									ArrayList <Piece> fBBPieces = new ArrayList<Piece>(); //Make new list for promotions
									//Create new deep copy for next promotion. Repeat till all promotions are completed
									for(int k = 0; k < fBPieces.size(); ++k) {
										if(fBPieces.get(k).getName().startsWith("Black Pawn") == true) {
											++pawnCount2;
											Pawn nPawn = new Pawn("Black", fBPieces.get(k).getPosition(), pawnCount2);
											nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
											fBBPieces.add(nPawn);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Knight") == true) {
											++knightCount2;
											Knight nKnight = new Knight("Black", fBPieces.get(k).getPosition(), knightCount2);
											fBBPieces.add(nKnight);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Knight") == true) {
											++promKCount2;
											Knight nKnight = new Knight("Black Promoted", fBPieces.get(k).getPosition(), promKCount2);
											fBBPieces.add(nKnight);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Bishop") == true) {
											++bishopCount2;
											Bishop nBishop = new Bishop("Black", fBPieces.get(k).getPosition(), bishopCount2);
											fBBPieces.add(nBishop);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Bishop") == true) {
											++promBCount2;
											Rook nBishop = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promBCount2);
											fBBPieces.add(nBishop);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Rook") == true) {
											++rookCount2;
											Rook nRook = new Rook("Black", fBPieces.get(k).getPosition(), rookCount2);
											fBBPieces.add(nRook);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Rook") == true) {
											++promRCount2;
											Rook nRook = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promRCount2);
											fBBPieces.add(nRook);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Queen") == true) {
											Queen nQueen = new Queen("Black", fBPieces.get(k).getPosition());
											fBBPieces.add(nQueen);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Queen") == true) {
											++promQCount2;
											Queen nQueen = new Queen("Black Promoted", fBPieces.get(k).getPosition(), promQCount2);
											fBBPieces.add(nQueen);
										}
										else if(fBPieces.get(k).getName().startsWith("Black King") == true) {
											King nKing = new King("Black", fBPieces.get(k).getPosition());
											fBBPieces.add(nKing);
										}
									}
									Bishop promBishop = new Bishop("Black Promoted", fBPieces.get(i).getPosition(), promBCount2 + 1);
									fBBPieces.set(i, promBishop);
									GameState newBoardB = new GameState(gState.getState()[0], new ArrayList<Piece>(fBBPieces));
									theMoves.add(newBoardB);
									//Reset counters
									pawnCount2 = 0;
									knightCount2 = 0;
									bishopCount2 = 0;
									rookCount2 = 0;
									promKCount2 = 0;
									promBCount2 = 0;
									promRCount2 = 0;
									promQCount2 = 0;
									ArrayList <Piece> fBRPieces = new ArrayList<Piece>(); //Make new list for promotions
									//Create new deep copy for next promotion. Repeat till all promotions are completed
									for(int k = 0; k < fBPieces.size(); ++k) {
										if(fBPieces.get(k).getName().startsWith("Black Pawn") == true) {
											++pawnCount2;
											Pawn nPawn = new Pawn("Black", fBPieces.get(k).getPosition(), pawnCount2);
											nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
											fBRPieces.add(nPawn);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Knight") == true) {
											++knightCount2;
											Knight nKnight = new Knight("Black", fBPieces.get(k).getPosition(), knightCount2);
											fBRPieces.add(nKnight);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Knight") == true) {
											++promKCount2;
											Knight nKnight = new Knight("Black Promoted", fBPieces.get(k).getPosition(), promKCount2);
											fBRPieces.add(nKnight);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Bishop") == true) {
											++bishopCount2;
											Bishop nBishop = new Bishop("Black", fBPieces.get(k).getPosition(), bishopCount2);
											fBRPieces.add(nBishop);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Bishop") == true) {
											++promBCount2;
											Rook nBishop = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promBCount2);
											fBRPieces.add(nBishop);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Rook") == true) {
											++rookCount2;
											Rook nRook = new Rook("Black", fBPieces.get(k).getPosition(), rookCount2);
											fBRPieces.add(nRook);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Rook") == true) {
											++promRCount2;
											Rook nRook = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promRCount2);
											fBRPieces.add(nRook);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Queen") == true) {
											Queen nQueen = new Queen("Black", fBPieces.get(k).getPosition());
											fBRPieces.add(nQueen);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Queen") == true) {
											++promQCount2;
											Queen nQueen = new Queen("Black Promoted", fBPieces.get(k).getPosition(), promQCount2);
											fBRPieces.add(nQueen);
										}
										else if(fBPieces.get(k).getName().startsWith("Black King") == true) {
											King nKing = new King("Black", fBPieces.get(k).getPosition());
											fBRPieces.add(nKing);
										}
									}
									Rook promRook = new Rook("Black Promoted", fBPieces.get(i).getPosition(), promBCount2 + 1);
									fBRPieces.set(i, promBishop);
									GameState newBoardR = new GameState(gState.getState()[0], new ArrayList<Piece>(fBRPieces));
									theMoves.add(newBoardR);
									
									//Reset counters
									pawnCount2 = 0;
									knightCount2 = 0;
									bishopCount2 = 0;
									rookCount2 = 0;
									promKCount2 = 0;
									promBCount2 = 0;
									promRCount2 = 0;
									promQCount2 = 0;
									ArrayList <Piece> fBQPieces = new ArrayList<Piece>(); //Make new list for promotions
									//Create new deep copy for next promotion. Repeat till all promotions are completed
									for(int k = 0; k < fBPieces.size(); ++k) {
										if(fBPieces.get(k).getName().startsWith("Black Pawn") == true) {
											++pawnCount2;
											Pawn nPawn = new Pawn("Black", fBPieces.get(k).getPosition(), pawnCount2);
											nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
											fBQPieces.add(nPawn);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Knight") == true) {
											++knightCount2;
											Knight nKnight = new Knight("Black", fBPieces.get(k).getPosition(), knightCount2);
											fBQPieces.add(nKnight);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Knight") == true) {
											++promKCount2;
											Knight nKnight = new Knight("Black Promoted", fBPieces.get(k).getPosition(), promKCount2);
											fBQPieces.add(nKnight);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Bishop") == true) {
											++bishopCount2;
											Bishop nBishop = new Bishop("Black", fBPieces.get(k).getPosition(), bishopCount2);
											fBQPieces.add(nBishop);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Bishop") == true) {
											++promBCount2;
											Rook nBishop = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promBCount2);
											fBQPieces.add(nBishop);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Rook") == true) {
											++rookCount2;
											Rook nRook = new Rook("Black", fBPieces.get(k).getPosition(), rookCount2);
											fBQPieces.add(nRook);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Rook") == true) {
											++promRCount2;
											Rook nRook = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promRCount2);
											fBQPieces.add(nRook);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Queen") == true) {
											Queen nQueen = new Queen("Black", fBPieces.get(k).getPosition());
											fBQPieces.add(nQueen);
										}
										else if(fBPieces.get(k).getName().startsWith("Black Promoted Queen") == true) {
											++promQCount2;
											Queen nQueen = new Queen("Black Promoted", fBPieces.get(k).getPosition(), promQCount2);
											fBQPieces.add(nQueen);
										}
										else if(fBPieces.get(k).getName().startsWith("Black King") == true) {
											King nKing = new King("Black", fBPieces.get(k).getPosition());
											fBQPieces.add(nKing);
										}
									}
									Queen promQueen = new Queen("Black Promoted", fBPieces.get(i).getPosition(), promBCount2 + 1);
									fBQPieces.set(i, promBishop);
									GameState newBoardQ = new GameState(gState.getState()[0], new ArrayList<Piece>(fBQPieces));
									theMoves.add(newBoardQ);
									
							}
							else {
							GameState newBoard = new GameState(gState.getState()[0], fBPieces);
							theMoves.add(newBoard);
							}
						}
						
				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0;  j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Pawn)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						((Pawn)fBPieces.get(i)).addRank(1);
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						if(((Pawn)fBPieces.get(i)).getRank() == 8){
							int pawnCount2 = 0;
							int knightCount2 = 0;
							int bishopCount2 = 0;
							int rookCount2 = 0;
							int promKCount2 = 0;
							int promBCount2 = 0;
							int promRCount2 = 0;
							int promQCount2 = 0;
		
								ArrayList <Piece> fBKPieces = new ArrayList<Piece>(); //Make new list for promotions
								//Create a deep copy of white pieces to safely create new game states after a promotion
								for(int k = 0; k < fBPieces.size(); ++k) {
									if(fBPieces.get(k).getName().startsWith("Black Pawn") == true) {
										++pawnCount2;
										Pawn nPawn = new Pawn("Black", fBPieces.get(k).getPosition(), pawnCount2);
										nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
										fBKPieces.add(nPawn);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Knight") == true) {
										++knightCount2;
										Knight nKnight = new Knight("Black", fBPieces.get(k).getPosition(), knightCount2);
										fBKPieces.add(nKnight);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Knight") == true) {
										++promKCount2;
										Knight nKnight = new Knight("Black Promoted", fBPieces.get(k).getPosition(), promKCount2);
										fBKPieces.add(nKnight);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Bishop") == true) {
										++bishopCount2;
										Bishop nBishop = new Bishop("Black", fBPieces.get(k).getPosition(), bishopCount2);
										fBKPieces.add(nBishop);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Bishop") == true) {
										++promBCount2;
										Rook nBishop = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promBCount2);
										fBKPieces.add(nBishop);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Rook") == true) {
										++rookCount2;
										Rook nRook = new Rook("Black", fBPieces.get(k).getPosition(), rookCount2);
										fBKPieces.add(nRook);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Rook") == true) {
										++promRCount2;
										Rook nRook = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promRCount2);
										fBKPieces.add(nRook);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Queen") == true) {
										Queen nQueen = new Queen("Black", fBPieces.get(k).getPosition());
										fBKPieces.add(nQueen);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Queen") == true) {
										++promQCount2;
										Queen nQueen = new Queen("Black Promoted", fBPieces.get(k).getPosition(), promQCount2);
										fBKPieces.add(nQueen);
									}
									else if(fBPieces.get(k).getName().startsWith("Black King") == true) {
										King nKing = new King("Black", fBPieces.get(k).getPosition());
										fBKPieces.add(nKing);
									}
								}
								Knight promKnight = new Knight("Black Promoted", fBPieces.get(i).getPosition(), promKCount2 + 1);
								fBKPieces.set(i, promKnight);
								GameState newBoardK = new GameState(fWPieces, new ArrayList<Piece>(fBKPieces));
								theMoves.add(newBoardK);
								//Reset counters
								pawnCount2 = 0;
								knightCount2 = 0;
								bishopCount2 = 0;
								rookCount2 = 0;
								promKCount2 = 0;
								promBCount2 = 0;
								promRCount2 = 0;
								promQCount2 = 0;
								ArrayList <Piece> fBBPieces = new ArrayList<Piece>(); //Make new list for promotions
								//Create new deep copy for next promotion. Repeat till all promotions are completed
								for(int k = 0; k < fBPieces.size(); ++k) {
									if(fBPieces.get(k).getName().startsWith("Black Pawn") == true) {
										++pawnCount2;
										Pawn nPawn = new Pawn("Black", fBPieces.get(k).getPosition(), pawnCount2);
										nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
										fBBPieces.add(nPawn);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Knight") == true) {
										++knightCount2;
										Knight nKnight = new Knight("Black", fBPieces.get(k).getPosition(), knightCount2);
										fBBPieces.add(nKnight);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Knight") == true) {
										++promKCount2;
										Knight nKnight = new Knight("Black Promoted", fBPieces.get(k).getPosition(), promKCount2);
										fBBPieces.add(nKnight);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Bishop") == true) {
										++bishopCount2;
										Bishop nBishop = new Bishop("Black", fBPieces.get(k).getPosition(), bishopCount2);
										fBBPieces.add(nBishop);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Bishop") == true) {
										++promBCount2;
										Rook nBishop = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promBCount2);
										fBBPieces.add(nBishop);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Rook") == true) {
										++rookCount2;
										Rook nRook = new Rook("Black", fBPieces.get(k).getPosition(), rookCount2);
										fBBPieces.add(nRook);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Rook") == true) {
										++promRCount2;
										Rook nRook = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promRCount2);
										fBBPieces.add(nRook);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Queen") == true) {
										Queen nQueen = new Queen("Black", fBPieces.get(k).getPosition());
										fBBPieces.add(nQueen);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Queen") == true) {
										++promQCount2;
										Queen nQueen = new Queen("Black Promoted", fBPieces.get(k).getPosition(), promQCount2);
										fBBPieces.add(nQueen);
									}
									else if(fBPieces.get(k).getName().startsWith("Black King") == true) {
										King nKing = new King("Black", fBPieces.get(k).getPosition());
										fBBPieces.add(nKing);
									}
								}
								Bishop promBishop = new Bishop("Black Promoted", fBPieces.get(i).getPosition(), promBCount2 + 1);
								fBBPieces.set(i, promBishop);
								GameState newBoardB = new GameState(fWPieces, new ArrayList<Piece>(fBBPieces));
								theMoves.add(newBoardB);
								//Reset counters
								pawnCount2 = 0;
								knightCount2 = 0;
								bishopCount2 = 0;
								rookCount2 = 0;
								promKCount2 = 0;
								promBCount2 = 0;
								promRCount2 = 0;
								promQCount2 = 0;
								ArrayList <Piece> fBRPieces = new ArrayList<Piece>(); //Make new list for promotions
								//Create new deep copy for next promotion. Repeat till all promotions are completed
								for(int k = 0; k < fBPieces.size(); ++k) {
									if(fBPieces.get(k).getName().startsWith("Black Pawn") == true) {
										++pawnCount2;
										Pawn nPawn = new Pawn("Black", fBPieces.get(k).getPosition(), pawnCount2);
										nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
										fBRPieces.add(nPawn);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Knight") == true) {
										++knightCount2;
										Knight nKnight = new Knight("Black", fBPieces.get(k).getPosition(), knightCount2);
										fBRPieces.add(nKnight);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Knight") == true) {
										++promKCount2;
										Knight nKnight = new Knight("Black Promoted", fBPieces.get(k).getPosition(), promKCount2);
										fBRPieces.add(nKnight);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Bishop") == true) {
										++bishopCount2;
										Bishop nBishop = new Bishop("Black", fBPieces.get(k).getPosition(), bishopCount2);
										fBRPieces.add(nBishop);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Bishop") == true) {
										++promBCount2;
										Rook nBishop = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promBCount2);
										fBRPieces.add(nBishop);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Rook") == true) {
										++rookCount2;
										Rook nRook = new Rook("Black", fBPieces.get(k).getPosition(), rookCount2);
										fBRPieces.add(nRook);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Rook") == true) {
										++promRCount2;
										Rook nRook = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promRCount2);
										fBRPieces.add(nRook);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Queen") == true) {
										Queen nQueen = new Queen("Black", fBPieces.get(k).getPosition());
										fBRPieces.add(nQueen);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Queen") == true) {
										++promQCount2;
										Queen nQueen = new Queen("Black Promoted", fBPieces.get(k).getPosition(), promQCount2);
										fBRPieces.add(nQueen);
									}
									else if(fBPieces.get(k).getName().startsWith("Black King") == true) {
										King nKing = new King("Black", fBPieces.get(k).getPosition());
										fBRPieces.add(nKing);
									}
								}
								Rook promRook = new Rook("Black Promoted", fBPieces.get(i).getPosition(), promBCount2 + 1);
								fBRPieces.set(i, promBishop);
								GameState newBoardR = new GameState(fWPieces, new ArrayList<Piece>(fBRPieces));
								theMoves.add(newBoardR);
								
								//Reset counters
								pawnCount2 = 0;
								knightCount2 = 0;
								bishopCount2 = 0;
								rookCount2 = 0;
								promKCount2 = 0;
								promBCount2 = 0;
								promRCount2 = 0;
								promQCount2 = 0;
								ArrayList <Piece> fBQPieces = new ArrayList<Piece>(); //Make new list for promotions
								//Create new deep copy for next promotion. Repeat till all promotions are completed
								for(int k = 0; k < fBPieces.size(); ++k) {
									if(fBPieces.get(k).getName().startsWith("Black Pawn") == true) {
										++pawnCount2;
										Pawn nPawn = new Pawn("Black", fBPieces.get(k).getPosition(), pawnCount2);
										nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
										fBQPieces.add(nPawn);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Knight") == true) {
										++knightCount2;
										Knight nKnight = new Knight("Black", fBPieces.get(k).getPosition(), knightCount2);
										fBQPieces.add(nKnight);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Knight") == true) {
										++promKCount2;
										Knight nKnight = new Knight("Black Promoted", fBPieces.get(k).getPosition(), promKCount2);
										fBQPieces.add(nKnight);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Bishop") == true) {
										++bishopCount2;
										Bishop nBishop = new Bishop("Black", fBPieces.get(k).getPosition(), bishopCount2);
										fBQPieces.add(nBishop);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Bishop") == true) {
										++promBCount2;
										Rook nBishop = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promBCount2);
										fBQPieces.add(nBishop);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Rook") == true) {
										++rookCount2;
										Rook nRook = new Rook("Black", fBPieces.get(k).getPosition(), rookCount2);
										fBQPieces.add(nRook);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Rook") == true) {
										++promRCount2;
										Rook nRook = new Rook("Black Promoted", fBPieces.get(k).getPosition(), promRCount2);
										fBQPieces.add(nRook);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Queen") == true) {
										Queen nQueen = new Queen("Black", fBPieces.get(k).getPosition());
										fBQPieces.add(nQueen);
									}
									else if(fBPieces.get(k).getName().startsWith("Black Promoted Queen") == true) {
										++promQCount2;
										Queen nQueen = new Queen("Black Promoted", fBPieces.get(k).getPosition(), promQCount2);
										fBQPieces.add(nQueen);
									}
									else if(fBPieces.get(k).getName().startsWith("Black King") == true) {
										King nKing = new King("Black", fBPieces.get(k).getPosition());
										fBQPieces.add(nKing);
									}
								}
								Queen promQueen = new Queen("Black Promoted", fBPieces.get(i).getPosition(), promBCount2 + 1);
								fBQPieces.set(i, promBishop);
								GameState newBoardQ = new GameState(fWPieces, new ArrayList<Piece>(fBQPieces));
								theMoves.add(newBoardQ);
								
						}
						else {
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
						}
					}
				}
				
			}
			else if(gState.getState()[1].get(i).getName().startsWith("Black Knight") == true) {
				Knight theKnight = (Knight)gState.getState()[1].get(i);
				ArrayList [] positions = theKnight.getBPositions(theKnight, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Knight)fBPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(gState.getState()[0], fBPieces);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Knight)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			else if(gState.getState()[1].get(i).getName().startsWith("Black Promoted Knight") == true) {
				Knight theKnight = (Knight)gState.getState()[1].get(i);
				ArrayList [] positions = theKnight.getBPositions(theKnight, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Knight)fBPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(gState.getState()[0], fBPieces);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Knight)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			else if(gState.getState()[1].get(i).getName().startsWith("Black Bishop")) {
				Bishop theBishop = (Bishop)gState.getState()[1].get(i);
				ArrayList [] positions = theBishop.getBPositions(theBishop, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Bishop)fBPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(gState.getState()[0], fBPieces);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Bishop)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			else if(gState.getState()[1].get(i).getName().startsWith("Black Promoted Bishop")) {
				Bishop theBishop = (Bishop)gState.getState()[1].get(i);
				ArrayList [] positions = theBishop.getBPositions(theBishop, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Bishop)fBPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(gState.getState()[0], fBPieces);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Bishop)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			else if(gState.getState()[1].get(i).getName().startsWith("Black Rook")) {
				Rook theRook = (Rook)gState.getState()[1].get(i);
				ArrayList [] positions = theRook.getBPositions(theRook, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Rook)fBPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(gState.getState()[0], fBPieces);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Rook)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			else if(gState.getState()[1].get(i).getName().startsWith("Black Promoted Rook")) {
				Rook theRook = (Rook)gState.getState()[1].get(i);
				ArrayList [] positions = theRook.getBPositions(theRook, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Rook)fBPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(gState.getState()[0], fBPieces);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Rook)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			else if(gState.getState()[1].get(i).getName().startsWith("Black Queen")) {
				Queen theQueen = (Queen)gState.getState()[1].get(i);
				ArrayList [] positions = theQueen.getWPositions(theQueen, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Queen)fBPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(gState.getState()[0], fBPieces);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Queen)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			else if(gState.getState()[1].get(i).getName().startsWith("Black Promoted Queen")) {
				Queen theQueen = (Queen)gState.getState()[1].get(i);
				ArrayList [] positions = theQueen.getWPositions(theQueen, theBoard, gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Queen)fBPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(gState.getState()[0], fBPieces);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((Queen)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			else if(gState.getState()[1].get(i).getName().startsWith("Black King")) {
				King theKing = (King)gState.getState()[1].get(i);
				ArrayList [] positions = theKing.getWPositions(theKing, theBoard,gState.getState()[0], gState.getState()[1]);
				ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
				ArrayList <String> rPositions = positions[0]; // List of possible regular positions
				if(rPositions.isEmpty() == false) {
					for(int j = 0; j < rPositions.size(); ++j) {
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((King)fBPieces.get(i)).setPosition(rPositions.get(j));
						GameState newBoard = new GameState(gState.getState()[0], fBPieces);
						theMoves.add(newBoard);
					}

				}
				if(cPieces.isEmpty() == false) {
					for(int j = 0; j < cPieces.size(); ++j) {
						ArrayList <Piece> fWPieces = new ArrayList<Piece>();
						int pawnCount = 0;
						int knightCount = 0;
						int bishopCount = 0;
						int rookCount = 0;
						int promKCount = 0;
						int promBCount = 0;
						int promRCount = 0;
						int promQCount = 0;
						//Make a deep copy of the white pieces
						for(int k = 0; k < gState.getState()[0].size(); ++k) {
							if(gState.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
								++pawnCount;
								Pawn nPawn = new Pawn("White", gState.getState()[0].get(k).getPosition(), pawnCount);
								nPawn.setRank(((Pawn) gState.getState()[0].get(k)).getRank());
								fWPieces.add(nPawn);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Knight") == true) {
								++knightCount;
								Knight nKnight = new Knight("White", gState.getState()[0].get(k).getPosition(), knightCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
								++promKCount;
								Knight nKnight = new Knight("White Promoted", gState.getState()[0].get(k).getPosition(), promKCount);
								fWPieces.add(nKnight);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
								++bishopCount;
								Bishop nBishop = new Bishop("White", gState.getState()[0].get(k).getPosition(), bishopCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
								++promBCount;
								Rook nBishop = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promBCount);
								fWPieces.add(nBishop);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Rook") == true) {
								++rookCount;
								Rook nRook = new Rook("White", gState.getState()[0].get(k).getPosition(), rookCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
								++promRCount;
								Rook nRook = new Rook("White Promoted", gState.getState()[0].get(k).getPosition(), promRCount);
								fWPieces.add(nRook);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Queen") == true) {
								Queen nQueen = new Queen("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
								++promQCount;
								Queen nQueen = new Queen("White Promoted", gState.getState()[0].get(k).getPosition(), promQCount);
								fWPieces.add(nQueen);
							}
							else if(gState.getState()[0].get(k).getName().startsWith("White King") == true) {
								King nKing = new King("White", gState.getState()[0].get(k).getPosition());
								fWPieces.add(nKing);
							}
						}
						ArrayList <Piece> fBPieces = new ArrayList<Piece>();
						int pawnCountB = 0;
						int knightCountB = 0;
						int bishopCountB = 0;
						int rookCountB = 0;
						int promKCountB = 0;
						int promBCountB = 0;
						int promRCountB = 0;
						int promQCountB = 0;
						//Make a deep copy of the black pieces
						for(int k = 0; k < gState.getState()[1].size(); ++k) {
							if(gState.getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
								++pawnCountB;
								Pawn nPawn = new Pawn("Black", gState.getState()[1].get(k).getPosition(), pawnCountB);
								nPawn.setRank(((Pawn) gState.getState()[1].get(k)).getRank());
								fBPieces.add(nPawn);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Knight") == true) {
								++knightCountB;
								Knight nKnight = new Knight("Black", gState.getState()[1].get(k).getPosition(), knightCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
								++promKCountB;
								Knight nKnight = new Knight("Black Promoted", gState.getState()[1].get(k).getPosition(), promKCountB);
								fBPieces.add(nKnight);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
								++bishopCountB;
								Bishop nBishop = new Bishop("Black", gState.getState()[1].get(k).getPosition(), bishopCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
								++promBCountB;
								Bishop nBishop = new Bishop("Black Promoted", gState.getState()[1].get(k).getPosition(), promBCountB);
								fBPieces.add(nBishop);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Rook") == true) {
								++rookCountB;
								Rook nRook = new Rook("Black", gState.getState()[1].get(k).getPosition(), rookCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
								++promRCountB;
								Rook nRook = new Rook("Black Promoted", gState.getState()[1].get(k).getPosition(), promRCountB);
								fBPieces.add(nRook);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Queen") == true) {
								Queen nQueen = new Queen("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
								++promQCountB;
								Queen nQueen = new Queen("Black Promoted", gState.getState()[1].get(k).getPosition(), promQCountB);
								fBPieces.add(nQueen);
							}
							else if(gState.getState()[1].get(k).getName().startsWith("Black King") == true) {
								King nKing = new King("Black", gState.getState()[1].get(k).getPosition());
								fBPieces.add(nKing);
							}
						}
						((King)fBPieces.get(i)).setPosition(cPieces.get(j).getPosition());
						for(int k = 0; k < fWPieces.size(); ++k) {
							if(cPieces.get(j).getName().equals(fWPieces.get(k).getName())) { //If capture piece is found in list
								fWPieces.remove(k);
							}
						}
						GameState newBoard = new GameState(fWPieces, fBPieces);
						theMoves.add(newBoard);
					}
					
				}
			}
			
		}
		
		return theMoves;
	}
	
	public ArrayList <Piece> [] getState() {
		return theState;
	}
	
	//Method that alters the current game state to represent making a move
	//Returns a GameState that represents the previous state of the game
	public GameState makeMove(GameState prevState, GameState newState) {
		GameState stateTracker = prevState;
		prevState = newState;
		return prevState;
		
	}
	
	public boolean end() {
		boolean gameEndW = true;
		boolean gameEndB = true;
		for(int i = 0; i < theState[0].size(); ++i) {
			if(theState[0].get(i).getName().equals("White King") == true){
				gameEndW = false;
				break;
			}
			else {
				gameEndW = true;
			}
		}
		for(int i = 0; i < theState[1].size(); ++i) {
			if(theState[1].get(i).getName().equals("Black King")){
				gameEndB = false;
				break;
			}
			else {
				gameEndB = true;
			}
		}
		return gameEndW || gameEndB;
	}
}
