package org.example.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PgReportResult {

    // 각 유저는 한 번에 한 명의 유저를 신고
    // 신고 횟수에 제한은 없음
    // 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리
    // k번 이상 신고된 유저는 게시판 이용이 정지
    // 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
    // 유저가 신고한 모든 내용을 취합 -> 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송
    public static void main(String[] args) {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;  // 2번 이상 신고당하면 정지
        // 해당 유저가 신고해서 정지된 유저의 수

        int[] result = solution(id_list, report, k);
        for (int r: result) {
            System.out.print(r+" ");
        }
        System.out.println();

    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        /** 중복제거 */
        HashSet<String> reportSet = new HashSet<>();
        for(String s: report)reportSet.add(s);

        /** 신고 통지 위한 Map*/
        HashMap<String, ArrayList<String>> notifyUserMap = new HashMap<>();
        for (String s: reportSet){
            int blankIdx = s.indexOf(" ");  //
            String reportingUser =s.substring(0,blankIdx);
            String reportedUser =s.substring(blankIdx+1);

            ArrayList<String> reportingUserList = notifyUserMap.getOrDefault(reportedUser, null);
            // 신고당한 유저가 있다면 그 값을 가져옴, 디폴트 값을 가져오는 것은 신고당한 적인 없다는 뜻
            if (reportingUserList == null) reportingUserList = new ArrayList<>();

            reportingUserList.add(reportingUser);
            notifyUserMap.put(reportedUser, reportingUserList); // key는 신고당한 사람,  value는 통지해야 될 사람

        }
        //System.out.println(notifyUserMap);

        /** 통지 받을 메일의 수를 위한 Map */
        HashMap<String, Integer> reportingUserMailCntMap = new HashMap<>();
        for(ArrayList<String> notifyUserList: notifyUserMap.values()){
            if(notifyUserList.size() >= k){
                for(String notifyUser: notifyUserList){
                    reportingUserMailCntMap.put(notifyUser, reportingUserMailCntMap.getOrDefault(notifyUser, 0)+1);
                }
            }
        }

        for (int i=0; i<id_list.length; i++) {
            answer[i] = reportingUserMailCntMap.getOrDefault(id_list[i], 0);

        }


        return answer;
    }

}
