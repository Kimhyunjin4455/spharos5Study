import java.util.Arrays;
import java.util.Scanner;

public class BJ2110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int c = scanner.nextInt();

        int[] house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = scanner.nextInt();
        }

        Arrays.sort(house);

        int start = 1; //가능한 최소 거리
        int end = house[n-1] - house[0]; //가능한 최대 거리
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2; //공유기 설치 거리
            int value = house[0]; //공유기 설치한 집의 위치
            int count = 1; //공유기의 개수
            for (int i = 1; i < n; i++) {
                if ((house[i] - value) >= mid) { // 공유기가 설치된 집과 설치할 집이 설치거리 이상 떨어져있다면
                    count++; //공유기의 개수 + 1
                    value = house[i]; //그 집에 공유기 설치
                }
            }
            if (count >= c) { //설치 가능한 공유기 개수가 c개 이상이라면 최대거리 찾기
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}