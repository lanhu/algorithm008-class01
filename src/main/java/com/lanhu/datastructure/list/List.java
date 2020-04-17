package com.lanhu.datastructure.list;

/**
 * @author 蓝狐
 *  抽象线性表
 *  线性表的定义:线性表是最简单的数据结构，它是由n个数据元素(结点)a1,a2,a3……dn
 *  组成的有序序列。
 *  逻辑特征：
 *  (1)有且仅有一个称为开始元素的a1,它没有前驱，仅有一个直接后继a2
 *  (2)有且仅有一个称为终端元素的an,它没有后继，仅有一个直接前驱
 *  (3)其余元素ai(2<=i<n-1)称为内部元素，他们都有且仅有一个直接前驱ai-1和一个直接后继ai+1
 */
public interface List<T> {

    /**
     *  拥有元素的个数
     */
    int size();

    /**
     * 线性表判断空
     * @return
     */
    boolean isEmpty();

    /**
     *  添加元素
     */
    int add(T t);

    /**
     * 指定索引添加元素
     * @param t
     * @param index
     * @return
     */
    int add(T t,int index);

    /**
     *  删除顺序表下标元素
      * @param index
     * @return  返回被删除的元素
     */
    Object remove(int index);

    /**
     * 从线性表中删除最后一个元素
     * @return
     */
    Object remove();


    /**
     * 根据索引获取元素
     * @param index
     * @return 从线性表中获取元素
     */
    Object get(int index);

    /**
     * 判断线性表是否包含元素
     * @param t
     * @return
     */
    boolean contains(T t);


}
