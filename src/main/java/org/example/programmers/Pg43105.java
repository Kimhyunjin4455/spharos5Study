package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class Pg43105 {
	public static void main(String[] args) {
		int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

		Solution sol = new Solution();

		System.out.println(sol.solution(triangle));
	}
	static class Solution{
		static ArrayList<Integer> dp;
		public int solution(int[][] triangle) {

			for (int i=1; i<triangle.length; i++){
				for (int j=0; j<triangle[i].length; j++){
					if (j==0){
						triangle[i][j] = triangle[i][j] + triangle[i-1][0];
					} else if (j==triangle[i].length-1) {
						triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
					}else
						triangle[i][j] = Math.max(triangle[i][j]+triangle[i-1][j-1], triangle[i][j]+triangle[i-1][j]);

				}

			}

			int answer = Arrays.stream(triangle[triangle.length - 1]).max().orElseThrow();

			return answer;
		}

	}
}
