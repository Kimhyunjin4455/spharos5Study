package problem;

import java.util.Arrays;

public class Spharos_1 {

    public static int[] solution(int[][] arr) {

        int row = arr.length;
        int col = arr[0].length;
        int[] answer = new int[col];

        for (int i = 0; i < col; i++) {
            int curCol = i;
            int sum = 0;

            for (int j = 1; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (arr[j][k] == arr[0][i]) {
                        sum += Math.abs(k - curCol);
                        curCol = k;
                    }
                }
            }
            answer[arr[0][i]] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{
                {1, 3, 2, 0},
                {2, 0, 1, 3},
                {1, 2, 0, 3}})));
        System.out.println(Arrays.toString(solution(new int[][]{
                {1, 0, 2},
                {2, 0, 1},
                {1, 0, 2}})));
        System.out.println(Arrays.toString(solution(new int[][]{
                {0, 1, 2},
                {0, 1, 2}})));
    }
}