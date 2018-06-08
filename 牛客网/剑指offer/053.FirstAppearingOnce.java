package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;


/***
 * 题目：
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符“go”时，第一个只出现一次的字符时“g”。
 * 当从该字符流中读出前六个字符“google”时，第一个只出现一次的字符时“l”.
 */

public class Main {

    int[] appearTable = new int[256];
    ArrayList<Character> list = new ArrayList<>();

    void Insert(char ch){
        int index = ch;
        if(appearTable[index] == 0){
            appearTable[index] = 1;
            list.add(ch);
        }else {
            appearTable[ch] += 1;
            if(list.contains(ch)){
                int i = list.indexOf(ch);
                list.remove(i);
            }
        }
    }

    public char FirstAppearingOnce(){
        if(list.size()>0){
            return list.get(0);
        }else{
            return '#';
        }

    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            m.Insert(ch[i]);
            System.out.print(m.FirstAppearingOnce() + " ");

        }
    }
}
