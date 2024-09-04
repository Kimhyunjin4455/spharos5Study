package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int max = 10000;
        boolean[] check = new boolean[max + 1]; // 소수 판별 배열

        for (int i = 2; i < max; i++) { // 초기화
            check[i] = true;
        }

        // 에라토스테네스의 체
        for (int i = 2; i * i <= max; i++){ // i * i <= max인 이유는 i * i 이후의 값은 이미 처리되었기 때문
            if (check[i]) {
                for (int j = i * i; j <= max; j += i) { // i * i부터 시작하여 i의 배수들을 false로 변경
                    check[j] = false;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int num1 = 0;
            int num2 = 0;

            // n을 2로 나누어 두 수의 차이가 가장 작은 수를 찾음, 가장 차이가 적은 경우는 두 수가 n / 2인 경우
            for (int j = 2; j <= n / 2; j++) {
                if (check[j] && check[n - j]) { // 두 수가 소수인 경우
                    num1 = j;
                    num2 = n - j;
                }
            }
            System.out.println(num1 + " " + num2);
        }
    }
}
