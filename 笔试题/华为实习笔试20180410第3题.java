package com.company;
/**
 * 华为实习20180410机试题：计算两个长整数的乘积
 * 例：
 * 输入：
 * 1234
 * 4321
 * 输出：
 * 5332114
 * @Author zhudky
 * @Version v1.0.0 2018.04.10
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strX = sc.nextLine();
        String strY = sc.nextLine();


        int flagX = 0;
        if (strX.startsWith("-")) {
            flagX = 1;
        }
        int[] intStrX = new int[strX.length() - flagX];
        for (int i = 0; i < intStrX.length; i++) {
            intStrX[i] = strX.charAt(strX.length() - 1 - i) - '0';
        }
        int flagY = 0;
        if (strY.startsWith("-")) {
            flagY = 1;
        }
        int[] intStrY = new int[strY.length() - flagY];
        for (int i = 0; i < intStrY.length; i++) {
            intStrY[i] = strY.charAt(strY.length() - 1 - i) - '0';
        }

        long xLen = intStrX.length;
        long yLen = intStrY.length;
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> midAnswer = new ArrayList<>();
        for (int i = 0; i < yLen; i++) {
            midAnswer.clear();
            int tempY = intStrY[i];
            int bitCarry = 0;  //进位
            for (int k = 0; k < i; k++) {
                midAnswer.add(0);
            }
            for (int j = 0; j < xLen; j++) {
                int product = tempY * intStrX[j];
                int bitThis = product % 10;
                midAnswer.add(bitThis + bitCarry);
                bitCarry = product / 10;


            }
            if (bitCarry != 0) {
                midAnswer.add(bitCarry);
            }
            if (i == 0) {
                answer = (ArrayList<Integer>) midAnswer.clone();
            } else {
                while (midAnswer.size() > answer.size()) {
                    answer.add(0);
                }
                int subC = 0;
                for (int j = 0; j < midAnswer.size(); j++) {
                    int sub = answer.get(j) + midAnswer.get(j);
                    int bitThis = sub % 10;
                    answer.set(j, bitThis + subC);
                    subC = sub / 10;

                }
                if (subC > 0) {
                    if (midAnswer.size() == answer.size()) {
                        answer.add(subC);
                    } else {
                        answer.set(midAnswer.size(), subC);
                    }
                }
            }
        }

        if((flagX + flagY)==1) {
            System.out.print("-");
        }
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(answer.size() - 1-i));
        }
    }
}

