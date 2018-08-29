package com.company;
import java.util.*;
/**
 * Created by zhu on 2018/8/29.
 * 146. LRU缓存机制
 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

 进阶:

 你是否可以在 O(1) 时间复杂度内完成这两种操作？

 示例:

 LRUCache cache = new LRUCache( 2   );//缓存容量

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
 */
public class LRUCache {

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
