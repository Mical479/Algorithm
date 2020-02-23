package com.mical.stackqueue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 类 名 称：NestedIterator
 * 类 描 述：力扣网341题：扁平化嵌套列表迭代器
 * 题 描 述：给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的每一项或者为一个整数，或者是另一个列表。
 * 输 入：[[1,1],2,[1,1]]
 * 输 出：[1,1,2,1,1]
 * 解 释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 思 路：在构造器中利用递归直接将NestedList转化为普通的List。
 * 创建时间：2020/2/23 10:35
 * 创建人：Mical
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> integerList = new ArrayList<>();
    private int count;
    private int cur = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        nestedListToList(nestedList);
        count = integerList.size();
    }

    private void nestedListToList(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                integerList.add(nestedInteger.getInteger());
            } else {
                List<NestedInteger> list = nestedInteger.getList();
                nestedListToList(list);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return cur < count;
    }

    @Override
    public Integer next() {
        return integerList.get(cur++);
    }

    public static void main(String[] args) {
        ArrayList<NestedInteger> list = new ArrayList<>();
        NestedInteger nestedInteger = new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(2)));
        list.add(nestedInteger);
        list.add(new NestedInteger(2));
        list.add(nestedInteger);
        NestedIterator nestedIterator = new NestedIterator(list);
        while (nestedIterator.hasNext()){
            System.out.println(nestedIterator.next());
        }
    }
}
