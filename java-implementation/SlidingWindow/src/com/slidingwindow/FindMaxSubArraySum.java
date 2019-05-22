package com.slidingwindow;

public class FindMaxSubArraySum {

	public static int arr[] = { 1, 5, 8, 2, -3, 9, 6 };
	static int k = 3;

	public static int maxSubarraySum() {
		int s = 0, e = k - 1, sum = 0, maxSum = 0;

		for (int i = 0; i < k; i++)
			sum += arr[i];

		maxSum = sum;

		while (e < arr.length - 1) {
			s++;
			e++;
			sum = sum - arr[s - 1] + arr[e];
			if (sum > maxSum)
				maxSum = sum;
		}
		return maxSum;
	}
	
	public static void main(String...strings) {
		System.out.println("Max Sum of sub array of given array is="+maxSubarraySum());
	}
}