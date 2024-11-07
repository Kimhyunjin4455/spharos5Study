package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];

		if (n==1) {
			bw.write(String.valueOf(1));
		}else if (n==2) {
			bw.write(String.valueOf(2));
		}else{
			// dp 초기값에 대해 dp를 적용 가능한 시점에 부여, n==1일 때는 인덱스에러 발생하기 때문
			dp[1] = 1;
			dp[2] = 2;
			for (int i=3; i<n+1; i++){
				dp[i] = dp[i-1]%10007 + dp[i-2]%10007; // 답안 나머지 연산이 필요할 경우, 과정에서도 나머지 연산 필요
			}
			bw.write(String.valueOf(dp[n]%10007)); // 과정에서 나누고 답안에서 나눌 필요가 없음
		}

		bw.flush();
		bw.close();
		br.close();
	} // i-1일 때의 경우에서 올 수 있고, i-2일 때의 경우에서 올 수 있기 때문에 이 두가지의 dp값을 더하기
}
