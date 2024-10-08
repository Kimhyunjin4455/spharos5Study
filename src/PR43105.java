public class PR43105 {

	public static void main(String[] args) {
		int solution = new Solution().solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
		System.out.println(solution);
	}

	static class Solution {
		public int solution(int[][] triangle) {
			int answer = 0;
			int len = triangle.length;

			for (int i=1; i<len;i++) {
				for (int j=0; j<=i; j++) {
					if (j==0) { // 삼각형의 왼쪽 끝부분일 때
						triangle[i][j] += triangle[i-1][j];
					} else if (j==i) { //삼각형의 오른쪽 끝부분일 때
						triangle[i][j] += triangle[i-1][j-1];
					} else {
						triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
					}
					answer = Math.max(triangle[i][j], answer);
				}
			}

			return answer;
		}
	}
}
