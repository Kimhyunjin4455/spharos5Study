package problem;

public class Programmers_12902 {

    public static long solution(int n) {
        if (n % 2 == 1) return 0;
        long[] dp = new long[n + 1];

        // 초기값 설정
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            // 아전 경우의 수 * 늘어난 칸에 대한 경우의 수 (3)
            dp[i] = dp[i - 2] * 3;

            // 노션 참고
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(1558));
    }
}