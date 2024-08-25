package org.example.programmers;

public class PgGoSchool {
    // (1,1)에서 출발 (4,3)에 도착 (2,2)는 방문 불가 -> (x,y)라 가정
    // 오른쪽과 아래쪽으로만 움직일 수 있음 (오른쪽은 x값 1증가, 아래쪽은 y값 1증가)
    // 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지 return
    // 현재 위치에서의 최솟값 구하기
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n]; // 몇가지의 루트로 갈 수 있는지 값을 저장할 배열
        int answer = 0;

        dp[0][0] =1; // 첫 위치의 최단경로의 갯수는 1

        for (int i = 0; i< puddles.length; i++){ // 웅덩이의 갯수만큼 비활성화 처리
            dp[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }


        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (dp[i][j] == -1) {
                    dp[i][j] = 0; // 방문을 못하게 하는 처리 X -> 방문하더라도 이후 로직에 영향 안가도록 처리
                }else {
                    // row, column이 0일떄는 1가지만 가능
                    // 아래 과정을 통해 오른쪽과 위로 올 수 있는 경로의 수를 더해나가는 식으로 최종 값 계산
                    if (i>0){
                        dp[i][j] += dp[i-1][j];
                    }
                    if (j>0) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }

//        for (int[] v : dp){
//            for (int value: v){
//                System.out.print(value + " ");
//            }System.out.println();
//        } // 중간 점검용 출력문
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
