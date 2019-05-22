package com.backtracking;

public class NQueenProblem {
	
	public static void main(String...strings) {
		putQueen(0);
		for(int i =0 ;i<4 ; i++) {
			for(int j =0 ;j<4 ; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int N = 4;
	public static int board[][] = new int[N][N];
	
	public static boolean putQueen(int r) {
		if(r == N){ return true; }
		
		for(int c=0; c<N; c++) {
			if(isSafe(r, c)) {
				board[r][c] = 1;
				if(putQueen(r+1) == true)
					return true;
				else
					board[r][c] = 0;
			}
		}
		return false;
	}
	
	 public static boolean isSafe(int r, int c) {
		for(int i=r-1; i>=0; i--)
			if(board[i][c] == 1)
				return false;
		int i = r-1;
		int j = c-1;
		while(i>=0 && j>=0) {
			if(board[i][j] == 1)
				return false;
			i--; j--;
		}
		i = r-1;
		j = c+1;
		while(i>=0 && j<N) {
			if(board[i][j] == 1)
				return false;
			i--; j++;
		}
		return true;
	}
}