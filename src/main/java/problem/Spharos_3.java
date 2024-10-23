package problem;

public class Spharos_3 {

    // n : 사람의 수, m : 목표 지점
    // k : 자동차의 탈 수 있는 사람의 수
    // s : 1초 동안 움직일 수 있는 자동차의 거리
    public static int solution(int n, int m, int k, int s) {
        int answer = 0;
        int curCarPos = 1;
        int curPeoplePos = 1;

        while (true) {
            int carTIme = (m - curCarPos) / s; // 자동차가 목표 지점까지 가는데 걸리는 시간
            answer += carTIme;
            System.out.println("carTIme: " + carTIme);
            System.out.println("answer: " + answer);
            System.out.println("--------------------");

            curCarPos = m;
            curPeoplePos += carTIme;

            if (n <= k) {
                break;
            }
            n -= (k - 1);

            while (curPeoplePos <= curCarPos) {
                curPeoplePos++;
                curCarPos -= s;
                answer++;
                System.out.println("  curPeoplePos: " + curPeoplePos);
                System.out.println("  curCarPos: " + curCarPos);
                System.out.println("  answer: " + answer);
                System.out.println("  --------------------");

                if(curPeoplePos == m) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 10, 3, 3));
        System.out.println(solution(10, 100, 5, 99));
        System.out.println(solution(100, 11, 4, 5));
        System.out.println(solution(3, 3, 2, 2));
    }
}
