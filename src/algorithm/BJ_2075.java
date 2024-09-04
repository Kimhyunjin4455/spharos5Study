package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(n); // 최소 힙, 크기가 n인 우선순위 큐

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (pq.size() < n) { // 최소 힙의 크기가 n보다 작을 경우 그냥 삽입
                    pq.offer(num);
                }
                else if (pq.peek() < num) { // 최소 힙의 루트(최소 값)보다 큰 경우, peek()은 우선순위가 가장 높은 값(최소 값)
                    pq.poll(); // 최소 힙의 루트 제거
                    pq.offer(num); // num 삽입
                }
            }
        }
        System.out.println(pq.peek()); // 최소 힙의 루트가 n번째 큰 수
    }
}
