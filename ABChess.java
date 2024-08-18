import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ABChess {
	
	private static final String whiteLabel = "White";
	
	private static final String blackLabel = "Black";
	
	public static ArrayList <Integer> [] ABChess() {
		ArrayList<Integer> [] times = new ArrayList[2];
		ArrayList<Integer> wTime = new ArrayList<Integer>();
		ArrayList<Integer> bTime = new ArrayList<Integer>();
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
		AlphaBeta whiteABPlayer = new AlphaBeta("White");
		AlphaBeta blackABPlayer = new AlphaBeta("Black");
		boolean gameEnd = false;
		boolean whiteTurn = true;
		boolean blackTurn = false;
		boolean whiteWin = false;
		boolean blackWin = false;
		int w = 0;
		int b = 0;
		while(gameEnd == false) {
			System.out.println(w + " White Moves");
			if(whiteTurn == true && blackTurn == false) {
				++w;
				//Depth 5 and 6 are the sweet spot. Depth 7 may take 5-10 minutes. Depth 8 may take 10-20 minutes.
				theState = whiteABPlayer.makeMaxValueMove(theState, (int)Double.NEGATIVE_INFINITY, (int)Double.POSITIVE_INFINITY, 1, "White");
				wTime.add((int) System.nanoTime());
				for(int i = 0; i < theState.getState()[1].size(); ++i) {
					System.out.println(theState.getState()[1].get(i).getName());
					System.out.println(theState.getState()[1].get(i).getPosition());
					if(theState.getState()[1].get(i).getName().equals("Black King") == false){
						gameEnd = true;
					}
					else {
						gameEnd = false;
						break;
					}
				}
				if(gameEnd == true) {
					whiteWin = true;
					break;
				}
				whiteTurn = false;
				blackTurn = true;
			}
			else {
				++b;
				System.out.println(b + " Black Moves");
				theState = blackABPlayer.makeMaxValueMove(theState, (int)Double.NEGATIVE_INFINITY, (int)Double.POSITIVE_INFINITY, 5, "Black");
				bTime.add((int) System.nanoTime());
				for(int i = 0; i < theState.getState()[0].size(); ++i) {
					System.out.println(theState.getState()[0].get(i).getName());
					System.out.println(theState.getState()[0].get(i).getPosition());
					if(theState.getState()[0].get(i).getName().equals("White King") == false){
						gameEnd = true;
					}
					else {
						gameEnd = false;
						break;
					}
				}
				if(gameEnd == true) {
					blackWin = true;
					break;
				}
				whiteTurn = true;
				blackTurn = false;
			}
		}
		boolean gameEndW = true;
		boolean gameEndB = true;
		for(int i = 0; i < theState.getState()[0].size(); ++i) {
			if(theState.getState()[0].get(i).getName().equals("White King") == true){
				gameEndW = false;
				break;
			}
			else {
				gameEndW = true;
			}
		}
		for(int i = 0; i < theState.getState()[1].size(); ++i) {
			if(theState.getState()[1].get(i).getName().equals("Black King")){
				gameEndB = false;
				break;
			}
			else {
				gameEndB = true;
			}
		}
		if(gameEndW == true && gameEndB == false) {
			System.out.println("CHECKMATE. The Black Team's King has been Captured. White Team Wins!");
		}
		else if(gameEndW == false && gameEndB == true) {
			System.out.println("CHECKMATE. The White Team's King has been Captured. Black Team Wins!");
		}
		
			times[0] = wTime;
			times[1] = bTime;
			return times;
		}
		

	
	public static void ABChessIB(int depth) {
		Board theBoard = new Board();
		int mCount = 0;
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
		AlphaBeta whiteABPlayer = new AlphaBeta("White");
		Scanner players = new Scanner(System.in);
		boolean gameEnd = false;
		boolean whiteTurn = true;
		boolean blackTurn = false;
		System.out.println("Chess Game Starting. White Team goes first");
		while(gameEnd == false) {
			if(whiteTurn == true && blackTurn == false) {
				System.out.println("White's turn. Board before turn is as follows: ");
				for(int i = 0; i < theState.getState()[0].size(); ++i) {
					System.out.println(theState.getState()[0].get(i).getName());
					System.out.println(theState.getState()[0].get(i).getPosition());
				}
				for(int i = 0; i < theState.getState()[1].size(); ++i) {
					System.out.println(theState.getState()[1].get(i).getName());
					System.out.println(theState.getState()[1].get(i).getPosition());
				}
				System.out.println("White's turn has terminated. Current Board is now as follows: ");
				theState = whiteABPlayer.makeMaxValueMove(theState, (int)Double.NEGATIVE_INFINITY, (int)Double.POSITIVE_INFINITY, depth, "White");
				for(int i = 0; i < theState.getState()[0].size(); ++i) {
					System.out.println(theState.getState()[0].get(i).getName());
					System.out.println(theState.getState()[0].get(i).getPosition());
				}
				for(int i = 0; i < theState.getState()[1].size(); ++i) {
					System.out.println(theState.getState()[1].get(i).getName());
					System.out.println(theState.getState()[1].get(i).getPosition());
				}
				
				if(theState.end() == true) {
					gameEnd = true;
					break;
				}
				whiteTurn = false;
				blackTurn = true;
			}
			else {
				System.out.println("Black's turn. Please select a piece type from the following choices");
				System.out.println("1 = Pawn");
				System.out.println("2 = Knight");
				System.out.println("3 = Bishop");
				System.out.println("4 = Rook");
				System.out.println("5 = Queen");
				System.out.println("6 = King");
				int typeChoice = players.nextInt();
				if(typeChoice == 1) {
					ArrayList<Pawn> bP = new ArrayList<Pawn>();
					for(int i = 0; i < theState.getState()[1].size(); ++i) {
						if(theState.getState()[1].get(i).getName().startsWith("Black Pawn") == true) {
							bP.add((Pawn)theState.getState()[1].get(i));
						}
					}
					if(bP.isEmpty() == true) {
						System.out.println("You no longer have any pawns. Please select another piece type.");
					}
					else {
						System.out.println("Please select the Pawn you would like to use from the following choices: ");
						int pawnChoice = 1;
						for(int i = 0; i < bP.size(); ++i) {
							System.out.println(pawnChoice + " = " + bP.get(i).getName());
							++pawnChoice;
						}
						boolean pChoice = false;
						while(pChoice == false) {
							int bPawnChoice = players.nextInt();
						if(bPawnChoice >= 1 || bPawnChoice <= bP.size()) {
							pChoice = true;
							Pawn chosenPawn = blackPawns.get(bPawnChoice-1);
							System.out.println("This pawn's position on the board is " + chosenPawn.getPosition());
							ArrayList [] positions = chosenPawn.getBPositions(chosenPawn, theBoard, theState.getState()[0], theState.getState()[1]);
							ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
							ArrayList <String> rPositions = positions[0]; // List of possible regular positions
							boolean rankBy1 = (boolean) positions[2].get(0);
							boolean rankBy2 = (boolean) positions[2].get(1);
							boolean validPosition = false; //To be used to get proper input for a user's choice in position
							
							
							if(rPositions.isEmpty() == false) {
								System.out.println("The positions this pawn can travel to are as follows: ");
								for(int i = 0; i < rPositions.size(); ++i) {
									System.out.println(rPositions.get(i));
								}
							}
							else {
								System.out.println("There are no normal positions for this pawn to travel");
							}
							if(cPieces.isEmpty() == true) {
								System.out.println("There are no pieces that this pawn can capture");
							}
							else {
								System.out.println("The pieces that this pawn can capture are: ");
								for(int i = 0; i < cPieces.size(); ++i) {
									System.out.println(cPieces.get(i).getName() + " at " + cPieces.get(i).getPosition());
								}
							}
							
							if(rPositions.isEmpty() == true && cPieces.isEmpty() == true) {
								System.out.println("This pawn cannot travel anywhere. Please Select another piece");
							}
							else {
								while(validPosition == false) {
									System.out.println("Select a position by inputting any of the valid positions above");
									String pawnPosition = players.nextLine();
									if(rPositions.isEmpty() == false || cPieces.isEmpty() == false) {
										for(int i = 0; i < rPositions.size(); ++i) {
											if(pawnPosition.equals(rPositions.get(i)) == true) {
												validPosition = true;
												for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
													if(theState.getState()[1].get(j).getName().equals(chosenPawn.getName()) == true) {
														((Pawn)theState.getState()[1].get(j)).setPosition(pawnPosition);
														if(rankBy1 == true && rankBy2 == true) {
															if(pawnPosition.equals(rPositions.get(0)) == true) {
																((Pawn)theState.getState()[1].get(j)).addRank(1);
															}
															else if(pawnPosition.equals(rPositions.get(1)) == true) {
																((Pawn)theState.getState()[1].get(j)).addRank(2);
															}
														}
														else if(rankBy1 == true && rankBy2 == false) {
															((Pawn)theState.getState()[1].get(j)).addRank(1);
														}
														break;
													}
												}
												whiteTurn = true;
												blackTurn = false;
												break;
											}
										}
										for(int i = 0; i < cPieces.size(); ++i) {
											if(pawnPosition.equals(cPieces.get(i).getPosition()) == true) {
												validPosition = true;
												for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
													if(theState.getState()[1].get(j).getName().equals(chosenPawn.getName()) == true) {
														((Pawn)theState.getState()[1].get(j)).setPosition(pawnPosition);
														((Pawn)theState.getState()[1].get(j)).addRank(1);
														break;
													}
												}
												
												
												//Update larger list for capturing a piece
												for(int j = 0; j < theState.getState()[0].size(); ++j) { //Update larger list, check if king is captured
													if(theState.getState()[0].get(j).getName().equals(cPieces.get(i).getName()) == true) {
														theState.getState()[0].remove(j);
															whiteTurn = true;
															blackTurn = false;
															break;
													}
								
													}
												if(theState.end() == true) {
													gameEnd = true;
													break;
												}
											}
												
												
										}
										ArrayList<Pawn> bPR = new ArrayList<Pawn>();
										for(int i = 0; i < theState.getState()[1].size(); ++i) {
											if(theState.getState()[1].get(i).getName().startsWith("Black Pawn") == true) {
												bPR.add((Pawn)theState.getState()[1].get(i));
											}
										}
										//Code for promoting a pawn
										for(int i = 0; i < bPR.size(); ++i) {
											int kCount = 1;
											int bCount = 1;
											int rCount = 1;
											int qCount = 1;
											if(bPR.get(i).getRank() == 8) {
												System.out.println(bPR.get(i).getName() + " can be promoted. Please select a choice of Knight, Bishop, Rook, or Queen");
												System.out.println("Knight = 1");
												System.out.println("Bishop = 2");
												System.out.println("Rook = 3");
												System.out.println("Queen = 4");
												boolean promotionCondition = false;
												int promotionChoice = 0;
												while(promotionCondition == false) {
													promotionChoice = players.nextInt();
													if(promotionChoice == 1 || promotionChoice == 2 || promotionChoice == 3 || promotionChoice == 4) {
														promotionCondition = true;
													}
													else {
														System.out.println("This is an invalid promotion option. Please select a valid condition.");
													}
												}
												if(promotionChoice == 1) {
													for(int j = 0; j < theState.getState()[1].size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(bPR.get(i).getName().equals(theState.getState()[1].get(j).getName()) == true) {
															theState.getState()[1].remove(j);
															//If there is already promoted knights in list, add to counter
															for(int k = 0; k < theState.getState()[1].size(); ++k) {
																if(theState.getState()[1].get(k).getName().startsWith("Black Promoted Knight") == true) {
																	++kCount;
																}
															}
														}
														theState.getState()[1].set(j, new Knight("Black Promoted", bPR.get(i).getPosition(), kCount));
														break;
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
													break;
												}
												else if(promotionChoice == 2) {
													for(int j = 0; j < theState.getState()[1].size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(bPR.get(i).getName().equals(theState.getState()[1].get(j).getName()) == true) {
															//If there is already promoted bishops in list, add to counter
															for(int k = 0; k < theState.getState()[1].size(); ++k) {
																if(theState.getState()[1].get(k).getName().startsWith("Black Promoted Bishop") == true) {
																	++bCount;
																}
															}
														}
														theState.getState()[1].set(j, new Bishop("Black Promoted", bPR.get(i).getPosition(), kCount));
														break;
													}
													
												}
												else if(promotionChoice == 3) {
													for(int j = 0; j < theState.getState()[1].size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(bPR.get(i).getName().equals(theState.getState()[1].get(j).getName()) == true) {
															//If there is already promoted rooks in list, add to counter
															for(int k = 0; k < theState.getState()[1].size(); ++k) {
																if(theState.getState()[1].get(k).getName().startsWith("Black Promoted Rook") == true) {
																	++rCount;
																}
															}
														}
														theState.getState()[1].set(j, new Rook("Black Promoted", bPR.get(i).getPosition(), kCount));
														break;
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
												}
												else if(promotionChoice == 4) {
													for(int j = 0; j < theState.getState()[1].size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(bPR.get(i).getName().equals(theState.getState()[1].get(j).getName()) == true) {
															//If there is already promoted queens in list, add to counter
															for(int k = 0; k < theState.getState()[1].size(); ++k) {
																if(theState.getState()[1].get(k).getName().startsWith("Black Promoted Queen") == true) {
																	++qCount;
																}
															}
														}
														theState.getState()[1].set(j, new Queen("Black Promoted", bPR.get(i).getPosition(), kCount));
														break;
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
												}
										
											}
										}
									}
								}
							}
		
						}
						else {
							System.out.println("Your input was not valid. Please select a valid input");
						}
						}
					}
				}
				else if(typeChoice == 2) {
					ArrayList<Knight> bK = new ArrayList<Knight>();
					for(int i = 0; i < theState.getState()[1].size(); ++i) {
						if(theState.getState()[1].get(i).getName().startsWith("Black Knight") == true || theState.getState()[1].get(i).getName().startsWith("Promoted Black Knight") == true) {
							bK.add((Knight)theState.getState()[1].get(i));
						}
					}
					if(bK.isEmpty() == true) {
						System.out.println("You no longer have any knights. Please select another piece type.");
					}
					else {
						System.out.println("Please select the knight from the following list of choices: ");
						int knightChoice = 1;
						for(int i = 0; i < bK.size(); ++i) {
							System.out.println(knightChoice + " = " + bK.get(i).getName());
							++knightChoice;
						}
						boolean kChoice = false;
						int bKnightChoice = 0;
						while(kChoice == false) {
							bKnightChoice = players.nextInt();
							if(bKnightChoice < 1 || bKnightChoice > bK.size()) {
								System.out.println("This is an invalid choice. Please select a valid knight.");
							}
							else {
								kChoice = true;
							}
						}
						Knight chosenKnight = bK.get(bKnightChoice-1);
						System.out.println("This knight's position on the board is " + chosenKnight.getPosition());
						ArrayList [] positions = chosenKnight.getBPositions(chosenKnight, theBoard, theState.getState()[0], theState.getState()[1]);
						ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
						ArrayList <String> rPositions = positions[0]; // List of possible regular positions
						boolean validPosition = false; //To be used to get proper input for a user's choice in position
						
						
						
						if(rPositions.isEmpty() == false) {
							System.out.println("The positions this knight can travel to are as follows: ");
							for(int i = 0; i < rPositions.size(); ++i) {
								System.out.println(rPositions.get(i));
							}
						}
						else {
							System.out.println("There are no normal positions for this knight to travel");
						}
						if(cPieces.isEmpty() == true) {
							System.out.println("There are no pieces that this knight can capture");
						}
						else {
							System.out.println("The pieces that this knight can capture are: ");
							for(int i = 0; i < cPieces.size(); ++i) {
								System.out.println(cPieces.get(i).getName() + " at " + cPieces.get(i).getPosition());
							}
						}
						
						if(rPositions.isEmpty() == true && cPieces.isEmpty() == true) {
							System.out.println("This knight cannot travel anywhere. Please Select another piece");
						}
						else {
							System.out.println("Select a position by inputting any of the valid positions above");
							while(validPosition == false) {
								String knightPosition = players.nextLine();
								if(rPositions.isEmpty() == false || cPieces.isEmpty() == false) {
									for(int i = 0; i < rPositions.size(); ++i) {
										if(knightPosition.equals(rPositions.get(i)) == true) {
											validPosition = true;
											for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
												if(theState.getState()[1].get(j).getName().equals(chosenKnight.getName()) == true) {
													theState.getState()[1].get(j).setPosition(knightPosition);
													break;
												}
											}
											whiteTurn = true;
											blackTurn = false;
											break;
										}
									}
									
									//Update larger list for capturing a piece
									for(int i = 0; i < cPieces.size(); ++i) {
										if(knightPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
												if(theState.getState()[1].get(j).getName().equals(chosenKnight.getName()) == true) {
													theState.getState()[1].get(j).setPosition(knightPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < theState.getState()[0].size(); ++j) { //Update larger list, check if king is captured
												if(theState.getState()[0].get(j).getName().equals(cPieces.get(i).getName()) == true) {
														whitePieces.remove(j);
														whiteTurn = true;
														blackTurn = false;
														break;
												}
							
												}
										}
											//Use multiple loops to find sub list to update
											
										if(theState.end() == true) {
											gameEnd = true;
											break;
										}
									}
								}
							}
						}
					}
				}
				else if(typeChoice == 3) {
					ArrayList<Bishop> bB = new ArrayList<Bishop>();
					for(int i = 0; i < theState.getState()[1].size(); ++i) {
						if(theState.getState()[1].get(i).getName().startsWith("Black Bishop") == true || theState.getState()[1].get(i).getName().startsWith("Promoted Black Bishop") == true) {
							bB.add((Bishop)theState.getState()[1].get(i));
						}
					}
					if(bB.isEmpty() == true) {
						System.out.println("You no longer have any bishops. Please select another piece type.");
					}
					else {
						System.out.println("Please select the bishop from the following list of choices: ");
						int bishopChoice = 1;
						for(int i = 0; i < bB.size(); ++i) {
							System.out.println(bishopChoice + " = " + bB.get(i).getName());
							++bishopChoice;
						}
						boolean bChoice = false;
						int bBishopChoice = 0;
						while(bChoice == false) {
							bBishopChoice = players.nextInt();
							if(bBishopChoice < 1 || bBishopChoice > bB.size()) {
								System.out.println("This is an invalid choice. Please select a valid bishop.");
							}
							else {
								bChoice = true;
							}
						}
						Bishop chosenBishop = bB.get(bBishopChoice-1);
						System.out.println("This bishop's position on the board is " + chosenBishop.getPosition());
						ArrayList [] positions = chosenBishop.getBPositions(chosenBishop, theBoard, theState.getState()[0], theState.getState()[1]);
						ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
						ArrayList <String> rPositions = positions[0]; // List of possible regular positions
						boolean validPosition = false; //To be used to get proper input for a user's choice in position
						//Create booleans to represent directions
						
						
						
						if(rPositions.isEmpty() == false) {
							System.out.println("The positions this bishop can travel to are as follows: ");
							for(int i = 0; i < rPositions.size(); ++i) {
								System.out.println(rPositions.get(i));
							}
						}
						else {
							System.out.println("There are no normal positions for this bishop to travel");
						}
						if(cPieces.isEmpty() == true) {
							System.out.println("There are no pieces that this bishop can capture");
						}
						else {
							System.out.println("The pieces that this bishop can capture are: ");
							for(int i = 0; i < cPieces.size(); ++i) {
								System.out.println(cPieces.get(i).getName() + " at " + cPieces.get(i).getPosition());
							}
						}
						
						if(rPositions.isEmpty() == true && cPieces.isEmpty() == true) {
							System.out.println("This bishop cannot travel anywhere. Please Select another piece");
						}
						else {
							System.out.println("Select a position by inputting any of the valid positions above");
							while(validPosition == false) {
								String bishopPosition = players.nextLine();
								if(rPositions.isEmpty() == false || cPieces.isEmpty() == false) {
									for(int i = 0; i < rPositions.size(); ++i) {
										if(bishopPosition.equals(rPositions.get(i)) == true) {
											validPosition = true;
											for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
												if(theState.getState()[1].get(j).getName().equals(chosenBishop.getName()) == true) {
													theState.getState()[1].get(j).setPosition(bishopPosition);
													break;
												}
											}
											whiteTurn = true;
											blackTurn = false;
											break;
										}
									}
									
									//Update larger list for capturing a piece
									for(int i = 0; i < cPieces.size(); ++i) {
										if(bishopPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
												if(theState.getState()[1].get(j).getName().equals(chosenBishop.getName()) == true) {
													theState.getState()[1].get(j).setPosition(bishopPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < theState.getState()[0].size(); ++j) { //Update larger list, check if king is captured
												if(theState.getState()[0].get(j).getName().equals(cPieces.get(i).getName()) == true) {
														whitePieces.remove(j);
														whiteTurn = true;
														blackTurn = false;
														break;
												}
							
												}
										}
											
										if(theState.end() == true) {
											gameEnd = true;
											break;
									}
								}
							}
						}
						
						
						
					}
				}
				}
				else if(typeChoice == 4) {
					ArrayList<Rook> bR = new ArrayList<Rook>();
					for(int i = 0; i < theState.getState()[1].size(); ++i) {
						if(theState.getState()[1].get(i).getName().startsWith("Black Rook") == true || theState.getState()[1].get(i).getName().startsWith("Promoted Black Rook") == true) {
							bR.add((Rook)theState.getState()[1].get(i));
						}
					}
					if(bR.isEmpty() == true) {
						System.out.println("You no longer have any rooks. Please select another piece type");
					}
					else {
						System.out.println("Please select the rook from the following list of choices: ");
						int rookChoice = 1;
						for(int i = 0; i < bR.size(); ++i) {
							System.out.println(rookChoice + " = " + bR.get(i).getName());
							++rookChoice;
						}
						boolean rChoice = false;
						int bRookChoice = 0;
						while(rChoice == false) {
							bRookChoice = players.nextInt();
							if(bRookChoice < 1 || bRookChoice > bR.size()) {
								System.out.println("This is an invalid choice. Please select a valid bishop.");
							}
							else {
								rChoice = true;
							}
						}
						Rook chosenRook = bR.get(bRookChoice-1);
						System.out.println("This rook's position on the board is " + chosenRook.getPosition());
						ArrayList [] positions = chosenRook.getBPositions(chosenRook, theBoard, theState.getState()[0], theState.getState()[1]);
						ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
						ArrayList <String> rPositions = positions[0]; // List of possible regular positions
						boolean validPosition = false; //To be used to get proper input for a user's choice in position
						
						//Create counters for rows and columns to keep track of diagonal positions
						
						if(rPositions.isEmpty() == false) {
							System.out.println("The positions this rook can travel to are as follows: ");
							for(int i = 0; i < rPositions.size(); ++i) {
								System.out.println(rPositions.get(i));
							}
						}
						else {
							System.out.println("There are no normal positions for this rook to travel");
						}
						if(cPieces.isEmpty() == true) {
							System.out.println("There are no pieces that this rook can capture");
						}
						else {
							System.out.println("The pieces that this rook can capture are: ");
							for(int i = 0; i < cPieces.size(); ++i) {
								System.out.println(cPieces.get(i).getName() + " at " + cPieces.get(i).getPosition());
							}
						}
						
						if(rPositions.isEmpty() == true && cPieces.isEmpty() == true) {
							System.out.println("This rook cannot travel anywhere. Please Select another piece");
						}
						else {
							System.out.println("Select a position by inputting any of the valid positions above");
							while(validPosition == false) {
								String rookPosition = players.nextLine();
								if(rPositions.isEmpty() == false || cPieces.isEmpty() == false) {
									for(int i = 0; i < rPositions.size(); ++i) {
										if(rookPosition.equals(rPositions.get(i)) == true) {
											validPosition = true;
											for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
												if(theState.getState()[1].get(j).getName().equals(chosenRook.getName()) == true) {
													theState.getState()[1].get(j).setPosition(rookPosition);
													break;
												}
											}
											whiteTurn = true;
											blackTurn = false;
											break;
										}
									}
									
									//Update larger list for capturing a piece
									for(int i = 0; i < cPieces.size(); ++i) {
										if(rookPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
												if(theState.getState()[1].get(j).getName().equals(chosenRook.getName()) == true) {
													theState.getState()[1].get(j).setPosition(rookPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < theState.getState()[0].size(); ++j) { //Update larger list, check if king is captured
												if(theState.getState()[0].get(j).getName().equals(cPieces.get(i).getName()) == true) {
														whitePieces.remove(j);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
												}
							
												}
										
										if(theState.end() == true) {
											gameEnd = true;
											break;
									}
									}
								}
							}
						}
					}
				}
				else if(typeChoice == 5) {
					ArrayList<Queen> bQ = new ArrayList<Queen>();
					for(int i = 0; i < theState.getState()[1].size(); ++i) {
						if(theState.getState()[1].get(i).getName().startsWith("Black Queen") == true || theState.getState()[1].get(i).getName().startsWith("Promoted Black Queen") == true) {
							bQ.add((Queen)theState.getState()[1].get(i));
						}
					}
					if(blackQueens.isEmpty() == true) {
						System.out.println("You no longer have any queens. Please select another piece type");
					}
					else {
						System.out.println("Please select the queen from the following list of choices: ");
						int queenChoice = 1;
						for(int i = 0; i < bQ.size(); ++i) {
							System.out.println(queenChoice + " = " + bQ.get(i).getName());
							++queenChoice;
						}
						boolean qChoice = false;
						int bQueenChoice = 0;
						while(qChoice == false) {
							bQueenChoice = players.nextInt();
							if(bQueenChoice < 1 || bQueenChoice > bQ.size()) {
								System.out.println("This is an invalid choice. Please select a valid queen.");
							}
							else {
								qChoice = true;
							}
						}
						Queen chosenQueen = bQ.get(bQueenChoice-1);
						System.out.println("This queen's position on the board is " + chosenQueen.getPosition());
						ArrayList [] positions = chosenQueen.getBPositions(chosenQueen, theBoard, theState.getState()[0], theState.getState()[1]);
						ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
						ArrayList <String> rPositions = positions[0]; // List of possible regular positions
						boolean validPosition = false; //To be used to get proper input for a user's choice in position
						
						if(rPositions.isEmpty() == false) {
							System.out.println("The positions this queen can travel to are as follows: ");
							for(int i = 0; i < rPositions.size(); ++i) {
								System.out.println(rPositions.get(i));
							}
						}
						else {
							System.out.println("There are no normal positions for this queen to travel");
						}
						if(cPieces.isEmpty() == true) {
							System.out.println("There are no pieces that this queen can capture");
						}
						else {
							System.out.println("The pieces that this queen can capture are: ");
							for(int i = 0; i < cPieces.size(); ++i) {
								System.out.println(cPieces.get(i).getName() + " at " + cPieces.get(i).getPosition());
							}
						}
						
						if(rPositions.isEmpty() == true && cPieces.isEmpty() == true) {
							System.out.println("This queen cannot travel anywhere. Please Select another piece");
						}
						else {
							System.out.println("Select a position by inputting any of the valid positions above");
							while(validPosition == false) {
								String queenPosition = players.nextLine();
								if(rPositions.isEmpty() == false || cPieces.isEmpty() == false) {
									for(int i = 0; i < rPositions.size(); ++i) {
										if(queenPosition.equals(rPositions.get(i)) == true) {
											validPosition = true;
											for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
												if(theState.getState()[1].get(j).getName().equals(chosenQueen.getName()) == true) {
													theState.getState()[1].get(j).setPosition(queenPosition);
													break;
												}
											}
											whiteTurn = true;
											blackTurn = false;
											break;
										}
									}
									//Update larger list for capturing a piece
									for(int i = 0; i < cPieces.size(); ++i) {
										if(queenPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
												if(theState.getState()[1].get(j).getName().equals(chosenQueen.getName()) == true) {
													theState.getState()[1].get(j).setPosition(queenPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < theState.getState()[0].size(); ++j) { //Update larger list, check if king is captured
												if(theState.getState()[0].get(j).getName().equals(cPieces.get(i).getName()) == true) {
														whitePieces.remove(j);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
												}
							
												}
										if(theState.end() == true) {
											gameEnd = true;
											break;
									}
									}
								}
							}
						}
					}
				}
				else if(typeChoice == 6) {
					ArrayList<King> bK = new ArrayList<King>();
					for(int i = 0; i < theState.getState()[1].size(); ++i) {
						if(theState.getState()[1].get(i).getName().startsWith("Black King") == true) {
							bK.add((King)theState.getState()[1].get(i));
						}
					}
					King k = bK.get(0);
					System.out.println("The king's position on the board is " + k.getPosition());
					ArrayList [] positions = k.getBPositions(k, theBoard, theState.getState()[0], theState.getState()[1]);
					ArrayList <Piece> cPieces = positions[1]; // List of capture pieces
					ArrayList <String> rPositions = positions[0]; // List of possible regular positions
					boolean validPosition = false; //To be used to get proper input for a user's choice in position
					
					if(rPositions.isEmpty() == false) {
						System.out.println("The positions the king can travel to are as follows: ");
						for(int i = 0; i < rPositions.size(); ++i) {
							System.out.println(rPositions.get(i));
						}
					}
					else {
						System.out.println("There are no normal positions for the king to travel");
					}
					if(cPieces.isEmpty() == true) {
						System.out.println("There are no pieces that the king can capture");
					}
					else {
						System.out.println("The pieces that the king can capture are: ");
						for(int i = 0; i < cPieces.size(); ++i) {
							System.out.println(cPieces.get(i).getName() + " at " + cPieces.get(i).getPosition());
						}
					}
					if(rPositions.isEmpty() == true && cPieces.isEmpty() == true) {
						System.out.println("The king cannot travel anywhere. Please Select another piece");
					}
					else {
						System.out.println("Select a position by inputting any of the valid positions above");
						while(validPosition == false) {
							String kingPosition = players.nextLine();
							if(rPositions.isEmpty() == false || cPieces.isEmpty() == false) {
								for(int i = 0; i < rPositions.size(); ++i) {
									if(kingPosition.equals(rPositions.get(i)) == true) {
										validPosition = true;
										for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
											if(theState.getState()[1].get(j).getName().equals(k.getName()) == true) {
												theState.getState()[1].get(j).setPosition(kingPosition);
												break;
											}
										}
										whiteTurn = true;
										blackTurn = false;
										
									}
								}
								//Update larger list for capturing a piece
								for(int i = 0; i < cPieces.size(); ++i) {
									if(kingPosition.equals(cPieces.get(i).getPosition()) == true) {
										validPosition = true;
										for(int j = 0; j < theState.getState()[1].size(); ++j) { //Update larger list with new position
											if(theState.getState()[1].get(j).getName().equals(k.getName()) == true) {
												theState.getState()[1].get(j).setPosition(kingPosition);
												break;
											}
										}
										blackKing.setPosition(kingPosition);
												
											
										
										
										
										//Update larger list for capturing a piece
										for(int j = 0; j < theState.getState()[0].size(); ++j) { //Update larger list, check if king is captured
											if(theState.getState()[0].get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whitePieces.remove(j);
													whiteTurn = true;
													blackTurn = false;
													break;
											}
						
											}
									}
									if(theState.end() == true) {
										gameEnd = true;
										break;
								}
								}
							}
						}
					}
				}
				else {
					System.out.println("That is an invalid choice. Please select a valid piece type.");
				}
			
				}
			}
		boolean gameEndW = true;
		boolean gameEndB = true;
		for(int i = 0; i < theState.getState()[0].size(); ++i) {
			if(theState.getState()[0].get(i).getName().equals("White King") == true){
				gameEndW = false;
				break;
			}
			else {
				gameEndW = true;
			}
		}
		for(int i = 0; i < theState.getState()[1].size(); ++i) {
			if(theState.getState()[1].get(i).getName().equals("Black King")){
				gameEndB = false;
				break;
			}
			else {
				gameEndB = true;
			}
		}
		if(gameEndW == true && gameEndB == false) {
			System.out.println("CHECKMATE. The Black Team's King has been Captured. White Team Wins!");
		}
		else {
			System.out.println("CHECKMATE. The White Team's King has been Captured. Black Team Wins!");
		}
		}
	
	
	public static void main(String [] args) {
//		ArrayList<Integer> [] times = ABChess();
//		ArrayList<Integer> w = times[0];
//		ArrayList<Integer> b = times[1];
//		Collections.sort(w);
//		Collections.sort(b);
//		int wAvg = 0;
//		int wSum = 0;
//		int bAvg = 0;
//		int bSum = 0;
//		for(int i = 0; i < w.size(); ++i) {
//			wSum += w.get(i);
//		}
//		for(int i = 0; i < b.size(); ++i) {
//			bSum += b.get(i);
//		}
//		wAvg = wSum / w.size();
//		bAvg = bSum / b.size();
//		System.out.println("Average Time for white: " + wAvg);
//		System.out.println("Average Time for black: " + bAvg);
		Scanner s = new Scanner(System.in);
		System.out.println("Select the depth you want to play with. Warning: I wouldn't go any higher than 6");
		int depth = s.nextInt();
		ABChessIB(depth);
		
		
	}
}
