/*
 *	Author:  
 *  Date: 
*/

package pkg;
import java.util.Scanner;
import java.util.Random;


public class game {
	
	piece[][] gameBoard;
	boolean turn;
	
	
	public game() {
		gameBoard = new piece[8][8];
		turn = true;
	}
	
	public void setupChecker() {
		
		int num;
		for (int countY = 0; countY < 8; countY++) {
			if (countY%2 == 0) {
				num = 0;
			}	
			else {
				num = 1;
			}
			for (int countX = 0; countX < 8; countX++) {					
				if (num%2 == 0) {
					gameBoard[countY][countX] = new piece(true);
					num++;
				}
				else {
					gameBoard[countY][countX] = new piece(false);
					num++;
				}
			}
		}
	}
	
	
	public void setupPiece() {
		gameBoard[0][0].setPiece("R",0,0);
		gameBoard[0][7].setPiece("R",7,0);
		gameBoard[0][1].setPiece("H",1,0);
		gameBoard[0][6].setPiece("H",6,0);
		gameBoard[0][2].setPiece("B",2,0);
		gameBoard[0][5].setPiece("B",5,0);
		gameBoard[0][3].setPiece("K",3,0);
		gameBoard[0][4].setPiece("Q",4,0);
		
		for (int count = 0; count < 8; count++) {
			gameBoard[1][count].setPiece("P",count,1);
		}
		
		gameBoard[7][0].setPiece("r",0,7);
		gameBoard[7][7].setPiece("r",7,7);
		gameBoard[7][1].setPiece("h",1,7);
		gameBoard[7][6].setPiece("h",6,7);
		gameBoard[7][2].setPiece("b",2,7);
		gameBoard[7][5].setPiece("b",5,7);
		gameBoard[7][3].setPiece("q",3,7);
		gameBoard[7][4].setPiece("k",4,7);
		
		for (int count = 0; count < 8; count++) {
			gameBoard[6][count].setPiece("p",count,6);
		}
		
	}
	
	
	public void play() {
		Scanner sc = new Scanner(System.in); 
		System.out.print("Player 1 name: ");
		String player1 = sc.nextLine();
		System.out.print("Player 2 name: ");
		String player2 = sc.nextLine();
		System.out.println();
		
		//lower case goes first
		System.out.println(player1 + " is lower case pieces and "+ player2 + " is upper case pieces.");
		System.out.println();
		setupChecker();
		setupPiece();
		
		while (true) {
			printGameBoard();
			System.out.println();
			boolean kingHasToMove = false;
			
			if (getKingPiecePosY(gameBoard, turn) == -1 || getKingPiecePosX(gameBoard, turn) == -1) {
				if (turn) {
					System.out.println(player1 + "lost. Good Game.");
					return;
				}
				else {
					System.out.println(player2 + "lost. Good Game.");
				}
			}
			
			if (gameBoard[getKingPiecePosY(gameBoard, turn)][getKingPiecePosX(gameBoard, turn)].check(gameBoard, getKingPiecePosY(gameBoard, turn), getKingPiecePosX(gameBoard, turn))) { //for lowercase king
				System.out.println("You are checked.");
				kingHasToMove = true;
			} //tomorrow plan: if king posY or posX is -1, then game over. use the posY and posX for the check method. Make a separate boolean method and put it in line 159. Also make the king move. Then I am done with this!!! 
			
			if (turn) {
				System.out.println(player1 + ":");
			}
			else {
				System.out.println(player2 + ":");
			}
			
			boolean invalidCode = true;
			boolean moveBoolean = true;
			int horizontal = 0;
			int vertical = 0;
			int newHorizontal = 0;
			int newVertical = 0;
			
			
			while (invalidCode) {
				System.out.print("Enter horizontal value: ");
				String horizontalLetter = sc.nextLine();
				System.out.print("Enter vertical value: ");
				vertical = sc.nextInt();
				sc.nextLine();
				vertical = 8 - vertical;
				if (horizontalLetter.equalsIgnoreCase("a") && vertical < 8) {
						horizontal = 0;
					}
				else {
					if (horizontalLetter.equalsIgnoreCase("b") && vertical < 8) {
						horizontal = 1;
					}
					else {
						if (horizontalLetter.equalsIgnoreCase("c") && vertical < 8) {
							horizontal = 2;
						}
						else {
							if (horizontalLetter.equalsIgnoreCase("d") && vertical < 8) {
								horizontal = 3;
							}
							else {
								if (horizontalLetter.equalsIgnoreCase("e") && vertical < 8) {
									horizontal = 4;
								}
								else {
									if (horizontalLetter.equalsIgnoreCase("f") && vertical < 8) {
										horizontal = 5;
									}
									else {
										if (horizontalLetter.equalsIgnoreCase("g") && vertical < 8) {
											horizontal = 6;
											}
										else {
											if (horizontalLetter.equalsIgnoreCase("h") && vertical < 8) {
												horizontal = 7;
											}
											else {
												System.out.println("Invalid coordinates");
											}
										}
									}
								}
							}
						}
					}
				}
				
				if (turn != gameBoard[vertical][horizontal].isUppercase(gameBoard[vertical][horizontal].showPiece().substring(1,2)) && !gameBoard[vertical][horizontal].showPiece().substring(1,2).equals(" ")) {
					if (kingHasToMove) {
						if (gameBoard[vertical][horizontal].showPiece().substring(1,2).equals("K") || gameBoard[vertical][horizontal].showPiece().substring(1,2).equals("k")) {
							invalidCode = false;
						}
					}
					else {
						invalidCode = false;
					}
				}
				else {
					System.out.println("Invalid coordinates");
				}
			}	
			
			invalidCode = true;
			
			while (invalidCode) {
				System.out.print("Enter new horizontal value: ");
				String newHorizontalLetter = sc.nextLine();
				System.out.print("Enter new vertical value: ");
				newVertical = sc.nextInt();
				sc.nextLine();
				newVertical = 8 - newVertical;
				if (newHorizontalLetter.equalsIgnoreCase("a") && newVertical < 8) {
					newHorizontal = 0;
				}
				else {
					if (newHorizontalLetter.equalsIgnoreCase("b") && newVertical < 8) {
						newHorizontal = 1;
					}
					else {
						if (newHorizontalLetter.equalsIgnoreCase("c") && newVertical < 8) {
							newHorizontal = 2;
						}
						else {
							if (newHorizontalLetter.equalsIgnoreCase("d") && newVertical < 8) {
								newHorizontal = 3;
							}
							else {
								if (newHorizontalLetter.equalsIgnoreCase("e") && newVertical < 8) {
									newHorizontal = 4;
								}
								else {
									if (newHorizontalLetter.equalsIgnoreCase("f") && newVertical < 8) {
										newHorizontal = 5;
									}
									else {
										if (newHorizontalLetter.equalsIgnoreCase("g") && newVertical < 8) {
											newHorizontal = 6;
											}
										else {
											if (newHorizontalLetter.equalsIgnoreCase("h") && newVertical < 8) {
												newHorizontal = 7;
											}
											else {
												System.out.println("Invalid coordinates");
											}
										}
									}
								}
							}
						}
					}
				}
				
				if (gameBoard[newVertical][newHorizontal].movePieceCorrectSpace(gameBoard, horizontal, vertical, newHorizontal, newVertical)) {
					moveBoolean = true;
					invalidCode = false;
				}
				else {
					if (gameBoard[newVertical][newHorizontal].takePieceCorrectSpace(gameBoard, horizontal, vertical, newHorizontal, newVertical)) {
						moveBoolean = false;
						invalidCode = false;
					}
					else {
						System.out.println("Invalid coordinates");
					}
				}
				
			}
			
			if (moveBoolean) {
				gameBoard[vertical][horizontal].movePiece(gameBoard, horizontal, vertical, newHorizontal, newVertical);	
			}
			else {
				gameBoard[vertical][horizontal].takePiece(gameBoard, horizontal, vertical, newHorizontal, newVertical);
			}
			
			System.out.println();
			
			turn = !turn;	
				
		}
	}
	
	
	public int getKingPiecePosY(piece[][] board, boolean turn) {
		int countY;
		int countX;
		if (!turn) { //find lowercase K
			for (countY = 0; countY < board.length; countY++) {
				for (countX = 0; countX < board[0].length; countX++) {
					if (board[countY][countX].showPiece().substring(1,2).equals("k")) {
						return countY;
					}
				}
			}
		}
		else {
			for (countY = 0; countY < board.length; countY++) {
				for (countX = 0; countX < board[0].length; countX++) {
					if (board[countY][countX].showPiece().substring(1,2).equals("K")) {
						return countY;
					}
				}
			}
		}
		
		return -1;
	}
	
	public int getKingPiecePosX(piece[][] board, boolean turn) {
		int countY;
		int countX;
		if (!turn) { //find lowercase K
			for (countY = 0; countY < board.length; countY++) {
				for (countX = 0; countX < board[0].length; countX++) {
					if (board[countY][countX].showPiece().substring(1,2).equals("k")) {
						return countX;
					}
				}
			}
		}
		else {
			for (countY = 0; countY < board.length; countY++) {
				for (countX = 0; countX < board[0].length; countX++) {
					if (board[countY][countX].showPiece().substring(1,2).equals("K")) {
						return countX;
					}
				}
			}
		}
		
		return -1;
	}
	
	
	public void printGameBoard() {
		int num = 8;
		for (int countY = 0; countY < 9; countY++) {
			for (int countX = 0; countX < 9; countX++) {
				if (countY == 0 && countX == 0) {
					System.out.print("  ");
				}
				if (countY == 0) {
					if (countX == 0) {
						System.out.print(" a ");
					}
					else {
						if (countX == 1) {
							System.out.print(" b ");
						}
						else {
							if (countX == 2) {
								System.out.print(" c ");
							}
							else {
								if (countX == 3) {
									System.out.print(" d ");
								}
								else {
									if (countX == 4) {
										System.out.print(" e ");
									}
									else {
										if (countX == 5) {
											System.out.print(" f ");
										}
										else {
											if (countX == 6) {
												System.out.print(" g ");
											}
											else {
												if (countX == 7) {
													System.out.print(" h ");
												}
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					if (countX == 0) {
						System.out.print(num + " ");
						num--;
					}
					else {
						System.out.print(gameBoard[countY - 1][countX - 1 ].showPiece());	
					}
				}
			}
			System.out.println();
		}
	}
}