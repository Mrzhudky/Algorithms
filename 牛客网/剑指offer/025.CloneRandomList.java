/**
 *题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *返回结果为复制后复杂链表的head。
 *（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 *思路：
 *分三步:
 *1) A-B-C-D   -->    A-A'-B-B'-C-C'-D-D'
 *2)连接各结点的random
 *3)A-A'-B-B'-C-C'-D-D' --> A-B-C-D 
 */

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReconnectNodes(pHead);
    }
    public void CloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode tempNode = new RandomListNode(pNode.label);
            tempNode.next = pNode.next;            
            tempNode.random = null;
            
            pNode.next = tempNode;
            pNode = tempNode.next;
        }
    }
    
    public void ConnectRandomNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode tempNode = pNode.next;
            if(pNode.random != null){
                tempNode.random = pNode.random.next;
            }
            pNode = tempNode.next;
        }
    }
    public RandomListNode ReconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode cloneHead = null;
        RandomListNode pCloneNode = null;
        
        if(pNode != null){
            cloneHead = pNode.next;
            pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        
        while(pNode != null){
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }
    
}