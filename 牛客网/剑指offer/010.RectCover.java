/*
 *我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 斐波那契数
 **/
public class Solution {
    public int RectCover(int target) {
        if(target<1){
            return 0;
        }
        if(target<3){
            return target;
        }
        int lastN = 1;
        int nextN = 2;
        for(int i=2;i<target;i++){
            nextN = nextN + lastN;
            lastN = nextN - lastN;
        }
        return nextN;
        
    }
}