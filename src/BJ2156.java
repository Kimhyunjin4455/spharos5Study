import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] wine = new int[n+1];

		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		if (n == 0) {
			System.out.println(0);
			return;
		} else if (n == 1) {
			System.out.println(wine[1]);
			return;
		} else if (n == 2) {
			System.out.println(wine[1] + wine[2]);
			return;
		}
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];

		for (int i = 3; i <= n; i++) {
			//oox
//			dp[i-1]
			//oxo i-2까지의 마실 수 있는 와인 최대값 + wine[i]
//			dp[i-2]+wine[i]
			//xoo i-3까지의 마실 수 있는 와인 최대값 + wine[i-1] + wine[i]
//			dp[i-3]+wine[i-1]+wine[i]

			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
		}
		System.out.println(dp[n]);
	}
}
