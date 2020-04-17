package com.lanhu.leecode;

import com.google.gson.Gson;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author 蓝狐
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
}
