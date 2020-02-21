package com.mical.stackqueue;

/**
 * 类 名 称：Command
 * 类 描 述：用于遍历树的结构体
 * 创建时间：2020/2/21 13:45
 * 创建人：Mical
 */
public class Command {
    String mark; //标识为，go，表示继续；print，表示打印。
    TreeNode node;

    public Command(String mark, TreeNode node) {
         this.mark = mark;
         this.node = node;
    }
}
