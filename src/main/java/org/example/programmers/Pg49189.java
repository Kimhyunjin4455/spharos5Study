package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pg49189 {
	// 노드 1~n
	// 최단 경로 이동 시 간선 갯수가 가장 많은 노드
	// 1번에서 부터 가장 멀리 떨어진게 몇개인지?

	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = new int[][]{{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};

		Solution sol = new Solution();
		System.out.println(sol.solution(n, vertex));
	}
	static class Solution {
		public int solution(int n, int[][] vertex) {
			List<Integer>[] graph = new ArrayList[n+1]; // 길이가 n+1인 List<Integer>[] 배열을 생성
			for (int i=1; i<=n; i++){
				graph[i] = new ArrayList<>();
			}
			for (int[] edge: vertex){
				int a = edge[0];
				int b = edge[1];
				graph[a].add(b);
				graph[b].add(a);
			}

			int[] distances = new int[n+1]; // 1번 노드로 부터 거리의 저장하기 위함
			Arrays.fill(distances, -1); // distances배열의 모든 요소를 -1로 초기화
			distances[1] = 0;
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(1);
			while (!queue.isEmpty()){
				int node = queue.poll();
				for (int neighbor : graph[node]){
					if (distances[neighbor] == -1){
						distances[neighbor] = distances[node]+1;
						queue.offer(neighbor);
					}
				}
			}

			int maxDistance= 0;
			for (int distance: distances){
				maxDistance = Math.max(maxDistance, distance);
			}

			int count = 0;
			for (int distance : distances){
				if (distance == maxDistance){
					count++;
				}
			}

			return count;
		}
	}
}
