package com.mmall.concurrencyy.example.LinkedList;

/**
 * 链表结构实体类
 * Created by 胡金才
 * 2019/7/29 13:26
 */
public class Node<T> {
    private Node next; //指针域
    private T t;  // 数据区
    Node(T t) {
        this.t = t;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
