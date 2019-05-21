package com.dp;

/* Given the value of n you have to find the number of way in which briks can be put to fill the entire plot.  
 *  Inputs : height and width n of plot and size of briks (1).
 *  Output : Number of way to fill the entire plot.
 * */
public class FindTilesProblem {

	public static void main(String...strings) {
		System.out.println(solveMemo(1));
		System.out.println(solveTab(0));
	}
	
	// Recursive Solution :
	int solve(int n) {
		if(n==1) {return 1;}
		if(n==2) {return 2;}
		return solve(n-1) + solve(n-2);
	}
	
	// Memorization Solution : O(n) | O(n)
	public static int cache[] = new int[100];
	public static int solveMemo(int n) {
		
		if(cache[n]!=0)
			return cache[n];
		
		if(n == 1) 
			cache[n] = 1;
		else if(n == 2) 
			cache[n] = 2;
		else
			cache[n] = solveMemo(n-1) + solveMemo(n-2);
		
		return cache[n];
	}

	// Tabulation Solution : O(n) | O(n) (Bottom-up approach)
	public static int solveTab(int n) {
		
		int cache[] = new int[n+1];
		
		if(n==0) return 0;
		
		if(n == 1) return 1;
	
		if(n == 2) return 2;
	
		cache[1] = 1; 
		cache[2] = 2;
		
		for(int i =3 ; i<=n ;  i++)
			cache[i] = cache[i-1] + cache[i-2];
		
		return cache[n];
	}
}