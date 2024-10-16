package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(bufferedReader.readLine());

        while (testcase > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] block = new int[n];
            int[] result = new int[n];
            int start = 0;
            int end = n-1;

            for (int i = 0; i < n; i++) {
                block[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Arrays.sort(block);

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    result[start] = block[i];
                    start++;
                } else {
                    result[end] = block[i];
                    end--;
                }
            }

            int min = Math.abs(result[0] - result[n-1]);

            for (int i = 1; i < n; i++) {
                min = Math.max(min, Math.abs(result[i] - result[i-1]));
            }

            System.out.println(min);

            testcase--;
        }
        bufferedReader.close();
    }
}