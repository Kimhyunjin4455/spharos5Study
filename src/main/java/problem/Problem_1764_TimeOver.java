package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1764_TimeOver {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();

        // n개의 이름을 한 줄씩 읽어와서 list에 저장
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            list.add(name);
        }

        List<String> result = new ArrayList<>();

        // m개의 이름을 한 줄씩 읽어와서 list에서 확인
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (list.contains(name)) {
                result.add(name);
            }
        }

        // 정렬
        Collections.sort(result);

        // 결과 출력
        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}