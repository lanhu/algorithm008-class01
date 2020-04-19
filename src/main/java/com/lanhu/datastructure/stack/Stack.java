package com.lanhu.datastructure.stack;

/**
 * @author 蓝狐
 *    栈其实也是一种操作受限的线性表。是一种后进先出的数据结构可以使用数
 *    组或者链表的形式来实现
 *
 *    定义栈接口规范，接口注重行为
 */
public interface Stack<T> {
    /**
     *栈判空
     * @return
     */
    boolean isEmpty();

    /**
     * 弹出栈顶元素
     * @return
     */
    T pop();

    /**
     * 入栈
     * @param t
     * @return
     */
    T push(T t);

    /**
     * 栈置空
     */
    void clear();

    /**
     * 查看栈顶元素，但不删除
     * @return
     */
    T peek();

    /**
     * 返回栈长度
     * @return
     */
    int length();

    /**
     * 返回栈的位置结点
     * @param t
     * @return
     */
    int search(T t);
}
