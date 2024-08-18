import java.util.ArrayList;

public class RLChess {
	
	private static final String whiteLabel = "White";
	
	private static final String blackLabel = "Black";
	
	ReinforcementLearner rlW = new ReinforcementLearner(whiteLabel);
	ReinforcementLearner rlB = new ReinforcementLearner(blackLabel);
	
	
	public static void RLChess() {
		Board theBoard = new Board();
		ArrayList<Pawn> whitePawns = new ArrayList();
		ArrayList<Pawn> blackPawns = new ArrayList();
		for(int i = 0; i < 8; ++i) {
			whitePawns.add(new Pawn(whiteLabel, theBoard.getBoard()[1][i], i+1));
			blackPawns.add(new Pawn(blackLabel, theBoard.getBoard()[6][i], i+1));
		}
		ArrayList<Rook> whiteRooks = new ArrayList();
		ArrayList<Rook> blackRooks = new ArrayList();
		whiteRooks.add(new Rook (whiteLabel, theBoard.getBoard()[0][0], 1));
		whiteRooks.add(new Rook (whiteLabel, theBoard.getBoard()[0][7], 2));
		blackRooks.add(new Rook (blackLabel, theBoard.getBoard()[7][0], 1));
		blackRooks.add(new Rook (blackLabel, theBoard.getBoard()[7][7], 2));
		
		ArrayList<Knight> whiteKnights = new ArrayList();
		ArrayList<Knight> blackKnights = new ArrayList();
		whiteKnights.add(new Knight(whiteLabel, theBoard.getBoard()[0][1], 1));
		whiteKnights.add(new Knight(whiteLabel, theBoard.getBoard()[0][6], 2));
		blackKnights.add(new Knight(blackLabel, theBoard.getBoard()[7][1], 1));
		blackKnights.add(new Knight(blackLabel, theBoard.getBoard()[7][6], 2));
		
		ArrayList<Bishop> whiteBishops = new ArrayList();
		ArrayList<Bishop> blackBishops = new ArrayList();
		whiteBishops.add(new Bishop(whiteLabel, theBoard.getBoard()[0][2], 1));
		whiteBishops.add(new Bishop(whiteLabel, theBoard.getBoard()[0][5], 2));
		blackBishops.add(new Bishop(blackLabel, theBoard.getBoard()[7][2], 1));
		blackBishops.add(new Bishop(blackLabel, theBoard.getBoard()[7][5], 2));
		
		ArrayList<Queen> whiteQueens = new ArrayList();
		ArrayList<Queen> blackQueens = new ArrayList();
		whiteQueens.add(new Queen(whiteLabel, theBoard.getBoard()[0][3]));
		blackQueens.add(new Queen(blackLabel, theBoard.getBoard()[7][3]));
		
		King whiteKing = new King(whiteLabel, theBoard.getBoard()[0][4]);
		King blackKing = new King(blackLabel, theBoard.getBoard()[7][4]);
				
		ArrayList <Piece> whitePieces = new ArrayList(); //Make list of all white pieces for easier access to their positions
		
		for(int i = 0; i < whitePawns.size(); ++i) {
			whitePieces.add(whitePawns.get(i));
		}
		
		for(int i = 0; i < whiteKnights.size(); ++i) {
			whitePieces.add(whiteKnights.get(i));
		}
		
		for(int i = 0; i < whiteBishops.size(); ++i) {
			whitePieces.add(whiteBishops.get(i));
		}
		
		for(int i = 0; i < whiteRooks.size(); ++i) {
			whitePieces.add(whiteRooks.get(i));
		}
		
		for(int i = 0; i < whiteQueens.size(); ++i) {
			whitePieces.add(whiteQueens.get(i));
		}
		
		whitePieces.add(whiteKing);
		
		ArrayList<Piece> blackPieces = new ArrayList();
		
		for(int i = 0; i < blackPawns.size(); ++i) {
			blackPieces.add(blackPawns.get(i));
		}
		
		for(int i = 0; i < blackKnights.size(); ++i) {
			blackPieces.add(blackKnights.get(i));
		}
		
		for(int i = 0; i < blackBishops.size(); ++i) {
			blackPieces.add(blackBishops.get(i));
		}
		
		for(int i = 0; i < blackRooks.size(); ++i) {
			blackPieces.add(blackRooks.get(i));
		}
		
		for(int i = 0; i < blackQueens.size(); ++i) {
			blackPieces.add(blackQueens.get(i));
		}
		
		blackPieces.add(blackKing);
		
		GameState theState = new GameState(whitePieces, blackPieces);
	}
	
	public static void main(String [] args) {
		RLChess();
	}
}
