package problem;

import java.util.HashMap;
import java.util.Map;

public class Programmers_258712 {

    // 선물 점수
    private static class Present {
        int sendCount;
        int receiveCount;

        public Present(int sendCount, int receiveCount) {
            this.sendCount = sendCount;
            this.receiveCount = receiveCount;
        }

        public void send() {
            this.sendCount++;
        }

        public void receive() {
            this.receiveCount++;
        }

        public int getPresentCount() {
            return this.sendCount - this.receiveCount;
        }
    }

    public static int solution(String[] friends, String[] gifts) {

        // <송신사, <수신자, 갯수>>
        Map<String, Map<String, Integer>> presentMap = new HashMap<>();

        // 선물 지수
        Map<String, Present> presentScoreMap = new HashMap<>();

        // 초기화
        for (String friend : friends) {
            presentMap.put(friend, new HashMap<>());
            presentScoreMap.put(friend, new Present(0, 0));
        }

        for (String gift : gifts) {
            String[] giftCommand = gift.split(" ");
            String sender = giftCommand[0];
            String receiver = giftCommand[1];

            Map<String, Integer> senderMap = presentMap.get(sender);
            senderMap.put(receiver, senderMap.getOrDefault(receiver, 0) + 1);

            presentScoreMap.get(sender).send();
            presentScoreMap.get(receiver).receive();
        }

        Map<String, Integer> presentCountMap = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String a = friends[i];
                String b = friends[j];

                // null 처리
                Integer aTob = presentMap.get(a).getOrDefault(b, 0);
                Integer bToa = presentMap.get(b).getOrDefault(a, 0);

                if (aTob.compareTo(bToa) > 0) {
                    presentCountMap.put(a, presentCountMap.getOrDefault(a, 0) + 1);
                } else if (aTob.compareTo(bToa) < 0) {
                    presentCountMap.put(b, presentCountMap.getOrDefault(b, 0) + 1);
                } else {
                    int presentCountA = presentScoreMap.get(a).getPresentCount();
                    int presentCountB = presentScoreMap.get(b).getPresentCount();
                    if (presentCountA > presentCountB) {
                        presentCountMap.put(a, presentCountMap.getOrDefault(a, 0) + 1);
                    } else if (presentCountB > presentCountA) {
                        presentCountMap.put(b, presentCountMap.getOrDefault(b, 0) + 1);
                    }
                }
            }
        }

        int max = -1;
        for (String friend : friends) {
            // null 처리
            max = Math.max(max, presentCountMap.getOrDefault(friend, 0));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[] {"muzi", "ryan", "frodo", "neo"},
                new String[] {
                        "muzi frodo", "muzi frodo",
                        "ryan muzi", "ryan muzi", "ryan muzi",
                        "frodo muzi", "frodo ryan",
                        "neo muzi"}));

        System.out.println(solution(
                new String[] {"joy", "brad", "alessandro", "conan", "david"},
                new String[] {
                        "alessandro brad", "alessandro joy", "alessandro conan",
                        "david alessandro", "alessandro david"}));

        System.out.println(solution(
                new String[]{"a", "b", "c"},
                new String[]{
                        "a b", "b a", "c a", "a c", "a c", "c a"}));
    }
}
