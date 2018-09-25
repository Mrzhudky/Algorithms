package com.company;
import java.util.*;
/**
 * Created by zhu on 2018/8/29.
 * 841. 钥匙和房间
有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。

在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。

最初，除 0 号房间外的其余所有房间都被锁住。

你可以自由地在房间之间来回走动。

如果能进入每个房间返回 true，否则返回 false。

示例 1：

输入: [[1],[2],[3],[]]
输出: true
解释:  
我们从 0 号房间开始，拿到钥匙 1。
之后我们去 1 号房间，拿到钥匙 2。
然后我们去 2 号房间，拿到钥匙 3。
最后我们去了 3 号房间。
由于我们能够进入每个房间，我们返回 true。
示例 2：

输入：[[1,3],[3,0,1],[2],[0]]
输出：false
解释：我们不能进入 2 号房间。
提示：

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
所有房间中的钥匙数量总计不超过 3000。
 */
class Solution {

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] reached = new boolean[N];
        bfs(reached,rooms,0);
        for (int i = 0; i < N; i++) {
            if(!reached[i]){
                return false;
            }
        }
        return true;

    }

    private void bfs(boolean[] reached,List<List<Integer>> rooms,int s){

        LinkedList<Integer> queue = new LinkedList<>();
        reached[s] = true;        
        queue.offer(s);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            List<Integer> room = rooms.get(index);
            int len = room.size();
            for (int i = 0; i < len; i++) {
                int key = room.get(i);
                if (!reached[key]) {
                    reached[key] = true;
                    queue.offer(key);
                }
            }
        }
    }
}

    //双向链表
    private class Node{
        int val = 0;
        int key = 0;
        Node pre = null;
        Node next = null;
        public Node(int key,int val){
            this.val = val;
            this.key = key;
        }
    }

    //LinkedList<Integer> list =  new LinkedList<>();
    Node headNode = null;//头结点
    Node endNode = null;//尾节点
    HashMap<Integer,Node> map = null;// = new HashMap<>();
    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer,Node>(capacity);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            remove(old);
            addHead(old);
            map.put(key,old);
            return old.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            remove(old);
            old.val = value;
            addHead(old);
            map.put(key,old);
        }else{
            Node node = new Node(key,value);
            addHead(node);
            map.put(key,node);
            if(map.size()>capacity){
                map.remove(endNode.key);
                remove(endNode);
            }
        }
    }

    private void remove(Node node){
        if(node.pre != null){
            node.pre.next = node.next;
        }else{
            headNode = node.next;
        }
        if(node.next != null){
            node.next.pre = node.pre;
        }else{
            endNode = node.pre;
        }
    }

    private void addHead(Node node){
        node.pre = null;
        node.next = headNode;
        if(headNode != null){
            headNode.pre = node;
        }else{
            endNode = node;
        }
        headNode = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        //cache.get(2);       // 返回 -1 (未找到)
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        //cache.get(1);       // 返回 -1 (未找到)
        System.out.println(cache.get(1));
        //cache.get(3);       // 返回  3
        System.out.println(cache.get(3));
        //cache.get(4);       // 返回  4
        System.out.println(cache.get(4));
    }
}
