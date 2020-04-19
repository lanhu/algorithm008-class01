package com.lanhu.leecode;

import com.google.gson.Gson;

/**
 * @author 蓝狐
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 注意：已经有序了
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 注意审题：
 * 1、数组有序
 * 2、要求返回移除后的数组新长度，而不是数组本身！重要，重要
 * 3、不使用二外空间
 */
public class RemoveDuplicates {
    public static void main (String[] args) {
        int[] nums = new int[]{1,1,1,2};
        int result = removeDuplicatesOne(nums);
        System.out.println(result);
    }

    /**
     * 双端指针，快指针，慢指针，
     * 初始化慢指针j，快指针i循环，如果发现出现如果快指针不等于慢指针，j+1,在这里充当计数
     * 然后将快指针移到慢指针，循环到结束
     * @param nums
     * @return
     */
    public static int removeDuplicatesOne(int[] nums){
        int length = nums.length;
        if (length <= 1){
            return length;
        }
        int j = 0;
        int i = 1;
        while(i<length){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

}
