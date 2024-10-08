package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bj11049{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N+1]; // 각 행렬의 차원을 저장

		for (int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			p[i] = row; // 행렬의 행 크기
			if (i == N-1){ // 마지막 행렬의 열 크기
				p[N] = col;
			}
		}

		int[][] dp = new int[N][N];

		for (int depth=2; depth<=N; depth++){ // 곱하는 행렬의 갯수가 2부터 N까지
			for (int i=0; i<= N-depth; i++){ // 시작
				int j= i + depth -1; // 끝
				dp[i][j] = Integer.MAX_VALUE;

				for (int k=i; k<j; k++){ // i ~ j-1
					// dp[i][k]: i번째 행렬부터 k번쨰 행렬까지 곱하는데 필요한 최소 행렬 수
					int cost = dp[i][k] + dp[k+1][j] + p[i] * p[k+1] * p[j+1];
					dp[i][j] = Math.min(dp[i][j], cost);
				}
			}
		}

		bw.write(String.valueOf(dp[0][N-1]));
		bw.flush();
		bw.close();
		br.close();


	}
}
