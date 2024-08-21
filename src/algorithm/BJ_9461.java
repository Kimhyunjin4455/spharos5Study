package algorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수
        long[] dp = new long[101];  // dp 배열 생성
        dp[1] = 1;  // 초기값 설정
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= 100; i++) {  // dp 배열 채우기
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < t; i++) {  // 테스트 케이스만큼 반복
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);  // dp 배열에서 n번째 값 출력
        }

        br.close();
    }
}

