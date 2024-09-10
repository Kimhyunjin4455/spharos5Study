package problem;

public class Programmers_250137 {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int attackCnt = attacks.length;
        int endDamage = attacks[attackCnt - 1][1];
        if (endDamage > health) return -1;
        int curHealth = health;
        int timeCnt = 0;

        for (int i = 0; i < attackCnt; i++) {
            int gapTime = attacks[i][0] - timeCnt - 1;

            curHealth = getHeal(bandage, curHealth, gapTime);
            if (curHealth > health) curHealth = health;

            curHealth -= attacks[i][1];
            if (curHealth <= 0) return -1;

            timeCnt = attacks[i][0];
        }
        return  curHealth;
    }

    private static int getHeal(int[] bandage, int curHealth, int healTime) {
        if (healTime >= bandage[0]) {
            int additionalHeal = healTime / bandage[0];
            curHealth += healTime * bandage[1] + additionalHeal * bandage[2];
        } else {
            curHealth += healTime * bandage[1];
        }
        return curHealth;
    }
}
