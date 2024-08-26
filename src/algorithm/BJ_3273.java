package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];  // 수열을 저장할 배열 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);  // 정렬

        // 투 포인터
        int count = 0;
        int s = 0;  // 시작
        int e = n - 1;  // 끝

        while (s < e) {
            int sum = arr[s] + arr[e];

            if (sum == x) {  // 합이 x와 같은 경우
                count++;
                s++;
                e--;
            }
            else if (sum < x) {  // 합이 x보다 작은 경우
                s++;
            }
            else {  // 합이 x보다 큰 경우
                e--;
            }
        }

        System.out.println(count);



//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (arr[i] + arr[j] > x) {
//                    break;
//                }
//                else if (arr[i] + arr[j] == x) {
//                    count++;
//                    break;
//                }
//            }
//        }
    }
}
