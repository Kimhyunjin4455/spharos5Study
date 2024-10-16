package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[n];
        int[] best = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        best[0] = arr[0];
        max = best[0];

        for (int i = 1; i < n; i++) {
            best[i] = Math.max(best[i-1] + arr[i], arr[i]);
            max = Math.max(max, best[i]);
        }
        System.out.println(max);
        bufferedReader.close();
    }
}