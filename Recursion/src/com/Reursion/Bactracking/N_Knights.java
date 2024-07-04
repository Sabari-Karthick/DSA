package com.Reursion.Bactracking;

public class N_Knights {
	public static void main(String[] args) {
         boolean[][] board = new boolean [4][4];
         solve(board, 0, 0, 4);
	}
	
	static void solve(boolean[][] board,int r,int c,int knights) {
		if(knights==0) {
			display(board);
			System.out.println();
			return;
		}
		if(r==board.length-1&&c==board.length ) {
			return;
		}
		
		if(c==board.length) {
			solve(board, r+1, 0, knights);
			return; 
		}
		if(isSafe(board,r,c)) {
			board[r][c]=true;
			solve(board, r, c+1, knights-1);
			board[r][c]=false;
		}
		solve(board, r, c+1, knights);
		
		
	}
	private static boolean isSafe(boolean[][] board, int r, int c) {
		
		if(isValid(board,r-2,c-1)) {
			if(board[r-2][c-1]) {
				return false;
			}
		}
		if(isValid(board,r-2,c+1)) {
			if(board[r-2][c+1]) {
				return false;
			}
		}
		if(isValid(board,r-1,c-2)) {
			if(board[r-1][c-2]) {
				return false;
			}
		}
		if(isValid(board,r-1,c+2)) {
			if(board[r-1][c+2]) {
				return false;
			}
		}
		
		
		return true;
	}

	private static boolean isValid(boolean[][] board, int r, int c) {
		if(r>=0 && r<board.length && c>=0  && c<board.length) {
			return true;
		}
		return false;
	}

	private static void display(boolean[][] board) {
		 for (boolean[] bs : board) {
			for(boolean b : bs) {
				if(b) {
					System.out.print("K ");
				}
				else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}
}
