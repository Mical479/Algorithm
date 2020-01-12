package com.mical.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 名 称：LeetCode283
 * 类 描 述：力扣网283题，移动零
 * 题 描 述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 创建时间：2020/1/12 15:39
 * 创建人：Mical
 */
public class LeetCode283 {

    class Solution {
        /**
         * 时间复杂度：O（n）
         * 空间复杂度：O（n）
         */
        public void moveZeroes(int[] nums){
            List<Integer> nonZeroesList = new ArrayList<>();

            for (int num : nums) {
                if (num != 0)
                    nonZeroesList.add(num);
            }

            for (int i = 0; i < nonZeroesList.size(); i++) {
                nums[i] = nonZeroesList.get(i);
            }

            for (int i = nonZeroesList.size(); i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        /**
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         * @param nums
         */
        public void moveZeroes1(int[] nums){
           int k = 0; //nums中，[0...k)的元素均为非0元素

            //遍历到第i个元素后，保证[0...i]中所有非0元素
            //都按照顺序排列在[0...k)中
            //直接用非0元素覆盖nums前面的元素
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0){
                    nums[k] = nums[i];
                    k++;
                }
            }
            //将nums剩余的位置放置为0
            for (int i = k; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        //用非0元素交换nums前面的元素
        public void moveZeroes2(int[] nums){
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != 0){
                    if (nums[i] != nums[k]) {
                        int t = nums[i];
                        nums[i] = nums[k];
                        nums[k] = t;
                    }
                    k ++;
                }
            }
        }
    }

    @Test
    public void test(){
        int arr[] = new int[]{0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
