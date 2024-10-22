package org.example.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea1244 {

	static int count;
	static String number;
	static int res;
	static int[] graph;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			number = String.valueOf(st.nextToken());
			count = Integer.parseInt(st.nextToken());

			graph = new int[number.length()];
			for (int i = 0; i < number.length(); i++) {
				graph[i] = number.charAt(i) - '0';
			}

			if (graph.length < count) {
				count = graph.length;
			} // 자리수만큼 교환 기회가 주어진다면 선택 정렬에 의해서 무조건 내림차순으로 정렬하여 최대 상금을 획득

			res = Integer.MIN_VALUE;
			dfs(0, 0);

			bw.write("#" + test_case + " " + res);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int start, int idx){
		if (idx == count) {
			int result = 0;
			for (int i = 0; i < graph.length; i++) {
				result = result * 10 + graph[i];
			}
			res = Math.max(res, result);
			return;
		}

		for (int i = start; i < graph.length - 1; i++) {
			for (int j = i + 1; j < graph.length; j++) {
				// Swap
				swap(i, j);
				dfs(i, idx + 1);
				// Swap back
				swap(i, j);
			}
		}
	}

	private static void swap(int i, int j) {
		int temp = graph[i];
		graph[i] = graph[j];
		graph[j] = temp;
	}
}
