package org.example.programmers;

import java.util.*;
import java.io.*;

public class Pg12909 {
	public static void main(String[] args) {

		String s1 = "()()";
		String s2 = "(())()";
		String s3 = ")()(";
		String s4 = "(()(";

		Solution sol = new Solution();

		System.out.println(sol.solution(s1)); // true
		System.out.println(sol.solution(s2)); // true
		System.out.println(sol.solution(s3)); // false
		System.out.println(sol.solution(s4)); // false
	}
	static class Solution{
		boolean solution(String s) {
			boolean answer = true;

			Stack<Character> stack = new Stack<>();

			for (char c : s.toCharArray()){
				if (c == '('){
					stack.push(c);
				}else if (c==')'){ // 닫힌 괄호 추가시에 스택에 남아있으면 빼고 없으면 return
					if (stack.isEmpty()){
						return false;
					}
					stack.pop();
				}
			}

			return stack.isEmpty(); // 남아있는 경우는 false 처리 필요
		}
	}
}
