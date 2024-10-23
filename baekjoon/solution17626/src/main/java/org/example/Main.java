package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++) {

            arr[i] = arr[i - 1];

            for(int j = 1; j * j <= i; j++) {

                arr[i] = Math.min(arr[i], arr[i - (j * j)]);
            }

            arr[i]++;
        }
        System.out.println(arr[n]);
        bufferedReader.close();
    }
}