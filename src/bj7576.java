import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj7576 {
    public static int bfs(int[][] box, Queue<int[]> queue) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int x;
        int y;
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            answer = tomato[2];
            for (int i = 0; i < 4; i++) {
                x = tomato[0] + dx[i];
                y = tomato[1] + dy[i];
                if (x < 0 || x >= box.length || y < 0 || y >= box[0].length) {
                    continue;
                }
                if (box[x][y] == 0) { //익은 토마토의 상하좌우에 익지않은 토마토가 있는지 확인
                    box[x][y] = 1;
                    queue.offer(new int[] {x, y, tomato[2] + 1}); //익은 토마토에 영향을 받아 하루가 지난 후 익게 되기 때문에 하루를 더해 저장
                }
            }
        }

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0) { //창고에 토마토가 모두 익지 못하는 상황에는 -1 출력
                    return -1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M]; //토마토 보관 창고
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.offer(new int[]{i, j, 0}); //익은 토마토의 위치와 최소 일수를 담아 queue에 저장
                }
            }
        }

        int answer = bfs(box, queue);
        System.out.println(answer);
    }
}
