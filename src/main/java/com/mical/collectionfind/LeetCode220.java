package com.mical.collectionfind;

import org.junit.Test;

import java.util.TreeSet;

/**
 * 类 名 称：LeetCode220（219题）
 * 类 描 述：给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * 输 入：nums = [1, 2, 3, 1], k = 3, t = 0
 * 输 出：true
 * 创建时间：2020/2/6 11:56
 * 创建人：Mical
 */
public class LeetCode220 {

    class Solution {
        /**
         * 使用滑动窗口加Set容器，通过滑动窗口判断索引之差，将窗口中的元素都放入set集合中
         * 若判断：| nums[i] - nums[j] | <= t  即为 nums[i] - t <= nums[j] <= nums[i] + t, nums[j]为插入了set中的元素
         * 所以需要查找大于等于 nums[i] - t 的最小元素并判断其中要小于等于 nums[i] + t
         * @return
         */
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                Long floor = set.ceiling((long) nums[i] - t);
                if (floor != null && floor <= (long)nums[i] + t){
                    return true;
                }
                set.add((long) nums[i]);

                if (set.size() == k + 1){
                    set.remove((long)nums[i - k]);
                }
            }
            return false;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        boolean b = solution.containsNearbyAlmostDuplicate(new int[]{-2147483648, -2147483648}, 3, 3);
        System.out.println(b);

        String s = "fawfaf";
        System.out.println(s.indexOf('f'));
    }
}
