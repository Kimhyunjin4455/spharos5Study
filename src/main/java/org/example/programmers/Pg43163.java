package org.example.programmers;

import java.util.Arrays;

public class Pg43163 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";

		String[] wordsA = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
		String[] wordsB = new String[]{"hot", "dot", "dog", "lot", "log"};

		Solution sol = new Solution();

		System.out.println(sol.solution(begin, target, wordsA));
		System.out.println(sol.solution(begin, target, wordsB));
	}
	static class Solution {
		static int answer;
		static boolean[] visited;
		public int solution(String begin, String target, String[] words) {
			answer = Integer.MAX_VALUE;
			visited =  new boolean[words.length];

			if (!Arrays.asList(words).contains(target)) {
				return 0;
			}


			dfs(begin, target, words, 0);

			// 변환이 불가능한 경우 0 반환
			return answer == Integer.MAX_VALUE ? 0 : answer;


		}

		public static void dfs(String begin, String target, String[] words ,int depth){
			if (begin.equals(target)){
				answer = Math.min(answer, depth);
				return;
			}
			for (int now = 0; now< words.length; now++){
				// if (!visited[now] && words[now] != begin){ // 방문되지 않았고 다른 문자라면
				// 	// if words[now]와 begin이 한 글자만 다르다면
				// 	if(differentOne(begin, words[now])){
				// 		visited[now] = true;
				// 		System.out.println("begin: " + begin + " " + "words: "+ words[now] + " depth: "+ depth);
				// 		dfs(words[now], target, words, depth+1);
				// 		visited[now] = false;
				// 	}
				// }
				// 방문하지 않았고, 한 글자만 다른 경우
				if (!visited[now] && differentOne(begin, words[now])) {
					visited[now] = true; // 방문 체크
					dfs(words[now], target, words, depth + 1); // 다음 단계 탐색
					visited[now] = false; // 백트래킹
				}
			}
		}

		public static boolean differentOne(String begin, String words) {
			if (begin.length() != words.length()) {
				return false;
			}

			int differenceCount = 0;

			// 각 문자 비교
			for (int i = 0; i < begin.length(); i++) {
				if (begin.charAt(i) != words.charAt(i)) {
					differenceCount++;
				}
				if (differenceCount > 1) {
					return false; // 두 글자 이상 다르면 false
				}
			}
			return differenceCount == 1; // 정확히 한 글자만 다르면 true


		}
	}
}
