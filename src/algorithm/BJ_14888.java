package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888 {
    static int[] arr; // 숫자 배열
    static int[] operator; // 연산자 배열
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int num, int res) {

        // 모든 연사자를 쓴 경우 결과 입력
        if (num == arr.length) {
            max = Math.max(max, res);
            min = Math.min(min, res);
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                if (i == 0) {
                    dfs(num + 1, res + arr[num]);
                } else if (i == 1) {
                    dfs(num + 1, res - arr[num]);
                } else if (i == 2) {
                    dfs(num + 1, res * arr[num]);
                } else if (i == 3) {
                    dfs(num + 1, res / arr[num]);
                }
                operator[i]++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}
