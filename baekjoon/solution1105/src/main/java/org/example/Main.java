package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

        String l = st.nextToken();
        String r = st.nextToken();

        if (l.length() != r.length()) {
            System.out.println(0);
        } else {
            int count = 0;

            for (int i = 0; i < l.length(); i++) {
                if (l.charAt(i) == '8' && r.charAt(i) == '8') {
                    count++;
                } else if (l.charAt(i) == r.charAt(i)) {
                    continue;
                } else {
                    break;
                }
            }
            System.out.println(count);
        }
        bufferedReader.close();
    }
}