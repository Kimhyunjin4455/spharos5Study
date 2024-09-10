package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
//        int [][] candy = new int[n][m];
//        int [][] Verstappen = new int[n][m]; //ArrayIndexOutOfBoundsException
        int [][] candy = new int[n+1][m+1];
        int [][] Verstappen = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= m; j++) {
                candy[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    Verstappen[1][1] = candy[1][1];
                }
                else {
                    Verstappen[i][j] = Math.max(Verstappen[i - 1][j], Math.max(Verstappen[i][j - 1], Verstappen[i - 1][j - 1])) + candy[i][j];
                }
            }
        }
//        System.out.println(Verstappen[n-1][m-1]);
        System.out.println(Verstappen[n][m]);
        bufferedReader.close();
    }
}