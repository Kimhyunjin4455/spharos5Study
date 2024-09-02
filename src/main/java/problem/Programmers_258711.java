package problem;

import java.util.*;

public class Programmers_258711 {

    public static int[] solution(int[][] edges) {
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        int[] answer = new int[4];

        // 각 정점의 fan-out, fan-in을 계산한다
        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }

        for (int node : out.keySet()) {
            if (out.get(node) > 1) {
                // fan-out이 2이상인 경우, fan-in이 0이라면 해당 정점이 추가된 정점이다
                if (!in.containsKey(node)) {
                    answer[0] = node;
                }
                // 그 외의 경우는 8자 그래프이다
                else {
                    answer[3] += 1;
                }
            }
        }

        for (int node : in.keySet()) {
            // 막대 그래프의 마지막 정점은 fan-out이 0인 정점이다
            if (!out.containsKey(node)) {
                answer[2] += 1;
            }
        }

        // 도넛 그래프는 그외의 경우이다
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{
                {2, 3}, {4, 3}, {1, 1}, {2, 1}
        })));
        System.out.println(Arrays.toString(solution(new int[][]{
                {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6},
                {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
        })));
    }
}