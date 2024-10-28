package org.example.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Swea2806 {

	static int N;
	static int res = 0;
	static boolean[] col; // 같은 행과 열에 배치되었는지는 1차원 배열로도 확인 가능
	static boolean[][] crossRight;
	static boolean[][] crossLeft;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i < T + 1; i++) {
			N = Integer.parseInt(br.readLine());
			col = new boolean[N];
			crossRight = new boolean[N][N];
			crossLeft = new boolean[N][N];
			res = 0;
			dfs(0, 0);

			bw.write("#" + i + " " + res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int start, int depth){
		if(depth == N){
			res++;
			return;
		}

		for(int idx=start; idx<N; idx++){
			if (!col[idx] && !crossRight[depth][idx] && !crossLeft[depth][idx]){
				col[idx] = true;
				crossRight[depth][idx] = true;
				crossLeft[depth][idx] = true;

				dfs(idx+1, depth+1);

				col[idx] = false;
				crossRight[depth][idx] = false;
				crossLeft[depth][idx] = false;

			}
		}
	}
}
