package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;
        int minBlockHeight = Integer.MAX_VALUE;
        int maxBlockHeight = Integer.MIN_VALUE;

        int[][] blocks = new int[n][m]; //i, j의 높이 저장

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                blocks[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (blocks[i][j] < minBlockHeight) {
                    minBlockHeight = blocks[i][j];
                }
                if (blocks[i][j] > maxBlockHeight) {
                    maxBlockHeight = blocks[i][j];
                }
            }
        }

        //모든 경우의 수 계산(0~256)
        for (int h = minBlockHeight; h <= maxBlockHeight; h++) {
            int plus_time = 0;
            int minus_time = 0;
            int time = 0; // 평탄화에 걸리는 시간 계산
            int total = b; //가지고 있는 블록의 갯수

            //평탄화 작업 진행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int diff = blocks[i][j] - h;

                    if (diff > 0) { // 블록을 제거하는 경우
                        plus_time += 2 * diff;
                        total += diff;
                    } else if (diff < 0) { // 블록을 쌓는 경우
                        minus_time -= diff;
                        total += diff;
                    }
                }
            }

            //블록이 충분한지 확인
            if (total >= 0) {
                time = plus_time + minus_time;
                if (time <= minTime) {
                    minTime = time;
                    maxHeight = h;
                }
            }
        }

        System.out.println(minTime + " " + maxHeight);

        bufferedReader.close();
    }
}