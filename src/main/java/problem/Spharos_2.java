package problem;

public class Spharos_2 {

    public static int solution(int k, int[] limits, int[][] sockets) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                300, new int[] {2000, 1000, 3000, 200, 600, 500}, new int[][]{
                        {2, 3, -1, -1, -1},
                        {4, 0, -1, -1, 6},
                        {5, 0, 0, 0, 0},
                        {-1, 0, 0, 0, 0},
                        {-1, -1, -1, -1, -1},
                        {-1, -1, 0, 0, 0},
                }
        ));

        System.out.println(solution(
                120, new int[] {1500, 300, 250, 359, 600}, new int[][]{
                        {2, 3, 4, 0, -1},
                        {0, 0, 0, 0, 0},
                        {-1, -1, -1, 0, 0},
                        {0, 0, 5, 0, 0},
                        {-1, 0, 0, -1, -1},
                }
        ));
    }
}
