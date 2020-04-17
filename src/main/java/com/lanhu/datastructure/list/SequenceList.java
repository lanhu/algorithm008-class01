package com.lanhu.datastructure.list;

import java.util.Arrays;

/**
 * @author 蓝狐
 * 顺序表
 * 数组实现顺序表
 * 数组的优势：
 * (1)内存空间连续
 * (2)查询快速，可以随机访问，时间复杂度为O(1)
 * 数组劣势：
 * (1)预先分配空间，并且固定不变，可能造成空间浪费
 * (2)增加，删除涉及到数组的移动
 * (3)大量的修改操作，涉及到大量的system.arraycopy
 */
public class SequenceList<T> implements List<T>{
    /**
     * 存储数据元素
     */
    private Object[] element;

    /**
     * 当前线性表大小
     */
    private int size = 0;

    /**
     * 初始化顺序表容量
     */
    private int default_capacity = 10;

    /**
     * 顺序表容量
     */
    private int capacity;

    /**
     * 默认构造方法初始化大小为default_capacity 10的数组
     */
    public SequenceList () {
        capacity = default_capacity;
        element = new Object[capacity];
    }

    /**
     * 自定义长度顺序表
     * @param capacity
     */
    public SequenceList(int capacity){
        this.capacity = capacity;
        element = new Object[capacity];
    }

    /**
     * 线性表存储元素个数
     * @return
     */
    public int size () {
        return this.size;
    }

    /**
     * 判断顺序表是否为空
     * @return
     */
    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * 添加一个元素到顺序表尾部
     * @param t
     * @return
     */
    public int add (T t) {
        return add(t,size);
    }

    /**
     * 添加元素到指定索引结点
     * @param t
     * @param index
     * @return
     */
    public int add (T t, int index) {
        if(index < 0 || index > capacity-1){
            throw new IndexOutOfBoundsException("下标数组越界");
        }
        size++;
        resize(size);
        System.arraycopy(element,index,element,index+1,capacity-index-1);
        // 将下标index指向t
        element[index] = t;
        return 1;
    }

    /**
     * 从顺序表中移除指定下标元素
     * @param index
     * @return
     */
    public Object remove (int index) {
        if(index < 0 || index > capacity-1){
            throw new IndexOutOfBoundsException("下标数组越界");
        }
        Object removeEle = element[index];
        // 将index下标元素设置为空
        element[index] = null;
        size--;
        System.arraycopy(element,index+1,element,index,capacity-index-1);
        return removeEle;
    }

    /**
     * 从顺序表中删除最后一个元素
     * @return
     */
    @Override
    public Object remove () {
        return remove(size-1);
    }

    /**
     * 从顺序表中获取元素
     * @param index
     * @return
     */
    public Object get (int index) {
        if(index < 0 || index > capacity-1){
            throw new IndexOutOfBoundsException("下标数组越界");
        }
        return element[index];
    }

    /**
     * 判断顺序表中是否存在元素t
     * @param t
     * @return
     */
    public boolean contains (T t) {
        boolean flag = false;
        for (int i = 0; i < element.length; i++) {
            T ele = (T)get(i);
            if(ele == t){
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 将顺序表扩容为原来的两倍
     * @param size
     */
    private void resize(int size){
        if(size > capacity-1){
            Arrays.copyOf(element,capacity*2);
        }
    }
}
