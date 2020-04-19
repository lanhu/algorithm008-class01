package com.lanhu.leecode;

import com.google.gson.Gson;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author 蓝狐
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class MoveZeroes {
    public static void main (String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (int i = 0; i < threadInfos.length; i++) {
            System.out.println(threadInfos[i].getThreadId()+","+threadInfos[i].getThreadName());
        }
        int[] array = new int[]{1,3,34,0,56,0,58,34};
        moveZeroes(array);
        System.out.println(new Gson().toJson(array));
        moveZeroes2(array);
        System.out.println(new Gson().toJson(array));
    }

    /**
     * 思路：单指针记录，k记录下不为0的数据项移动次数
     * 剩余的就是length-k就是后续0的个数
     * 时间复杂度O(n)
     * @param nums
     */
    public static void moveZeroes(int[] nums){
        int length = nums.length;
        if (length == 0){
            return;
        }
        int k = 0;
        // 不为0的记录数向前移动
        for (int j = 0;j<length; j++){
            if(nums[j] != 0){
                nums[k]=nums[j];
                k++;
            }
        };
        // 循环剩余的为0的记录数
        for (int n = k; n<length;n++){
            nums[n] = 0;
        }
    }

    /**
     * 优化版，方法1第二步循环可以优化，在第一步循环判断
     * @param nums
     */
    public static void moveZeroes2(int[] nums){
        int length = nums.length;
        if (length == 0){
            return;
        }
        int k = 0;
        // 不为0的记录数向前移动，如果k=j说明遍历没有0，如果k不等于j说明0位出现
        // 该方法比较精妙，j充当指针作用，nums[j] = 0 不断向后写0，写0前已经由
        // nums[k]=nums[j] 向前移动
        for (int j = 0; j < length; j++){
            if (nums[j] != 0){
                nums[k]=nums[j];
                if ( k != j){
                    nums[j] = 0;
                }
                k++;
            }
        }
    }
}
