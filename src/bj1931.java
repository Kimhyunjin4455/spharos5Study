import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj1931 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Times> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Times times = new Times(start, end);
            list.add(times);
        }
        Collections.sort(list);

        int answer = 0;
        int start = 0;
        int end = 0;
        for (Times times : list) {
            if (times.start >= end) {
                answer++;
                start = times.start;
                end = times.end;
            }
        }
        System.out.println(answer);
    }
}

class Times implements Comparable<Times> {
    int start;
    int end;

    public Times(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Times o){
        if (this.end == o.end) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }
    }
}