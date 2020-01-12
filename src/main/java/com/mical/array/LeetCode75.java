package com.mical.array;

import org.junit.Test;

/**
 * 类 名 称：LeetCode75
 * 类 描 述：力扣网75题
 * 题 描 述：给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
 * 示 例：输入: [2,0,2,1,1,0] 输出: [0,0,1,1,2,2]
 * 创建时间：2020/1/12 19:50
 * 创建人：Mical
 */
public class LeetCode75 {

    class Solution{

        /**
         * 时间复杂度：O(n)
         * 空间复杂度：O(k)，k为元素的取值范围
         * 使用一个数组分别记录三个元素的个数，再将三个元素按大小放入原数组中
         * @param nums
         */
        public void sortColors(int[] nums){
            int[] counts = new int[]{0, 0, 0};
            for (int num : nums) {
                assert num >= 0 && num <= 3;
                counts[num]++;
            }

            int index = 0;
            for (int i = 0; i < counts[0]; i++) {
                nums[index++] = 0;
            }
            for (int i = 0; i < counts[1]; i++){
                nums[index ++] = 1;
            }
            for (int i = 0; i < counts[2]; i++) {
                nums[index++] = 2;
            }
        }

        /**
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         * 只遍历了数组一遍，使用了三路快排，默认数组所有都为1的段，然后1段前面为0，后面为2，
         * 遍历1段，分别将值为1的放入1段前面，将值为2的放入1段后面
         * @param nums
         */
        public void sortColors1(int[] nums){

            int zero = -1; //最后确保 nums[0...zero] 为0
            int two = nums.length; //最后确保 nums[two...n-1] 为2

            for (int i = 0; i < two; ) {
                if (nums[i] == 1){
                    i++;
                }else if (nums[i] == 2){
                    two --;
                    //交换
                    int temp = nums[i];
                    nums[i] = nums[two];
                    nums[two] = temp;
                }else {  // nums[i] == 0,zero自加后，zero索引处的值为1，所以i要自加
                    zero ++;
                    //交换
                    int temp = nums[i];
                    nums[i] = nums[zero];
                    nums[zero] = temp;
                    i ++;
                }
            }
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();

        int[] arr = new int[]{2,0,2,1,1,0};
        solution.sortColors1(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
