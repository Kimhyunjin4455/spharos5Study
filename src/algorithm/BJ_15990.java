package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15990 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] dp = new int[100001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		int t = Integer.parseInt(br.readLine());

		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
		}

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009);
		}

	}
}
