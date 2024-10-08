package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int resultZero = 0;
		int resultOne = 0;

		char now = str.charAt(0);
		if (now =='0'){
			resultZero++;
		}else {
			resultOne++;
		}

		for (int i=1; i<str.length(); i++){
			if (str.charAt(i) != now){
				if (str.charAt(i) == '0'){
					resultZero++;
				}else{
					resultOne++;
				}
				now = str.charAt(i);
			}
		}

		int result = Math.min(resultOne, resultZero);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
