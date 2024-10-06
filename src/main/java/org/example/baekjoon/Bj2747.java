package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj2747 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N+1];
		int result = 0;

		// 점화식은 쉬운 난이도이지만, N값이 1과 2로 들어올 상황을 고려해야 함
		if (N == 1){
			result = 1;
		} else if (N==2) {
			result = 1;
		}else{
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;

			for (int i=3; i<N+1; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}

			result = dp[N];

		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();


	}
}
