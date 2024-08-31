package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());


		int[] w = new int[N+1]; // 무게 0의 경우 추가
		int[] v = new int[N+1]; // 무게 0의 경우 모든 v는 0이어야 하기에 N+1
		int[][] dp = new int[N+1][K+1]; // 0개를 택했을때와 무게가 0일때의 경우를 위해 row, col +1

		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			w[i+1] = Integer.parseInt(st.nextToken());
			v[i+1] = Integer.parseInt(st.nextToken());
		}

		for (int i=1; i<=N; i++){
			for (int j=0; j<=K; j++){
				if (w[i] > j){ // 현재 선택한 것의 무게기준보다 작으면
					dp[i][j] = dp[i-1][j]; // 이전의 값 그대로 적용
				}else{
					dp[i][j] = Math.max(dp[i-1][j-w[i]] + v[i], dp[i-1][j]);
					// 무게를 넣거나 말거나, 넣는 다면 현재 무게를 덜 넣었을 때의 가치에서 현재 무게의 가치를 더함
					// 안 넣으면 이전번의 그 무게의 값을 선택해야 됨
				}
			}
		}

		// for (int i=0; i<N; i++){
		// 	bw.write("weight: " + w[i] + " value: " + v[i] + "\n");
		// } // 테스트 출력

		for (int[]temp: dp){
			for (int value: temp){
				System.out.print(value +" ");
			}
			System.out.println();
		}

		bw.write(String.valueOf(dp[N][K]));

		bw.flush();
		bw.close();
		br.close();


	}
}
