package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Bj1309 {

	/** Hint: dp[i][j]
	 *  i번째 칸이 비어 있는 경우는 i-1번째 칸이 비어 있거나 사자가 있는 경우 모두 포함
	 *  i번째 칸에 사자가 있는 경우는 i-1번째 칸이 비어 있어야 함 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N][3]; // 3인 이유: 사자 없음 + 왼쪽/오른쪽에 사자 존재

		// 가로로도 세로로도 붙어 있게 배치할 수는 없음
		// 2*N 배열에 사자를 배치하는 경우의 수가 몇 가지인지 (사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수)

		// 첫번째 열 기준으로 올 수 있는 경우의 수(사자가 없거나 왼or오른쪽에 있는 경우)
		dp[0][0] = 1; // 없음
		dp[0][1] = 1; // 왼쪽
		dp[0][2] = 1; // 오른쪽

		for (int i = 1; i < N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i-1][2]) % 9901; // i번째 칸이 비어 있음 <- 이전 번째 열의 경우에 신경쓸 것이 없음
			dp[i][1] = (dp[i - 1][0] + dp[i-1][2]) % 9901; // 왼쪽에 사자가 있기에 이전번째 열에서 사자가 없거나 오른쪽에 있어야 함
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
		}

		int result = (dp[N-1][0] + dp[N-1][1] + dp[N-1][2]) % 9901; // 최종 결과

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
