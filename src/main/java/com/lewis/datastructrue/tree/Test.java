package com.lewis.datastructrue.tree;

/**
 * Created by zhangminghua on 2017/2/24.
 */
public class Test {

    @org.junit.Test
    public void testBinarySearchTree(){
        BinarySearchTree<TreeNode<Integer>> tree = new BinarySearchTree<TreeNode<Integer>>();
        tree.insert(new TreeNode<Integer>(5));
        tree.insert(new TreeNode<Integer>(8));
        tree.insert(new TreeNode<Integer>(4));
        tree.insert(new TreeNode<Integer>(9));
        tree.insert(new TreeNode<Integer>(10));
        tree.insert(new TreeNode<Integer>(10));
        tree.insert(new TreeNode<Integer>(10));
        tree.insert(new TreeNode<Integer>(2));
        tree.insert(new TreeNode<Integer>(12));
        tree.insert(new TreeNode<Integer>(7));
        tree.printTree();
        System.out.println("==========");
        tree.remove(new TreeNode<Integer>(10));
        tree.remove(new TreeNode<Integer>(8));
        tree.printTree();
    }
}
