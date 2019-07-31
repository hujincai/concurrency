package com.mmall.concurrencyy.example.LinkedList;

import java.util.LinkedList;

/**
 * Created by 胡金才
 * 2019/7/29 13:26
 */
public class LinkedListExample1 {
    // 单链表反转
    public static Node reverseListNode(Node head) {
        // 如果单链表为Null或只有一个节点，直接返回原有链表
        if (head == null || head.getNext() == null) {
            return head;
        }

        // 前一个节点
        Node preNode = null;
        // 当前节点
        Node curNode = null;
        // 后一个节点
        Node nextNode = null;

        while (null != curNode) {
            nextNode = curNode.getNext(); // nextNode指向下一个节点
            curNode.setNext(preNode); // 当前节点next域指向前一个点。
            preNode = curNode;   // preNode向后移动
            curNode = nextNode; // curNode向后移动
        }
        //
        return preNode;
    }
}
