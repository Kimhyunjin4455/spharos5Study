package org.example.programmers;

import java.util.Arrays;

public class PgTheft {
    // 인접한 두 집을 털면 경보가 울림
    // 훔칠 수 있는 돈의 최댓값을 return
    // {1,2,3,1} -> 붙은 두개를 털 수 없음, 동그랗게 배치이기에 0번째 집과 -1번째 집도 털 수 없음
    /** 1차 시도: 문제 오해 -> 인접하지 않은 두곳에 대해서만 생각하고 풀이, But 인접하지 않은 여러집 가능*/
    // 가상의 예시 {1,3,2,6,8,6,2} -> 12

    // 집은 3개 이상 1,000,000개 이하 -> 배열의 최대 크기 1,000,000 -> 이중 반복부터 시간 초과일듯 -> 1번의 반복 내에서 처리해야될듯
    // money 배열의 각 원소는 0 이상 1,000 이하인 정수

    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length]; // 값을 저장할 배열

        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        // ai 힌트
        // 루프: dp[i]는 i번째 요소를 선택하지 않는 경우(dp[i-1])와 선택하는 경우(money[i] + dp[i-2]) 중에서 큰 값을 선택합니다.
        /** 첫번째 요소를 선택할지 마지막 요소를 선택할지 */

        // 1. 첫번째 요소 선택
        for (int i=2; i< money.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }

        int maxContainFirstIdx = dp[money.length-2]; // 마지막 요소를 사용한 dp 값 사용 불가능

//        for (int v: dp){
//            System.out.print(v + " ");
//        }
//        System.out.println(); // 중간 점검 출력 코드 {1,2,4,4} / {1,3,3,9,11,15,15}

        // 2. 마지막 요소 선택
        dp[0] = 0; // 첫번째 요소 사용 X
        dp[1] = money[1]; // 첫 요소를 사용하지 않기에 max를 구할 가치조차 없음

        for (int i=2; i< money.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }

        int maxNotContainFirstIdx = dp[money.length-1]; // 마지막 요소가 포함되었기에 마지막의 dp값 사용 가능


//        for (int v: dp){
//            System.out.print(v + " ");
//        }
//        System.out.println(); // 중간 점검 출력 코드 {0,2,3,3} / {0,3,3,9,11,15,15}

        answer = Math.max(maxContainFirstIdx, maxNotContainFirstIdx);
        return answer;
    }

    public static void main(String[] args) {
        int[] money = new int[]{1,2,3,1};
        int[] money2 = new int[]{1,3,2,6,8,6,2};
        PgTheft sol = new PgTheft();
        System.out.println(sol.solution(money));
        System.out.println(sol.solution(money2));
    }
}
