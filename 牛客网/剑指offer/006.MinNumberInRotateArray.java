/*
 *链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba
 *来源：牛客网
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 *输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
 *例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 
 *因为数组有序，使用二分法。因为数组长度有奇偶两种，最后有两种情况，left ==right 以及 right == left+1;
 */
import java.util.ArrayList;
class Solution {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int mid = 0;
        int right = array.length;
        if(right <= 0){
            return 0;
        }
        else{
            right = right -1;
        }
        while (left<right){
            mid = (left + right)/2;
            if(array[mid] < array[right]){
                right = mid;
            }else {
                left = mid;
            }
            if(right-left==1){
                break;
            }
        }
        return array[right];
    }


}

