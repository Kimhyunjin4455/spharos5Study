package org.example;

import java.util.ArrayList;
import java.util.Collection;
/**
 * Collection 인터페이스를 임포트
 * List, Set, Queue와 같은 컬렉션을 위한 공통 메서드들을 정의
 */
import java.util.Collections;
/**
 * Collections 클래스를 임포트
 * 컬렉션에 대해 다양한 유틸리티 메서드를 제공하는 클래스
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        double max;
        double sum = 0.0;

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int score = scanner.nextInt();
            list.add((double)score);
        }

        max = Collections.max(list);

        for (int i = 0; i < n; i++) {
            sum += list.get(i) / max * 100;
        }

        double avg = sum / n;
        System.out.println(avg);
        scanner.close();
    }
}