package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        //텍스트(주로 문자열)를 버퍼링된 방식으로 읽는데 사용, IOException 필요
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> que = new PriorityQueue<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine().split("\\.")[1]; //.를 구분자로 사용

            if (map.containsKey(s)) {
                int tool = map.get(s);
                map.put(s, tool + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (String s : map.keySet()) {
            que.add(s);
        }

        for (int i = 0; i < map.size(); i++) {
            String s = que.poll();
            System.out.println(s + " " + map.get(s));
        }
    }
}