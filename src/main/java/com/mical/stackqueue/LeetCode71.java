package com.mical.stackqueue;

import org.junit.Test;

import java.util.Stack;

/**
 * 类 名 称：LeetCode71
 * 类 描 述：力扣网71题
 * 题 描 述：以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串
 * /a/b/../
 * 创建时间：2020/2/21 11:19
 * 创建人：Mical
 */
public class LeetCode71 {
    class Solution {
        //思路：先将路径用"/"进行分割，分割后，在遍历分割后的数组。如果是“.”，就直接跳过；如果是两个点，就删除字符串最后的“/”及之后的字符。我都没有用到栈
        public String simplifyPath(String path) {
            String[] split = path.split("/");
            StringBuilder sb = new StringBuilder();
            //遍历字符数组
            for (String s : split) {
                switch (s) {
                    case ".":
                        break;
                    case "..": {
                        if (sb.length() != 0) {
                            sb.delete(sb.lastIndexOf("/"), sb.length());
                        }
                        break;
                    }
                    case "": {
                        break;
                    }
                    default: {
                        sb.append("/").append(s);
                    }
                }
            }
            //当遍历半天后，跑到跟路径了的情况下，字符串的长度就为0，所以要加一个根路径
            if (sb.length() == 0){
                sb.append("/");
            }
            return sb.toString();
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        String s = solution.simplifyPath("/a//b////c/d//././/..");
        System.out.println(s);
    }
}
