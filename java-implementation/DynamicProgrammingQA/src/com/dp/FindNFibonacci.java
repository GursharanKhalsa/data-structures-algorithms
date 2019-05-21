package com.dp;

public class FindNFibonacci {
	
	public static void main(String...strings) {
//		System.out.println(findFib(7));
//		System.out.println(findFibMemo(7));
		System.out.println(findFibTab(7));
	}
	
	// Time Complexity = o(2n)
	public static int findFib(int n) {
		if(n==0)
			return 0;
		if(n == 1 || n == 2) 
			return 1;
		return findFib(n-1) + findFib(n-2);
	}
	
	// Memorization Solution: Time Complexity = o(n) | o(n)  (Top-Down approach)
	public static int cache[] = new int[100];
	public static int findFibMemo(int n) {
		
		if(cache[n]!=0)
			return cache[n];
		
		if(n == 1 || n == 2) 
			cache[n] = 1;
		else
			cache[n] = findFib(n-1) + findFib(n-2);
		
		return cache[n];
	}
	
	// Tabulation Solution: Time Complexity = o(n) | o(n)  (Bottom-Top approach)
	public static int findFibTab(int n) {
			
		int cache[] = new int[n+1];
		
		if(n==0) return 0;
		
		if(n == 1 || n == 2) return 1;
		
		cache[0] = 0;
		cache[1] = cache[2] = 1;
		
		for(int i =3; i<=n; i++)
			cache[i] = cache[i-1] + cache[i-2];
			
		return cache[n];
	}
 }