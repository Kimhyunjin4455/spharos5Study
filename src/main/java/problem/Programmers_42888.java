package problem;

import java.util.*;

public class Programmers_42888 {

    public static String[] solution(String[] record) {

        // <uid, nickkname>
        // LinkedHashMap : 순서 유지 O, 중복 키 허용 X
        Map<String, String> uidToNickName = new LinkedHashMap<>();

        // 결과를 저장할 리스트
        List<String[]> logs = new ArrayList<>();

        for (String line : record) {
            // 명령 분리
            // Enter uid1234 Muzi, Leave uid1234, Change uid1234 Prodo
            String[] split = line.split(" ");
            String command = split[0];
            String uid = split[1];
            String nickname = split.length == 3 ? split[2] : "";

            // 명령에 따른 처리
            if (command.equals("Enter")) {
                if (uidToNickName.containsKey(uid)) {
                    // 이미 존재하는 uid라면 nickname을 변경
                    uidToNickName.replace(uid, nickname);
                } else {
                    // 새로운 uid라면 nickname을 추가
                    uidToNickName.put(uid, nickname);
                }
                logs.add(new String[]{uid, "님이 들어왔습니다."});
            } else if (command.equals("Leave")) {
                logs.add(new String[]{uid, "님이 나갔습니다."});
            } else if (command.equals("Change")) {
                // 이미 존재하는 uid라면 nickname을 변경
                uidToNickName.put(uid, nickname);
            }
        }

        // nickname + message
        String[] answer = new String[logs.size()];
        int i = 0;
        for (String[] log : logs) {
            answer[i++] = uidToNickName.get(log[0]) + log[1];
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] chatLogs = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        System.out.println(Arrays.toString(solution(chatLogs)));
    }
}