package com.lanhu.datastructure.list;

/**
 * @author 蓝狐
 * 单循环链表，是单链表的另一种形式。
 * 单链表的特点是单链表的最后一个结点不是null,而是指向了头结点
 * 这样形成了一个循环链表
 */
public class CycleLinkList<T> implements List<T>{
    /**
     * 头结点
     */
    Node head;

    /**
     * 尾结点
     */
    Node last;

    /**
     * 链表拥有记录数
     */
    int size;

    /**
     * 构造单链表
     */
    public CycleLinkList () {
        head = last = new Node(null);
        size = 0;
    }

    /**
     * 链表拥有元素个数
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
     * 链表中添加元素，默认尾部添加
     * @param t
     * @return
     */
    @Override
    public int add (T t) {
        if(isEmpty()){
            // 如果链表为空，则头部结点后移
            head = new Node(t,head);
            size++;
            return 1;
        }
        // 创建新的结点
        Node newNode = new Node(t,null);
        // 尾结点下一个结点是新的结点
        last.next = newNode;
        // 新的结点的下一个结点指向头部结点
        newNode.next = head;
        size++;
        return 1;
    }

    @Override
    public int add (T t, int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标数组越界");
        }
        // 获取插入结点的前一个位置结点
        Node pre = getByIndex(index-1);
        // 如果为null直接插入结点，说明是空链
        if(pre == null){
            add(t);
            size++;
            return 1;
        }
        //
        Node newNode = new Node(t,null);
        // 找出前一个结点的下一个结点
        Node next = pre.next;
        // 将新增的node结点的下一个结点连接到next结点
        newNode.next = next;
        pre.next = newNode;
        size++;
        return 1;
    }

    /**
     * 根据index获取链表中的node结点
     * @param index
     * @return
     */
    private Node getByIndex(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标数组越界");
        }
        if(index == size){
            return last;
        }
        // 从头开始遍历
        Node tmp = head;
        for (int i = 0; i < size && tmp!=null; i++,tmp = tmp.next) {
            if(i == index){
                return tmp;
            }
        }
        return null;
    }

    /**
     * 删除链表中的结点
     * @param index
     * @return
     */
    @Override
    public Object remove (int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标数组越界");
        }
        // 获取被删除结点的前一个结点
        Node pre = getByIndex(index-1);
        // 找到被删除结点
        Node delNode = pre.next;
        // 找到被删除结点的下一个结点
        Node next = delNode.next;
        // 被删除结点的前一个结点的下一个结点指向其下一个结点
        pre.next = next;
        // 断开 等待gc回收
        delNode.next = null;
        return delNode.value;
    }

    /**
     * 默认删除尾结点
     * @return
     */
    @Override
    public Object remove () {
        return remove(size - 1);
    }

    /**
     * 根据下标获取链表元素
     * @param index
     * @return
     */
    @Override
    public Object get (int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标数组越界");
        }
        // 从头结点开始遍历
        Node tmp = head;
        for (int i = 0; i < size; i++,tmp = tmp.next) {
            if(tmp.next != null && i == index){
                return tmp.value;
            }
        }
        return null;
    }

    @Override
    public boolean contains (T t) {
        if(head.value.equals(t) || head.next.value.equals(t)){
            return true;
        }
        if(last.value.equals(t) || head.next.value.equals(t)){
            return true;
        }
        // 从头部遍历结点
        Node tmp = head;
        for (int i = 0; i < size && tmp != null; i++,tmp = tmp.next) {
            if(tmp.value.equals(t)){
                return true;
            }
        }
        return false;
    }
}
