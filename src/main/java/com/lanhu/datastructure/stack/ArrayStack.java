package com.lanhu.datastructure.stack;

import java.util.EmptyStackException;

/**
 * @author 蓝狐
 *数组栈，top=0 空栈
 */
public class ArrayStack<T> implements Stack<T>{

    /**
     * 数据元素
     */
    Object[] elements;

    /**
     * 栈元素大小
     */
    int size;


    /**
     * 默认初始化数组大小为10
     */
    public ArrayStack () {
        elements = new Object[10];
    }

    /**
     * 栈判空
     * @return
     */
    @Override
    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * 出栈，返回栈顶元素，即在数组尾部移除最后一个元素
     * 并返回最后一个元素
     * @return
     */
    @Override
    public T pop () {
        if (size == 0){
            throw new EmptyStackException();
        }
        int index = size - 1;
        // 取出栈顶元素
        T t = (T)elements[index];
        // 栈顶元素置空
        elements[index] = null;
        size--;
        return t;
    }

    /**
     * 栈顶入栈，即在数组尾部添加元素
     * @param t
     * @return
     */
    @Override
    public T push (T t) {
        int index = size++;
        elements[index] = t;
        return t;
    }

    /**
     * 栈置空
     */
    @Override
    public void clear () {
        if (size == 0){
            return;
        }
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     *栈顶查询，不删除
     * @return
     */
    @Override
    public T peek () {
        if (size == 0){
            return null;
        }
        int index = size - 1;
        return (T)elements[index];
    }

    /**
     * 返回栈的长度
     * @return
     */
    @Override
    public int length () {
        return size;
    }

    /**
     *根据数据元素，搜索返回元素至栈顶的距离
     * @param t
     * @return
     */
    @Override
    public int search (T t) {
        if (size == 0){
            throw new EmptyStackException();
        }
        int j = 0;
        for (int i = 0; i < size; i++) {
            Object element = elements[i];
            if (t.equals(element)){
                return size - i;
            }
        }

        return -1;
    }
}
