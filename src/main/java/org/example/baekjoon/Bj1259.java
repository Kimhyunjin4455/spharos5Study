package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




		while(true){
			String str = br.readLine();

			String result ="yes";

			if (str.equals("0")){
				break;
			}
			for(int i=0; i<str.length()/2; i++){
				if(str.charAt(i) != str.charAt(str.length()-1-i)){
					result = "no";
					break;
				}
			}
			bw.write(String.valueOf(result));
			bw.newLine(); // 줄바꿈
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
