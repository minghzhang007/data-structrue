package com.lewis.datastructrue.tree;

/**
 * Created by zhangminghua on 2017/1/24.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private TreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public boolean contains(T x){
        return contains(x,root);
    }

    public boolean contains(T x,TreeNode<T> t){
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult > 0) {
            return contains(x,t.left);
        }else if (compareResult < 0) {
            return contains(x,t.right);
        }else{
            return true;
        }
    }

    public T findMin(){
        if (isEmpty()) {
            throw new RuntimeException("BinarySearchTree is empty!");
        }
        return findMin(root).element;
    }

    public T findMax(){
        if (isEmpty()) {
            throw new RuntimeException("BinarySearchTree is empty!");
        }
        return findMax(root).element;
    }

    public TreeNode<T> findMin(TreeNode<T> t){
        if (t == null) {
            return null;
        }else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    public TreeNode<T> findMax(TreeNode<T> t){
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    public void insert(T t){
        root = insert(t,root);
    }

    private TreeNode<T> insert(T x, TreeNode<T> t) {
        if (t == null) {
            return new TreeNode<T>(x,null,null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x,t.left);
        }else if (compareResult > 0) {
            t.right= insert(x,t.right);
        }else{
            //说明二叉搜索数中存在此元素，则将其属性count++;
            t.count++;
        }
        return t;
    }

    public void remove(T t){
        this.root = remove(t,root);
    }

    /**
     * 删除操作，根据节点A的子节点数量的不同进行不同的处理：
     * 1.若要删除的节点A无子节点，则可以直接将节点A删除。
     * 2.若要删除的节点A有一个子节点，则将其子节点顶上去。
     * 3.若要删除的节点A有两个子节点，先找出节点A的右子树的最小节点M，然后将M节点的元素赋值给A节点的元素，然后递归的删除A节点右子树的M节点。
     * @param x
     * @param t
     * @return
     */
    private TreeNode<T> remove(T x,TreeNode<T> t){
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x,t.left);
        }else if (compareResult > 0) {
            t.right = remove(x,t.right);
        }else if (t.left != null && t.right != null) {//有两个子节点
            //1.找出待删除节点右子树的最小元素M，将其赋值给待删除元素。
            t.element = findMin(t.right).element;
            //2.递归删除待删除元素右子树的最小元素M
            t.right = remove(t.element,t.right);
        }else{//有一个子节点
            //
            t =(t.left != null)?t.left:t.right;
        }
        if (t != null && t.count > 1) {
            //删除该元素，将其数量--；
            t.count--;
        }
        return t;
    }

    public void printTree(){
        printTree(root);
    }

    private void printTree(TreeNode<T> t){
        if (t == null) {
           // System.out.println("tree is empty !");
            return;
        }
        if (t.left != null) {
            printTree(t.left);
        }
        System.out.println(t.element);
        if (t.right != null) {
           printTree(t.right);
        }
       // System.out.println(t.toString());
    }

}
