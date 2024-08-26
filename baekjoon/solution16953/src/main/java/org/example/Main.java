package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());


        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int count = 0;

        while (true) {
            if (a > b) {
                System.out.println("-1");
                break;
            }

            if (a == b) {
                count++;
                System.out.println(count);
                break;
            }

            if (b % 10 == 1) { // b의 마지막 자리가 1인 경우
                b--; // 마지막 자리의 1을 제거
                b /= 10;
                count++;
            } else if (b % 2 == 0) { // b가 짝수인 경우
                b /= 2;
                count++;
            } else { // 더 이상 조건을 만족하지 않는 경우
                System.out.println("-1");
                break;
            }
        }
        bufferedReader.close();
    }
}