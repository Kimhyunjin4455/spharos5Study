package org.example.programmers;

public class PgGoSchool {
    // (1,1)에서 출발 (4,3)에 도착 (2,2)는 방문 불가 -> (x,y)라 가정
    // 오른쪽과 아래쪽으로만 움직일 수 있음 (오른쪽은 x값 1증가, 아래쪽은 y값 1증가)
    // 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지 return
    // 현재 위치에서의 최솟값 구하기
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        int answer = 0;

        dp[0][0] =1;

        for (int i = 0; i< puddles.length; i++){
            dp[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }


        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                }else {
                    if (i>0){
                        dp[i][j] += dp[i-1][j];
                    }
                    if (j>0) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }

        for (int[] v : dp){
            for (int value: v){
                System.out.print(value + " ");
            }System.out.println();
        }
        answer = dp[m-1][n-1];
        return answer % 1000000007; // 문제에 return의 경우 도착 전 거리만 판단
    }
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = new int[][]{{2,2}};
        PgGoSchool sol = new PgGoSchool();
        System.out.println(sol.solution(m,n,puddles));

    }
}
