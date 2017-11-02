package Tree;

import java.util.Random;

public class BST {
    BSTNode root;

    public BST(){
        this.root = null;
    }

    public BSTNode getRoot() {
        return root;
    }

    public void insert(int key){
//        root = insert(root, key);
        root = insert(root, new BSTNode(null,key));
    }

    private BSTNode insert(BSTNode x, int key){
        if(x==null) return new BSTNode(null,key);

        if(key<x.key) x.left = insert(x.left,key);
        else if(key>x.key) x.right = insert(x.right, key);
        return x;
    }

    //NOTE: This code takes care of parent amendment as well while insertion, which is required by many applications of binary search trees such as finding nextLargest element.
    private BSTNode insert(BSTNode x, BSTNode child){
        if(x==null) return child;

        if(child.key<x.key){
            if(x.left == null){
                child.parent = x;
                x.left = child;
            }
            else x.left = insert(x.left, child);
        }
        //NOTE: We should always store distinct keys in binary tree (NO equal to sign). If we need to store duplicate values, implement a counter on each node that contains the count value.
        else if (child.key>x.key){
            if(x.right == null){
                child.parent = x;
                x.right = child;
            }
            else x.right = insert(x.right, child);
        }
        return x;
    }

    public void printPreOrder(){
        printPreOrder(root);
    }

    private void printPreOrder(BSTNode x){
        if(x==null)
            return;
        System.out.print(x.key+" ");
        printPreOrder(x.left);
        printPreOrder(x.right);
    }

    public void printInOrder(){
        printInOrder(root);
    }

    private void printInOrder(BSTNode x){
        if(x==null)
            return;
        printInOrder(x.left);
        System.out.print(x.key+" ");
        printInOrder(x.right);
    }

    public void printPostOrder(){
        printPostOrder(root);
    }

    private void printPostOrder(BSTNode x){
        if(x==null)
            return;
        printPostOrder(x.left);
        printPostOrder(x.right);
        System.out.print(x.key+" ");
    }

    public BSTNode find(int key){
        return find(root, key);
    }

    private BSTNode find(BSTNode x, int key){
        if(x==null)
            return null;
        if(key<x.key) return find(x.left,key);
        else if(key>x.key) return find(x.right,key);
        else return x;
    }

    public BSTNode findMin(){
        return findMin(root);
    }

    private BSTNode findMin(BSTNode x){
        while(x.left!=null) x=x.left;
        return x;
    }

    public BSTNode nextLarger(BSTNode node){
        if(node.right!=null)
            return findMin(node.right);
        BSTNode current = node;
        /* NOTE: I am the right leaf node. I am always greater than my parent. i will see if my parent is a left node of their parent, and if that is the case, then my parent's parent has the value larger than me. Otherwise, I see his parent as well, until there is no such parent (null) */
        while(current.parent != null && current == current.parent.right){
            current = current.parent;
        }
        return current.parent;
    }
}

class BSTCaller{
    public static void main(String[] args) {
        BST bst = new BST();
        int[] keys = {5,2,7,1,3,6,8};
        int[] random = new int[keys.length];
        Random ran = new Random();
        for(int i=0; i<random.length; i++){
            random[i]= ran.nextInt(10);
        }
        for(int key: keys){
            bst.insert(key);
        }

        System.out.print("PRE ORDER: "); bst.printPreOrder();
        System.out.println();
        System.out.print("IN ORDER: "); bst.printInOrder();
        System.out.println();
        System.out.print("POST ORDER: "); bst.printPostOrder();
        System.out.println();
        System.out.println(bst.nextLarger(bst.findMin()).key);

        //Way to get sorted elements from binary tree: will be nlogn if the tree is balanced. AVL trees!
        int minValCurrent = 0;
        for(int i=0; i<keys.length-1; i++){
            if (i==0)  minValCurrent = bst.findMin().key;
            System.out.print(minValCurrent+" ");
            minValCurrent = bst.nextLarger(bst.find(minValCurrent)).key;
        }
        System.out.print(minValCurrent+" ");
    }
}
