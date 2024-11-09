package org.example.programmers;

import java.util.*;
import java.io.*;

public class Pg42584 {
	public static void main(String[] args) {
		int[] prices = new int[]{1,2,3,2,3};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(prices)));
	}
	static class Solution {
		public int[] solution(int[] prices) {
			int[] answer = new int[prices.length];
			Stack<Integer> stack = new Stack<>();


			for (int i=0; i<prices.length; i++){
				// 가격이 떨어지기 시작하는 시점을 찾기 위해 스택을 사용
				// 요소가 stack에 들어가있고, 스택에 마지막으로 저장된 값보다 현재번째 인덱스의 요소값이 더 크면 push
				while(!stack.isEmpty() && prices[stack.peek()] > prices [i]){
					int index = stack.pop();
					answer[index] = i-index;
				}
				stack.push(i);
			}

			while (!stack.isEmpty()){
				int index = stack.pop();
				answer[index] = prices.length - index -1;
			}

			return answer;
		}
	}
}
