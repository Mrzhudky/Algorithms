###02-线性结构3 Reversing Linked List###

Given a constant `K` and a singly linked list `L`, you are supposed to reverse the links of every `K` elements on `L`. For example, given L being `1→2→3→4→5→6`, if `K=3`, then you must output `3→2→1→6→5→4`; if `K=4`, you must output `4→3→2→1→5→6`.

####Input Specification:####

Each input file contains one test case. For each case, the first line contains the address of the first node, a positive `N (≤10^5​)` which is the total number of nodes, and a positive `K (≤N)` which is the length of the sublist to be reversed. The address of a node is a 5-digit nonnegative integer, and NULL is represented by `-1`.

Then `N` lines follow, each describes a node in the format:

<i>`Address Data Next` </i>

where Address is the position of the node, Data is an integer, and Next is the position of the next node.

####Output Specification:####

For each case, output the resulting ordered linked list. Each node occupies a line, and is printed in the same format as in the input.

#####Sample Input:#####
`00100 6 4 `
<br>`00000 4 99999`
<br>`00100 1 12309`
<br>`68237 6 -1`
<br>`33218 3 00000`
<br>`99999 5 68237`
<br>`12309 2 33218`

#####Sample Output:#####
`00000 4 33218`
<br>`33218 3 12309`
<br>`12309 2 00100`
<br>`00100 1 99999`
<br>`99999 5 68237`
<br>`68237 6 -1`

##思路##
构建结构体
<code>
<br>typedef struct Node *List; 
<br>struct Node{
<br>	long lastAddr;
<br>	long nextAddr;
<br>	int data;
<br>	List link;
<br>};
<br>void main(){
<br>	//依次读入一个链表中，
<br>	//根据当前及后一个地址排序
<br>	//循环的方式模拟一个深度为K的栈，栈满后将栈顶地址加到结果链表后面，记录栈底指针，
<br>    // N%k 个不需逆转的节点以及加到链表后面
<br>	//打印结果链表
<br>｝
</code>
