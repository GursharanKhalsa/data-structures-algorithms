package com.dp.matrix.pathproblems;

// TODO check for blocking cells
public class FindMinCostPathInBlockedMatrix {

	public static int cost[][] = { {2,1,1,3} ,{0,3,1,6} , {8,4,2,1} , {0,5,6,8} };
	
	public static void main(String...strings) {
//		System.out.println("Min Cost Path from (0,0) to (3,3)=>"+minCost(3,3));
		System.out.println("Min Cost Path from (0,0) to (3,3)=>"+minCostMemo(3,3));
		System.out.println("Min Cost Path from (0,0) to (3,3)=>"+findMinCost(4,4));
	}
	
	// Recursive Solution
	public static int minCost(int m, int n) {
		if(m == 0 && n == 0){ return cost[0][0]; }
		if(m == 0){ return minCost(m, n-1) + cost[m][n]; }
		if(n == 0){ return minCost(m-1, n) + cost[m][n]; }

		int x = minCost(m-1, n);
		int y = minCost(m, n-1);
		return min(x,y)+ cost[m][n];
	}

	// Memoization Solution
	public static int minCostMemo(int m, int n) {
		int cache[][] = new int[m+1][n+1];
		for(int i =0 ; i<= m ; i++) {
			for(int j =0 ; j<= n ; j++) {
				cache[i][j] = -1;
			}
		}
		return minCostMemo(m,n,cache);
	}
	public static int minCostMemo(int m, int n,  int cache[][]) {
		
		if(m == 0 && n == 0){ return cache[m][n] = cost[0][0]; }
		if(m == 0){ return cache[m][n] = minCostMemo(m, n-1) + cost[m][n]; }
		if(n == 0){ return cache[m][n] = minCostMemo(m-1, n) + cost[m][n]; }

		if(cache[m][n] != -1)
			return cache[m][n];
		else {
			int x = minCostMemo(m-1, n);
			int y = minCostMemo(m, n-1);
			cache[m][n]  = min(x,y)+ cost[m][n];
		}
		return cache[m][n];
	}
	
	// Bottom UP DP Approach
	public static int findMinCost(int m, int n ) {
		
		int cache[][] = new int[m][n];
		
		if(m==0 && n==0)
			return cost[0][0];
		
		cache[0][0] = cost[0][0]; 
		
		for(int i=1; i<n; i++) {
			cache[0][i] = cache[0][i-1] + cost[0][i];
			cache[i][0] = cache[i-1][0] + cost[i][0];
		}
		
		for(int i =1 ; i<m ; i++) {
			for(int j =1 ; j<n ; j++) {
				int x = cache[i-1][j];
				int y = cache[i][j-1];
				cache[i][j]  = min(x,y)+ cost[i][j];
			}
		} 
		return cache[m-1][n-1];
	} 
	
	public static int min(int x, int y) {
		if (x <= y)
			return x;
		else
			return y;
	}
}