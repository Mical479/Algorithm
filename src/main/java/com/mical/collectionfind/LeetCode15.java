package com.mical.collectionfind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类 名 称：LeetCode15
 * 类 描 述：力扣网15题（1题, 18题, 16题）
 * 题 描 述： 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注 意：答案中不可以包含重复的三元组。
 * 输 入：给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 输 出：满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 创建时间：2020/1/24 11:26
 * 创建人：Mical
 */
public class LeetCode15 {

    class Solution{
        //解题思路：3指针碰撞，首先for循环遍历数组，以i为起点，在i的右边利用双指针碰撞的方法查找三数之和。
        public List<List<Integer>> threeSum(int[] nums){
            List<List<Integer>> ans = new ArrayList<>();
            int len = nums.length;
            if (len < 3) return ans;
            Arrays.sort(nums); //排序
            for (int i = 0; i < len; i++) {
                //如果当前数字大于0，则三数之和一定大于0，所以结束循环,因为是在i的右边寻找，所以当i处的数大于0，i右边的必大于0
                //所以直接break。
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i-1]) continue; //去重
                int L = i + 1;
                int R = len - 1;

                while (L < R){
                    int sum = nums[i] + nums[L] + nums[R];
                    if (sum == 0){
                        ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L+1]) L ++; //去重
                        while (L < R && nums[R] == nums[R-1]) R --; //去重
                        L ++;
                        R --;
                    }else if (sum < 0){
                        L ++;
                    }else {
                        R --;
                    }
                }
            }
            return ans;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.threeSum(new int[]{2, -1, 1, 0, -1});
    }
}
