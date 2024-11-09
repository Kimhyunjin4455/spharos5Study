package org.example.programmers;

import java.util.Arrays;

public class Pg120808 {
	public static void main(String[] args) {
		int numer1a = 1;
		int denom1a = 2;
		int numer2a = 3;
		int denom2a = 4;

		int numer1b = 9;
		int denom1b = 2;
		int numer2b = 1;
		int denom2b = 3;

		Solution sol = new Solution();
		int[] solArr = sol.solution(numer1a, denom1a, numer2a, denom2a);
		System.out.println(Arrays.toString(solArr));
		int[] solArr2 = sol.solution(numer1b, denom1b, numer2b, denom2b);
		System.out.println(Arrays.toString(solArr2));
	}

	static class Solution {
		public int[] solution(int numer1, int denom1, int numer2, int denom2) {
			int[] answer = new int[2];
			int lcs = lcs(denom1, denom2);
			int numer = numer1 * (lcs/denom1) + numer2 * (lcs/denom2);
			int gcd = gcd(numer, lcs);

			int resultNumer = numer / gcd;
			int resultDenom = lcs / gcd;

			answer[0] = resultNumer;
			answer[1] = resultDenom;

			return answer;
		}

		public int gcd(int a, int b){
			int temp = 0;
			while (b != 0){
				temp = a%b;
				a = b;
				b = temp;
			}
			return a;
		}

		public int lcs(int a, int b){
			return (a*b / gcd(a,b));
		}
	}


}
