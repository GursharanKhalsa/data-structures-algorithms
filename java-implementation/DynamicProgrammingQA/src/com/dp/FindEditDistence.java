package com.dp;

public class FindEditDistence {

	public static void main(String... strings) {
//		System.out.println("Minimun Edit distence of CAT and CAR is="+minEditDistance("CAT","CAR"));
//		System.out.println("Minimun Edit distence of SATURDAY and SUNDAY is="+minEditDistance("SATURDAY","SUNDAY"));
//		
		System.out.println("Minimun Edit distence of CAT and CAR is=" + minEditDistanceMemo("CAT", "CAR"));
		System.out.println(
				"Minimun Edit distence of SATURDAY and SUNDAY is=" + minEditDistanceMemo("SATURDAY", "SUNDAY"));
	}

	public static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		else
			return z;
	}

	public static int minEditDistance(String a, String b) {
		return minEditDistance(a, b, a.length(), b.length());
	}

	public static int minEditDistance(String a, String b, int al, int bl) {
		if (a == null && b == null) {
			return 0;
		}
		if (al == 0)
			return bl;
		if (bl == 0)
			return al;

		if (a.charAt(al - 1) == b.charAt(bl - 1))
			return minEditDistance(a, b, al - 1, bl - 1);

		int x = minEditDistance(a, b, al, bl - 1); // INSERT
		int y = minEditDistance(a, b, al - 1, bl); // UPDATE
		int z = minEditDistance(a, b, al - 1, bl - 1); // DELETE

		return min(x, y, z) + 1;
	}

	// Memoization Solution
	public static int minEditDistanceMemo(String a, String b) {
		int cache[][] = new int[a.length()][b.length()];
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				cache[i][j] = -1;
			}
		}
		return minEditDistanceMemo(a, b, a.length(), b.length(), cache);
	}
	public static int minEditDistanceMemo(String a, String b, int al, int bl, int cache[][]) {

		if (a == null && b == null) {
			return 0;
		}

		if (al == 0)
			return bl;
		if (bl == 0)
			return al;

		if (cache[al - 1][bl - 1] != -1)
			return cache[al - 1][bl - 1];

		if (a.charAt(al - 1) == b.charAt(bl - 1))
			return cache[al - 1][bl - 1] = minEditDistance(a, b, al - 1, bl - 1);

		int x = minEditDistance(a, b, al, bl - 1); // INSERT
		int y = minEditDistance(a, b, al - 1, bl); // UPDATE
		int z = minEditDistance(a, b, al - 1, bl - 1); // DELETE

		return cache[al - 1][bl - 1] = min(x, y, z) + 1;
	}

	public static int minEditDistanceTab(String a, String b) {

		int al = a.length(), bl = b.length();

		if (a == null && b == null) {
			return 0;
		}

		if (al == 0)
			return bl;
		if (bl == 0)
			return al;

		int cache[][] = new int[al][bl];

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				cache[i][j] = -1;
			}
		}

		if (cache[al - 1][bl - 1] != -1)
			return cache[al - 1][bl - 1];

		if (a.charAt(al - 1) == b.charAt(bl - 1))
			return cache[al - 1][bl - 1] = minEditDistance(a, b, al - 1, bl - 1);

		int x = minEditDistance(a, b, al, bl - 1); // INSERT
		int y = minEditDistance(a, b, al - 1, bl); // UPDATE
		int z = minEditDistance(a, b, al - 1, bl - 1); // DELETE

		return cache[al - 1][bl - 1] = min(x, y, z) + 1;
	}
}


//int minEditDist(char* s1, char* s2)
//{
//	if(s1 == NULL && s2 == NULL){ return 0; }
//	if(s1 == NULL) {return strlen(s2); }
//	if(s2 == NULL) {return strlen(s1); }
//
//	if(s1[0] == s2[0])
//		return minEditDist(s1+1, s2+1);
//	
//	x = minEditDist(s1, s2+1); // INSERT
//	y = minEditDist(s1+1, s2+1); // UPDATE
//	z = minEditDist(s1+1, s2); // DELETE
//	
//	return min(x, y, z) + 1;
//}