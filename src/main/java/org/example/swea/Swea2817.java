package org.example.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea2817 {
	static int[] graph;
	static int N,K,cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc=1; tc<T+1; tc++){
			cnt = 0;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			graph = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i=0; i<N; i++){
				graph[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0,0);

			bw.write("#"+tc+" "+cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int value, int idx){
		if (value == K){
			cnt++;
			return;
		}
		if (idx >= N || value >K ){ // 인덱스 범위 초과하거나, 합계가 k 초과할 경우 백트래킹
			return;
		}

		dfs(value+graph[idx], idx+1);
		dfs(value, idx+1);
	}
}
