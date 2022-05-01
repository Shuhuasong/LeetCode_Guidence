package Greedy.Medium;

/**
 * Created by Shuhua Song
 */
public class _2214_MinimumHealthToBeatGame {
    public long minimumHealth(int[] damage, int armor) {
        long health = 1;
        int maxDamage = Integer.MIN_VALUE;
        for(int i=0; i<damage.length; i++){
            health += damage[i];
            maxDamage = Math.max(maxDamage, damage[i]);
        }
        long minHealth = health-Math.min(armor, maxDamage);
        return minHealth;
    }
}


/*
Solution-Greedy
1) since the armor only can be use one time, so that we hope choose a maxDamage
2) to start the game, we at least need 1
3) add all damages: needHealth = 1 + sum(damages)
4) minHealth = needHealth-Math.min(armor, maxDamage), because
   armor < maxDamage or armor > maxDamage
case-1:
[3]
1
case-2:
[1]
0
*/