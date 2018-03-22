/*
 *大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 *n<=39
*/

import java.util.ArrayList;
class Solution {
    public int Fibonacci(int n) {
        int lastN = 1;
        int nextN = 1;
        if(n<1){
            return 0;
        }
        if(n <3){
            return 1;
        }
        for(int i=2;i<n;i++){
            nextN = nextN + lastN;
            lastN = nextN - lastN;
        }
        return nextN;
    }
}

