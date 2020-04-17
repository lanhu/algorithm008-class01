package com.lanhu.datastructure.list;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author 蓝狐
 *
 * 单链表尾结点为null
 */
public class LinkedList<T> implements List<T>{

    /**
     * 头结点
     */
    Node head;

    /**
     *
     */
    Node last;

    /**
     * 链表元素大小记录
     */
    int size;

    /**
     * 链表初始化
     * 头结点=尾结点=null代表一个空链
     */
    public LinkedList () {
        head = last = new Node(null);
        size =0;
    }

    /**
     * 返回链表中元素个数
     * @return
     */
    @Override
    public int size () {
        return size;
    }

    /**
     * 链表判空
     * @return
     */
    @Override
    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * 向链表中添加元素，可分为头插法和尾插法
     * 尾插法比较容易时间复杂度O(1)
     * @param t
     * @return
     *
     */
    @Override
    public int add (T t) {
        Node tmp = last;
        Node newNode = new Node(t);
        if(tmp == null){
            head = newNode;
        }
        tmp.next = newNode;
        size++;
        return 1;
    }

    /**
     * 将元素添加到链表中
     *
     * @param t
     * @param index
     * @return
     */
    @Override
    public int add (T t, int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node newNode = new Node(t);
        if(head == null){
            head = newNode;
            return 1;
        }
        // 建立临时结点从头结点遍历
        Node tmp = head;
        //记录当前遍历位置，判断是否到达指定位置
        int position = 0;
        while (tmp.next != null){
            // 将newNode结点插入tmp结点之后，
            // 首先newNode结点的下一个结点指向，tmp的下一个结点
            // 然后tmp的下一个结点，指向newNode，步骤不可反
            if(position == index-1){
                newNode.next = tmp.next;
                tmp.next = newNode;
                return 1;
            }

            position++;
            // 向后遍历node结点
            tmp = tmp.next;
            size++;
        }
        return 1;
    }

    @Override
    public Object remove (int index) {
        return null;
    }

    /**
     * 默认删除头结点
     * @return
     */
    @Override
    public Object remove () {
        Node element = head;
        Node next = head.next;
        if(head == null){
            throw new NoSuchElementException("没有该元素");
        }
        head.next = null;
        head = next;
        size--;
        return head.value;
    }

    @Override
    public Object get (int index) {
        if(index < 0 || index >size){
            throw new IndexOutOfBoundsException("下标数组越界");
        }
        // 如果index恰好为尾部结点则直接返回，不需遍历
        if(index == size-1){
            return last.value;
        }
        Node tmp = head;
        for (int i = 0; i < size; i++) {
            // 不断循环查找对应下标的结点
            tmp = head.next;
            if(i == index){
                return tmp.value;
            }
        }
        return null;
    }

    /**
     * 判断链表是否包含某一元素
     * @param t
     * @return
     */
    @Override
    public boolean contains (T t) {
        if(head.value.equals(t)){
            return true;
        }
        if(last.value.equals(t)){
            return true;
        }
        Node tmp = head;
        for (int i = 0; i < size; i++) {
            tmp = tmp.next;
            if(tmp.value.equals(t)){
                return true;
            }
        }
        return false;
    }
}
