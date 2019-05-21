package com.dp.matrix.pathproblems;

/*	Find the number of ways to reach end of given matrix
 *  Ex: if there is 2*2 matrix then the number of ways to reach at (2,2) from (0,0) is 6.
 * */
public class FindNoOfPathsInMatrix {

	public static int cnt = 0;
	
	public static void main(String... strings) {
		System.out.println("No of paths ="+noOfPaths(3,3));
		System.out.println("Function Count="+cnt);
		cnt = 0;
		System.out.println("No of paths ="+noOfPathsMemo(3,3));
		System.out.println("Function Count="+cnt);
		cnt = 0;
		System.out.println("No of paths ="+noOfPathsTab(4,4));
		System.out.println("Function Count="+cnt);
		cnt = 0;
	}

	// Recursive Solution
	public static int noOfPaths(int n, int m) {
		cnt++;
		if (m == 0 && n == 0) {
			return 0;
		}
		if (m == 0 || n == 0) {
			return 1;
		}

		int x = noOfPaths(m - 1, n);
		int y = noOfPaths(m, n - 1);
		return x + y;
	}

	// Memorization Solution :
	public static int noOfPathsMemo(int m, int n) {
		int cache[][] = new int[m+1][n+1];
		for(int i =0 ; i<= m ; i++) {
			for(int j =0 ; j<= m ; j++) {
				cache[m][n] = 0;
			}
		}
		return noOfPathsMemo(m,n,cache);
	}
	public static int noOfPathsMemo(int m, int n, int cache[][]) {	
		cnt++;
		if (cache[m][n] != 0) {
			return cache[m][n];
		}
		if (m == 0 && n == 0) {
			return 0;
		}
		if (m == 0 || n == 0) {
			return 1;
		}
		cache[m][n] = noOfPaths(m - 1, n) + noOfPaths(m, n - 1);
		return cache[m][n];
	}

	// Tabulation Solution : 
	public static int noOfPathsTab(int m, int n) {
		int arr[][] = new int[m][n];

		arr[0][0] = 0;
		
		for(int i=1; i<n; i++)
			arr[i][0] = arr[0][i] = 1;
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		return arr[n-1][m-1];
	}
}