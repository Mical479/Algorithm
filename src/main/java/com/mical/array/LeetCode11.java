package com.mical.array;

import org.junit.Test;

/**
 * 类 名 称：LeetCode11
 * 类 描 述：力扣网11题(167题、345题、125题）
 * 题 描 述：给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 输 入: [1,8,6,2,5,4,8,3,7]
 * 输 出: 49
 * 创建时间：2020/1/13 21:41
 * 创建人：Mical
 */
public class LeetCode11 {
    class Solution{
        /**
         * 双指针碰撞法，主要在于怎么移动指针，应该判断哪个墙矮一点，哪个才移动，这样子才能使总的面积增大
         * @param height 墙的高度
         * @return
         */
        public int maxArea(int[] height){
            int l = 0, r = height.length - 1;
            int count = 0;
            while(l <= r){
                int area = getArea(height[l], height[r], r - l);
                if (area > count){
                    count = area;
                }

                if (height[l] < height[r]){
                    l ++;
                }else {
                    r --;
                }
            }
            return count;
        }

        private int getArea(int num1, int num2, int length){
            int min = Math.min(num1, num2);
            return min * length;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int i = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
