package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] price = new long[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                price[n - j - 1] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            long max = price[0];

            for (int j = 1; j < n; j++) {
                if (price[j] > max) {
                    max = price[j];
                } else {
                    result += max - price[j];
                }
            }

            System.out.println("#" + i + " " + result);
        }
    }
}

/*
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
*/