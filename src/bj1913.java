import java.util.Scanner;

public class bj1913 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int target = scanner.nextInt();
        int[][] arr = new int[N][N];

        int num = N*N;
        int x = 0;
        int y = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int direction = 0;
        int t_x = 0;
        int t_y = 0;

        while (num > 0) {
            if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y]==0) {
                arr[x][y] = num;
                if (num == target) {
                    t_x = x+1;
                    t_y = y+1;
                }
                num--;
            } else {
                x -= dx[direction];
                y -= dy[direction];
                direction = (direction+1)%4;
            }
            x += dx[direction];
            y += dy[direction];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(t_x + " " + t_y);
    }
}