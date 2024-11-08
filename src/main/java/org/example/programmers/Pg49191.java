package org.example.programmers;

public class Pg49191 {
	public static void main(String[] args) {
		int n = 5;
		int[][] results = new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
		Solution sol = new Solution();
		System.out.println(sol.solution(n,results));

	}
	static class Solution {
		public int solution(int n, int[][] results) {
			int[][] fightArrays = new int[n+1][n+1];

			// 1차원에는 사람수만큼 1~4
			// 2차원에는 그 순서에 사람에 대해 이기면 1 정보없으면 0 지면 -1
			int answer = 0;

			// 2차원 배열에 대해 이긴 사람에 대해 1 진 사람에 대해 -1 처리
			for (int[] result : results){
				int winner = result[0];
				int loser = result[1];

				fightArrays[winner][loser] = 1;
				fightArrays[loser][winner] = -1;

			}

			for (int k=1; k<n+1; k++){ // k라는 지점에 대해 i번과 j번에 대해 반복
				for (int i=1; i<n+1; i++){
					for (int j = 1; j<n+1; j++){
						// k 지점에 대해 i지점이 더 강력하고, k지점에 대해 i지점이 더 약하면
						if (fightArrays[i][k]==1 && fightArrays[k][j]==1){
							fightArrays[i][j] = 1;
							fightArrays[j][i] = -1;
						}
					}
				}
			}

			for (int i=1; i<n+1; i++){
				int cnt = 0;
				for (int j=1; j<n+1; j++){
					if (fightArrays[i][j] != 0){
						cnt++;
					}
				}
				if (cnt == n-1){
					answer ++;
				}
			}




			return answer;
		}
	}
}
