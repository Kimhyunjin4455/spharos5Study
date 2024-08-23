package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int b = scanner.nextInt();

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;

        int[][] blocks = new int[n][m]; //i, j의 높이 저장

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                blocks[i][j] = scanner.nextInt();
            }
        }

        //모든 경우의 수 계산(0~256)
        for (int h = 0; h <= 256; h++) {
            int plus_time = 0;
            int minus_time = 0;
            int time = 0; // 평탄화에 걸리는 시간 계산
            int total = b; //가지고 있는 블록의 갯수

            //평탄화 작업 진행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (blocks[i][j] > h) {
                        plus_time = 2 * (blocks[i][j] - h);
                        total += blocks[i][j] - h;
                        time += plus_time;
                    } else if (blocks[i][j] < h) {
                        minus_time = h - blocks[i][j];
                        total -= h - blocks[i][j];
                        time += minus_time;
                    }
                }
            }

            //블록이 충분한지 확인
            if (total >= 0) {
                if (time <= minTime) {
                    minTime = time;
                    if (h >= maxHeight) {
                        maxHeight = h;
                    }
                }
            }
        }

        System.out.println(minTime + " " + maxHeight);

        scanner.close();
    }
}