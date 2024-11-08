package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj2443 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i=0; i<N; i++){
			for (int j=0; j<i; j++){
				System.out.print(" ");
			}
			for (int j=i; j<(2*N-1-i); j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
