package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        // n개의 이름을 한 줄씩 읽어와서 Map에 저장
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, 0);
        }

        List<String> result = new ArrayList<>();

        // m개의 이름을 한 줄씩 읽어와서 Map에서 확인
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);

        // 결과 출력
        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}