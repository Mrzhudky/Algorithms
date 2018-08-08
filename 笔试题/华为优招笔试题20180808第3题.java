package com.company;

import java.util.*;

/*
C++中typedef的模拟
第一行输入一堆typedef定义，标准C++语句，以分号结束，这里只考虑基本类型和指针。
第二行是制定某个自定义type，
输出为该自定义type的最终形态
如输入：
typedef int INT; typedef INT** INTP;
INTP
输出为：
int **
注意：如果有指针类型，则指针表达的*和前面的类型中间间隔一个空格，和编译器的输出保持一致；
另外，如果一行输入的语句是编译不过的，或者第二行选择的type在第一行中没有定义，则输出none

 */

class RealName{
    String name;
    int numOfPrint = 0;

    public RealName(String str,int num){
        name = str;
        numOfPrint = num;
    }
}

public class Main {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String typedefLine = sc.nextLine();
        String outName = sc.nextLine();

        HashMap<String,RealName> map = new HashMap<>();
        map.put("int",new RealName("int",0));
        map.put("float",new RealName("float",0));
        map.put("char",new RealName("char",0));
        map.put("long",new RealName("long",0));
        map.put("double",new RealName("double",0));
        map.put("bool",new RealName("bool",0));
        map.put("long long",new RealName("bool",0));

        String[] split = typedefLine.split(";");
        for (int i = 0; i < split.length; i++) {
            String temp[] = split[i].split(" ");
            int index =temp.length -2;
            int j = temp[index].length()-1;
            while(j>=0 && temp[index].charAt(j)=='*') j--;
            if(j<0){
                System.out.println("none");
                return;
            }
            RealName rn = new RealName(temp[index].substring(0,j+1),temp[index].length() -j-1);
            if(!map.containsKey(rn.name)){
                System.out.println("none");
                return;
            }
            rn.name = map.get(rn.name).name;
            rn.numOfPrint += map.get(rn.name).numOfPrint;
            map.put(temp[index+1],rn);
        }

        if(map.containsKey(outName)){
            System.out.print(map.get(outName).name);
            int num = map.get(outName).numOfPrint;
            if(num>0){
                System.out.print(" ");
            }
            for (int i = 0; i < num; i++) {
                    System.out.print("*");
            }
            System.out.println();
            return;
        }
        System.out.println("none");

    }

}
