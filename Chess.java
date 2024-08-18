import java.util.ArrayList;
import java.util.Scanner;

public class Chess {
	
	private static final String whiteLabel = "White";
	
	private static final String blackLabel = "Black";
	
	public static void Chess() {
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
				
		ArrayList <Piece> whitePieces= new ArrayList(); //Make list of all white pieces for easier access to their positions
		
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
		
		
		Scanner players = new Scanner(System.in);
		boolean gameEnd = false;
		boolean whiteTurn = true;
		boolean blackTurn = false;
		System.out.println("Chess Game Starting. White Team goes first");
		while(gameEnd == false) {
			if(whiteTurn == true && blackTurn == false) {
				System.out.println("White's turn. Please select a piece type from the following choices: ");
				System.out.println("1 = Pawn");
				System.out.println("2 = Knight");
				System.out.println("3 = Bishop");
				System.out.println("4 = Rook");
				System.out.println("5 = Queen");
				System.out.println("6 = King");
				int typeChoice = players.nextInt();
				if(typeChoice == 1) {
					System.out.println(whitePawns.size());
					if(whitePawns.isEmpty() == true) {
						System.out.println("You no longer have any pawns. Please select another piece type.");
					}
					else {
						System.out.println("Please select the Pawn you would like to use from the following choices: ");
						int pawnChoice = 1;
						for(int i = 0; i < whitePawns.size(); ++i) {
							System.out.println(pawnChoice + " = " + whitePawns.get(i).getName());
							++pawnChoice;
						}
						boolean pChoice = false;
						int wPawnChoice = 0;
						while(pChoice == false) {
							wPawnChoice = players.nextInt();
						if(wPawnChoice < 1 || wPawnChoice > whitePawns.size()) {
							System.out.println("This choice is invalid. Please select a valid pawn from the choices given");
						}
						else {
							pChoice = true;
						}
						}
							Pawn chosenPawn = whitePawns.get(wPawnChoice-1);
							System.out.println("This pawn's position on the board is " + chosenPawn.getPosition());
							int rowIdx = 0;
							int columnIdx = 0;
							for(int i = 0; i < theBoard.getBoard().length; ++i) {
								for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
									if(chosenPawn.getPosition().equals(theBoard.getBoard()[i][j])) {
										rowIdx = i;
										columnIdx = j;
									}
								}
							}
							ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
							ArrayList <String> cPositions = new ArrayList(); //Represents capture positions
							boolean validPosition = false; //To be used to get proper input for a user's choice in position
							rPositions.add(theBoard.getBoard()[rowIdx+1][columnIdx]); 
							ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
							boolean rankBy1 = true;
							boolean rankBy2 = true;
							
							//Check if any white pieces are in front of the the current pawn
							for(int i = 0; i < whitePieces.size();++i) {
								if(whitePieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx+1][columnIdx]) == true) {
									rPositions.remove(0);
									rankBy1 = false;
								}
							}
							//Check if any black pieces are in front of current pawn
								for(int i = 0; i < blackPieces.size();++i) {
									if(blackPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx+1][columnIdx]) == true) {
										rPositions.remove(0);
										rankBy1 = false;
									}
								}
							
							//If the pawn is in the start position, allow it to move two additional spaces
							if(whitePawns.get(wPawnChoice-1).getRank() == 2) {
								rPositions.add(theBoard.getBoard()[rowIdx+2][columnIdx]);
							}
							
							//Check to see if other white pieces are two spaces ahead of the pawn
							if(chosenPawn.getRank() == 2) {
							for(int i = 0; i < whitePieces.size();++i) {
								if(whitePieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx+2][columnIdx]) == true) {
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
							if(chosenPawn.getRank() == 2) {
							for(int i = 0; i < blackPieces.size();++i) {
								if(blackPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx+2][columnIdx]) == true) {
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
							for(int i = 0; i < blackPieces.size(); ++i) {
								if(cPositions.size() == 1) {
									if(blackPieces.get(i).getPosition().equals(cPositions.get(0)) == true) {
										cPieces.add(blackPieces.get(i));
										System.out.println(cPieces.size());
									}
								}
								else if(cPositions.size() == 2) {
									if(blackPieces.get(i).getPosition().equals(cPositions.get(0)) == true || blackPieces.get(i).getPosition().equals(cPositions.get(1)) == true) {
										cPieces.add(blackPieces.get(i));
									}
								}
								
							}
							
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
								System.out.println("Select a position by inputting any of the valid positions above");
								while(validPosition == false) {
									String pawnPosition = players.nextLine();
									if(rPositions.isEmpty() == false || cPieces.isEmpty() == false) { //If the pawn can move somewhere
										for(int i = 0; i < rPositions.size(); ++i) {
											if(pawnPosition.equals(rPositions.get(i)) == true) {
												validPosition = true;
												for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
													if(whitePieces.get(j).getName().equals(chosenPawn.getName()) == true) {
														whitePieces.get(j).setPosition(pawnPosition);
														break;
													}
												}
												for(int k = 0; k < whitePawns.size(); ++k) { //Update smaller list with new position
													if(whitePawns.get(k).getName().equals(chosenPawn.getName()) == true) {
														whitePawns.get(k).setPosition(pawnPosition);
														if(rankBy1 == true && rankBy2 == true) {
															if(pawnPosition.equals(rPositions.get(0)) == true) {
																whitePawns.get(k).addRank(1);
															}
															else if(pawnPosition.equals(rPositions.get(1)) == true) {
																whitePawns.get(k).addRank(2);
															}
														}
														else if(rankBy1 == true && rankBy2 == false) {
															whitePawns.get(k).addRank(1);
														}
														else if (rankBy1 == false && rankBy2 == true) {
															whitePawns.get(k).addRank(2);
														}
														break;
													}
												}
												whiteTurn = false;
												blackTurn = true;
												break;
											}
										}
										for(int i = 0; i < cPieces.size(); ++i) {
											if(pawnPosition.equals(cPieces.get(i).getPosition()) == true) {
												validPosition = true;
												for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
													if(whitePieces.get(j).getName().equals(chosenPawn.getName()) == true) {
														whitePieces.get(j).setPosition(pawnPosition);
														break;
													}
												}
												for(int k = 0; k < whitePawns.size(); ++k) { //Update smaller list with new position
													if(whitePawns.get(k).getName().equals(chosenPawn.getName()) == true) {
														whitePawns.get(k).setPosition(pawnPosition);
														if(rankBy1 == true && rankBy2 == true) {
															if(pawnPosition.equals(cPositions.get(0)) == true) {
																whitePawns.get(k).addRank(1);
															}
															else if(pawnPosition.equals(cPositions.get(1)) == true) {
																whitePawns.get(k).addRank(2);
															}
														}
														else if(rankBy1 == true && rankBy2 == false) {
															whitePawns.get(k).addRank(1);
														}
														else if (rankBy1 == false && rankBy2 == true) {
															whitePawns.get(k).addRank(2);
														}
														break;
													}
												}
												
												
												//Update larger list for capturing a piece
												for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list, check if king is captured
													if(blackPieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														if(blackPieces.get(j).getName().equals(blackKing.getName())) {
															blackPieces.get(j).setFlag(true);
															blackKing.setFlag(true);
															whiteTurn = false;
															blackTurn = true;
															break;
														}
														else {
															blackPieces.remove(j);
															whiteTurn = false;
															blackTurn = true;
															break;
														}
													}
								
													}
											}
												//Use multiple loops to find sub list to update
												for(int j = 0; j < blackPawns.size(); ++j) {
													if(blackPawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackPawns.remove(j);
														break;
													}
												}
												for(int j = 0; j < blackKnights.size(); ++j) {
													if(blackKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackKnights.remove(j);
														break;
													}
												}
												for(int j = 0; j < blackBishops.size(); ++j) {
													if(blackBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackBishops.remove(j);
														break;
													}
												}
												for(int j = 0; j < blackRooks.size(); ++j) {
													if(blackRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackRooks.remove(j);
														break;
													}
												}
												
												for(int j = 0; j < blackQueens.size(); ++j) {
													if(blackQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackQueens.remove(j);
														break;
													}
												}
												
												
										}
										//Loop through the pawns after one moves to check if any of them can be promoted
										for(int i = 0; i < whitePawns.size(); ++i) {
											int kCount = 1;
											int bCount = 1;
											int rCount = 1;
											int qCount = 1;
											if(whitePawns.get(i).getRank() == 8) {
												System.out.println(whitePawns.get(i).getName() + " can be promoted. Please select a choice of Knight, Bishop, Rook, or Queen");
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
														System.out.println("This is an invalid promotion condition. Please select a valid condition.");
													}
												}
												if(promotionChoice == 1) {
													for(int j = 0; j < whitePieces.size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(whitePawns.get(i).getName().equals(whitePieces.get(j).getName()) == true) {
															whitePieces.remove(j);
															//If there is already promoted knights in list, add to counter
															for(int k = 0; k < whiteKnights.size(); ++k) {
																if(whiteKnights.get(k).getName().startsWith("Promoted") == true) {
																	++kCount;
																}
															}
														}
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
													whitePawns.remove(i);
													whitePieces.add(new Knight("Promoted " + whiteLabel, whitePawns.get(i).getPosition(), kCount));
													whiteKnights.add(new Knight("Promoted " + whiteLabel, whitePawns.get(i).getPosition(), kCount));
													break;
												}
												else if(promotionChoice == 2) {
													for(int j = 0; j < whitePieces.size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(whitePawns.get(i).getName().equals(whitePieces.get(j).getName()) == true) {
															whitePieces.remove(j);
															//If there is already promoted bishops in list, add to counter
															for(int k = 0; k < whiteBishops.size(); ++k) {
																if(whiteBishops.get(k).getName().startsWith("Promoted") == true) {
																	++bCount;
																}
															}
														}
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
													whitePawns.remove(i);
													whitePieces.add(new Bishop("Promoted " + whiteLabel, whitePawns.get(i).getPosition(), bCount));
													whiteBishops.add(new Bishop("Promoted " + whiteLabel, whitePawns.get(i).getPosition(), bCount));
													break;
												}
												else if(promotionChoice == 3) {
													for(int j = 0; j < whitePieces.size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(whitePawns.get(i).getName().equals(whitePieces.get(j).getName()) == true) {
															whitePieces.remove(j);
															//If there is already promoted rooks in list, add to counter
															for(int k = 0; k < whiteRooks.size(); ++k) {
																if(whiteRooks.get(k).getName().startsWith("Promoted") == true) {
																	++rCount;
																}
															}
														}
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
													whitePawns.remove(i);
													whitePieces.add(new Rook("Promoted " + whiteLabel, whitePawns.get(i).getPosition(), rCount));
													whiteRooks.add(new Rook("Promoted " + whiteLabel, whitePawns.get(i).getPosition(), rCount));
													break;
												}
												else if(promotionChoice == 4) {
													for(int j = 0; j < whitePieces.size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(whitePawns.get(i).getName().equals(whitePieces.get(j).getName()) == true) {
															whitePieces.remove(j);
															//If there is already promoted queens in list, add to counter
															for(int k = 0; k < whiteQueens.size(); ++k) {
																if(whiteQueens.get(k).getName().startsWith("Promoted") == true) {
																	++qCount;
																}
															}
														}
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
													whitePawns.remove(i);
													whitePieces.add(new Queen(whiteLabel + " Promoted", whitePawns.get(i).getPosition(), qCount));
													whiteQueens.add(new Queen(whiteLabel + " Promoted", whitePawns.get(i).getPosition(), qCount));
													break;
												}
											}
										}
									}
									if(blackKing.getFlag() == true) {
										gameEnd = true;
										System.out.println("CHECKMATE. The black team's king has been captured. White team wins!");
									}
								}
							}
		
						}
				}
					else if(typeChoice == 2) {
						if(whiteKnights.isEmpty() == true) {
							System.out.println("You no longer have any knights. Please select another piece type.");
						}
						else {
							System.out.println("Please select the knight from the following list of choices: ");
							int knightChoice = 1;
							for(int i = 0; i < whiteKnights.size(); ++i) {
								System.out.println(knightChoice + " = " + whiteKnights.get(i).getName());
								++knightChoice;
							}
							boolean kChoice = false;
							int wKnightChoice = 0;
							while(kChoice == false) {
								wKnightChoice = players.nextInt();
								if(wKnightChoice < 1 || wKnightChoice > whiteKnights.size()) {
									System.out.println("This is an invalid choice. Please select a valid knight.");
								}
								else {
									kChoice = true;
								}
							}
							Knight chosenKnight = whiteKnights.get(wKnightChoice-1);
							System.out.println("This knight's position on the board is " + chosenKnight.getPosition());
							int rowIdx = 0;
							int columnIdx = 0;
							for(int i = 0; i < theBoard.getBoard().length; ++i) {
								for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
									if(chosenKnight.getPosition().equals(theBoard.getBoard()[i][j])) {
										rowIdx = i;
										columnIdx = j;
									}
								}
							}
							ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
							boolean validPosition = false; //To be used to get proper input for a user's choice in position
							ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
							
							//Add possible positions a knight can travel. Keep base cases in mind (Ex: can't travel right if at rightmost column
							if(rowIdx != 7 && (columnIdx != 6 && columnIdx != 7)) {
								rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx + 2]);
							}
							if((rowIdx != 6 && rowIdx != 7) && columnIdx != 7) {
								rPositions.add(theBoard.getBoard()[rowIdx + 2][columnIdx + 1]);
							}
							if(rowIdx != 7 && (columnIdx != 1 && columnIdx != 0)) {
								rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx - 2]);
							}
							if((rowIdx != 6 && rowIdx != 7) && columnIdx != 0) {
								rPositions.add(theBoard.getBoard()[rowIdx + 2][columnIdx - 1]);
							}
							if(rowIdx != 0 && (columnIdx != 6 && columnIdx != 7)) {
								rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx + 2]);
							}
							if((rowIdx != 1 && rowIdx != 0) && columnIdx != 7) {
								rPositions.add(theBoard.getBoard()[rowIdx - 2][columnIdx + 1]);
							}
							if(rowIdx != 0 && (columnIdx != 1 && columnIdx != 0)) {
								rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx - 2]);
							}
							if((rowIdx != 1 && rowIdx != 0) && columnIdx != 0) {
								rPositions.add(theBoard.getBoard()[rowIdx - 2][columnIdx - 1]);
							}
							
							//Check that there are no white pieces in the knight's possible positions
							for(int i = 0; i < whitePieces.size(); ++i) {
								for(int j = 0; j < rPositions.size(); ++j) {
									if(rPositions.get(j).equals(whitePieces.get(i).getPosition())) {
										rPositions.remove(j);
									}
								}
							}
							
							//Check for possible black pieces that can be captured
							for(int i = 0; i < blackPieces.size(); ++i) {
								for(int j = 0; j < rPositions.size(); ++j) {
									if(rPositions.get(j).equals(blackPieces.get(i).getPosition())) {
										rPositions.remove(j);
										cPieces.add(blackPieces.get(i));	
									}
								}
							}
							
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
												for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
													if(whitePieces.get(j).getName().equals(chosenKnight.getName()) == true) {
														whitePieces.get(j).setPosition(knightPosition);
														break;
													}
												}
												for(int k = 0; k < whiteKnights.size(); ++k) { //Update smaller list with new position
													if(whiteKnights.get(k).getName().equals(chosenKnight.getName()) == true) {
														whiteKnights.get(k).setPosition(knightPosition);
													}
												}
												whiteTurn = false;
												blackTurn = true;
												break;
											}
										}
										for(int i = 0; i < cPieces.size(); ++i) {
											if(knightPosition.equals(cPieces.get(i).getPosition()) == true) {
												validPosition = true;
												for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
													if(whitePieces.get(j).getName().equals(chosenKnight.getName()) == true) {
														whitePieces.get(j).setPosition(knightPosition);
														break;
													}
												}
												for(int k = 0; k < whiteKnights.size(); ++k) { //Update smaller list with new position
													if(whiteKnights.get(k).getName().equals(chosenKnight.getName()) == true) {
														whiteKnights.get(k).setPosition(knightPosition);
													}
												}
												whiteTurn = false;
												blackTurn = true;
												break;
											}
											
										}
										//Update larger list for capturing a piece
										for(int i = 0; i < cPieces.size(); ++i) {
											if(knightPosition.equals(cPieces.get(i).getPosition()) == true) {
												validPosition = true;
												for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
													if(whitePieces.get(j).getName().equals(chosenKnight.getName()) == true) {
														whitePieces.get(j).setPosition(knightPosition);
														break;
													}
												}
												for(int k = 0; k < whiteKnights.size(); ++k) { //Update smaller list with new position
													if(whiteKnights.get(k).getName().equals(chosenKnight.getName()) == true) {
														whiteKnights.get(k).setPosition(knightPosition);
														break;
													}
												}
												
												
												//Update larger list for capturing a piece
												for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list, check if king is captured
													if(blackPieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														if(blackPieces.get(j).getName().equals(blackKing.getName())) {
															blackPieces.get(j).setFlag(true);
															blackKing.setFlag(true);
															whiteTurn = false;
															blackTurn = true;
															break;
														}
														else {
															blackPieces.remove(j);
															whiteTurn = false;
															blackTurn = true;
															break;
														}
													}
								
													}
											}
												//Use multiple loops to find sub list to update
												for(int j = 0; j < blackPawns.size(); ++j) {
													if(blackPawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackPawns.remove(j);
														break;
													}
												}
												for(int j = 0; j < blackKnights.size(); ++j) {
													if(blackKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackKnights.remove(j);
														break;
													}
												}
												for(int j = 0; j < blackBishops.size(); ++j) {
													if(blackBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackBishops.remove(j);
														break;
													}
												}
												for(int j = 0; j < blackRooks.size(); ++j) {
													if(blackRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackRooks.remove(j);
														break;
													}
												}
												
												for(int j = 0; j < blackQueens.size(); ++j) {
													if(blackQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														blackQueens.remove(j);
														break;
													}
												}
												if(blackKing.getFlag() == true) {
													gameEnd = true;
													System.out.println("CHECKMATE. The black team's king has been captured. White team wins!");
												}
										}
									}
								}
							}
						}
						
						
					}
				
				else if(typeChoice == 3) {
					if(whiteBishops.isEmpty() == true) {
						System.out.println("You no longer have any bishops. Please select another piece type.");
					}
					else {
						System.out.println("Please select the bishop from the following list of choices: ");
						int bishopChoice = 1;
						for(int i = 0; i < whiteBishops.size(); ++i) {
							System.out.println(bishopChoice + " = " + whiteBishops.get(i).getName());
							++bishopChoice;
						}
						boolean bChoice = false;
						int wBishopChoice = 0;
						while(bChoice == false) {
							wBishopChoice = players.nextInt();
							if(wBishopChoice < 1 || wBishopChoice > whiteBishops.size()) {
								System.out.println("This is an invalid choice. Please select a valid bishop.");
							}
							else {
								bChoice = true;
							}
						}
						Bishop chosenBishop = whiteBishops.get(wBishopChoice-1);
						System.out.println("This bishop's position on the board is " + chosenBishop.getPosition());
						int rowIdx = 0;
						int columnIdx = 0;
						for(int i = 0; i < theBoard.getBoard().length; ++i) {
							for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
								if(chosenBishop.getPosition().equals(theBoard.getBoard()[i][j])) {
									rowIdx = i;
									columnIdx = j;
								}
							}
						}
						ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
						boolean validPosition = false; //To be used to get proper input for a user's choice in position
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
								System.out.println(rPositions.size());
								System.out.println(whitePieces.size());
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										System.out.println(j);
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											rightUp = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											leftUp = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											rightDown = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											leftDown = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
												if(whitePieces.get(j).getName().equals(chosenBishop.getName()) == true) {
													whitePieces.get(j).setPosition(bishopPosition);
													break;
												}
											}
											for(int k = 0; k < whiteBishops.size(); ++k) { //Update smaller list with new position
												if(whiteBishops.get(k).getName().equals(chosenBishop.getName()) == true) {
													whiteBishops.get(k).setPosition(bishopPosition);
												}
											}
											whiteTurn = false;
											blackTurn = true;
											break;
										}
									}
									for(int i = 0; i < cPieces.size(); ++i) {
										if(bishopPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
												if(whitePieces.get(j).getName().equals(chosenBishop.getName()) == true) {
													whitePieces.get(j).setPosition(bishopPosition);
													break;
												}
											}
											for(int k = 0; k < whiteBishops.size(); ++k) { //Update smaller list with new position
												if(whiteBishops.get(k).getName().equals(chosenBishop.getName()) == true) {
													whiteBishops.get(k).setPosition(bishopPosition);
												}
											}
											whiteTurn = false;
											blackTurn = true;
											break;
										}
										
									}
									//Update larger list for capturing a piece
									for(int i = 0; i < cPieces.size(); ++i) {
										if(bishopPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
												if(whitePieces.get(j).getName().equals(chosenBishop.getName()) == true) {
													whitePieces.get(j).setPosition(bishopPosition);
													break;
												}
											}
											for(int k = 0; k < whiteBishops.size(); ++k) { //Update smaller list with new position
												if(whiteBishops.get(k).getName().equals(chosenBishop.getName()) == true) {
													whiteBishops.get(k).setPosition(bishopPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list, check if king is captured
												if(blackPieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													if(blackPieces.get(j).getName().equals(blackKing.getName())) {
														blackPieces.get(j).setFlag(true);
														blackKing.setFlag(true);
														whiteTurn = false;
														blackTurn = true;
														break;
													}
													else {
														blackPieces.remove(j);
														whiteTurn = false;
														blackTurn = true;
														break;
													}
												}
							
												}
										}
											//Use multiple loops to find sub list to update
											for(int j = 0; j < blackPawns.size(); ++j) {
												if(blackPawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackPawns.remove(j);
													break;
												}
											}
											for(int j = 0; j < blackKnights.size(); ++j) {
												if(blackKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackKnights.remove(j);
													break;
												}
											}
											for(int j = 0; j < blackBishops.size(); ++j) {
												if(blackBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackBishops.remove(j);
													break;
												}
											}
											for(int j = 0; j < blackRooks.size(); ++j) {
												if(blackRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackRooks.remove(j);
													break;
												}
											}
											
											for(int j = 0; j < blackQueens.size(); ++j) {
												if(blackQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackQueens.remove(j);
													break;
												}
											}
											if(blackKing.getFlag() == true) {
												gameEnd = true;
												System.out.println("CHECKMATE. The black team's king has been captured. White team wins!");
											}
									}
								}
							}
						}
						
						
						
					}
				}
				else if(typeChoice == 4) {
					if(whiteRooks.isEmpty() == true) {
						System.out.println("You no longer have any rooks. Please select another piece type");
					}
					else {
						System.out.println("Please select the rook from the following list of choices: ");
						int rookChoice = 1;
						for(int i = 0; i < whiteRooks.size(); ++i) {
							System.out.println(rookChoice + " = " + whiteRooks.get(i).getName());
							++rookChoice;
						}
						boolean rChoice = false;
						int wRookChoice = 0;
						while(rChoice == false) {
							wRookChoice = players.nextInt();
							if(wRookChoice < 1 || wRookChoice > whiteRooks.size()) {
								System.out.println("This is an invalid choice. Please select a valid bishop.");
							}
							else {
								rChoice = true;
							}
						}
						Rook chosenRook = whiteRooks.get(wRookChoice-1);
						System.out.println("This rook's position on the board is " + chosenRook.getPosition());
						int rowIdx = 0;
						int columnIdx = 0;
						for(int i = 0; i < theBoard.getBoard().length; ++i) {
							for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
								if(chosenRook.getPosition().equals(theBoard.getBoard()[i][j])) {
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											up = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											down = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											right = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											left = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
												if(whitePieces.get(j).getName().equals(chosenRook.getName()) == true) {
													whitePieces.get(j).setPosition(rookPosition);
													break;
												}
											}
											for(int k = 0; k < whiteRooks.size(); ++k) { //Update smaller list with new position
												if(whiteRooks.get(k).getName().equals(chosenRook.getName()) == true) {
													whiteRooks.get(k).setPosition(rookPosition);
												}
											}
											whiteTurn = false;
											blackTurn = true;
											break;
										}
									}
									for(int i = 0; i < cPieces.size(); ++i) {
										if(rookPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
												if(whitePieces.get(j).getName().equals(chosenRook.getName()) == true) {
													whitePieces.get(j).setPosition(rookPosition);
													break;
												}
											}
											for(int k = 0; k < whiteRooks.size(); ++k) { //Update smaller list with new position
												if(whiteRooks.get(k).getName().equals(chosenRook.getName()) == true) {
													whiteRooks.get(k).setPosition(rookPosition);
												}
											}
											whiteTurn = false;
											blackTurn = true;
											break;
										}
										
									}
									//Update larger list for capturing a piece
									for(int i = 0; i < cPieces.size(); ++i) {
										if(rookPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
												if(whitePieces.get(j).getName().equals(chosenRook.getName()) == true) {
													whitePieces.get(j).setPosition(rookPosition);
													break;
												}
											}
											for(int k = 0; k < whiteRooks.size(); ++k) { //Update smaller list with new position
												if(whiteRooks.get(k).getName().equals(chosenRook.getName()) == true) {
													whiteRooks.get(k).setPosition(rookPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list, check if king is captured
												if(blackPieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													if(blackPieces.get(j).getName().equals(blackKing.getName())) {
														blackPieces.get(j).setFlag(true);
														blackKing.setFlag(true);
														whiteTurn = false;
														blackTurn = true;
														break;
													}
													else {
														blackPieces.remove(j);
														whiteTurn = false;
														blackTurn = true;
														break;
													}
												}
							
												}
										}
											//Use multiple loops to find sub list to update
											for(int j = 0; j < blackPawns.size(); ++j) {
												if(blackPawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackPawns.remove(j);
													break;
												}
											}
											for(int j = 0; j < blackKnights.size(); ++j) {
												if(blackKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackKnights.remove(j);
													break;
												}
											}
											for(int j = 0; j < blackBishops.size(); ++j) {
												if(blackBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackBishops.remove(j);
													break;
												}
											}
											for(int j = 0; j < blackRooks.size(); ++j) {
												if(blackRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackRooks.remove(j);
													break;
												}
											}
											
											for(int j = 0; j < blackQueens.size(); ++j) {
												if(blackQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackQueens.remove(j);
													break;
												}
											}
											if(blackKing.getFlag() == true) {
												gameEnd = true;
												System.out.println("CHECKMATE. The black team's king has been captured. White team wins!");
											}
									}
								}
							}
						}
					}
				}
				else if(typeChoice == 5) {
					if(whiteQueens.isEmpty() == true) {
						System.out.println("You no longer have any queens. Please select another piece type");
					}
					else {
						System.out.println("Please select the rook from the following list of choices: ");
						int queenChoice = 1;
						for(int i = 0; i < whiteQueens.size(); ++i) {
							System.out.println(queenChoice + " = " + whiteQueens.get(i).getName());
							++queenChoice;
						}
						boolean qChoice = false;
						int wQueenChoice = 0;
						while(qChoice == false) {
							wQueenChoice = players.nextInt();
							if(wQueenChoice < 1 || wQueenChoice > whiteQueens.size()) {
								System.out.println("This is an invalid choice. Please select a valid queen.");
							}
							else {
								qChoice = true;
							}
						}
						Queen chosenQueen = whiteQueens.get(wQueenChoice-1);
						System.out.println("This queen's position on the board is " + chosenQueen.getPosition());
						int rowIdx = 0;
						int columnIdx = 0;
						
						for(int i = 0; i < theBoard.getBoard().length; ++i) {
							for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
								if(chosenQueen.getPosition().equals(theBoard.getBoard()[i][j])) {
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											up = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											down = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											right = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											left = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											rightUp = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											leftUp = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											rightDown = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											rPositions.remove(i);
											leftDown = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
												if(whitePieces.get(j).getName().equals(chosenQueen.getName()) == true) {
													whitePieces.get(j).setPosition(queenPosition);
													break;
												}
											}
											for(int k = 0; k < whiteQueens.size(); ++k) { //Update smaller list with new position
												if(whiteQueens.get(k).getName().equals(chosenQueen.getName()) == true) {
													whiteQueens.get(k).setPosition(queenPosition);
												}
											}
											whiteTurn = false;
											blackTurn = true;
											break;
										}
									}
									for(int i = 0; i < cPieces.size(); ++i) {
										if(queenPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
												if(whitePieces.get(j).getName().equals(chosenQueen.getName()) == true) {
													whitePieces.get(j).setPosition(queenPosition);
													break;
												}
											}
											for(int k = 0; k < whiteQueens.size(); ++k) { //Update smaller list with new position
												if(whiteQueens.get(k).getName().equals(chosenQueen.getName()) == true) {
													whiteQueens.get(k).setPosition(queenPosition);
												}
											}
											whiteTurn = false;
											blackTurn = true;
											break;
										}
										
									}
									//Update larger list for capturing a piece
									for(int i = 0; i < cPieces.size(); ++i) {
										if(queenPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
												if(whitePieces.get(j).getName().equals(chosenQueen.getName()) == true) {
													whitePieces.get(j).setPosition(queenPosition);
													break;
												}
											}
											for(int k = 0; k < whiteQueens.size(); ++k) { //Update smaller list with new position
												if(whiteQueens.get(k).getName().equals(chosenQueen.getName()) == true) {
													whiteQueens.get(k).setPosition(queenPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list, check if king is captured
												if(blackPieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													if(blackPieces.get(j).getName().equals(blackKing.getName())) {
														blackPieces.get(j).setFlag(true);
														blackKing.setFlag(true);
														whiteTurn = false;
														blackTurn = true;
														break;
													}
													else {
														blackPieces.remove(j);
														whiteTurn = false;
														blackTurn = true;
														break;
													}
												}
							
												}
										}
											//Use multiple loops to find sub list to update
											for(int j = 0; j < blackPawns.size(); ++j) {
												if(blackPawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackPawns.remove(j);
													break;
												}
											}
											for(int j = 0; j < blackKnights.size(); ++j) {
												if(blackKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackKnights.remove(j);
													break;
												}
											}
											for(int j = 0; j < blackBishops.size(); ++j) {
												if(blackBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackBishops.remove(j);
													break;
												}
											}
											for(int j = 0; j < blackRooks.size(); ++j) {
												if(blackRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackRooks.remove(j);
													break;
												}
											}
											
											for(int j = 0; j < blackQueens.size(); ++j) {
												if(blackQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													blackQueens.remove(j);
													break;
												}
											}
											if(blackKing.getFlag() == true) {
												gameEnd = true;
												System.out.println("CHECKMATE. The black team's king has been captured. White team wins!");
											}
									}
								}
							}
						}
					}
				}
				else if(typeChoice == 6) {
					System.out.println("The king's position on the board is " + whiteKing.getPosition());
					int rowIdx = 0;
					int columnIdx = 0;
					
					for(int i = 0; i < theBoard.getBoard().length; ++i) {
						for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
							if(whiteKing.getPosition().equals(theBoard.getBoard()[i][j])) {
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
					for(int i = 0; i < whitePieces.size(); ++i) {
						for(int j = 0; j < rPositions.size(); ++j) {
							if(rPositions.get(j).equals(whitePieces.get(i).getPosition())) {
								rPositions.remove(j);
							}
						}
					}
					
					//Check for possible black pieces that can be captured
					for(int i = 0; i < blackPieces.size(); ++i) {
						for(int j = 0; j < rPositions.size(); ++j) {
							if(rPositions.get(j).equals(blackPieces.get(i).getPosition())) {
								rPositions.remove(j);
								cPieces.add(blackPieces.get(i));	
							}
						}
					}
					
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
										for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
											if(whitePieces.get(j).getName().equals(whiteKing.getName()) == true) {
												whitePieces.get(j).setPosition(kingPosition);
												break;
											}
										}
										 //Update white king
										whiteKing.setPosition(kingPosition);
										
										whiteTurn = false;
										blackTurn = true;
										
									}
								}
								for(int i = 0; i < cPieces.size(); ++i) {
									if(kingPosition.equals(cPieces.get(i).getPosition()) == true) {
										validPosition = true;
										for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
											if(whitePieces.get(j).getName().equals(whiteKing.getName()) == true) {
												whitePieces.get(j).setPosition(kingPosition);
												break;
											}
										}
										whiteKing.setPosition(kingPosition);
											
										
										whiteTurn = false;
										blackTurn = true;
										
									}
									
								}
								//Update larger list for capturing a piece
								for(int i = 0; i < cPieces.size(); ++i) {
									if(kingPosition.equals(cPieces.get(i).getPosition()) == true) {
										validPosition = true;
										for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list with new position
											if(whitePieces.get(j).getName().equals(whiteKing.getName()) == true) {
												whitePieces.get(j).setPosition(kingPosition);
												break;
											}
										}
										whiteKing.setPosition(kingPosition);
												
											
										
										
										
										//Update larger list for capturing a piece
										for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list, check if king is captured
											if(blackPieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												if(blackPieces.get(j).getName().equals(blackKing.getName())) {
													blackPieces.get(j).setFlag(true);
													blackKing.setFlag(true);
													whiteTurn = false;
													blackTurn = true;
													break;
												}
												else {
													blackPieces.remove(j);
													whiteTurn = false;
													blackTurn = true;
													break;
												}
											}
						
											}
									}
										//Use multiple loops to find sub list to update
										for(int j = 0; j < blackPawns.size(); ++j) {
											if(blackPawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												blackPawns.remove(j);
												break;
											}
										}
										for(int j = 0; j < blackKnights.size(); ++j) {
											if(blackKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												blackKnights.remove(j);
												break;
											}
										}
										for(int j = 0; j < blackBishops.size(); ++j) {
											if(blackBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												blackBishops.remove(j);
												break;
											}
										}
										for(int j = 0; j < blackRooks.size(); ++j) {
											if(blackRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												blackRooks.remove(j);
												break;
											}
										}
										
										for(int j = 0; j < blackQueens.size(); ++j) {
											if(blackQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												blackQueens.remove(j);
												break;
											}
										}
										if(blackKing.getFlag() == true) {
											gameEnd = true;
											System.out.println("CHECKMATE. The black team's king has been captured. White team wins!");
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
					System.out.println(blackPawns.size());
					if(blackPawns.isEmpty() == true) {
						System.out.println("You no longer have any pawns. Please select another piece type.");
					}
					else {
						System.out.println("Please select the Pawn you would like to use from the following choices: ");
						int pawnChoice = 1;
						for(int i = 0; i < blackPawns.size(); ++i) {
							System.out.println(pawnChoice + " = " + blackPawns.get(i).getName());
							++pawnChoice;
						}
						boolean pChoice = false;
						while(pChoice == false) {
							int bPawnChoice = players.nextInt();
						if(bPawnChoice == 1 || bPawnChoice == 2 || bPawnChoice == 3 || bPawnChoice == 4 || bPawnChoice == 5 || bPawnChoice == 6 || bPawnChoice == 7 || bPawnChoice == 8) {
							pChoice = true;
							Pawn chosenPawn = blackPawns.get(bPawnChoice-1);
							System.out.println("This pawn's position on the board is " + chosenPawn.getPosition());
							int rowIdx = 0;
							int columnIdx = 0;
							for(int i = 0; i < theBoard.getBoard().length; ++i) {
								for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
									if(chosenPawn.getPosition().equals(theBoard.getBoard()[i][j])) {
										rowIdx = i;
										columnIdx = j;
									}
								}
							}
							ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
							ArrayList <String> cPositions = new ArrayList(); //Represents capture positions
							boolean validPosition = false; //To be used to get proper input for a user's choice in position
							rPositions.add(theBoard.getBoard()[rowIdx-1][columnIdx]); 
							ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
							boolean rankBy1 = true;
							boolean rankBy2 = true;
							
							//Check if any black pieces are in front of the the current pawn
							for(int i = 0; i < blackPieces.size();++i) {
								if(blackPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx-1][columnIdx]) == true) {
									rPositions.remove(0);
									rankBy1 = false;
								}
							}
							//Check if any white pieces are in front of current pawn
								for(int i = 0; i < whitePieces.size();++i) {
									if(whitePieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx-1][columnIdx]) == true) {
										rPositions.remove(0);
										rankBy1 = false;
									}
								}
							
							//If the pawn is in the start position, allow it to move two additional spaces
							if(blackPawns.get(bPawnChoice-1).getRank() == 2) {
								rPositions.add(theBoard.getBoard()[rowIdx-2][columnIdx]);
							}
							
							//Check to see if other black pieces are two spaces ahead of the pawn
							if(chosenPawn.getRank() == 2) {
							for(int i = 0; i < blackPieces.size();++i) {
								if(blackPieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx-2][columnIdx]) == true) {
									if(rPositions.isEmpty() == true) {
										rPositions.remove(0);
										rankBy2 = false;
									}
									else {
										rPositions.remove(1);
										rankBy2 = false;
									}
									
								}
							}
							}
							//Check if any white pieces are two spaces in front of current pawn
							if(chosenPawn.getRank() == 2) {
							for(int i = 0; i < whitePieces.size();++i) {
								if(whitePieces.get(i).getPosition().equals(theBoard.getBoard()[rowIdx-2][columnIdx]) == true) {
									if(rPositions.isEmpty() == true) {
										rPositions.remove(0);
										rankBy2 = false;
									}
									else {
										rPositions.remove(1);
										rankBy2 = false;
									}
									
								}
							}
							}
							
							
							//Make note of the pawn's capture positions. Since they capture diagonally, move up a row and go either to the left or right column
							if(columnIdx != 7) {
								cPositions.add(theBoard.getBoard()[rowIdx-1][columnIdx+1]);
							}
							if(columnIdx != 0) {
								cPositions.add(theBoard.getBoard()[rowIdx-1][columnIdx-1]);
							}
							
							//Check if there are any white pieces in the pawn's capture positions
							int count = 0;
							System.out.println(cPositions.size());
							for(int i = 0; i < whitePieces.size(); ++i) {
								if(cPositions.size() == 1) {
									if(whitePieces.get(i).getPosition().equals(cPositions.get(0)) == true) {
										cPieces.add(whitePieces.get(i));
										
									}
								}
								else if(cPositions.size() == 2) {
									if(whitePieces.get(i).getPosition().equals(cPositions.get(0)) == true || whitePieces.get(i).getPosition().equals(cPositions.get(1)) == true) {
										cPieces.add(whitePieces.get(i));
										
									}
								}
								
							}
							
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
												for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
													if(blackPieces.get(j).getName().equals(chosenPawn.getName()) == true) {
														blackPieces.get(j).setPosition(pawnPosition);
														break;
													}
												}
												for(int k = 0; k < blackPawns.size(); ++k) { //Update smaller list with new position
													if(blackPawns.get(k).getName().equals(chosenPawn.getName()) == true) {
														blackPawns.get(k).setPosition(pawnPosition);
														if(rankBy1 == true && rankBy2 == true) {
															if(pawnPosition.equals(rPositions.get(0)) == true) {
																blackPawns.get(k).addRank(1);
															}
															else if(pawnPosition.equals(rPositions.get(1)) == true) {
																blackPawns.get(k).addRank(2);
															}
														}
														else if(rankBy1 == true && rankBy2 == false) {
															blackPawns.get(k).addRank(1);
														}
														else if (rankBy1 == false && rankBy2 == true) {
															blackPawns.get(k).addRank(2);
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
												for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
													if(blackPieces.get(j).getName().equals(chosenPawn.getName()) == true) {
														blackPieces.get(j).setPosition(pawnPosition);
														break;
													}
												}
												for(int k = 0; k < blackPawns.size(); ++k) { //Update smaller list with new position
													if(blackPawns.get(k).getName().equals(chosenPawn.getName()) == true) {
														blackPawns.get(k).setPosition(pawnPosition);
														if(rankBy1 == true && rankBy2 == true) {
															if(pawnPosition.equals(rPositions.get(0)) == true) {
																blackPawns.get(k).addRank(1);
															}
															else if(pawnPosition.equals(rPositions.get(1)) == true) {
																blackPawns.get(k).addRank(2);
															}
														}
														else if(rankBy1 == true && rankBy2 == false) {
															blackPawns.get(k).addRank(1);
														}
														else if (rankBy1 == false && rankBy2 == true) {
															blackPawns.get(k).addRank(2);
														}
														break;
													}
												}
												
												
												//Update larger list for capturing a piece
												for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list, check if king is captured
													if(whitePieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														if(whitePieces.get(j).getName().equals(whiteKing.getName())) {
															whitePieces.get(j).setFlag(true);
															whiteKing.setFlag(true);
															whiteTurn = true;
															blackTurn = false;
															break;
														}
														else {
															whitePieces.remove(j);
															whiteTurn = true;
															blackTurn = false;
															break;
														}
													}
								
													}
											}
												//Use multiple loops to find sub list to update
												for(int j = 0; j < whitePawns.size(); ++j) {
													if(whitePawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														whitePawns.remove(j);
														break;
													}
												}
												for(int j = 0; j < whiteKnights.size(); ++j) {
													if(whiteKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														whiteKnights.remove(j);
														break;
													}
												}
												for(int j = 0; j < whiteBishops.size(); ++j) {
													if(whiteBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														whiteBishops.remove(j);
														break;
													}
												}
												for(int j = 0; j < whiteRooks.size(); ++j) {
													if(whiteRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														whiteRooks.remove(j);
														break;
													}
												}
												
												for(int j = 0; j < whiteQueens.size(); ++j) {
													if(whiteQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
														whiteQueens.remove(j);
														break;
													}
												}
												
												
										}
										//Code for promoting a pawn
										for(int i = 0; i < blackPawns.size(); ++i) {
											int kCount = 1;
											int bCount = 1;
											int rCount = 1;
											int qCount = 1;
											if(blackPawns.get(i).getRank() == 8) {
												System.out.println(blackPawns.get(i).getName() + " can be promoted. Please select a choice of Knight, Bishop, Rook, or Queen");
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
													for(int j = 0; j < blackPieces.size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(blackPawns.get(i).getName().equals(blackPieces.get(j).getName()) == true) {
															blackPieces.remove(j);
															//If there is already promoted knights in list, add to counter
															for(int k = 0; k < blackKnights.size(); ++k) {
																if(blackKnights.get(k).getName().startsWith("Promoted") == true) {
																	++kCount;
																}
															}
														}
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
													blackPawns.remove(i);
													blackPieces.add(new Knight("Promoted " + blackLabel, blackPawns.get(i).getPosition(), kCount));
													blackKnights.add(new Knight("Promoted " + blackLabel, blackPawns.get(i).getPosition(), kCount));
													break;
												}
												else if(promotionChoice == 2) {
													for(int j = 0; j < whitePieces.size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(blackPawns.get(i).getName().equals(whitePieces.get(j).getName()) == true) {
															blackPieces.remove(j);
															//If there is already promoted bishops in list, add to counter
															for(int k = 0; k < blackBishops.size(); ++k) {
																if(blackBishops.get(k).getName().startsWith("Promoted") == true) {
																	++bCount;
																}
															}
														}
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
													blackPawns.remove(i);
													blackPieces.add(new Bishop("Promoted " + blackLabel, blackPawns.get(i).getPosition(), bCount));
													blackBishops.add(new Bishop("Promoted " + blackLabel, blackPawns.get(i).getPosition(), bCount));
													break;
												}
												else if(promotionChoice == 3) {
													for(int j = 0; j < blackPieces.size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(blackPawns.get(i).getName().equals(blackPieces.get(j).getName()) == true) {
															blackPieces.remove(j);
															//If there is already promoted rooks in list, add to counter
															for(int k = 0; k < blackRooks.size(); ++k) {
																if(blackRooks.get(k).getName().startsWith("Promoted") == true) {
																	++rCount;
																}
															}
														}
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
													blackPawns.remove(i);
													blackPieces.add(new Rook("Promoted " + blackLabel, blackPawns.get(i).getPosition(), rCount));
													blackRooks.add(new Rook("Promoted " + blackLabel, blackPawns.get(i).getPosition(), rCount));
													break;
												}
												else if(promotionChoice == 4) {
													for(int j = 0; j < blackPieces.size(); ++j) {
														//Remove the pawn that is being promoted from larger list
														if(blackPawns.get(i).getName().equals(blackPieces.get(j).getName()) == true) {
															blackPieces.remove(j);
															//If there is already promoted queens in list, add to counter
															for(int k = 0; k < blackQueens.size(); ++k) {
																if(blackQueens.get(k).getName().startsWith("Promoted") == true) {
																	++qCount;
																}
															}
														}
													}
													//Append new knight to end of larger and smaller list. Remove pawn being promoted from smaller list
													blackPawns.remove(i);
													blackPieces.add(new Queen("Promoted " + blackLabel, blackPawns.get(i).getPosition(), qCount));
													blackQueens.add(new Queen("Promoted " + blackLabel, blackPawns.get(i).getPosition(), qCount));
													break;
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
					if(blackKnights.isEmpty() == true) {
						System.out.println("You no longer have any knights. Please select another piece type.");
					}
					else {
						System.out.println("Please select the knight from the following list of choices: ");
						int knightChoice = 1;
						for(int i = 0; i < blackKnights.size(); ++i) {
							System.out.println(knightChoice + " = " + blackKnights.get(i).getName());
							++knightChoice;
						}
						boolean kChoice = false;
						int bKnightChoice = 0;
						while(kChoice == false) {
							bKnightChoice = players.nextInt();
							if(bKnightChoice < 1 || bKnightChoice > blackKnights.size()) {
								System.out.println("This is an invalid choice. Please select a valid knight.");
							}
							else {
								kChoice = true;
							}
						}
						Knight chosenKnight = blackKnights.get(bKnightChoice-1);
						System.out.println("This knight's position on the board is " + chosenKnight.getPosition());
						int rowIdx = 0;
						int columnIdx = 0;
						for(int i = 0; i < theBoard.getBoard().length; ++i) {
							for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
								if(chosenKnight.getPosition().equals(theBoard.getBoard()[i][j])) {
									rowIdx = i;
									columnIdx = j;
								}
							}
						}
						ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
						boolean validPosition = false; //To be used to get proper input for a user's choice in position
						ArrayList <Piece> cPieces = new ArrayList(); //To be used to keep track of pieces that can be captured
						
						//Add possible positions a knight can travel. Keep base cases in mind (Ex: can't travel right if at rightmost column
						if(rowIdx != 7 && (columnIdx != 6 && columnIdx != 7)) {
							rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx + 2]);
						}
						if((rowIdx != 6 && rowIdx != 7) && columnIdx != 7) {
							rPositions.add(theBoard.getBoard()[rowIdx + 2][columnIdx + 1]);
						}
						if(rowIdx != 7 && (columnIdx != 1 && columnIdx != 0)) {
							rPositions.add(theBoard.getBoard()[rowIdx + 1][columnIdx - 2]);
						}
						if((rowIdx != 6 && rowIdx != 7) && columnIdx != 0) {
							rPositions.add(theBoard.getBoard()[rowIdx + 2][columnIdx - 1]);
						}
						if(rowIdx != 0 && (columnIdx != 6 && columnIdx != 7)) {
							rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx + 2]);
						}
						if((rowIdx != 1 && rowIdx != 0) && columnIdx != 7) {
							rPositions.add(theBoard.getBoard()[rowIdx - 2][columnIdx + 1]);
						}
						if(rowIdx != 0 && (columnIdx != 1 && columnIdx != 0)) {
							rPositions.add(theBoard.getBoard()[rowIdx - 1][columnIdx - 2]);
						}
						if((rowIdx != 1 && rowIdx != 0) && columnIdx != 0) {
							rPositions.add(theBoard.getBoard()[rowIdx - 2][columnIdx - 1]);
						}
						
						//Check that there are no black pieces in the knight's possible positions
						for(int i = 0; i < blackPieces.size(); ++i) {
							for(int j = 0; j < rPositions.size(); ++j) {
								if(rPositions.get(j).equals(blackPieces.get(i).getPosition())) {
									rPositions.remove(j);
								}
							}
						}
						
						//Check for possible white pieces that can be captured
						for(int i = 0; i < whitePieces.size(); ++i) {
							for(int j = 0; j < rPositions.size(); ++j) {
								if(rPositions.get(j).equals(whitePieces.get(i).getPosition())) {
									rPositions.remove(j);
									cPieces.add(whitePieces.get(i));	
								}
							}
						}
						
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
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenKnight.getName()) == true) {
													blackPieces.get(j).setPosition(knightPosition);
													break;
												}
											}
											for(int k = 0; k < blackKnights.size(); ++k) { //Update smaller list with new position
												if(blackKnights.get(k).getName().equals(chosenKnight.getName()) == true) {
													blackKnights.get(k).setPosition(knightPosition);
												}
											}
											whiteTurn = true;
											blackTurn = false;
											break;
										}
									}
									for(int i = 0; i < cPieces.size(); ++i) {
										if(knightPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenKnight.getName()) == true) {
													blackPieces.get(j).setPosition(knightPosition);
													break;
												}
											}
											for(int k = 0; k < blackKnights.size(); ++k) { //Update smaller list with new position
												if(blackKnights.get(k).getName().equals(chosenKnight.getName()) == true) {
													blackKnights.get(k).setPosition(knightPosition);
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
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenKnight.getName()) == true) {
													blackPieces.get(j).setPosition(knightPosition);
													break;
												}
											}
											for(int k = 0; k < blackKnights.size(); ++k) { //Update smaller list with new position
												if(blackKnights.get(k).getName().equals(chosenKnight.getName()) == true) {
													blackKnights.get(k).setPosition(knightPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list, check if king is captured
												if(whitePieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													if(whitePieces.get(j).getName().equals(whiteKing.getName())) {
														whitePieces.get(j).setFlag(true);
														whiteKing.setFlag(true);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
													else {
														whitePieces.remove(j);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
												}
							
												}
										}
											//Use multiple loops to find sub list to update
											for(int j = 0; j < whitePawns.size(); ++j) {
												if(whitePawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whitePawns.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteKnights.size(); ++j) {
												if(whiteKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteKnights.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteBishops.size(); ++j) {
												if(whiteBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteBishops.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteRooks.size(); ++j) {
												if(whiteRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteRooks.remove(j);
													break;
												}
											}
											
											for(int j = 0; j < whiteQueens.size(); ++j) {
												if(whiteQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteQueens.remove(j);
													break;
												}
											}
											if(whiteKing.getFlag() == true) {
												gameEnd = true;
												System.out.println("CHECKMATE. The white team's king has been captured. Black team wins!");
											}
									}
								}
							}
						}
					}
				}
				else if(typeChoice == 3) {
					if(blackBishops.isEmpty() == true) {
						System.out.println("You no longer have any bishops. Please select another piece type.");
					}
					else {
						System.out.println("Please select the bishop from the following list of choices: ");
						int bishopChoice = 1;
						for(int i = 0; i < blackBishops.size(); ++i) {
							System.out.println(bishopChoice + " = " + blackBishops.get(i).getName());
							++bishopChoice;
						}
						boolean bChoice = false;
						int bBishopChoice = 0;
						while(bChoice == false) {
							bBishopChoice = players.nextInt();
							if(bBishopChoice < 1 || bBishopChoice > blackBishops.size()) {
								System.out.println("This is an invalid choice. Please select a valid bishop.");
							}
							else {
								bChoice = true;
							}
						}
						Bishop chosenBishop = blackBishops.get(bBishopChoice-1);
						System.out.println("This bishop's position on the board is " + chosenBishop.getPosition());
						int rowIdx = 0;
						int columnIdx = 0;
						for(int i = 0; i < theBoard.getBoard().length; ++i) {
							for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
								if(chosenBishop.getPosition().equals(theBoard.getBoard()[i][j])) {
									rowIdx = i;
									columnIdx = j;
								}
							}
						}
						ArrayList <String> rPositions = new ArrayList(); //Represents regular positions
						boolean validPosition = false; //To be used to get proper input for a user's choice in position
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
							if(bishopRow != 7 && bishopColumn != 7 ) {
								++bishopRow;
								++bishopColumn;
								String pos = theBoard.getBoard()[bishopRow][bishopColumn];
								rPositions.add(pos);
								for(int i = 0; i < rPositions.size() ; ++i) {
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											rightUp = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											leftUp = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											rightDown = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											leftDown = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenBishop.getName()) == true) {
													blackPieces.get(j).setPosition(bishopPosition);
													break;
												}
											}
											for(int k = 0; k < blackBishops.size(); ++k) { //Update smaller list with new position
												if(blackBishops.get(k).getName().equals(chosenBishop.getName()) == true) {
													blackBishops.get(k).setPosition(bishopPosition);
												}
											}
											whiteTurn = true;
											blackTurn = false;
											break;
										}
									}
									for(int i = 0; i < cPieces.size(); ++i) {
										if(bishopPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenBishop.getName()) == true) {
													blackPieces.get(j).setPosition(bishopPosition);
													break;
												}
											}
											for(int k = 0; k < blackBishops.size(); ++k) { //Update smaller list with new position
												if(blackBishops.get(k).getName().equals(chosenBishop.getName()) == true) {
													blackBishops.get(k).setPosition(bishopPosition);
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
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenBishop.getName()) == true) {
													blackPieces.get(j).setPosition(bishopPosition);
													break;
												}
											}
											for(int k = 0; k < blackBishops.size(); ++k) { //Update smaller list with new position
												if(blackBishops.get(k).getName().equals(chosenBishop.getName()) == true) {
													blackBishops.get(k).setPosition(bishopPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list, check if king is captured
												if(whitePieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													if(whitePieces.get(j).getName().equals(whiteKing.getName())) {
														whitePieces.get(j).setFlag(true);
														whiteKing.setFlag(true);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
													else {
														whitePieces.remove(j);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
												}
							
												}
										}
											//Use multiple loops to find sub list to update
											for(int j = 0; j < whitePawns.size(); ++j) {
												if(whitePawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whitePawns.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteKnights.size(); ++j) {
												if(whiteKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteKnights.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteBishops.size(); ++j) {
												if(whiteBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteBishops.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteRooks.size(); ++j) {
												if(whiteRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteRooks.remove(j);
													break;
												}
											}
											
											for(int j = 0; j < whiteQueens.size(); ++j) {
												if(whiteQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteQueens.remove(j);
													break;
												}
											}
											if(whiteKing.getFlag() == true) {
												gameEnd = true;
												System.out.println("CHECKMATE. The white team's king has been captured. Black team wins!");
											}
									}
								}
							}
						}
						
						
						
					}
				}
				else if(typeChoice == 4) {
					if(blackRooks.isEmpty() == true) {
						System.out.println("You no longer have any rooks. Please select another piece type");
					}
					else {
						System.out.println("Please select the rook from the following list of choices: ");
						int rookChoice = 1;
						for(int i = 0; i < blackRooks.size(); ++i) {
							System.out.println(rookChoice + " = " + blackRooks.get(i).getName());
							++rookChoice;
						}
						boolean rChoice = false;
						int bRookChoice = 0;
						while(rChoice == false) {
							bRookChoice = players.nextInt();
							if(bRookChoice < 1 || bRookChoice > blackRooks.size()) {
								System.out.println("This is an invalid choice. Please select a valid bishop.");
							}
							else {
								rChoice = true;
							}
						}
						Rook chosenRook = whiteRooks.get(bRookChoice-1);
						System.out.println("This rook's position on the board is " + chosenRook.getPosition());
						int rowIdx = 0;
						int columnIdx = 0;
						for(int i = 0; i < theBoard.getBoard().length; ++i) {
							for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
								if(chosenRook.getPosition().equals(theBoard.getBoard()[i][j])) {
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											up = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											down = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											right = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											left = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenRook.getName()) == true) {
													blackPieces.get(j).setPosition(rookPosition);
													break;
												}
											}
											for(int k = 0; k < blackRooks.size(); ++k) { //Update smaller list with new position
												if(blackRooks.get(k).getName().equals(chosenRook.getName()) == true) {
													blackRooks.get(k).setPosition(rookPosition);
												}
											}
											whiteTurn = true;
											blackTurn = false;
											break;
										}
									}
									for(int i = 0; i < cPieces.size(); ++i) {
										if(rookPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenRook.getName()) == true) {
													blackPieces.get(j).setPosition(rookPosition);
													break;
												}
											}
											for(int k = 0; k < blackRooks.size(); ++k) { //Update smaller list with new position
												if(blackRooks.get(k).getName().equals(chosenRook.getName()) == true) {
													blackRooks.get(k).setPosition(rookPosition);
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
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenRook.getName()) == true) {
													blackPieces.get(j).setPosition(rookPosition);
													break;
												}
											}
											for(int k = 0; k < blackRooks.size(); ++k) { //Update smaller list with new position
												if(blackRooks.get(k).getName().equals(chosenRook.getName()) == true) {
													blackRooks.get(k).setPosition(rookPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list, check if king is captured
												if(whitePieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													if(whitePieces.get(j).getName().equals(whiteKing.getName())) {
														whitePieces.get(j).setFlag(true);
														whiteKing.setFlag(true);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
													else {
														whitePieces.remove(j);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
												}
							
												}
										}
											//Use multiple loops to find sub list to update
											for(int j = 0; j < whitePawns.size(); ++j) {
												if(whitePawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whitePawns.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteKnights.size(); ++j) {
												if(whiteKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteKnights.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteBishops.size(); ++j) {
												if(whiteBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteBishops.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteRooks.size(); ++j) {
												if(whiteRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteRooks.remove(j);
													break;
												}
											}
											
											for(int j = 0; j < whiteQueens.size(); ++j) {
												if(whiteQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteQueens.remove(j);
													break;
												}
											}
											if(whiteKing.getFlag() == true) {
												gameEnd = true;
												System.out.println("CHECKMATE. The white team's king has been captured. Black team wins!");
											}
									}
								}
							}
						}
					}
				}
				else if(typeChoice == 5) {
					if(blackQueens.isEmpty() == true) {
						System.out.println("You no longer have any queens. Please select another piece type");
					}
					else {
						System.out.println("Please select the rook from the following list of choices: ");
						int queenChoice = 1;
						for(int i = 0; i < blackQueens.size(); ++i) {
							System.out.println(queenChoice + " = " + blackQueens.get(i).getName());
							++queenChoice;
						}
						boolean qChoice = false;
						int bQueenChoice = 0;
						while(qChoice == false) {
							bQueenChoice = players.nextInt();
							if(bQueenChoice < 1 || bQueenChoice > blackQueens.size()) {
								System.out.println("This is an invalid choice. Please select a valid queen.");
							}
							else {
								qChoice = true;
							}
						}
						Queen chosenQueen = blackQueens.get(bQueenChoice-1);
						System.out.println("This queen's position on the board is " + chosenQueen.getPosition());
						int rowIdx = 0;
						int columnIdx = 0;
						
						for(int i = 0; i < theBoard.getBoard().length; ++i) {
							for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
								if(chosenQueen.getPosition().equals(theBoard.getBoard()[i][j])) {
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											up = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											down = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											right = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											left = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											rightUp = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											leftUp = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											rightDown = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(blackPieces.get(j));
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
									for(int j = 0; j < blackPieces.size(); ++j) {
										if(rPositions.get(i).equals(blackPieces.get(j).getPosition())) {
											rPositions.remove(i);
											leftDown = true;
											break;
										}
									}
								}
								for(int i = 0; i < rPositions.size(); ++i) {
									for(int j = 0; j < whitePieces.size(); ++j) {
										if(rPositions.get(i).equals(whitePieces.get(j).getPosition())) {
											cPieces.add(whitePieces.get(j));
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
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenQueen.getName()) == true) {
													blackPieces.get(j).setPosition(queenPosition);
													break;
												}
											}
											for(int k = 0; k < blackQueens.size(); ++k) { //Update smaller list with new position
												if(blackQueens.get(k).getName().equals(chosenQueen.getName()) == true) {
													blackQueens.get(k).setPosition(queenPosition);
												}
											}
											whiteTurn = true;
											blackTurn = false;
											break;
										}
									}
									for(int i = 0; i < cPieces.size(); ++i) {
										if(queenPosition.equals(cPieces.get(i).getPosition()) == true) {
											validPosition = true;
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenQueen.getName()) == true) {
													blackPieces.get(j).setPosition(queenPosition);
													break;
												}
											}
											for(int k = 0; k < blackQueens.size(); ++k) { //Update smaller list with new position
												if(blackQueens.get(k).getName().equals(chosenQueen.getName()) == true) {
													blackQueens.get(k).setPosition(queenPosition);
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
											for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
												if(blackPieces.get(j).getName().equals(chosenQueen.getName()) == true) {
													blackPieces.get(j).setPosition(queenPosition);
													break;
												}
											}
											for(int k = 0; k < blackQueens.size(); ++k) { //Update smaller list with new position
												if(blackQueens.get(k).getName().equals(chosenQueen.getName()) == true) {
													blackQueens.get(k).setPosition(queenPosition);
													break;
												}
											}
											
											
											//Update larger list for capturing a piece
											for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list, check if king is captured
												if(whitePieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													if(whitePieces.get(j).getName().equals(whiteKing.getName())) {
														whitePieces.get(j).setFlag(true);
														whiteKing.setFlag(true);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
													else {
														whitePieces.remove(j);
														whiteTurn = true;
														blackTurn = false;
														break;
													}
												}
							
												}
										}
											//Use multiple loops to find sub list to update
											for(int j = 0; j < whitePawns.size(); ++j) {
												if(whitePawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whitePawns.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteKnights.size(); ++j) {
												if(whiteKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteKnights.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteBishops.size(); ++j) {
												if(whiteBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteBishops.remove(j);
													break;
												}
											}
											for(int j = 0; j < whiteRooks.size(); ++j) {
												if(whiteRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteRooks.remove(j);
													break;
												}
											}
											
											for(int j = 0; j < whiteQueens.size(); ++j) {
												if(whiteQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
													whiteQueens.remove(j);
													break;
												}
											}
											if(whiteKing.getFlag() == true) {
												gameEnd = true;
												System.out.println("CHECKMATE. The white team's king has been captured. Black team wins!");
											}
									}
								}
							}
						}
					}
				}
				else if(typeChoice == 6) {
					System.out.println("The king's position on the board is " + blackKing.getPosition());
					int rowIdx = 0;
					int columnIdx = 0;
					
					for(int i = 0; i < theBoard.getBoard().length; ++i) {
						for(int j = 0; j < theBoard.getBoard()[i].length; ++j) {
							if(blackKing.getPosition().equals(theBoard.getBoard()[i][j])) {
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
					for(int i = 0; i < blackPieces.size(); ++i) {
						for(int j = 0; j < rPositions.size(); ++j) {
							if(rPositions.get(j).equals(blackPieces.get(i).getPosition())) {
								rPositions.remove(j);
							}
						}
					}
					
					//Check for possible black pieces that can be captured
					for(int i = 0; i < whitePieces.size(); ++i) {
						for(int j = 0; j < rPositions.size(); ++j) {
							if(rPositions.get(j).equals(whitePieces.get(i).getPosition())) {
								rPositions.remove(j);
								cPieces.add(whitePieces.get(i));	
							}
						}
					}
					
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
										for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
											if(blackPieces.get(j).getName().equals(blackKing.getName()) == true) {
												blackPieces.get(j).setPosition(kingPosition);
												break;
											}
										}
										 //Update white king
										whiteKing.setPosition(kingPosition);
										whiteTurn = true;
										blackTurn = false;
										
									}
								}
								for(int i = 0; i < cPieces.size(); ++i) {
									if(kingPosition.equals(cPieces.get(i).getPosition()) == true) {
										validPosition = true;
										for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
											if(blackPieces.get(j).getName().equals(blackKing.getName()) == true) {
												blackPieces.get(j).setPosition(kingPosition);
												break;
											}
										}
										whiteKing.setPosition(kingPosition);
											
										
										whiteTurn = true;
										blackTurn = false;
										
									}
									
								}
								//Update larger list for capturing a piece
								for(int i = 0; i < cPieces.size(); ++i) {
									if(kingPosition.equals(cPieces.get(i).getPosition()) == true) {
										validPosition = true;
										for(int j = 0; j < blackPieces.size(); ++j) { //Update larger list with new position
											if(blackPieces.get(j).getName().equals(blackKing.getName()) == true) {
												blackPieces.get(j).setPosition(kingPosition);
												break;
											}
										}
										blackKing.setPosition(kingPosition);
												
											
										
										
										
										//Update larger list for capturing a piece
										for(int j = 0; j < whitePieces.size(); ++j) { //Update larger list, check if king is captured
											if(whitePieces.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												if(whitePieces.get(j).getName().equals(whiteKing.getName())) {
													whitePieces.get(j).setFlag(true);
													whiteKing.setFlag(true);
													whiteTurn = true;
													blackTurn = false;
													break;
												}
												else {
													whitePieces.remove(j);
													whiteTurn = true;
													blackTurn = false;
													break;
												}
											}
						
											}
									}
										//Use multiple loops to find sub list to update
										for(int j = 0; j < whitePawns.size(); ++j) {
											if(whitePawns.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												whitePawns.remove(j);
												break;
											}
										}
										for(int j = 0; j < whiteKnights.size(); ++j) {
											if(whiteKnights.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												whiteKnights.remove(j);
												break;
											}
										}
										for(int j = 0; j < whiteBishops.size(); ++j) {
											if(whiteBishops.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												whiteBishops.remove(j);
												break;
											}
										}
										for(int j = 0; j < whiteRooks.size(); ++j) {
											if(whiteRooks.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												whiteRooks.remove(j);
												break;
											}
										}
										
										for(int j = 0; j < whiteQueens.size(); ++j) {
											if(whiteQueens.get(j).getName().equals(cPieces.get(i).getName()) == true) {
												whiteQueens.remove(j);
												break;
											}
										}
										if(whiteKing.getFlag() == true) {
											gameEnd = true;
											System.out.println("CHECKMATE. The white team's king has been captured. Black team wins!");
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
			
			
			
			}
		
	
	
	public static void main(String [] args) {
		Chess();
	}
}
