package com.lanhu.leecode;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * @author 蓝狐
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class TwoSums {
    public static void main (String[] args) {
        Gson gson = new Gson();
        int[] tmp = new int[]{1,2,3,4,5,8};
        int[] tmpResult = twoSum(tmp,8);
        int[] tmpResult2 = twoSum2(tmp,8);

        System.out.println("tmpResult twoSum:"+gson.toJson(tmpResult));
        System.out.println("tmpResult twoSum2:"+gson.toJson(tmpResult2));

        int[] tmp2 = new int[]{3,3};
        int[] tmpResult3 = twoSum(tmp2,6);
        System.out.println("tmpResult2 twoSum:"+gson.toJson(tmpResult2));
        int[] tmpResult4 = twoSum2(tmp2,6);
        System.out.println("tmpResult2 twoSum2:"+gson.toJson(tmpResult4));

    }
    /**
     *
     * 暴力破解，双层循环，挨个比较当前i与下一个结点j(i+1)
     * 比较是否有 i+j=target,
     * 时间复杂度为O(n2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int length = nums.length;
        int[] tmpNums = null;
        for (int i = 0;i < length; i++){
            int first = nums[i];
            for ( int j = i+1; j< nums.length; j++){
                int second = nums[j];
                if( first + second == target){
                    tmpNums = new int[]{i,j};
                    break;
                }
            }
        }
        return tmpNums;
    }

    /**
     *利用外部空间，
     * 时间复杂度为O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums,int target){
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int length = nums.length;
        // 首先将数组中的元素遍历放进map缓存中,key为值，value为下标
        HashMap<Integer,Integer> map = new HashMap(length);
        for (int i = 0; i< length; i++) {
            map.put(nums[i],i);
        }

        for (int j = 0; j < length; j++) {
            int first = nums[j];
            // 第二个值为map的键，
            int second = target - first;
            if(map.containsKey(second)){
                return new int[]{j,map.get(second)};
            }
        }
        return new int[0];
    }
}
