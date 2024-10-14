package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bj1138 {
	// N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다름
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] moreTallerArray = new int[N];
		int[] result = new int[N];
 		StringTokenizer st = new StringTokenizer(br.readLine());

		// 자기보다 큰 사람이 왼쪽에 몇 명 있는지 기록할 배열
		for (int i=0; i<N; i++){
			moreTallerArray[i] = Integer.parseInt(st.nextToken());
		}

		for(int  i=0; i<N; i++){
			int nowPosition = 0;

			while(moreTallerArray[i] > 0) {
				if(result[nowPosition]==0){
					moreTallerArray[i]--;
				}
				nowPosition++;
			}
			while(result[nowPosition] != 0){
				nowPosition++;
			}
			result[nowPosition] = i+1;
		}

		for (int res: result){
			bw.write(String.valueOf(res+" "));
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
