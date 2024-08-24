package org.example.programmers;

import java.util.Arrays;

public class PgInyTriangle {
    // 아래의 방향으로 오른쪽 왼쪽이 필요
    // 2계층의 경우 1계층의 값은 1개
    // 3계층부터
    // idx0은 이전계층의 idx0의 max값을 더한 것
    // idx1은 이전계층의 idx(1-1)과 idx(1)을 더한값중 큰 값
    // idxFinal은 이전계층의 idxFinal을 더한 값
    // 이 계산 결과들을 저장하고
    // 다음 계층에서 이 값들을 이용해서 계산하면 마지막 계층에서 정답이 나옴

    static int nowMaxValue;

    public int solution(int[][] triangle) {
        int answer = 0;


        for (int i=1; i< triangle.length; i++){
            for (int j=0; j<triangle[i].length; j++){
                if(i==1){
                    triangle[i][j] = triangle[i][j] + triangle[0][0];
                }
                else {
                    if (j==0){
                        triangle[i][j] = triangle[i][j] + triangle[i-1][0];
                    }else if (j == triangle[i].length-1){
                        triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                    }else {
                        triangle[i][j] = Math.max(triangle[i][j] + triangle[i-1][j-1], triangle[i][j] + triangle[i-1][j]);
                    }
                }
                // 원래는 각 계층마다 최댓값을 구하고 이전 계층과의 최댓값을 비교하여 나아감 -> 시간초과
                // 어차피 마지막 계층에서는 각 숫자를 통해 계산되는 최댓값이 저장될것이기에 의미없는 추가 연산
            }
            // 마지막 계층에서의
            answer = Arrays.stream(triangle[triangle.length-1]).max().orElseThrow();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] inputArr = new int[][]{{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};
        PgInyTriangle sol = new PgInyTriangle();
        System.out.println(sol.solution(inputArr));
//        for(int[] iarr:inputArr){ // 입력값 잘 받았는지 test
//            for (int i: iarr){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }

    }
}
