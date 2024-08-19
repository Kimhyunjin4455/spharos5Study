package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 입력을 받기 위한 BufferedReader 객체 생성
        StringTokenizer st = new StringTokenizer(br.readLine());  // 입력을 받아 StringTokenizer 객체 생성

        int n = Integer.parseInt(st.nextToken());  // 큐의 크기, StringTokenizer 객체를 통해 입력을 받아 정수형으로 변환
        int m = Integer.parseInt(st.nextToken());  // 뽑아내려고 하는 수의 개수, StringTokenizer 객체를 통해 입력을 받아 정수형으로 변환

        LinkedList<Integer> deque = new LinkedList<Integer>();  // 덱 객체 생성, 덱은 큐의 양쪽 끝에서 삽입과 삭제가 가능한 자료구조

        int count = 0;  // 회전 횟수를 저장할 변수

        int [] n_list = new int[m];  // 뽑아내려고 하는 수를 저장할 배열

        st = new StringTokenizer(br.readLine());  // 뽑아내려고 하는 수를 입력 받기 위해 StringTokenizer 객체 생성

        for (int i = 0; i < m; i++){  // 뽑아내려고 하는 수를 입력 받아 정수형으로 변환하여 배열에 저장
            n_list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++){  // 큐에 1부터 n까지의 수를 저장
            deque.add(i);
        }

        for (int i = 0; i < m; i++){  // 뽑아내려고 하는 수의 개수만큼 반복
            int target = n_list[i];  // 뽑아내려고 하는 수를 target 변수에 저장
            int index = deque.indexOf(target);  // 뽑아내려고 하는 수의 인덱스를 index 변수에 저장

            if (index <= deque.size() / 2) {  // 왼쪽으로 회전, 덱 크기의 절반보다 작거나 같을 때 왼쪽으로 회전(그 이상은 오른쪽으로 회전 하는 것이 더 시도횟수 적음)
                while (deque.peekFirst() != target) {  // 덱의 맨 앞에 있는 수가 목표 값이 될 때까지 반복, peekFirst()는 맨 앞에 있는 값을 반환
                    deque.addLast(deque.pollFirst());  // 맨 앞에 있는 값을 빼서 맨 뒤에 추가, pollFirst()는 맨 앞에 있는 값을 반환하고 제거
                    count++;
                }
            }
            else {  // 오른쪽으로 회전
                while (deque.peekFirst() != target) {  // 덱의 맨 앞에 있는 수가 목표 값이 될 때까지 반복
                    deque.addFirst(deque.pollLast());  // 맨 뒤에 있는 값을 빼서 맨 앞에 추가
                    count++;
                }
            }
            deque.pollFirst();  // 목표 값을 제거
        }
        System.out.println(count);
        br.close();
    }
}

