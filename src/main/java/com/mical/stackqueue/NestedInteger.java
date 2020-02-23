package com.mical.stackqueue;

import java.util.List;

/**
 * 类 名 称：NestedInteger
 * 类 描 述：TODO
 * 创建时间：2020/2/23 10:37
 * 创建人：Mical
 */
public class NestedInteger {

    private Integer integer;
    private List<NestedInteger> list;

    public NestedInteger(Integer integer) {
        this.integer = integer;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    public boolean isInteger(){
        return this.integer != null;
    }

    public Integer getInteger(){
        return this.integer;
    }

    public List<NestedInteger> getList(){
        return this.list;
    }
}
