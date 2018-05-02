
/**
 * 题目：
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 */

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<1){
            return 0;
        }
        int subN = 0;
        int factor = 10;
        int rightNum = 0;
        int curBit = n%factor;
        int leftNum = n/factor;
        while(leftNum != 0){
            if(curBit > 1){
                    subN += (leftNum +1)*(factor/10);
            }else if(curBit == 1){
                subN += leftNum * (factor/10) + rightNum + 1 ;
            }else{
                subN += leftNum * (factor/10);
            }
            rightNum = n%factor;
            curBit = leftNum%10;
            factor *= 10;            
            leftNum = n/factor;
        }
        if(curBit > 1){
            subN += (leftNum +1)*(factor/10);
        }else if(curBit == 1){
            subN += leftNum * (factor/10) + rightNum + 1 ;
        }else{
            subN += leftNum * (factor/10);
        }
        return subN;
    }
}


