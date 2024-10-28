package org.example.swea;

import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1860 {
	// N명의 사람
	// 0초부터 붕어빵을 만들기 시작하며, M초의 시간을 들이면 K개의 붕어빵
	// 0초 이후에 손님들이 언제 도착하는지 주어지면, 모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별
	static String result;
	static int N,M,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc =1; tc <=T; tc++){

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int[] arrivals = new int[N];
			st = new StringTokenizer(br.readLine(), " ");

			// 손님 도착 시간 저장
			for (int i = 0; i < N; i++) {
				arrivals[i] = Integer.parseInt(st.nextToken());
			}

			// 도착 시간 정렬
			Arrays.sort(arrivals);

			String result = solve(arrivals);
			bw.write("#" + tc + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static String solve(int[] arrivals) {
		// 0초에 도착하는 손님이 있다면 불가능
		if (arrivals[0] == 0) return "Impossible";

		// 각 시점까지 만들 수 있는 붕어빵의 개수와 필요한 붕어빵 개수 비교
		for (int i = 0; i < N; i++) {
			// arrivals[i] 시점까지 만들 수 있는 붕어빵 개수
			int madeFishBread = (arrivals[i] / M) * K;
			// i+1번째 손님까지 필요한 붕어빵 개수
			int neededFishBread = i + 1;

			if (madeFishBread < neededFishBread) {
				return "Impossible";
			}
		}

		return "Possible";
	}
}
