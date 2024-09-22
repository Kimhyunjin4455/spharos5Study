package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        int[] time = new int[100001];

        q.offer(n);
        time[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                System.out.println(time[now] - 1);
                break;
            }

            if (now - 1 >= 0 && time[now - 1] == 0) {
                q.offer(now - 1);
                time[now - 1] = time[now] + 1;
            }

            if (now + 1 <= 100000 && time[now + 1] == 0) {
                q.offer(now + 1);
                time[now + 1] = time[now] + 1;
            }

            if (now * 2 <= 100000 && time[now * 2] == 0) {
                q.offer(now * 2);
                time[now * 2] = time[now] + 1;
            }
        }

        br.close();
    }
}
