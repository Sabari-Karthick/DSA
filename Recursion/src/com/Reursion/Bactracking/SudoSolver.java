package com.Reursion.Bactracking;
//Total 9 numbers
//With N^2 possibilities
//O(9 ^ (N^2))
public class SudoSolver {
	public static void main(String[] args) {
		
		int[][] board = {
				  { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
				  { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
				  { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
				  { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
				  { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
				  { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
				  { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
				  { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
				  { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
				};
		
		if(solve(board)) {
			display(board);
		}
	}

	static boolean solve(int[][] board) {
		int n = board.length;
		int row = -1;
		int col = -1;
		boolean emptySpace = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					emptySpace = true;
					break;
				}
			}
			if(emptySpace) {
				break;
			}
		}
		if(!emptySpace) {
			return true;
		}
		//backtrack
		for(int i=1;i<=9;i++) {
			if(isSafe(board, row, col, i)) {
				board[row][col]=i;
				if(solve(board))
				{
					return true;
				}else {
					board[row][col]=0;//backtrack
					
				}
			}
		}
      return false;
	}

	private static void display(int[][] board) {
		
		for(int[] row : board) {
			for(int num:row) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

	static boolean isSafe(int[][] board, int r, int c, int num) {
		// check row
		for (int i = 0; i < board.length; i++) {
			if (board[r][i] == num) {
				return false;
			}
		}
		// check column
		for(int i=0;i<board.length;i++) {
			if(board[i][c]==num) {
				return false;
			}
		}
//		for (int[] row : board) {
//			if (row[c] == num) {
//				return false;
//			}
//		}
		int sq = (int) Math.sqrt(board.length);
		int rs = r - (r % sq);
		int cs = c - (c % sq);

		for (int i = rs; i < rs + sq; i++) {
			for (int j = cs; j < cs + sq; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}

		}
		return true;
	}
}
