package org.example.programmers;

import java.util.*;

public class PgBestAlbum {

    // 장르에 속한 곡이 하나라면, 하나의 곡만 선택.
    // 모든 장르는 재생된 횟수가 다름
    // 컬렉션 정렬 필요
    // 스트림
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> rankMap = new HashMap<>(); // 장르별 총 재생횟수 저장하기 위함
        HashMap<String, HashMap<Integer, Integer>> genreInfoMap = new HashMap<>(); // 장르별 노래의 원래 인덱스 정보(idx), 재생횟수(playTimes)

        for (int i=0; i< genres.length; i++){
            if (!rankMap.containsKey(genres[i])){
                HashMap<Integer, Integer> singInfoMap = new HashMap<>();
                singInfoMap.put(i, plays[i]); // 노래 정보에는 노래의 인덱스 정보와 재생횟수 저장
                genreInfoMap.put(genres[i], singInfoMap);
                rankMap.put(genres[i], plays[i]);
            }else {
                genreInfoMap.get(genres[i]).put(i, plays[i]); // 위에서 선언했던 해시맵 변수를 사용불가능 함 -> genreInfoMap 통해 값 이용
                rankMap.put(genres[i], rankMap.get(genres[i])+plays[i]); // 같은 장르에 대해 계속 값 업데이트 (총 횟수 저장)
            }
        }

        List<String> keySet = new ArrayList<>(rankMap.keySet()); // 장르별 총 횟수 정렬을 위한 밑준비 (장르를 따로 저장)
        Collections.sort(keySet, (s1, s2) -> rankMap.get(s2) - rankMap.get(s1)); // 내림차순 정렬 공식, 키에 해당하는 value에 대해 진행, 총 재생횟수 기준 내림차순 정렬

        /** Collections.sort() 에서 람다를 이용한 정렬
          Collections.sort(list, (o1, o2) -> {
              // 비교 로직
              // ex: Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());
          });
         Collections.sort(numbers, (a, b) -> a - b); // 오름차순 정렬
         Collections.sort(numbers, (a, b) -> b - a); // 내림차순 정렬

         람다 표현식 내에서 두 객체의 비교 결과
         음수: o1이 o2보다 작음 -> 오름차순
         0: 두 객체가 같음
         양수: o1이 o2보다 큼 -> 내림차순

          */


        for(String key: keySet){
            HashMap<Integer, Integer> singInfoMap = genreInfoMap.get(key); // 위의 singInfoMap 과는 다름, 각 곡들에 대하여 할 예정
            ArrayList<Integer> genreKey = new ArrayList<>(singInfoMap.keySet());

            Collections.sort(genreKey, (s1, s2) -> singInfoMap.get(s2) - singInfoMap.get(s1)); // 각 곡의 횟수에 대해 내림차순 정렬

            answer.add(genreKey.get(0));
            if (genreKey.size()>1){ // 이 경우는 곡이 2개 이상일 경우
                answer.add(genreKey.get(1));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
        /** 스트림에 대해 ->
         answer는 일반적으로 List<Integer>와 같은 컬렉션
         stream() 메서드는 해당 컬렉션에서 스트림을 생성 / 스트림은 데이터의 연속적인 흐름 / 다양한 연산을 수행가능
         mapToInt(i -> i) : 스트림의 각 요소를 int형으로 변환 / i -> i는 람다 표현식으로, 각 요소를 그대로 반환 / Integer 객체를 int 기본형으로 변환 / 결과적으로 IntStream이 생성
         toArray() : 스트림의 요소를 배열로 변환 / IntStream의 요소를 int[] 배열로 변환

         IntStream: Java의 스트림 API에서 제공하는 특수한 스트림의 한 유형 / 기본형인 int 값의 스트림을 처리하는데 사용 / Stream<Integer>와는 달리, 박싱된 객체가 아닌 기본형 int 값을 직접 처리할 수 있도록 최적화된 기능을 제공
         int 값만을 포함하며, 객체로 박싱(Wrapper) 되지 않기 때문에 메모리 사용이 더 효율적
         IntStream evenStream = IntStream.range(1, 11).filter(i -> i % 2 == 0);
         evenStream.forEach(i -> System.out.print(i + " ")); // 출력: 2 4 6 8 10

         */
    }

    public static void main(String[] args) {
        PgBestAlbum sol = new PgBestAlbum();
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(sol.solution(genres, plays)));
        // 배열을 직접 출력하면 배열의 주소가 출력
        // 배열의 내용을 출력하려면 Arrays.toString()을 사용
    }
}
