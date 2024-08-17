package org.example.programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class PgClothing {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();  // Key를 의상의 종류로

        for (int i=0; i<clothes.length; i++){
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1],0)+1);
            // 해쉬맵 이용시 계속해서 값을 업로드해야 되는 경우는 getOrDefault를 통해 값을 가져와 연산하는 것이 편리
            // 0으로 디폴트 값을 설정해야 계속해서 +1 을 적용가능
        }

        for (int value: clothesMap.values()){
            answer *= (value+1);
        }
        return answer-1;
    }

    public static void main(String[] args) {
        PgClothing sol = new PgClothing();
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(sol.solution(clothes));
        System.out.println(sol.solution(clothes2));
    }
}


