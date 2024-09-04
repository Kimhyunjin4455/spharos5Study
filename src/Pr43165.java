
public class Pr43165 {
    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        int answer = 0;
        public void dfs(int[] numbers, int target, int number, int index) {
            if (index == numbers.length) {
                if (number == target) {
                    answer++;
                }
                return;
            } else {
                dfs(numbers, target, number + numbers[index], index+1);
                dfs(numbers, target, number - numbers[index], index+1);
            }
        }
        public int solution(int[] numbers, int target) {
            dfs(numbers, target, 0, 0);
            return answer;
        }
    }
}


