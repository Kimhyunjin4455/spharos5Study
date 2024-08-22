package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 입력을 받기 위한 BufferedReader 객체 생성

        int n = Integer.parseInt(br.readLine());  // 수열의 크기 n

        String str = br.readLine();  // 수열 입력 받기
        String[] num = str.split(" ");  // 공백을 기준으로 문자열을 나누어 배열에 저장

        int[] b = new int[n];  // 수열을 저장할 배열 생성
        for (int i = 0; i < n; i++) {  // 수열 입력
            b[i] = Integer.parseInt(num[i]);
        }

        int[] dp = new int[n];  //dp 배열 생성

        for (int i = 0; i < n; i++) {  //dp 배열에 수열 입력
            dp[i] = b[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (b[i] > b[j]){  // 현재 수열의 값이 이전 수열의 값보다 큰 경우
                    dp[i] = Math.max(dp[i], dp[j] + b[i]);  // 현재 수열의 값과 이전 수열의 값의 합 중 큰 값을 dp 배열에 저장
                }
            }
        }

        int max_num = 0;
        for (int i = 0; i < n; i++) {
            max_num = Math.max(max_num, dp[i]);  // dp 배열에서 가장 큰 값을 찾아 max_num에 저장
        }
        System.out.println(max_num);
    }
}
