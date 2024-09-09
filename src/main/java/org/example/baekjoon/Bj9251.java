package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i < str1.length() + 1; i++) {
			for (int j = 1; j < str2.length() + 1; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1; // 문자A와 문자B에 대해 이전 반복에서의 값에 +1
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 이전 반복에서의 값 중 큰 값으로 갱신
				}

			}
		}

		for (int[] temp : dp) {
			for (int value : temp) {
				System.out.print(value + " ");
			}
			System.out.println();
		}


		bw.write(String.valueOf(dp[str1.length()][str2.length()]) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
