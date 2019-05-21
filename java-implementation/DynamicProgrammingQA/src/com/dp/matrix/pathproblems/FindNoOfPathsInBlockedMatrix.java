package com.dp.matrix.pathproblems;

/*	Find the number of paths in given blocked matrix.
 * */
public class FindNoOfPathsInBlockedMatrix {
	
	public static int blocked[][] = { {0,0,1,0} , {0,0,0,1} , {0,1,0,1} , {0,0,0,0} };
	public static int cnt = 0;
	
	public static void main(String...strings) {
		System.out.println("No fof paths in blocked matrix="+noOfWays(3,3));
		System.out.println("Function Count="+cnt);
		cnt = 0;
		System.out.println("No fof paths in blocked matrix="+noOfWaysMemo(3,3));
		System.out.println("Function Count="+cnt);
	}

	// Recursive
	public static int noOfWays(int m , int n) {
		cnt++;	
		if(blocked[m][n] == 1)
			return 0;
		
		if(m==0 && n==0) return 0;
		
		if(m==0 || n==0) return 1;
		
		int x = noOfWays(m-1,n);
		int y = noOfWays(m,n-1);
		
		return x+y;
	}
	
	// Memoization Approach
	public static int noOfWaysMemo(int m , int n) {
		int cache[][] = new int[m+1][n+1];
		for(int i =0 ; i<= m ; i++) {
			for(int j =0 ; j<= n ; j++) {
				cache[i][j] = -1;
			}
		}
		return noOfWaysMemo(m,n,cache);
	}
	public static int noOfWaysMemo(int m , int n ,int[][] cache) {
		cnt++;		
		if(blocked[m][n] == 1)
			return cache[m][n] = 0;
			
		if(m==0 && n==0) return cache[m][n] = 0;
			
		if(m==0 || n==0) return cache[m][n] = 1;
		
		if(cache[m][n] != -1)
			return cache[m][n];
		else {
			int x = noOfWaysMemo(m-1,n);
			int y = noOfWaysMemo(m,n-1);
			cache[m][n] = x+y;
		}
		return cache[m][n];
	}
	
	// Tabulation Approach  TODO
	public static int noOfWaysTab(int m , int n ) {
		
		int[][] cache = new int[m][n];
		
		for(int i =0 ; i<= m ; i++) {
			for(int j =0 ; j<= n ; j++) {
				cache[i][j] = -1;
			}
		}
		
		if(blocked[m][n] == 1)
			return cache[m][n] = 0;
			
		if(m==0 && n==0) return cache[m][n] = 0;
			
		if(m==0 || n==0) return cache[m][n] = 1;
		
		
		
		
		
		if(cache[m][n] != -1)
			return cache[m][n];
		else {
			int x = noOfWaysMemo(m-1,n);
			int y = noOfWaysMemo(m,n-1);
			cache[m][n] = x+y;
		}
		return cache[m][n];
	}
}
