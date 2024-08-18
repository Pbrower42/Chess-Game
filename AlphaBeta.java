import java.util.ArrayList;
import java.util.Random;

public class AlphaBeta {
	
	
	//int alpha;
	
	//int beta;
	
	//GameState bState;
	
	String mainColor;
	
	public AlphaBeta(String m) {
		mainColor = m;
	}
	
	/*
	 * The minimax function for an alpha/beta player.
	 */
	public int maxValue(GameState g, int alpha, int beta, int depth, String mColor) {
		int a = alpha;
		int b = beta;
		int d = depth;
		if(d == 0 || g.end() == true) {
			return evaluation(g, mColor); 
		}
		ArrayList <GameState> moves;
		if(mColor == "White") {
			moves = g.getWMoves(g);
		}
		else {
			moves = g.getBMoves(g);
		}
		Random r = new Random();
		GameState bState = moves.get(r.nextInt(moves.size()));
		ArrayList<Piece> wPieces = new ArrayList<Piece>();
		int pawnCount = 0;
		int knightCount = 0;
		int bishopCount = 0;
		int rookCount = 0;
		int promKCount = 0;
		int promBCount = 0;
		int promRCount = 0;
		int promQCount = 0;
		//Make deep copy of original game state. Must copy each set of pieces individually
		for(int i = 0; i < g.getState()[0].size(); ++i) {
			if(g.getState()[0].get(i).getName().startsWith("White Pawn") == true) {
				++pawnCount;
				Pawn nPawn = new Pawn("White", g.getState()[0].get(i).getPosition(), pawnCount);
				nPawn.setRank(((Pawn) g.getState()[0].get(i)).getRank());
				wPieces.add(nPawn);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Knight") == true) {
				++knightCount;
				Knight nKnight = new Knight("White", g.getState()[0].get(i).getPosition(), knightCount);
				wPieces.add(nKnight);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Knight") == true) {
				++promKCount;
				Knight nKnight = new Knight("White Promoted", g.getState()[0].get(i).getPosition(), promKCount);
				wPieces.add(nKnight);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Bishop") == true) {
				++bishopCount;
				Bishop nBishop = new Bishop("White", g.getState()[0].get(i).getPosition(), bishopCount);
				wPieces.add(nBishop);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Bishop") == true) {
				++promBCount;
				Rook nBishop = new Rook("White Promoted", g.getState()[0].get(i).getPosition(), promBCount);
				wPieces.add(nBishop);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Rook") == true) {
				++rookCount;
				Rook nRook = new Rook("White", g.getState()[0].get(i).getPosition(), rookCount);
				wPieces.add(nRook);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Rook") == true) {
				++promRCount;
				Rook nRook = new Rook("White Promoted", g.getState()[0].get(i).getPosition(), promRCount);
				wPieces.add(nRook);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Queen") == true) {
				Queen nQueen = new Queen("White", g.getState()[0].get(i).getPosition());
				wPieces.add(nQueen);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Queen") == true) {
				++promQCount;
				Queen nQueen = new Queen("White Promoted", g.getState()[0].get(i).getPosition(), promQCount);
				wPieces.add(nQueen);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White King") == true) {
				King nKing = new King("White", g.getState()[0].get(i).getPosition());
				wPieces.add(nKing);
			}
			
		}
		ArrayList <Piece> bPieces = new ArrayList<Piece>();
		int pawnCountB = 0;
		int knightCountB = 0;
		int bishopCountB = 0;
		int rookCountB = 0;
		int promKCountB = 0;
		int promBCountB = 0;
		int promRCountB = 0;
		int promQCountB = 0;
		//Make a deep copy of the black pieces
		for(int i = 0; i < g.getState()[1].size(); ++i) {
			if(g.getState()[1].get(i).getName().startsWith("Black Pawn") == true) {
				++pawnCountB;
				Pawn nPawn = new Pawn("Black", g.getState()[1].get(i).getPosition(), pawnCountB);
				nPawn.setRank(((Pawn) g.getState()[1].get(i)).getRank());
				bPieces.add(nPawn);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Knight") == true) {
				++knightCountB;
				Knight nKnight = new Knight("Black", g.getState()[1].get(i).getPosition(), knightCountB);
				bPieces.add(nKnight);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Knight") == true) {
				++promKCountB;
				Knight nKnight = new Knight("Black Promoted", g.getState()[1].get(i).getPosition(), promKCountB);
				bPieces.add(nKnight);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Bishop") == true) {
				++bishopCountB;
				Bishop nBishop = new Bishop("Black", g.getState()[1].get(i).getPosition(), bishopCountB);
				bPieces.add(nBishop);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Bishop") == true) {
				++promBCountB;
				Bishop nBishop = new Bishop("Black Promoted", g.getState()[1].get(i).getPosition(), promBCountB);
				bPieces.add(nBishop);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Rook") == true) {
				++rookCountB;
				Rook nRook = new Rook("Black", g.getState()[1].get(i).getPosition(), rookCountB);
				bPieces.add(nRook);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Rook") == true) {
				++promRCountB;
				Rook nRook = new Rook("Black Promoted", g.getState()[1].get(i).getPosition(), promRCountB);
				bPieces.add(nRook);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Queen") == true) {
				Queen nQueen = new Queen("Black", g.getState()[1].get(i).getPosition());
				bPieces.add(nQueen);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Queen") == true) {
				++promQCountB;
				Queen nQueen = new Queen("Black Promoted", g.getState()[1].get(i).getPosition(), promQCountB);
				bPieces.add(nQueen);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black King") == true) {
				King nKing = new King("Black", g.getState()[1].get(i).getPosition());
				bPieces.add(nKing);
			}
		}
		for(int i = 0; i < moves.size(); ++i) { //Loop through moves
			ArrayList<Piece> wMPieces = new ArrayList<Piece>();
			int pawnCount2 = 0;
			int knightCount2 = 0;
			int bishopCount2 = 0;
			int rookCount2 = 0;
			int promKCount2 = 0;
			int promBCount2 = 0;
			int promRCount2 = 0;
			int promQCount2 = 0;
			//Make deep copy of original game state. Must copy each set of pieces individually
			for(int k = 0; k < moves.get(i).getState()[0].size(); ++k) {
				if(moves.get(i).getState()[0].get(k).getName().startsWith("White Pawn") == true) {
					++pawnCount2;
					Pawn nPawn = new Pawn("White", moves.get(i).getState()[0].get(k).getPosition(), pawnCount2);
					nPawn.setRank(((Pawn) moves.get(i).getState()[0].get(k)).getRank());
					wMPieces.add(nPawn);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Knight") == true) {
					++knightCount2;
					Knight nKnight = new Knight("White", moves.get(i).getState()[0].get(k).getPosition(), knightCount2);
					wMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
					++promKCount2;
					Knight nKnight = new Knight("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promKCount2);
					wMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Bishop") == true) {
					++bishopCount2;
					Bishop nBishop = new Bishop("White", moves.get(i).getState()[0].get(k).getPosition(), bishopCount2);
					wMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
					++promBCount2;
					Rook nBishop = new Rook("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promBCount2);
					wMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Rook") == true) {
					++rookCount2;
					Rook nRook = new Rook("White", moves.get(i).getState()[0].get(k).getPosition(), rookCount2);
					wMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
					++promRCount2;
					Rook nRook = new Rook("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promRCount2);
					wMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Queen") == true) {
					Queen nQueen = new Queen("White", moves.get(i).getState()[0].get(k).getPosition());
					wMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
					++promQCount2;
					Queen nQueen = new Queen("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promQCount2);
					wMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White King") == true) {
					King nKing = new King("White", g.getState()[0].get(k).getPosition());
					wMPieces.add(nKing);
				}
				
			}
			ArrayList <Piece> bMPieces = new ArrayList<Piece>();
			int pawnCountB2 = 0;
			int knightCountB2 = 0;
			int bishopCountB2 = 0;
			int rookCountB2 = 0;
			int promKCountB2 = 0;
			int promBCountB2 = 0;
			int promRCountB2 = 0;
			int promQCountB2 = 0;
			//Make a deep copy of the black pieces
			for(int k = 0; k < moves.get(i).getState()[1].size(); ++k) {
				if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
					++pawnCountB2;
					Pawn nPawn = new Pawn("Black", (moves.get(i).getState()[1].get(k).getPosition()), pawnCountB2);
					nPawn.setRank(((Pawn) moves.get(i).getState()[1].get(k)).getRank());
					bMPieces.add(nPawn);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Knight") == true) {
					++knightCountB2;
					Knight nKnight = new Knight("Black", moves.get(i).getState()[1].get(k).getPosition(), knightCountB2);
					bMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
					++promKCountB2;
					Knight nKnight = new Knight("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promKCountB2);
					bMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
					++bishopCountB2;
					Bishop nBishop = new Bishop("Black", moves.get(i).getState()[1].get(k).getPosition(), bishopCountB2);
					bMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
					++promBCountB2;
					Bishop nBishop = new Bishop("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promBCountB2);
					bMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Rook") == true) {
					++rookCountB2;
					Rook nRook = new Rook("Black", moves.get(i).getState()[1].get(k).getPosition(), rookCountB2);
					bMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
					++promRCountB2;
					Rook nRook = new Rook("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promRCountB2);
					bMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Queen") == true) {
					Queen nQueen = new Queen("Black", moves.get(i).getState()[1].get(k).getPosition());
					bMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
					++promQCountB2;
					Queen nQueen = new Queen("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promQCountB2);
					bMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black King") == true) {
					King nKing = new King("Black", moves.get(i).getState()[1].get(k).getPosition());
					bMPieces.add(nKing);
				}
			}
			if(mColor.equals("White")) {
				mColor = "Black";
			}
			else {
				mColor = "White";
			}
			//Making the move
			g = new GameState(wMPieces, bMPieces);
			int currentVal = minValue(g, a, b, d-1, mColor);
			if(currentVal > a) {
				bState = new GameState(wMPieces, bMPieces);
				a = currentVal;
			}
			//Undoing the move
			g = new GameState(wPieces, bPieces);
			if(a >= b) {
			//	System.out.println("s");
				return currentVal;
			}
		}
		//System.out.println("f");
		return a;
		
	}
	
	public GameState makeMaxValueMove(GameState g, int alpha, int beta, int depth, String mColor) {
		int a = alpha;
		int b = beta;
		int d = depth;
		
		ArrayList <GameState> moves;
		if(mColor == "White") {
			moves = g.getWMoves(g);
		}
		else {
			moves = g.getBMoves(g);
		}
		Random r = new Random();
		GameState bState = moves.get(r.nextInt(moves.size()));
		ArrayList<Piece> wPieces = new ArrayList<Piece>();
		int pawnCount = 0;
		int knightCount = 0;
		int bishopCount = 0;
		int rookCount = 0;
		int promKCount = 0;
		int promBCount = 0;
		int promRCount = 0;
		int promQCount = 0;
		//Make deep copy of original game state. Must copy each set of pieces individually
		for(int i = 0; i < g.getState()[0].size(); ++i) {
			if(g.getState()[0].get(i).getName().startsWith("White Pawn") == true) {
				++pawnCount;
				Pawn nPawn = new Pawn("White", g.getState()[0].get(i).getPosition(), pawnCount);
				nPawn.setRank(((Pawn) g.getState()[0].get(i)).getRank());
				wPieces.add(nPawn);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Knight") == true) {
				++knightCount;
				Knight nKnight = new Knight("White", g.getState()[0].get(i).getPosition(), knightCount);
				wPieces.add(nKnight);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Knight") == true) {
				++promKCount;
				Knight nKnight = new Knight("White Promoted", g.getState()[0].get(i).getPosition(), promKCount);
				wPieces.add(nKnight);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Bishop") == true) {
				++bishopCount;
				Bishop nBishop = new Bishop("White", g.getState()[0].get(i).getPosition(), bishopCount);
				wPieces.add(nBishop);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Bishop") == true) {
				++promBCount;
				Rook nBishop = new Rook("White Promoted", g.getState()[0].get(i).getPosition(), promBCount);
				wPieces.add(nBishop);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Rook") == true) {
				++rookCount;
				Rook nRook = new Rook("White", g.getState()[0].get(i).getPosition(), rookCount);
				wPieces.add(nRook);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Rook") == true) {
				++promRCount;
				Rook nRook = new Rook("White Promoted", g.getState()[0].get(i).getPosition(), promRCount);
				wPieces.add(nRook);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Queen") == true) {
				Queen nQueen = new Queen("White", g.getState()[0].get(i).getPosition());
				wPieces.add(nQueen);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Queen") == true) {
				++promQCount;
				Queen nQueen = new Queen("White Promoted", g.getState()[0].get(i).getPosition(), promQCount);
				wPieces.add(nQueen);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White King") == true) {
				King nKing = new King("White", g.getState()[0].get(i).getPosition());
				wPieces.add(nKing);
			}
			
		}
		ArrayList <Piece> bPieces = new ArrayList<Piece>();
		int pawnCountB = 0;
		int knightCountB = 0;
		int bishopCountB = 0;
		int rookCountB = 0;
		int promKCountB = 0;
		int promBCountB = 0;
		int promRCountB = 0;
		int promQCountB = 0;
		//Make a deep copy of the black pieces
		for(int i = 0; i < g.getState()[1].size(); ++i) {
			if(g.getState()[1].get(i).getName().startsWith("Black Pawn") == true) {
				++pawnCountB;
				Pawn nPawn = new Pawn("Black", g.getState()[1].get(i).getPosition(), pawnCountB);
				nPawn.setRank(((Pawn) g.getState()[1].get(i)).getRank());
				bPieces.add(nPawn);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Knight") == true) {
				++knightCountB;
				Knight nKnight = new Knight("Black", g.getState()[1].get(i).getPosition(), knightCountB);
				bPieces.add(nKnight);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Knight") == true) {
				++promKCountB;
				Knight nKnight = new Knight("Black Promoted", g.getState()[1].get(i).getPosition(), promKCountB);
				bPieces.add(nKnight);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Bishop") == true) {
				++bishopCountB;
				Bishop nBishop = new Bishop("Black", g.getState()[1].get(i).getPosition(), bishopCountB);
				bPieces.add(nBishop);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Bishop") == true) {
				++promBCountB;
				Bishop nBishop = new Bishop("Black Promoted", g.getState()[1].get(i).getPosition(), promBCountB);
				bPieces.add(nBishop);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Rook") == true) {
				++rookCountB;
				Rook nRook = new Rook("Black", g.getState()[1].get(i).getPosition(), rookCountB);
				bPieces.add(nRook);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Rook") == true) {
				++promRCountB;
				Rook nRook = new Rook("Black Promoted", g.getState()[1].get(i).getPosition(), promRCountB);
				bPieces.add(nRook);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Queen") == true) {
				Queen nQueen = new Queen("Black", g.getState()[1].get(i).getPosition());
				bPieces.add(nQueen);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Queen") == true) {
				++promQCountB;
				Queen nQueen = new Queen("Black Promoted", g.getState()[1].get(i).getPosition(), promQCountB);
				bPieces.add(nQueen);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black King") == true) {
				King nKing = new King("Black", g.getState()[1].get(i).getPosition());
				bPieces.add(nKing);
			}
		}
		for(int i = 0; i < moves.size(); ++i) { //Loop through moves
			ArrayList<Piece> wMPieces = new ArrayList<Piece>();
			int pawnCount2 = 0;
			int knightCount2 = 0;
			int bishopCount2 = 0;
			int rookCount2 = 0;
			int promKCount2 = 0;
			int promBCount2 = 0;
			int promRCount2 = 0;
			int promQCount2 = 0;
			//Make deep copy of original game state. Must copy each set of pieces individually
			for(int k = 0; k < moves.get(i).getState()[0].size(); ++k) {
				if(moves.get(i).getState()[0].get(k).getName().startsWith("White Pawn") == true) {
					++pawnCount2;
					Pawn nPawn = new Pawn("White", moves.get(i).getState()[0].get(k).getPosition(), pawnCount2);
					nPawn.setRank(((Pawn) moves.get(i).getState()[0].get(k)).getRank());
					wMPieces.add(nPawn);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Knight") == true) {
					++knightCount2;
					Knight nKnight = new Knight("White", moves.get(i).getState()[0].get(k).getPosition(), knightCount2);
					wMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
					++promKCount2;
					Knight nKnight = new Knight("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promKCount2);
					wMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Bishop") == true) {
					++bishopCount2;
					Bishop nBishop = new Bishop("White", moves.get(i).getState()[0].get(k).getPosition(), bishopCount2);
					wMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
					++promBCount2;
					Rook nBishop = new Rook("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promBCount2);
					wMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Rook") == true) {
					++rookCount2;
					Rook nRook = new Rook("White", moves.get(i).getState()[0].get(k).getPosition(), rookCount2);
					wMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
					++promRCount2;
					Rook nRook = new Rook("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promRCount2);
					wMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Queen") == true) {
					Queen nQueen = new Queen("White", moves.get(i).getState()[0].get(k).getPosition());
					wMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
					++promQCount2;
					Queen nQueen = new Queen("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promQCount2);
					wMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White King") == true) {
					King nKing = new King("White", g.getState()[0].get(k).getPosition());
					wMPieces.add(nKing);
				}
				
			}
			ArrayList <Piece> bMPieces = new ArrayList<Piece>();
			int pawnCountB2 = 0;
			int knightCountB2 = 0;
			int bishopCountB2 = 0;
			int rookCountB2 = 0;
			int promKCountB2 = 0;
			int promBCountB2 = 0;
			int promRCountB2 = 0;
			int promQCountB2 = 0;
			//Make a deep copy of the black pieces
			for(int k = 0; k < moves.get(i).getState()[1].size(); ++k) {
				if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
					++pawnCountB2;
					Pawn nPawn = new Pawn("Black", (moves.get(i).getState()[1].get(k).getPosition()), pawnCountB2);
					nPawn.setRank(((Pawn) moves.get(i).getState()[1].get(k)).getRank());
					bMPieces.add(nPawn);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Knight") == true) {
					++knightCountB2;
					Knight nKnight = new Knight("Black", moves.get(i).getState()[1].get(k).getPosition(), knightCountB2);
					bMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
					++promKCountB2;
					Knight nKnight = new Knight("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promKCountB2);
					bMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
					++bishopCountB2;
					Bishop nBishop = new Bishop("Black", moves.get(i).getState()[1].get(k).getPosition(), bishopCountB2);
					bMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
					++promBCountB2;
					Bishop nBishop = new Bishop("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promBCountB2);
					bMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Rook") == true) {
					++rookCountB2;
					Rook nRook = new Rook("Black", moves.get(i).getState()[1].get(k).getPosition(), rookCountB2);
					bMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
					++promRCountB2;
					Rook nRook = new Rook("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promRCountB2);
					bMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Queen") == true) {
					Queen nQueen = new Queen("Black", moves.get(i).getState()[1].get(k).getPosition());
					bMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
					++promQCountB2;
					Queen nQueen = new Queen("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promQCountB2);
					bMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black King") == true) {
					King nKing = new King("Black", moves.get(i).getState()[1].get(k).getPosition());
					bMPieces.add(nKing);
				}
			}
			//Making the move
			if(mColor.equals("White")) {
				mColor = "Black";
			}
			else {
				mColor = "White";
			}
			g = new GameState(wMPieces, bMPieces);
			int currentVal = minValue(g, a, b, d-1, mColor);
			if(currentVal > a) {
				bState = new GameState(wMPieces, bMPieces);
				a = currentVal;
			}
			//Undoing the move
			g = new GameState(wPieces, bPieces);
			if(a >= b) {
			//	System.out.println("s");
				g = bState;
				return bState;
			}
		}
		//System.out.println("f");
		g = bState;
		return bState;
		
	}
	
	public int minValue(GameState g, int alpha, int beta, int depth, String mColor) {
		int a = alpha;
		int b = beta;
		int d = depth;
		if(d == 0 || g.end() == true) {
			return evaluation(g, mColor); 
		}
		ArrayList <GameState> moves;
		if(mColor == "White") {
			moves = g.getWMoves(g);
		}
		else {
			moves = g.getBMoves(g);
		}
		Random r = new Random();
		GameState bState = moves.get(r.nextInt(moves.size()));
		ArrayList<Piece> wPieces = new ArrayList<Piece>();
		int pawnCount = 0;
		int knightCount = 0;
		int bishopCount = 0;
		int rookCount = 0;
		int promKCount = 0;
		int promBCount = 0;
		int promRCount = 0;
		int promQCount = 0;
		//Make deep copy of original game state. Must copy each set of pieces individually
		for(int i = 0; i < g.getState()[0].size(); ++i) {
			if(g.getState()[0].get(i).getName().startsWith("White Pawn") == true) {
				++pawnCount;
				Pawn nPawn = new Pawn("White", g.getState()[0].get(i).getPosition(), pawnCount);
				nPawn.setRank(((Pawn) g.getState()[0].get(i)).getRank());
				wPieces.add(nPawn);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Knight") == true) {
				++knightCount;
				Knight nKnight = new Knight("White", g.getState()[0].get(i).getPosition(), knightCount);
				wPieces.add(nKnight);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Knight") == true) {
				++promKCount;
				Knight nKnight = new Knight("White Promoted", g.getState()[0].get(i).getPosition(), promKCount);
				wPieces.add(nKnight);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Bishop") == true) {
				++bishopCount;
				Bishop nBishop = new Bishop("White", g.getState()[0].get(i).getPosition(), bishopCount);
				wPieces.add(nBishop);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Bishop") == true) {
				++promBCount;
				Rook nBishop = new Rook("White Promoted", g.getState()[0].get(i).getPosition(), promBCount);
				wPieces.add(nBishop);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Rook") == true) {
				++rookCount;
				Rook nRook = new Rook("White", g.getState()[0].get(i).getPosition(), rookCount);
				wPieces.add(nRook);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Rook") == true) {
				++promRCount;
				Rook nRook = new Rook("White Promoted", g.getState()[0].get(i).getPosition(), promRCount);
				wPieces.add(nRook);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Queen") == true) {
				Queen nQueen = new Queen("White", g.getState()[0].get(i).getPosition());
				wPieces.add(nQueen);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White Promoted Queen") == true) {
				++promQCount;
				Queen nQueen = new Queen("White Promoted", g.getState()[0].get(i).getPosition(), promQCount);
				wPieces.add(nQueen);
			}
			else if(g.getState()[0].get(i).getName().startsWith("White King") == true) {
				King nKing = new King("White", g.getState()[0].get(i).getPosition());
				wPieces.add(nKing);
			}
			
		}
		ArrayList <Piece> bPieces = new ArrayList<Piece>();
		int pawnCountB = 0;
		int knightCountB = 0;
		int bishopCountB = 0;
		int rookCountB = 0;
		int promKCountB = 0;
		int promBCountB = 0;
		int promRCountB = 0;
		int promQCountB = 0;
		//Make a deep copy of the black pieces
		for(int i = 0; i < g.getState()[1].size(); ++i) {
			if(g.getState()[1].get(i).getName().startsWith("Black Pawn") == true) {
				++pawnCountB;
				Pawn nPawn = new Pawn("Black", g.getState()[1].get(i).getPosition(), pawnCountB);
				nPawn.setRank(((Pawn) g.getState()[1].get(i)).getRank());
				bPieces.add(nPawn);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Knight") == true) {
				++knightCountB;
				Knight nKnight = new Knight("Black", g.getState()[1].get(i).getPosition(), knightCountB);
				bPieces.add(nKnight);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Knight") == true) {
				++promKCountB;
				Knight nKnight = new Knight("Black Promoted", g.getState()[1].get(i).getPosition(), promKCountB);
				bPieces.add(nKnight);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Bishop") == true) {
				++bishopCountB;
				Bishop nBishop = new Bishop("Black", g.getState()[1].get(i).getPosition(), bishopCountB);
				bPieces.add(nBishop);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Bishop") == true) {
				++promBCountB;
				Bishop nBishop = new Bishop("Black Promoted", g.getState()[1].get(i).getPosition(), promBCountB);
				bPieces.add(nBishop);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Rook") == true) {
				++rookCountB;
				Rook nRook = new Rook("Black", g.getState()[1].get(i).getPosition(), rookCountB);
				bPieces.add(nRook);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Rook") == true) {
				++promRCountB;
				Rook nRook = new Rook("Black Promoted", g.getState()[1].get(i).getPosition(), promRCountB);
				bPieces.add(nRook);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Queen") == true) {
				Queen nQueen = new Queen("Black", g.getState()[1].get(i).getPosition());
				bPieces.add(nQueen);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black Promoted Queen") == true) {
				++promQCountB;
				Queen nQueen = new Queen("Black Promoted", g.getState()[1].get(i).getPosition(), promQCountB);
				bPieces.add(nQueen);
			}
			else if(g.getState()[1].get(i).getName().startsWith("Black King") == true) {
				King nKing = new King("Black", g.getState()[1].get(i).getPosition());
				bPieces.add(nKing);
			}
		}
		for(int i = 0; i < moves.size(); ++i) {
			ArrayList<Piece> wMPieces = new ArrayList<Piece>();
			int pawnCount2 = 0;
			int knightCount2 = 0;
			int bishopCount2 = 0;
			int rookCount2 = 0;
			int promKCount2 = 0;
			int promBCount2 = 0;
			int promRCount2 = 0;
			int promQCount2 = 0;
			//Make deep copy of original game state. Must copy each set of pieces individually
			for(int k = 0; k < moves.get(i).getState()[0].size(); ++k) {
				if(moves.get(i).getState()[0].get(k).getName().startsWith("White Pawn") == true) {
					++pawnCount2;
					Pawn nPawn = new Pawn("White", moves.get(i).getState()[0].get(k).getPosition(), pawnCount2);
					nPawn.setRank(((Pawn) moves.get(i).getState()[0].get(k)).getRank());
					wMPieces.add(nPawn);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Knight") == true) {
					++knightCount2;
					Knight nKnight = new Knight("White", moves.get(i).getState()[0].get(k).getPosition(), knightCount2);
					wMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Knight") == true) {
					++promKCount2;
					Knight nKnight = new Knight("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promKCount2);
					wMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Bishop") == true) {
					++bishopCount2;
					Bishop nBishop = new Bishop("White", moves.get(i).getState()[0].get(k).getPosition(), bishopCount2);
					wMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Bishop") == true) {
					++promBCount2;
					Rook nBishop = new Rook("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promBCount2);
					wMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Rook") == true) {
					++rookCount2;
					Rook nRook = new Rook("White", moves.get(i).getState()[0].get(k).getPosition(), rookCount2);
					wMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Rook") == true) {
					++promRCount2;
					Rook nRook = new Rook("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promRCount2);
					wMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Queen") == true) {
					Queen nQueen = new Queen("White", moves.get(i).getState()[0].get(k).getPosition());
					wMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
					++promQCount2;
					Queen nQueen = new Queen("White Promoted", moves.get(i).getState()[0].get(k).getPosition(), promQCount2);
					wMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[0].get(k).getName().startsWith("White King") == true) {
					King nKing = new King("White", g.getState()[0].get(k).getPosition());
					wMPieces.add(nKing);
				}
				
			}
			ArrayList <Piece> bMPieces = new ArrayList<Piece>();
			int pawnCountB2 = 0;
			int knightCountB2 = 0;
			int bishopCountB2 = 0;
			int rookCountB2 = 0;
			int promKCountB2 = 0;
			int promBCountB2 = 0;
			int promRCountB2 = 0;
			int promQCountB2 = 0;
			//Make a deep copy of the black pieces
			for(int k = 0; k < moves.get(i).getState()[1].size(); ++k) {
				if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Pawn") == true) {
					++pawnCountB2;
					Pawn nPawn = new Pawn("Black", (moves.get(i).getState()[1].get(k).getPosition()), pawnCountB2);
					nPawn.setRank(((Pawn) moves.get(i).getState()[1].get(k)).getRank());
					bMPieces.add(nPawn);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Knight") == true) {
					++knightCountB2;
					Knight nKnight = new Knight("Black", moves.get(i).getState()[1].get(k).getPosition(), knightCountB2);
					bMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
					++promKCountB2;
					Knight nKnight = new Knight("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promKCountB2);
					bMPieces.add(nKnight);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Bishop") == true) {
					++bishopCountB2;
					Bishop nBishop = new Bishop("Black", moves.get(i).getState()[1].get(k).getPosition(), bishopCountB2);
					bMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
					++promBCountB2;
					Bishop nBishop = new Bishop("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promBCountB2);
					bMPieces.add(nBishop);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Rook") == true) {
					++rookCountB2;
					Rook nRook = new Rook("Black", moves.get(i).getState()[1].get(k).getPosition(), rookCountB2);
					bMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
					++promRCountB2;
					Rook nRook = new Rook("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promRCountB2);
					bMPieces.add(nRook);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Queen") == true) {
					Queen nQueen = new Queen("Black", moves.get(i).getState()[1].get(k).getPosition());
					bMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
					++promQCountB2;
					Queen nQueen = new Queen("Black Promoted", moves.get(i).getState()[1].get(k).getPosition(), promQCountB2);
					bMPieces.add(nQueen);
				}
				else if(moves.get(i).getState()[1].get(k).getName().startsWith("Black King") == true) {
					King nKing = new King("Black", moves.get(i).getState()[1].get(k).getPosition());
					bMPieces.add(nKing);
				}
			}
			//Making the move
			if(mColor.equals("White")) {
				mColor = "Black";
			}
			else {
				mColor = "White";
			}
			g = new GameState(wMPieces, bMPieces);
			int currentVal = maxValue(g, a, b, d-1, mColor);
			if(currentVal < b) {
				bState = new GameState(wMPieces, bMPieces);
				b = currentVal;
			}
			//Undoing the move
			g = new GameState(wPieces, bPieces);
			if(a >= b) {
				//System.out.println("v");
				return currentVal;
			}
		}
		//System.out.println("f");
		for(int i = 0; i < bState.getState()[0].size(); ++i) {
			//System.out.println(bState.getState()[0].get(i).getName());
			//System.out.println(bState.getState()[0].get(i).getPosition());
		}
		return b;
	}
	
	
	

	
	public int evaluation(GameState gState, String mColor) {
		int whiteScore = 0;
		int blackScore = 0;
		for(int i = 0; i < gState.getState()[0].size(); ++i) {
			whiteScore += gState.getState()[0].get(i).getValue();
		}
		for(int i = 0; i < gState.getState()[1].size(); ++i) {
			blackScore +=  gState.getState()[1].get(i).getValue();
			
		}
		if(mColor.equals("White")) {
			if(whiteScore > blackScore) {
				return whiteScore - blackScore;
			}
			else {
				return  blackScore - whiteScore;
			}
		}
		else {
			if(blackScore > whiteScore) {
				return blackScore - whiteScore;
			}
			else {
				return whiteScore - blackScore;

			}
		}
	}
	
	
	
	
}
