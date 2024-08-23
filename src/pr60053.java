class Solution {
    public Boolean checkCorrect(String s) { //올바른 문자열 확인
        int count = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return true;
    }

    public int cutString(String s) { //'('와 ')'개수가 같을 때(균형잡힌 문자열일 때) 인덱스 리턴
        int count = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count==0) {
                return i;
            }
        }
        return 0;
    }



    public String solution(String p) {
        StringBuilder answer;
        if (p.isEmpty()) return p;
        int index = cutString(p);
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);

        if (checkCorrect(u)) {
            answer = new StringBuilder(u + solution(v));
        } else {
            System.out.println(u);
            answer = new StringBuilder("(" + solution(v) + ")");
            for (int i = 1; i < u.length()-1; i++) {
                if (u.charAt(i) == '(') answer.append(')');
                else answer.append('(');
            }
        }
        return answer.toString();
    }
}

public class pr60053 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("(()())()");
    }
}
