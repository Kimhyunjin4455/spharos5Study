package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj2075 {
	// 모든 수는 자신의 한 칸 위에 있는 수보다 크다는 것
	// N번째 큰 수를 찾기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		//
		// //graph = new int[N][N];
		// PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		//
		//
		// for (int i=0; i<N; i++){
		// 	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 	for (int j=0; j<N; j++){
		// 		pq.add(Integer.parseInt(st.nextToken()));
		// 	}
		// }
		//
		// for (int i=0; i<N-1; i++){
		// 	pq.poll();
		// }
		//
		// bw.write(String.valueOf(pq.poll()));

		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				numbers.add(Integer.parseInt(st.nextToken())); // 모든 수를 리스트에 추가
			}
		}

		// 리스트 정렬
		Collections.sort(numbers);

		bw.write(String.valueOf(numbers.get(numbers.size() - N)));
		bw.flush();
		bw.close();
		br.close();


	}
}
