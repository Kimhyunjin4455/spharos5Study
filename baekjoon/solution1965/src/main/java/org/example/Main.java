package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] sizes = new int[n];
        int[] BoxBox = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            sizes[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i = 0; i < n; i++) {
            BoxBox[i] = 1;
            for(int j = 0; j < i; j++) {
                if(sizes[j] < sizes[i]) {
                    BoxBox[i] = Math.max(BoxBox[j] + 1, BoxBox[i]);
                }
            }
            max = Math.max(BoxBox[i], max);
        }
        System.out.println(max);
        bufferedReader.close();
    }
}