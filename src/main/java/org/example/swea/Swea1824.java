package org.example.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.annotation.processing.SupportedSourceVersion;

public class Swea1824 {

	static String[][] graph;
	static int R,C;
	static int[] dr ={-1,0,1,0};
	static int[] dc ={0,1,0,-1};
	/** [row][col][direction][memory] */
	static boolean[][][][] visited;

	public static void main(String[] args) throws IOException {
		// 프로그램이 수행해야 하는 명령은 문자로 주어지며, 문자들은 2차원 격자 모양으로 줄지어 있음
		// 프로그램은 현재 위치에 있는 문자가 나타내는 명령을 처리하고, 이동 방향에 따라 다음 문자로 이동
		// 가장 처음 위치는 제일 왼쪽 위에 있는 문자이고, 이동 방향은 오른쪽
		// 명령을 처리하다 보면 이동 방향이 상하좌우로 바뀔 수 있음
		// 다음 이동이 2차원 격자의 바깥으로 이동하는 방향이면, 반대편에 있는 위치로 이동(첫 번째 줄의 가장 오른쪽 칸에서 오른쪽 방향으로 이동하면 첫 번째 줄의 가장 왼쪽 칸으로 이동)
		// 메모리가 단 하나 있으며, 0에서 15사이의 정수를 하나 저장할 수 있다. 가장 처음에는 0이 저장
		// <	이동 방향을 왼쪽으로 바꾼다.
		// >	이동 방향을 오른쪽으로 바꾼다.
		// ^	이동 방향을 위쪽으로 바꾼다.
		// v	이동 방향을 아래쪽으로 바꾼다.
		// _	메모리에 0이 저장되어 있으면 이동 방향을 오른쪽으로 바꾸고, 아니면 왼쪽으로 바꾼다.
		// |	메모리에 0이 저장되어 있으면 이동 방향을 아래쪽으로 바꾸고, 아니면 위쪽으로 바꾼다.
		// ?	이동 방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네 방향 동일하다.
		// .	아무 것도 하지 않는다.
		// @	프로그램의 실행을 정지한다.
		// 0~9	메모리에 문자가 나타내는 값을 저장한다.
		// +	메모리에 저장된 값에 1을 더한다. 만약 더하기 전 값이 15이라면 0으로 바꾼다.
		// -	메모리에 저장된 값에 1을 뺀다. 만약 빼기 전 값이 0이라면 15로 바꾼다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc=1; tc<T+1; tc++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			graph = new String[R][C];
			visited = new boolean[R][C][4][16]; // 4방향, 0~15 메모


			for (int i=0; i<R; i++){
				String line = br.readLine();
				for (int j=0; j<C; j++){
					graph[i][j] = String.valueOf(line.charAt(j));
				}
			}

			boolean res = hyukLang();

			bw.write("#"+tc+" "+(res? "YES":"NO")+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean hyukLang() {
		boolean hasEndCommend = false;
		for (int i=0; i<R; i++){
			for (int j=0; j<C; j++){
				if (graph[i][j].equals("@")){
					hasEndCommend = true; // 마지막 문자를 판단하는 것이지 결과에 대한 boolean 값은 아님
					break;
				}
			}
		}

		// 위 반복문을 통해 '@'가 그래프 내에 존재하지 않는다면 무조건 false
		if (!hasEndCommend){
			return false;
		}

		return dfs(0,0,1,0);

	}

	private static boolean dfs(int row, int col, int dir, int memory) {
		//  이미 방문한 상태라면
		if (visited[row][col][dir][memory]){ // memory는 당연히 달라야 되는거 아닌가..?
			return false;
		}

		visited[row][col][dir][memory] = true;
		String current = graph[row][col];

		if (current.equals("@")){
			return true;
		}

		if (current.equals("^")) dir=0; // 상
		else if (current.equals(">")) dir=1; // 우
		else if (current.equals("v")) dir=2; // 하
		else if (current.equals("<")) dir=3; // 좌
		else if (current.equals("_")) dir = (memory==0)? 1:3; // 좌, 우
		else if (current.equals("|")) dir = (memory==0)? 2:0; // 하, 상
		else if (current.equals("+")) memory = (memory == 15)? 0: memory+1;
		else if (current.equals("-")) memory = (memory == 0)? 15: memory-1;
		else if (Character.isDigit(current.charAt(0))) memory = current.charAt(0) - '0';

		if (current.equals("?")) {
			for (int i = 0; i < 4; i++) {
				int nextRow = getNextRow(row, i);
				int nextCol = getNextCol(col, i);
				if (dfs(nextRow, nextCol, i, memory)) {
					return true;
				}
			}
			return false;
		}

		// 일반적인 이동
		int nextRow = getNextRow(row, dir);
		int nextCol = getNextCol(col, dir);
		return dfs(nextRow, nextCol, dir, memory);
	}

	private static int getNextRow(int row, int dir) {
		int next = row + dr[dir];
		if (next < 0) return R - 1;
		if (next >= R) return 0;
		return next;
	}

	private static int getNextCol(int col, int dir) {
		int next = col + dc[dir];
		if (next < 0) return C - 1;
		if (next >= C) return 0;
		return next;
	}


}
