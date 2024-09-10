package problem;

public class Programmers_250137 {

    public int solution(int[] bandage, int health, int[][] attacks) {

        int attackCnt = attacks.length; // 공격 횟수
        int endDamage = attacks[attackCnt - 1][1]; // 마지막 공격의 데미지
        if (endDamage > health) return -1; // 마지막 공격의 데미지가 체력보다 크면 불가능
        int curHealth = health; // 현재 체력
        int timeCnt = 0; // 타이머

        for (int i = 0; i < attackCnt; i++) {
            int gapTime = attacks[i][0] - timeCnt - 1; // 공격 사이의 시간

            curHealth = getHeal(bandage, curHealth, gapTime);
            if (curHealth > health) curHealth = health; // 체력이 최대 체력을 넘어가면 최대 체력으로 설정

            curHealth -= attacks[i][1]; // 공격 데미지 계산
            if (curHealth <= 0) return -1; // 체력이 0 이하면 리턴

            timeCnt = attacks[i][0]; // 타이머 업데이트
        }
        return  curHealth;
    }

    private static int getHeal(int[] bandage, int curHealth, int healTime) {
        if (healTime >= bandage[0]) {
            int additionalHeal = healTime / bandage[0]; // 추가 회복 횟수
            curHealth += healTime * bandage[1] + additionalHeal * bandage[2];
        } else {
            curHealth += healTime * bandage[1];
        }
        return curHealth;
    }
}