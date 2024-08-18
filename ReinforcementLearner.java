import java.util.ArrayList;
import java.util.Random;

public class ReinforcementLearner {
	
	GameState state;
	
	//Represent feature vectors for white pieces (might be representing them incorrectly here)
	ArrayList <ArrayList<Piece>> whiteFeatures;
	
	//Represent feature vectors for black pieces (might be representing them incorrectly here)
	ArrayList <ArrayList<Piece>> blackFeatures;
	
	//Represents weight vectors tied to feature vectors. Need some idea of a policy Q(s, a) to arbitrarily and precisely choose these
	ArrayList<Integer> weights = new ArrayList <Integer> (6);
	
	//Represents current policy Q(s, a). May need to make this into its own function to calculate its value
	int Q = 0;
	
	String playerName;
	
	public ReinforcementLearner(String t) {
		if(t.equals("White")) {
			playerName = "White";
		}
		else {
			playerName = "Black";
		}
		
	}
	
	public void SARSA(GameState g, int episodes) {
		//Arbitrarily set weights
		Random r = new Random();
		for(int i = 0; i > weights.size(); ++i) {
			weights.set(i, r.nextInt(0, 100));
		}
		//Make a deep copy of the white pieces to keep an initial state for each episode
		ArrayList <Piece> cWPieces = new ArrayList <Piece>();
		int pawnCount = 0;
		int knightCount = 0;
		int bishopCount = 0;
		int rookCount = 0;
		int promCount = 0;
		for(int k = 0; k < g.getState()[0].size(); ++k) {
			if(g.getState()[0].get(k).getName().startsWith("White Pawn") == true) {
				++pawnCount;
				Pawn nPawn = new Pawn("White", g.getState()[0].get(k).getPosition(), pawnCount);
				nPawn.setRank(((Pawn) g.getState()[0].get(k)).getRank());
				cWPieces.add(nPawn);
			}
			else if(g.getState()[0].get(k).getName().startsWith("White Knight") == true) {
				++knightCount;
				Knight nKnight = new Knight("White", g.getState()[0].get(k).getPosition(), knightCount);
				cWPieces.add(nKnight);
			}
			else if(g.getState()[0].get(k).getName().startsWith("White Bishop") == true) {
				++bishopCount;
				Bishop nBishop = new Bishop("White", g.getState()[0].get(k).getPosition(), bishopCount);
				cWPieces.add(nBishop);
			}
			else if(g.getState()[0].get(k).getName().startsWith("White Rook") == true) {
				++rookCount;
				Rook nRook = new Rook("White", g.getState()[0].get(k).getPosition(), rookCount);
				cWPieces.add(nRook);
			}
			else if(g.getState()[0].get(k).getName().startsWith("White Queen") == true) {
				Queen nQueen = new Queen("White", g.getState()[0].get(k).getPosition());
				cWPieces.add(nQueen);
			}
			else if(g.getState()[0].get(k).getName().startsWith("White Promoted Queen") == true) {
				++promCount;
				Queen nQueen = new Queen("White", g.getState()[0].get(k).getPosition(), promCount);
				cWPieces.add(nQueen);
			}
			else if(g.getState()[0].get(k).getName().startsWith("White King") == true) {
				King nKing = new King("White", g.getState()[0].get(k).getPosition());
				cWPieces.add(nKing);
			}
		}
		for(int i = 0; i < episodes; ++i) {
			ArrayList<Piece> pawns = new ArrayList<Piece>();
			ArrayList<Piece> knights = new ArrayList<Piece>();
			ArrayList<Piece> bishops = new ArrayList<Piece>();
			ArrayList<Piece> rooks = new ArrayList<Piece>();
			ArrayList<Piece> queens = new ArrayList<Piece>();
			ArrayList<Piece> king = new ArrayList<Piece>();
			if(playerName.equals("White")) {
			for(int k = 0; k < state.getState()[0].size(); ++k) {
				if(state.getState()[0].get(k).getName().startsWith("White Pawn")) {
					pawns.add(state.getState()[0].get(k));
				}
				else if(state.getState()[0].get(k).getName().startsWith("White Knight")) {
					knights.add(state.getState()[0].get(k));
				}
				else if(state.getState()[0].get(k).getName().startsWith("White Bishop")) {
					bishops.add(state.getState()[0].get(k));
				}
				else if(state.getState()[0].get(k).getName().startsWith("White Rook")) {
					rooks.add(state.getState()[0].get(k));
				}
				else if(state.getState()[0].get(k).getName().startsWith("White Queen")) {
					queens.add(state.getState()[0].get(k));
				}
				else if(state.getState()[0].get(k).getName().startsWith("White King")) {
					king.add(state.getState()[0].get(k));
				}
			}
			whiteFeatures.add(pawns);
			whiteFeatures.add(knights);
			whiteFeatures.add(bishops);
			whiteFeatures.add(rooks);
			whiteFeatures.add(queens);
			whiteFeatures.add(king);
			//Maybe getting the moves will help RL understand logic? But how will a move be chosen initially?
			ArrayList <GameState> moves = state.getWMoves(state); 
			for(int k = 0; k < moves.size(); ++k) {
				
			}
			}
			else {
			for(int k = 0; i < state.getState()[1].size(); ++i) {
				if(state.getState()[1].get(k).getName().startsWith("Black Pawn")) {
					pawns.add(state.getState()[1].get(k));
				}
				else if(state.getState()[1].get(k).getName().startsWith("Black Knight")) {
					knights.add(state.getState()[1].get(k));
				}
				else if(state.getState()[1].get(k).getName().startsWith("Black Bishop")) {
					bishops.add(state.getState()[1].get(k));
				}
				else if(state.getState()[1].get(k).getName().startsWith("Black Rook")) {
					rooks.add(state.getState()[1].get(i));
				}
				else if(state.getState()[1].get(k).getName().startsWith("Black Queen")) {
					queens.add(state.getState()[1].get(i));
				}
				else if(state.getState()[1].get(k).getName().startsWith("Black King")) {
					king.add(state.getState()[1].get(k));
				}
			}
			blackFeatures.add(pawns);
			blackFeatures.add(knights);
			blackFeatures.add(bishops);
			blackFeatures.add(rooks);
			blackFeatures.add(queens);
			blackFeatures.add(king);
			}
			
		}
		}
		
		
	
	
	//Method that calculates the Q value
	public int QValue(ArrayList <ArrayList<Piece>> features, ArrayList<Integer> w) {
		ArrayList<Integer> featureValues = new ArrayList<Integer>();
		int pawnValue = 0;
		int knightValue = 0;
		int bishopValue = 0;
		int rookValue = 0;
		int queenValue = 0;
		int kingValue = 0;
		//See if we are dealing with white features
		if(features.get(5).get(0).getName().equals("White King")) {
		for(int i = 0; i < features.size(); ++i) {
			for(int k = 0; k < features.get(i).size(); ++k) {
				if(features.get(i).get(k).getName().startsWith("White Pawn")){
					pawnValue += features.get(i).get(k).getValue();
				}
				if(features.get(i).get(k).getName().startsWith("White Knight") || (features.get(i).get(k).getName().startsWith("White Promoted Knight"))){
					knightValue += features.get(i).get(k).getValue();
				}
				if(features.get(i).get(k).getName().startsWith("White Bishop") || (features.get(i).get(k).getName().startsWith("White Promoted Bishop"))){
					bishopValue += features.get(i).get(k).getValue();
				}
				if(features.get(i).get(k).getName().startsWith("White Rook") || (features.get(i).get(k).getName().startsWith("White Promoted Rook"))){
					rookValue += features.get(i).get(k).getValue();
				}
				if(features.get(i).get(k).getName().startsWith("White Queen") || (features.get(i).get(k).getName().startsWith("White Promoted Queen"))){
					queenValue += features.get(i).get(k).getValue();
				}
				if(features.get(i).get(k).getName().startsWith("White King")){
					kingValue += features.get(i).get(k).getValue();
				}
			}
		}
		
		featureValues.add(pawnValue);
		featureValues.add(knightValue);
		featureValues.add(bishopValue);
		featureValues.add(rookValue);
		featureValues.add(queenValue);
		featureValues.add(kingValue);
		for(int i = 0; i < w.size(); ++i) {
			Q += w.get(i) * featureValues.get(i);
		}
		}
		//If not white features, we are dealing with black features
		else {
			for(int i = 0; i < features.size(); ++i) {
				for(int k = 0; k < features.get(i).size(); ++k) {
					if(features.get(i).get(k).getName().startsWith("Black Pawn")){
						pawnValue += features.get(i).get(k).getValue();
					}
					if(features.get(i).get(k).getName().startsWith("Black Knight") || (features.get(i).get(k).getName().startsWith("Black Promoted Knight"))){
						knightValue += features.get(i).get(k).getValue();
					}
					if(features.get(i).get(k).getName().startsWith("Black Bishop") || (features.get(i).get(k).getName().startsWith("Black Promoted Bishop"))){
						bishopValue += features.get(i).get(k).getValue();
					}
					if(features.get(i).get(k).getName().startsWith("Black Rook") || (features.get(i).get(k).getName().startsWith("Black Promoted Rook"))){
						rookValue += features.get(i).get(k).getValue();
					}
					if(features.get(i).get(k).getName().startsWith("Black Queen") || (features.get(i).get(k).getName().startsWith("Black Promoted Queen"))){
						queenValue += features.get(i).get(k).getValue();
					}
					if(features.get(i).get(k).getName().startsWith("Black King")){
						kingValue += features.get(i).get(k).getValue();
					}
				}
			}
			
			featureValues.add(pawnValue);
			featureValues.add(knightValue);
			featureValues.add(bishopValue);
			featureValues.add(rookValue);
			featureValues.add(queenValue);
			featureValues.add(kingValue);
			for(int i = 0; i < w.size(); ++i) {
				Q += w.get(i) * featureValues.get(i);
			}
			}
		return Q;
	}
	
	public void setState(GameState s) {
		state = s;
	}
	
	public ArrayList<Integer> getWeights(){
		return weights;
	}
	
	public ArrayList<ArrayList<Piece>> getWhiteFeatures(){
		return whiteFeatures;
	}
	
	public ArrayList<ArrayList<Piece>> getBlackFeatures(){
		return blackFeatures;
	}
	
}
