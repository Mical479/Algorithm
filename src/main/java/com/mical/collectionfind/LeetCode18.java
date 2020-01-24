package com.mical.collectionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类 名 称：LeetCode18
 * 类 描 述：力扣网18题（力扣网1题，15题，16题）
 * 题 描 述：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注 意：答案中不可以包含重复的四元组
 * 输 入：nums = [1, 0, -1, 0, -2, 2], target = 0.
 * 输 出：[ [-1, 0, 0, 1], [-2, -1, 1, -2], [-2, 0, 0, 2] ]
 * 创建时间：2020/1/24 15:19
 * 创建人：Mical
 */
public class LeetCode18 {
    class Solution{
        //定义4个指针，i, j, k, h；i从0开始遍历，j从i+1开始遍历，留下k和h进行双指针碰撞。
        public List<List<Integer>> fourSum(int[] nums, int target){
            List<List<Integer>> res = new ArrayList<>();
            //当数组为null或元素小于4个时，直接返回。
            if (nums.length < 4){
                return res;
            }

            //对数组进行排序
            Arrays.sort(nums);

            //数组长度
            int len = nums.length;

            for (int i = 0; i < len - 3; i++) {
                //当i处索引的值与前面的值相等时忽略
                if (i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                //获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                    break;
                }

                //获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏
                if (nums[i] + nums[len - 1] + nums[len -2] + nums[len - 3] < target){
                    continue;
                }

                //第二层循环
                for (int j = i + 1; j < len - 2; j++) {
                    //当j出索引的值与前面的值相等时
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    //定义指针k指向j + 1
                    int k = j + 1;
                    //定义指针h指向数组末尾
                    int h = len - 1;
                    //获取当前最小值，如果最小值比目标值大，说明后面越来越大没戏
                    int min = nums[i] + nums[j] + nums[k] + nums[k + 1];
                    if (min > target){
                        continue;
                    }
                    //获取当前最大值，如果最大值比目标值小，说明后面越来越小的值没戏
                    int max = nums[i] + nums[j] + nums[h] + nums[h - 1];
                    if (max < target) continue;
                    //开始j指针和h指针的碰撞
                    while (k < h){
                        int cur = nums[i] + nums[j] + nums[k] + nums[h];
                        if (cur == target){
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[h]));
                            k ++;
                            while (k < h && nums[k] == nums[k - 1]) k ++;
                            h --;
                            while (k < h && j < h && nums[h] == nums[h + 1]) h --;
                        }else if (cur > target){
                            h --;
                        }else {
                            k ++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
