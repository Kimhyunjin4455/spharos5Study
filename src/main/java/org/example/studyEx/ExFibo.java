package org.example.studyEx;

public class ExFibo {
	public static void main(String[] args) {
		System.out.println(fibo(10));
	}

	public static int fibo(int i) {
		if (i <= 1) {
			return i;  // 0 또는 1일 때 i를 직접 반환
		}
		return i + fibo(i - 1);
	}
}
