package com.lewis.datastructrue.tree;

/**
 * Created by zhangminghua on 2017/2/24.
 */
public class TreeNode<T extends Comparable<? super T>> implements Comparable<TreeNode<T>> {

    int count = 1;//累计相同节点的个数
    T element;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T element) {
        this(element,null,null);
    }

    public TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public int compareTo(TreeNode<T> o) {
        return this.element.compareTo(o.element);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "count=" + count +
                ", element=" + element +
                '}';
    }
}
