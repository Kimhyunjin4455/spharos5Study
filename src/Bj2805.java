import java.util.Scanner;

public class Bj2805 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //나무의 수
        int m = scanner.nextInt(); //나무의 길이

        int start = 0;
        int end = 0;

        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = scanner.nextInt();
            if (trees[i] > end) end = trees[i]; //나무의 최대 길이 찾기
        }


        int answer = 0;

        while (start <= end) {
            long result = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                if (mid < trees[i]) result += (trees[i]-mid); //절단기의 길이보다 나무의 길이가 더 길면 가져갈 나무길이 더하기
            }
            if (result >= m) { //적어도 m 미터의 나무 가져가야함
                answer = mid; //가능한 절단 높이 중 가장 큰 값 찾기
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}