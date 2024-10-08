package org.example.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Pg43162 {

	public static void main(String[] args) {
		int[][] computers1 = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
		int[][] computers2 = new int[][]{{1,1,0}, {1,1,1}, {0,1,1}};

		Solution sol = new Solution();

		System.out.println(sol.solution(3, computers1));
		System.out.println(sol.solution(3, computers2));
	}

	// static class Solution {
	// 	static boolean[] visited;
	// 	public int solution(int n, int[][] computers) {
	// 		int answer = 0;
	//
	//
	// 		visited = new boolean[n];
	//
	// 		for (int i=0; i<n; i++){
	// 			if (!visited[i]){
	// 				dfs(i,n,computers);
	// 				answer++;
	// 			}
	// 		}
	//
	// 		return answer;
	// 	}
	//
	// 	private void dfs(int now, int cnt, int[][] computers) {
	// 		visited[now] = true;
	//
	// 		for (int i=0; i< cnt; i++){
	// 			if (computers[now][i] == 1 && !visited[i]){
	// 				dfs(i,cnt,computers);
	// 			}
	// 		}
	// 	}
	// }

	static class Solution {
		static int[][] graph; // 연결된 컴퓨터 상태를 저장하는 배열
		static boolean[] visited; // 방문한 컴퓨터를 기록하기 위한 2차원 배열

		public int solution(int n, int[][] computers) {
			int answer = 0;

			// 그래프 및 visited 배열 초기화
			graph = new int[n][n];
			visited = new boolean[n];

			// computers 배열을 graph 배열로 변환
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = computers[i][j]; // 연결 상태 복사
				}
			}

			// DFS를 통해 네트워크 개수 세기
			for (int i = 0; i < n; i++) {
				if (!visited[i]) { // 2차원 배열을 사용하므로 첫 번째 열을 체크
					dfs(i, n);
					answer++; // 새로운 네트워크 발견
				}
			}

			return answer; // 네트워크의 개수 반환
		}

		private void dfs(int now, int n) {
			visited[now] = true; // 현재 컴퓨터 방문 처리

			// 현재 컴퓨터와 연결된 모든 컴퓨터 탐색
			for (int i = 0; i < n; i++) {
				if (graph[now][i] == 1 && !visited[i]) { // 연결된 컴퓨터를 찾음
					dfs(i, n); // 재귀적으로 DFS 호출
				}
			}
		}
	}
}
