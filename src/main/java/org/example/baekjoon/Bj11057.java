package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// n은 자리 수, k는 마지막 자리의 숫자
		// dp[n][k]는 n-1자리의 수에서 마지막 자리가 0부터 k까지인 경우를 모두 합산하여 계산
		long[][] dp = new long[N][10];

		for (int i=0; i<10; i++){
			dp[0][i] = 1;
		}

		for (int i=1; i<N; i++){
			for (int j=0; j<10; j++){
				// 오르막 수의 정의에 따르면, 마지막 자리 수가 j인 경우, 그 다음의 자리 수는 j 이상의 숫자만 가능
				for (int k=0; k<=j; k++){
					dp[i][j] += (dp[i-1][k]) % 10007; // ? -> 문제에서 요구하는 결과는 10007로 나눈 나머지, dp문제일 경우 중간 계산에서도 이를 적용해 주는 것이 필요
				}
			}
		}


		long result = 0;
		for (int j = 0; j < 10; j++) {
			result += dp[N-1][j];
		}

		System.out.println(result % 10007);
		br.close();

	}
}
