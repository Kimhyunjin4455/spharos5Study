package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<Integer>();

        int count = 0;  // 덱의 연산 횟수

        int [] n_list = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++){
            n_list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++){
            deque.add(i);
        }

        for (int i = 0; i < m; i++){
            int target = n_list[i];
            int index = deque.indexOf(target);

            if (index <= deque.size() / 2) {  // 왼쪽으로 회전
                while (deque.peekFirst() != target) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            }
            else {  // 오른쪽으로 회전
                while (deque.peekFirst() != target) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();  // 목표 값을 제거
        }
        System.out.println(count);
    }
}

