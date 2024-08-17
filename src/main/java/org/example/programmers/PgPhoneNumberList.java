package org.example.programmers;

import java.util.Arrays;

public class PgPhoneNumberList {

        // 배열 자체는 phone_book에 입력되어 있음, 이 배열을 이용하여 로직 작성
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Arrays.sort(phone_book); // 전화번호 목록이 정렬됨, 이 경우 인접한 두개만 비교해도 됨
            // 119, 11828383, 119432141413 정렬 시, 11828383, 119, 119432141413

            for(int i = 0; i < phone_book.length-1; i++){
                if(phone_book[i+1].startsWith(phone_book[i])){
                    answer = false;
                    return answer;
                }
            }

            return answer;
        }



    public static void main(String[] args) {
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
        String[] phone_book2 = new String[]{"123","456","789"};
        String[] phone_book3 = new String[]{"11828383", "119", "119432141413"};

        PgPhoneNumberList sol = new PgPhoneNumberList();
        System.out.println(sol.solution(phone_book));
        System.out.println(sol.solution(phone_book2));
        System.out.println(sol.solution(phone_book3));

    }
}
