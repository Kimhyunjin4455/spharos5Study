package org.example.programmers;

import java.util.ArrayList;
import java.util.List;

public class Pg1843 {
	public int solution(String arr[]) {
		List<Integer> numbers = new ArrayList<>();
		List<String> operators = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) { // 짝수번째가 연산할 수들
				numbers.add(Integer.parseInt(arr[i]));
			} else {
				operators.add(arr[i]);
			}
		}

		int n = numbers.size();
		int[][] dp = new int[n][n];
		int[][] minDp = new int[n][n];

		for (int i = 0; i < n; i++) { // 각 숫자에 대해 자기 자신을 최댓값과 최솟값으로 초기화
			dp[i][i] = numbers.get(i); // i부터 j까지의 부분 수식에서 가능한 최대 결과
			minDp[i][i] = numbers.get(i); // i부터 j까지의 부분 수식에서 가능한 최소 결과
		}

		for (int size = 2; size <= n; size++){ // 부분 연산은 최소 2개부터 n개까지
			for (int i=0; i < n - size + 1; i++){ // i는 연산 시작의 인덱스 4개의 숫자에서 2개를 통한 연산을 할 때 마지막 경우의 수의 시작인덱스는 2(n-size+1 범위를 줘야 2까지 가능)
				int j = i + size - 1; // j는 연산 끝의 인덱스
				dp[i][j] = Integer.MIN_VALUE;
				minDp[i][j] = Integer.MAX_VALUE;

				for (int k=i; k < j; k++){ // i부터 j-1까지(연산자의 갯수)
					if (operators.get(k).equals("+")){
						dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k+1][j]); // i부터 k까지의 최댓값 + k+1부터 j까지의 최댓값
						minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k + 1][j]);
					}else if (operators.get(k).equals("-")) {
						dp[i][j] = Math.max(dp[i][j], dp[i][k] - minDp[k + 1][j]);
						minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - dp[k + 1][j]);
					}
				}
			}
		}


		int answer = dp[0][n-1];

		return dp[0][n-1];
	}

	public static void main(String[] args) {
		String[] arr1 = new String[] {"1", "-", "3", "+", "5", "-", "8"};
		String[] arr2 = new String[] {"5", "-", "3", "+", "1", "+", "2", "-", "4"};

		Pg1843 pg1843 = new Pg1843();
		System.out.println(pg1843.solution(arr1));
		System.out.println(pg1843.solution(arr2));

	}
}
