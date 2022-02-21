package com.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 双指针
 */
public class Text0838 {

    public static String pushDominoes(String dominoes) {
        // 记录初始存在的活动状态
        List<Integer> flags = new ArrayList<>();
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) != '.') {
                flags.add(i);
            }
        }
        if (flags.size() == 0) {
            return dominoes;
        }
        StringBuilder ansStr = new StringBuilder();
        int preIdx = 0;
        for (int curIdx : flags) {
            if (dominoes.charAt(preIdx) == 'R' && dominoes.charAt(curIdx) == 'L') {
                for (int l = preIdx; l < (preIdx + curIdx) / 2; l++) {
                    ansStr.append('R');
                }
                if ((curIdx + preIdx) % 2 == 0) {
                    ansStr.append(".");
                } else {
                    ansStr.append("R");
                }
                for (int l = (preIdx + curIdx) / 2 + 1; l < curIdx; l++) {
                    ansStr.append("L");
                }
            } else if (dominoes.charAt(preIdx) == 'R' && dominoes.charAt(curIdx) == 'R') {
                for (int l = preIdx; l < curIdx; l++) {
                    ansStr.append("R");
                }
            } else if (dominoes.charAt(curIdx) == 'L') {
                for (int l = preIdx; l < curIdx; l++) {
                    ansStr.append("L");
                }
            } else {
                ansStr.append(dominoes, preIdx, curIdx);
            }
            preIdx = curIdx;
        }
        if (dominoes.charAt(flags.get(flags.size() - 1)) == 'R') {
            ansStr.append('R');
            for (int i = preIdx + 1; i < dominoes.length(); i++) {
                ansStr.append('R');
            }

        } else {
            ansStr.append('L');
            ansStr.append(dominoes.substring(preIdx + 1));
        }
        return ansStr.toString();
    }

    public static void main(String[] args) {
        String dominoes = "...R....";
        System.out.println("dominoes = " + dominoes);
        System.out.println("pushDominoes(dominoes) = " + pushDominoes(dominoes));
    }

}

/*
用例设计：
"...L...."
"...R...."
"...L...R...."
"L....L...R...R"
"R...L...R...L"
"R.....L"
"R....L"
"RL"
"L"
"R"
 */