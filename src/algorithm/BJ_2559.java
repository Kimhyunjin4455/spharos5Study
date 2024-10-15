package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 전체 날짜
        int k = Integer.parseInt(st.nextToken()); // 연속적인 날짜

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 K일 동안, 비교를 위해
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        // 슬라이딩 윈도우
        for (int i = k; i < n; i++) {
            sum = sum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}

