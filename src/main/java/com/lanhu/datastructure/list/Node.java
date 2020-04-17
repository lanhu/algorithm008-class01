package com.lanhu.datastructure.list;

/**
 * @author 蓝狐
 */
public class Node {
    /**
     * 结点数值
     */
     Object value;

    /**
     * 下一个结点
     */
    Node next;

    public Node (Object value) {
        this.value = value;
        this.next = null;
    }

    public Node (Object value, Node next) {
        this.value = value;
        this.next = next;
    }
}
