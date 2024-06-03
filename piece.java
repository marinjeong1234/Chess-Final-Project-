/*
 *	Author:  
 *  Date: 
*/

package pkg;
import java.util.Scanner;
import java.util.Random;


public class piece {
	String pieceName;
	int step;
	
	public piece(boolean emptyType) {
		if (emptyType == true) {
			pieceName = "[ ]"; 
		}
		else {
			pieceName = "   ";
		}
	}
	
	public void setPiece(String piece, int x, int y) {
		pieceName = pieceName.substring(0,1) + piece + pieceName.substring(2);
		
	}

	public String showPiece() {
		return pieceName;
	}
	
	
	public boolean isUppercase(String piece) {
		if (piece.equals("P") || piece.equals("R") || piece.equals("H") || piece.equals("B") || piece.equals("Q") || piece.equals("K")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public boolean movePieceCorrectSpace(piece[][] board, int posX, int posY, int newPosX, int newPosY) {
		//if uppercase pawn is at index 1 or lowercase pawn is at index 6, move 2 steps 
		if (board[posY][posX].showPiece().substring(1,2).equals("P")) { //upper case moves
			if (posY == 1) {
				step = 2;
				if (Math.abs(newPosY - posY) <= step && newPosX == posX && board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if (posY > 1) {
					step = 1;
					if (Math.abs(newPosY - posY) == step && newPosX == posX && board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
						return true;
					}
					else {
						return false;
					}
				}
			}
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("p")) { //lower case moves 
				if (posY == 6) {
					step = 2;
					if (Math.abs(newPosY - posY) <= step && newPosX == posX) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					if (posY < 6) {
						step = 1;
						if (Math.abs(newPosY - posY) == step && newPosX == posX) {
							return true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
		
		if (board[posY][posX].showPiece().substring(1,2).equals("R")) {
			
			if (newPosY == posY) {
				boolean booleanHorizontal = true;
				
				if (posX < newPosX) {
					for (int count = posX + 1; count < newPosX; count++) { //check if there are any horizontal values that are non space 
						if (!board[posY][count].showPiece().substring(1,2).equals(" ")) {
							booleanHorizontal = false;
							break;
						}
					}
				}
				else {
					if (posX > newPosX) {
						for (int count = posX - 1; count > newPosX; count--) {
							if (!board[posY][count].showPiece().substring(1,2).equals(" ")) {
								booleanHorizontal = false;
								break;
							}
						}
					}
				}
				
				if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && isUppercase(board[newPosY][newPosX].showPiece().substring(1,2))) {
					booleanHorizontal = false;
				}
				
				if (booleanHorizontal) {
					return true;
				}
				else {
					return false; 
				}
			}
			else {
				if (newPosX == posX) {
					
					boolean booleanVertical = true;
					if (posY < newPosY) {
						for (int count = posY + 1; count < newPosY; count++) { //check if there are any values that are in its vertical way 
							if (!board[count][posX].showPiece().substring(1,2).equals(" ")) {
								booleanVertical = false;
								break;
							}
						}
					}
					else {
						if (posY > newPosY) {
							for (int count = posY - 1; count > newPosY; count--) {
								if (!board[count][posX].showPiece().substring(1,2).equals(" ")) {
									booleanVertical = false;
									break;
								}
							}
						}
					}
				
					if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && isUppercase(board[newPosY][newPosX].showPiece().substring(1,2))) {
						booleanVertical = false;
					}
				
					if (booleanVertical) {
						return true;
					}
					else {
						return false; 
					}
				}
			}
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("r")) {
				if (newPosY == posY) {
					boolean booleanHorizontal = true;
					if (posX < newPosX) {
						for (int count = posX + 1; count < newPosX; count++) { //when the rook is going to the side 
							if (!board[posY][count].showPiece().substring(1,2).equals(" ")) {
								booleanHorizontal = false;
								break;
							}
						}
					}
					else {
						if (posX > newPosX) {
							for (int count = posX - 1; count > newPosX; count--) { //when the rook is going to the side
								if (!board[posY][count].showPiece().substring(1,2).equals(" ")) {
									booleanHorizontal =  false;
									break;
								}
							}
						}
					}
					
					if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && !isUppercase(board[newPosY][newPosX].showPiece().substring(1,2))) {
						booleanHorizontal = false;
					}
					
					if (booleanHorizontal) {
						return true;
					}
					else {
						return false; 
					}
				}
				
				else {
					if (newPosX == posX) {
						
						boolean booleanVertical = true;
						if (posY < newPosY) {
							for (int count = posY + 1; count < newPosY; count++) { //when going down
								if (!board[count][posX].showPiece().substring(1,2).equals(" ")) {
									booleanVertical = false;
									break;
								}
							}
						}
						else {
							if (posY > newPosY) {
								for (int count = posY - 1; count > newPosY; count--) { //when going up 
									if (!board[count][posX].showPiece().substring(1,2).equals(" ")) {
										booleanVertical = false;
										break;
									}
								}
							}
						}
						
						if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && !isUppercase(board[newPosY][newPosX].showPiece().substring(1,2))) {
							booleanVertical = false;
						}
						
						if (booleanVertical) {
							return true;
						}
						else {
							return false; 
						}
					}
				}
			}
		}
		
		
		if (board[posY][posX].showPiece().substring(1,2).equals("B") || board[posY][posX].showPiece().substring(1,2).equals("b")) {
			boolean booleanMove = true;
			if (posX < newPosX && posY > newPosY) {
				int countY = posY - 1;
				int countX = posX + 1;
				while (countX < newPosX && countY > newPosY) { //check up-right values: horizontal increasing, vertical decreasing
					if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
						booleanMove = false;
						break;
					}
					countX++;
					countY--;
				}
			}
			else {
				if (posX > newPosX && posY > newPosY) {
					int countY = posY - 1;
					int countX = posX - 1;
					while (countX > newPosX && countY > newPosY) { //check up-left values: horizontal decreasing, vertical decreasing
						if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
							booleanMove = false;
							break;
						}
						countX--;
						countY--;
					}
				}
				
				else {
				
					if (posX < newPosX && posY < newPosY) {
						int countY = posY + 1;
						int countX = posX + 1;
						while (countX < newPosX && countY < newPosY) { //check down-right values: horizontal increasing , vertical increasing
							if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
								booleanMove = false;
								break;
							}
							countX++;
							countY++;
						}
						
					}
					
					else {
				
						if (posX > newPosX && posY < newPosY) {
							int countY = posY + 1;
							int countX = posX - 1;
							while (countX > newPosX && countY < newPosY) { //check down-left values: horizontal decreasing , vertical increasing
								if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
									booleanMove = false;
									break;
								}
								countX--;
								countY++;
							}
						}
					}
				}
			}
			boolean booleanMove2 = true;
			
			if (board[posY][posX].showPiece().substring(1,2).equals("B")) {
				if (!isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
					booleanMove2 = true;
				}
				else {
					booleanMove2 = false;
				}
			}
			else {
				if (board[posY][posX].showPiece().substring(1,2).equals("b")) {
					if (isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
						booleanMove2 = true;
					}
					else {
						booleanMove2 = false;
					}
				}
			}
			
		
			if (booleanMove == true && booleanMove2 == true && posX != newPosX && posY != newPosX) {
				return true;
			}
			else {
				return false;
			}

		}
		
		if (board[posY][posX].showPiece().substring(1,2).equals("H")) {
			if (Math.abs(newPosX - posX) == 1 && Math.abs(newPosY - posY) == 2) { 
				if (!isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if (Math.abs(newPosX - posX) == 2 && Math.abs(newPosY - posY) == 1) {
					if (!isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("h")) {
				if (Math.abs(newPosX - posX) == 1 && Math.abs(newPosY - posY) == 2) {
					if (isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					if (Math.abs(newPosX - posX) == 2 && Math.abs(newPosY - posY) == 1) {
						if (isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
			}
		}
		
		
		if (board[posY][posX].showPiece().substring(1,2).equals("Q")) {
			if (newPosY == posY) {
				boolean booleanHorizontal = true;
				
				if (posX < newPosX) {
					for (int count = posX + 1; count < newPosX; count++) { //check if there are any horizontal values that are non space 
						if (!board[posY][count].showPiece().substring(1,2).equals(" ")) {
							booleanHorizontal = false;
							break;
						}
					}
				}
				else {
					if (posX > newPosX) {
						for (int count = posX - 1; count > newPosX; count--) {
							if (!board[posY][count].showPiece().substring(1,2).equals(" ")) {
								booleanHorizontal = false;
								break;
							}
						}
					}
				}
				
				if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && isUppercase(board[newPosY][newPosX].showPiece().substring(1,2))) {
					booleanHorizontal = false;
				}
				
				if (booleanHorizontal) {
					return true;
				}
				else {
					return false; 
				}
			}
			else {
				if (newPosX == posX) {
					
					boolean booleanVertical = true;
					if (posY < newPosY) {
						for (int count = posY + 1; count < newPosY; count++) { //check if there are any values that are in its vertical way 
							if (!board[count][posX].showPiece().substring(1,2).equals(" ")) {
								booleanVertical = false;
								break;
							}
						}
					}
					else {
						if (posY > newPosY) {
							for (int count = posY - 1; count > newPosY; count--) {
								if (!board[count][posX].showPiece().substring(1,2).equals(" ")) {
									booleanVertical = false;
									break;
								}
							}
						}
					}
				
					if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && isUppercase(board[newPosY][newPosX].showPiece().substring(1,2))) {
						booleanVertical = false;
					}
				
					if (booleanVertical) {
						return true;
					}
					else {
						return false; 
					}
				}
				else {
					boolean booleanMove = true;
					if (posX < newPosX && posY > newPosY) {
					int countY = posY - 1;
					int countX = posX + 1;
					while (countX < newPosX && countY > newPosY) { //check up-right values: horizontal increasing, vertical decreasing
						if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
							booleanMove = false;
							break;
						}
						countX++;
						countY--;
					}
				}
					else {
						if (posX > newPosX && posY > newPosY) {
							int countY = posY - 1;
							int countX = posX - 1;
							while (countX > newPosX && countY > newPosY) { //check up-left values: horizontal decreasing, vertical decreasing
								if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
									booleanMove = false;
									break;
								}
								countX--;
								countY--;
							}
						}
						else {
							if (posX < newPosX && posY < newPosY) {
								int countY = posY + 1;
								int countX = posX + 1;
								while (countX < newPosX && countY < newPosY) { //check down-right values: horizontal increasing , vertical increasing
									if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
										booleanMove = false;
										break;
									}
									countX++;
									countY++;
								}
							}
							else {
								if (posX > newPosX && posY < newPosY) {
									int countY = posY + 1;
									int countX = posX - 1;
									while (countX > newPosX && countY < newPosY) { //check down-left values: horizontal decreasing , vertical increasing
										if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
											booleanMove = false;
											break;
										}
										countX--;
										countY++;
									}
								}
							}
						}
					}
					boolean booleanMove2 = true;
				
					if (board[posY][posX].showPiece().substring(1,2).equals("Q")) {
						if (!isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
							booleanMove2 = true;
						}
						else {
							booleanMove2 = false;
						}
					}
					else {
						if (board[posY][posX].showPiece().substring(1,2).equals("q")) {
							if (isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
								booleanMove2 = true;
							}
							else {
								booleanMove2 = false;
							}
						}
					}
			
		
					if (booleanMove == true && booleanMove2 == true && posX != newPosX && posY != newPosX) {
						return true;
					}
					else {
						return false;
					}
				}
			}
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("q")) {
				if (newPosY == posY) {
					boolean booleanHorizontal = true;
					
					if (posX < newPosX) {
						for (int count = posX + 1; count < newPosX; count++) { //check if there are any horizontal values that are non space 
							if (!board[posY][count].showPiece().substring(1,2).equals(" ")) {
								booleanHorizontal = false;
								break;
							}
						}
					}
					else {
						if (posX > newPosX) {
							for (int count = posX - 1; count > newPosX; count--) {
								if (!board[posY][count].showPiece().substring(1,2).equals(" ")) {
									booleanHorizontal = false;
									break;
								}
							}
						}
					}
					
					if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && isUppercase(board[newPosY][newPosX].showPiece().substring(1,2))) {
						booleanHorizontal = false;
					}
					
					if (booleanHorizontal) {
						return true;
					}
					else {
						return false; 
					}
				}
				else {
					if (newPosX == posX) {
					
						boolean booleanVertical = true;
						if (posY < newPosY) {
							for (int count = posY + 1; count < newPosY; count++) { //check if there are any values that are in its vertical way 
								if (!board[count][posX].showPiece().substring(1,2).equals(" ")) {
									booleanVertical = false;
									break;
								}
							}
						}
						else {
							if (posY > newPosY) {
								for (int count = posY - 1; count > newPosY; count--) {
									if (!board[count][posX].showPiece().substring(1,2).equals(" ")) {
										booleanVertical = false;
										break;
									}
								}
							}
						}
					
						if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && isUppercase(board[newPosY][newPosX].showPiece().substring(1,2))) {
							booleanVertical = false;
						}	
					
						if (booleanVertical) {
							return true;
						}
						else {
							return false; 
						}
					}
					else {
						
						boolean booleanMove = true;
						if (posX < newPosX && posY > newPosY) {
						int countY = posY - 1;
						int countX = posX + 1;
						while (countX < newPosX && countY > newPosY) { //check up-right values: horizontal increasing, vertical decreasing
							if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
								booleanMove = false;
								break;
							}
							countX++;
							countY--;
						}
					}
						else {
							if (posX > newPosX && posY > newPosY) {
								int countY = posY - 1;
								int countX = posX - 1;
								while (countX > newPosX && countY > newPosY) { //check up-left values: horizontal decreasing, vertical decreasing
									if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
										booleanMove = false;
										break;
									}
									countX--;
									countY--;
								}
							}
							else {
								if (posX < newPosX && posY < newPosY) {
									int countY = posY + 1;
									int countX = posX + 1;
									while (countX < newPosX && countY < newPosY) { //check down-right values: horizontal increasing , vertical increasing
										if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
											booleanMove = false;
											break;
										}
										countX++;
										countY++;
									}
								}
								else {
									if (posX > newPosX && posY < newPosY) {
										int countY = posY + 1;
										int countX = posX - 1;
										while (countX > newPosX && countY < newPosY) { //check down-left values: horizontal decreasing , vertical increasing
											if (!board[countY][countX].showPiece().substring(1,2).equals(" ")) {
												booleanMove = false;
												break;
											}
											countX--;
											countY++;
										}
									}
								}
							}
						}
						boolean booleanMove2 = true;
					
						if (board[posY][posX].showPiece().substring(1,2).equals("Q")) {
							if (!isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
								booleanMove2 = true;
							}
							else {
								booleanMove2 = false;
							}
						}
						else {
							if (board[posY][posX].showPiece().substring(1,2).equals("q")) {
								if (isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) || board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
									booleanMove2 = true;
								}
								else {
									booleanMove2 = false;
								}
							}
						}
			
		
						if (booleanMove == true && booleanMove2 == true && posX != newPosX && posY != newPosX) {
							return true;
						}	
						else {
							return false;
						}
					}
				}
			}
		}
		
		if (board[posY][posX].showPiece().substring(1,2).equals("K")) {
			if ((Math.abs(newPosY - posY) == 1 || newPosY == posY) && (Math.abs(newPosX - posX) == 1 || newPosX == posX) && (board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") || !isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)))) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("k")) {
				if ((Math.abs(newPosY - posY) == 1 || newPosY == posY) && (Math.abs(newPosX - posX) == 1 || newPosX == posX) && (board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") || isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)))) {
					return true;
				}
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public void movePiece(piece[][] board, int posX, int posY, int newPosX, int newPosY) {
		//if uppercase pawn is at index 1 or lowercase pawn is at index 6, move 2 steps 
		if (board[posY][posX].showPiece().substring(1,2).equals("P")) { //upper case moves
			if (posY == 1) {
				step = 2;
				if (Math.abs(newPosY - posY) <= step && newPosX == posX && board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
					board[newPosY][newPosX].setPiece("P", newPosX, newPosY);
					board[posY][posX].setPiece(" ", posX, posY);
					return;
				}
			}
			else {
				if (posY > 1) {
					step = 1;
					if (Math.abs(newPosY - posY) == step && newPosX == posX && board[newPosY][newPosX].showPiece().substring(1,2).equals(" ")) {
						board[newPosY][newPosX].setPiece("P", newPosX, newPosY);
						board[posY][posX].setPiece(" ", posX, posY);
						return;
					}
				}
			}
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("p")) { //lower case moves 
				if (posY == 6) {
					step = 2;
					if (Math.abs(newPosY - posY) <= step && newPosX == posX) {
						board[newPosY][newPosX].setPiece("p", newPosX, newPosY);
						board[posY][posX].setPiece(" ", posX, posY);
						return;
					}
				}
				else {
					if (posY < 6) {
						step = 1;
						if (Math.abs(newPosY - posY) == step && newPosX == posX) {
							board[newPosY][newPosX].setPiece("p", newPosX, newPosY);
							board[posY][posX].setPiece(" ", posX, posY);
							return;
						}

					}
				}
			}
		}
		
		if (board[posY][posX].showPiece().substring(1,2).equals("R")) {
			if (newPosY == posY) {
				board[newPosY][newPosX].setPiece("R", newPosX, newPosY);
				board[posY][posX].setPiece(" ", posX, posY);
				return;
			}
			else {
				if (newPosX == posX) {
					board[newPosY][newPosX].setPiece("R", newPosX, newPosY);
					board[posY][posX].setPiece(" ", posX, posY);
					return;
				}
			}
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("r")) {
				if (newPosY == posY) {
					board[posY][newPosX].setPiece("r", newPosX, newPosY);
					board[posY][posX].setPiece(" ", posX, posY);
					return;
				}
				else {
					if (newPosX == posX) {
						board[newPosY][posX].setPiece("r", newPosX, newPosY);
						board[posY][posX].setPiece(" ", posX, posY);
						return;
					}
				}
			}
		}
		
		if (board[posY][posX].showPiece().substring(1,2).equals("B")) {
			board[newPosY][newPosX].setPiece("B", newPosX, newPosY);
			board[posY][posX].setPiece(" ", posX, posY);
			return;
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("b")) {
				board[newPosY][newPosX].setPiece("b", newPosX, newPosY);
				board[posY][posX].setPiece(" ", posX, posY);
				return;
			}
		}
		
		if (board[posY][posX].showPiece().substring(1,2).equals("H")) {
			board[newPosY][newPosX].setPiece("H", newPosX, newPosY);
			board[posY][posX].setPiece(" ", posX, posY);
			return;
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("h")) {
				board[newPosY][newPosX].setPiece("h", newPosX, newPosY);
				board[posY][posX].setPiece(" ", posX, posY);
				return;
			}
		}
	
		if (board[posY][posX].showPiece().substring(1,2).equals("Q")) {
			board[newPosY][newPosX].setPiece("Q", newPosX, newPosY);
			board[posY][posX].setPiece(" ", posX, posY);
			return;
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("q")) {
				board[newPosY][newPosX].setPiece("q", newPosX, newPosY);
				board[posY][posX].setPiece(" ", posX, posY);
				return;
			}
		}
		
		if (board[posY][posX].showPiece().substring(1,2).equals("K")) {
			board[newPosY][newPosX].setPiece("K", newPosX, newPosY);
			board[posY][posX].setPiece(" ", posX, posY);
			return;
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("k")) {
				board[newPosY][newPosX].setPiece("k", newPosX, newPosY);
				board[posY][posX].setPiece(" ", posX, posY);
				return;
			}
		}
	}	
	
	
	
	public boolean takePieceCorrectSpace(piece[][] board, int posX, int posY, int newPosX, int newPosY) {
	
		if (board[posY][posX].showPiece().substring(1,2).equals("P")) { //upper case moves
			if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && !isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) && newPosY - posY == 1 && Math.abs(newPosX - posX) == 1) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("p")) { //lower case moves 
				if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) && posY - newPosY == 1 && Math.abs(newPosX - posX) == 1) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		
		
		/* if (board[posY][posX].showPiece().substring(1,2).equals("R")) {
				
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("r")) {
				
			}
			else {
				return false;
			}
		}
		*/
		
		return false;
	}
	
	public void takePiece(piece[][] board, int posX, int posY, int newPosX, int newPosY) {
	
		if (board[posY][posX].showPiece().substring(1,2).equals("P")) { //upper case moves
			if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && !isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) && newPosY - posY == 1 && Math.abs(newPosX - posX) == 1) {
				board[newPosY][newPosX].setPiece("P", newPosX, newPosY);
				board[posY][posX].setPiece(" ", posX, posY);
			}
		}
		else {
			if (board[posY][posX].showPiece().substring(1,2).equals("p")) { //lower case moves 
				if (!board[newPosY][newPosX].showPiece().substring(1,2).equals(" ") && isUppercase(board[newPosY][newPosX].showPiece().substring(1,2)) && posY - newPosY == 1 && Math.abs(newPosX - posX) == 1) {
					board[newPosY][newPosX].setPiece("p", newPosX, newPosY);
					board[posY][posX].setPiece(" ", posX, posY);
				}
			}
		}
	}
	
	
	
	public boolean check(piece[][] board, int posX, int posY) {
		if (board[posY][posX].showPiece().substring(1,2).equals("K")) {
				//check if there are any values diagonal to K (pawn), check if L shape (horse), check if straight (rook or queen), check if diagonal (bishop or queen)
			if (board[posY + 1][posX + 1].showPiece().substring(1,2).equals("p") || board[posY + 1][posX - 1].showPiece().substring(1,2).equals("p")) {
				return true;
			}
			else {
				//L shape:
				if (board[posY + 1][posX + 2].showPiece().substring(1,2).equals("h") || board[posY + 1][posX - 2].showPiece().substring(1,2).equals("h") || board[posY - 1][posX  + 2].showPiece().substring(1,2).equals("h") || board[posY - 1][posX - 2].showPiece().substring(1,2).equals("h") || board[posY + 2][posX + 1].showPiece().substring(1,2).equals("h") || board[posY + 2][posX - 1].showPiece().substring(1,2).equals("h") || board[posY - 2][posX + 1].showPiece().substring(1,2).equals("h") || board[posY- 2][posX - 1].showPiece().substring(1,2).equals("h")) {
					return true;
				}
				else {
					if (board[posY][posX].checkRookUp(board, posX, posY) || board[posY][posX].checkRookDown(board, posX, posY) || board[posY][posX].checkRookRight(board, posX, posY) || board[posY][posX].checkRookLeft(board, posX, posY)) {
						return true;
					}
					else {
						if (board[posY][posX].checkBishop45(board,posX,posY) || board[posY][posX].checkBishop135(board,posX,posY) || board[posY][posX].checkBishop225(board,posX,posY) || board[posY][posX].checkBishop315(board,posX,posY)) {
							return true;
						}
						else {
							return false;
						}
					}
				}
			}
		}	
		
		if (board[posY][posX].showPiece().substring(1,2).equals("k")) {
				//check if there are any values diagonal to K (pawn), check if L shape (horse), check if straight (rook or queen), check if diagonal (bishop or queen)
			if (board[posY + 1][posX + 1].showPiece().substring(1,2).equals("P") || board[posY + 1][posX - 1].showPiece().substring(1,2).equals("P")) {
				return true;
			}
			else {
				//L shape:
				if (board[posY + 1][posX + 2].showPiece().substring(1,2).equals("H") || board[posY + 1][posX - 2].showPiece().substring(1,2).equals("H") || board[posY - 1][posX  + 2].showPiece().substring(1,2).equals("H") || board[posY - 1][posX - 2].showPiece().substring(1,2).equals("H") || board[posY + 2][posX + 1].showPiece().substring(1,2).equals("H") || board[posY + 2][posX - 1].showPiece().substring(1,2).equals("H") || board[posY - 2][posX + 1].showPiece().substring(1,2).equals("H") || board[posY- 2][posX - 1].showPiece().substring(1,2).equals("H")) {
					return true;
				}
				else {
					if (board[posY][posX].checkRookUp(board, posX, posY) || board[posY][posX].checkRookDown(board, posX, posY) || board[posY][posX].checkRookRight(board, posX, posY) || board[posY][posX].checkRookLeft(board, posX, posY)) {
						return true;
					}
					else {
						if (board[posY][posX].checkBishop45(board,posX,posY) || board[posY][posX].checkBishop135(board,posX,posY) || board[posY][posX].checkBishop225(board,posX,posY) || board[posY][posX].checkBishop315(board,posX,posY)) {
							return true;
						}
						else {
							return false;
						}
					}
				}
			}
		}	
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean checkRookUp(piece[][] board, int posX, int posY) {
		//check up:
		if (isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY - 1;
			
			if (countY == -1) {
				return false;
			}
			
			while (countY > -1) {
				if (!board[countY][posX].showPiece().equals("r") && !board[countY][posX].showPiece().equals("q") && !board[countY][posX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][posX].showPiece().equals(" ")) {
						countY--;
					}
					else {
						if (!board[countY][posX].showPiece().equals("r") && !board[countY][posX].showPiece().equals("q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
		
		if (!isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY - 1;
			
			if (countY == -1) {
				return false;
			}
			
			while (countY > -1) {
				if (!board[countY][posX].showPiece().equals("R") && !board[countY][posX].showPiece().equals("Q") && !board[countY][posX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][posX].showPiece().equals(" ")) {
						countY--;
					}
					else {
						if (!board[countY][posX].showPiece().equals("R") && !board[countY][posX].showPiece().equals("Q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
			return false;
		}
		
		return false;
	}
	
	public boolean checkRookDown(piece[][] board, int posX, int posY) {
		//check down:
		if (isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY + 1;
			
			if (countY == board.length) {
				return false;
			}
			
			while (countY < board.length) {
				if (!board[countY][posX].showPiece().equals("r") && !board[countY][posX].showPiece().equals("q") && !board[countY][posX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][posX].showPiece().equals(" ")) {
						countY++;
					}
					else {
						if (board[countY][posX].showPiece().equals("r") && !board[countY][posX].showPiece().equals("q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
		
		if (!isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY + 1;
			
			if (countY == board.length) {
				return false;
			}
			
			while (countY < board.length) {
				if (!board[countY][posX].showPiece().equals("R") && !board[countY][posX].showPiece().equals("Q") && !board[countY][posX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][posX].showPiece().equals(" ")) {
						countY++;
					}
					else {
						if (!board[countY][posX].showPiece().equals("R") && !board[countY][posX].showPiece().equals("Q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
			return false;
		}
	
		return false;
	}	

	public boolean checkRookRight(piece[][] board, int posX, int posY) {
		//check right:
		if (isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countX = posX + 1;
			
			if (countX == board[0].length) {
				return false;
			}
			
			while (countX < board[0].length) {
				if (!board[posY][countX].showPiece().equals("r") && !board[posY][countX].showPiece().equals("q") && !board[posY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[posY][countX].showPiece().equals(" ")) {
						countX++;
					}
					else {
						if (!board[posY][countX].showPiece().equals("r") && !board[posY][countX].showPiece().equals("q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
		
		if (!isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countX = posX + 1;
			
			if (countX == board[0].length) {
				return false;
			}
			
			while (countX < board[0].length) {
				if (!board[posY][countX].showPiece().equals("R") && !board[posY][countX].showPiece().equals("Q") && !board[posY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[posY][countX].showPiece().equals(" ")) {
						countX++;
					}
					else {
						if (!board[posY][countX].showPiece().equals("R") && !board[posY][countX].showPiece().equals("Q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}	
	
		return false;
	}
	
	public boolean checkRookLeft(piece[][] board, int posX, int posY) {
		//check left:
		if (isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countX = posX - 1;
			
			if (countX == -1) {
				return false;
			}
			
			while (countX > -1) {
				if (!board[posY][countX].showPiece().equals("r") && !board[posY][countX].showPiece().equals("q") && !board[posY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[posY][countX].showPiece().equals(" ")) {
						countX--;
					}
					else {
						if (!board[posY][countX].showPiece().equals("r") && !board[posY][countX].showPiece().equals("q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
		
		if (!isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countX = posX - 1;
			
			if (countX == -1) {
				return false;
			}
			
			while (countX > -1) {
				if (!board[posY][countX].showPiece().equals("R") && !board[posY][countX].showPiece().equals("Q") && !board[posY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[posY][countX].showPiece().equals(" ")) {
						countX--;
					}
					else {
						if (!board[posY][countX].showPiece().equals("R") && !board[posY][countX].showPiece().equals("Q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
	
		return false;
	}


	public boolean checkBishop45(piece[][]board, int posX, int posY) {
		if (isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY - 1;
			int countX = posX + 1;
			if (countY == -1 || countX == board[0].length) {
				return false;
			}
			
			while (countY > -1 && countX < board[0].length) {
				if (!board[countY][countX].showPiece().equals("r") && !board[countY][countX].showPiece().equals("q") && !board[countY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][countX].showPiece().equals(" ")) {
						countY--;
						countX++;
					}
					else {
						if (!board[countY][countX].showPiece().equals("r") && !board[countY][countX].showPiece().equals("q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
		
		if (!isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY - 1;
			int countX = posX + 1;
			if (countY == -1 || countX == board[0].length) {
				return false;
			}
			
			while (countY > -1 && countX < board[0].length) {
				if (!board[countY][countX].showPiece().equals("R") && !board[countY][countX].showPiece().equals("Q") && !board[countY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][countX].showPiece().equals(" ")) {
						countY--;
						countX++;
					}
					else {
						if (!board[countY][countX].showPiece().equals("R") && !board[countY][countX].showPiece().equals("Q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
				
			}	
		}
		
		return false;
	}
	
	public boolean checkBishop135(piece[][]board, int posX, int posY) {
		if (isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY - 1;
			int countX = posX - 1;
			if (countY == -1 || countX == -1) {
				return false;
			}
			
			while (countY > -1 && countX > -1) {
				if (!board[countY][countX].showPiece().equals("r") && !board[countY][countX].showPiece().equals("q") && !board[countY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][countX].showPiece().equals(" ")) {
						countY--;
						countX--;
					}
					else {
						if (!board[countY][countX].showPiece().equals("r") && !board[countY][countX].showPiece().equals("q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
		
		if (!isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY - 1;
			int countX = posX - 1;
			if (countY == -1 || countX == -1) {
				return false;
			}
			
			while (countY > -1 && countX > -1) {
				if (!board[countY][countX].showPiece().equals("R") && !board[countY][countX].showPiece().equals("Q") && !board[countY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][countX].showPiece().equals(" ")) {
						countY--;
						countX--;
					}
					else {
						if (!board[countY][countX].showPiece().equals("R") && !board[countY][countX].showPiece().equals("Q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}	
		
		return false;
	}

	public boolean checkBishop225(piece[][]board, int posX, int posY) {
		if (isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY + 1;
			int countX = posX - 1;
			if (countY == board.length || countX == -1) {
				return false;
			}
			
			while (countY < board.length && countX > -1) {
				if (!board[countY][countX].showPiece().equals("r") && !board[countY][countX].showPiece().equals("q") && !board[countY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][countX].showPiece().equals(" ")) {
						countY++;
						countX--;
					}
					else {
						if (!board[countY][countX].showPiece().equals("r") && !board[countY][countX].showPiece().equals("q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
		
		if (!isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY + 1;
			int countX = posX - 1;
			if (countY == board.length || countX == -1) {
				return false;
			}
			
			while (countY < board.length && countX > -1) {
				if (!board[countY][countX].showPiece().equals("R") && !board[countY][countX].showPiece().equals("Q") && !board[countY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][countX].showPiece().equals(" ")) {
						countY++;
						countX--;
					}
					else {
						if (!board[countY][countX].showPiece().equals("R") && !board[countY][countX].showPiece().equals("Q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}	
		
		return false;
	}
	
	public boolean checkBishop315(piece[][]board, int posX, int posY) {
		if (isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY + 1;
			int countX = posX + 1;
			if (countY == board.length || countX == board[0].length) {
				return false;
			}
			
			while (countY < board.length && countX < board[0].length) {
				if (!board[countY][countX].showPiece().equals("r") && !board[countY][countX].showPiece().equals("q") && !board[countY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][countX].showPiece().equals(" ")) {
						countY++;
						countX++;
					}
					else {
						if (!board[countY][countX].showPiece().equals("r") && !board[countY][countX].showPiece().equals("q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
		
		if (!isUppercase(board[posY][posX].showPiece().substring(1,2))) {
			int countY = posY + 1;
			int countX = posX + 1;
			if (countY == board.length || countX == board[0].length) {
				return false;
			}
			
			while (countY < board.length && countX < board[0].length) {
				if (!board[countY][countX].showPiece().equals("R") && !board[countY][countX].showPiece().equals("Q") && !board[countY][countX].showPiece().equals(" ")) {
					return false;
				}
				else {
					if (board[countY][countX].showPiece().equals(" ")) {
						countY++;
						countX++;
					}
					else {
						if (!board[countY][countX].showPiece().equals("R") && !board[countY][countX].showPiece().equals("Q")) {
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}	
		
		return false;
	}
}
