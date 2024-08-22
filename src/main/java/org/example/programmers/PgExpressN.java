package org.example.programmers;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class PgExpressN {

    public int solution(int N, int number) {
        int answer = -1; // 기존 제시 값 0 -> 문제의 8보다 크면 -1 을 반환한다는 조건 위해 풀이 중 수정
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>(); // 각 dp 의 정보를 이용하기 위해 내부타입을 HashSet으로

        for (int i=0; i<=8; i++){ // 문제에서 제한된 조건으로 인해 8개까지의 수가 사용된 경우만 알면 됨
            list.add(new HashSet<Integer>()); //각 갯수의 수를 사용해서 만들수았는 값을 저장할 해시셋 추가(중복된 계산 결과는 필요없기에 set 사용)
        }
        list.get(1).add(N); // 1개 쓸때 자기자신 초기화(ex: N이 5일때 1개만 사용하면 5라는 결과만 나올수 있음)
        if(number == N) return 1; // 찾고자 하는 수가 N과 같다면 N을 1회 사용한 것만으로 바로 정답

        for (int i=2; i<=8; i++){ // 1개 사용할 경우의 HashSet을 위에서 처리했기에 2부터 시작
            HashSet<Integer> total = list.get(i); // 숫자 i개 썼을 때 숫자들이 들어갈 셋
            // 이전 셋들 통해 값 구하기 (이전셋들의 값을 통해 사칙연산하고 N을 i번 이어붙일 때)
            for (int j=1; j<i; j++){
                HashSet<Integer> a = list.get(j); //
                HashSet<Integer> b = list.get(i - j); //

                for (int x:a){
                    for(int y:b){
                        total.add(x+y);
                        total.add(x-y);
                        total.add(x*y);
                        if (x != 0 && y != 0) total.add(x/y); // 나누기 0 방지 위함
                    }
                }
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }

            if (total.contains(number)) return i; // i번째 계산때 원하는 값이 나왔으므로 i가 문제에서 제시하는 최솟값
        }

        return answer;



    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        int number = Integer.parseInt(br.readLine());

        PgExpressN sol = new PgExpressN();
        System.out.println(sol.solution(5,12));
        System.out.println(sol.solution(2,11))  ;



    }
}
