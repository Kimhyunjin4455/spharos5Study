package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] howMany = new int[n+1];
        int[] answer = new int[n+1];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= n; i++) {
            howMany[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 1; i<= n; i ++) {
            int j = 1;

            while (true) {
                if (howMany[i] == 0 && answer[j] == 0) { //왼쪽 인원 수도 맞고, 자기가 들어갈 수 있는 자리
                    answer[j] = i;
                    break;
                } else if (answer[j] == 0) { //왼쪽 인원 수도 안맞고 자기 자리도 안맞고
                    howMany[i]--;
                }
                j++; //자기 자리 찾아서 오른쪽 힌칸 이동
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }

        bufferedReader.close();
    }
}