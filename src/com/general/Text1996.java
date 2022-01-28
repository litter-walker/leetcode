package com.general;

import java.util.Arrays;

public class Text1996 {

    public static int numberOfWeakCharacters(int[][] properties) {
        int maxAttack = Integer.MIN_VALUE;
        for (int[] property : properties) {
            maxAttack = Math.max(maxAttack, property[0]);
        }
        // 保存攻击力对应最大防御力;
        int[] maxDefenseOfAttack = new int[maxAttack + 1];
        for (int[] property : properties) {
            maxDefenseOfAttack[property[0]] = Math.max(maxDefenseOfAttack[property[0]], property[1]);
        }
        // 将攻击力对应最大防御力;转换为比当前攻击大的最大防御力;
        // 记录当前最大防御力;
        int curMaxDefense = Integer.MIN_VALUE;
        for (int attack = maxAttack; attack >= 0; attack--) {
            int tmp = curMaxDefense;
            curMaxDefense = Math.max(curMaxDefense, maxDefenseOfAttack[attack]);
            maxDefenseOfAttack[attack] = tmp;
        }

        // 判断每个（除攻击力最大）角色的防御力 是否大于 比当前攻击大的最大防御力;
        int ans = 0;
        for (int[] property : properties) {
            if (property[0] < maxAttack && property[1] < maxDefenseOfAttack[property[0]]) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] properties = {{5, 5},{10, 4}, {4, 3}};
        System.out.println("properties = " + Arrays.deepToString(properties));
        System.out.println("numberOfWeakCharacters(properties) = " + numberOfWeakCharacters(properties));
    }
}
