package Tree;


import javax.swing.tree.TreeNode;
import java.util.*;

public class BST {
    BSTNode root;

    public BST(){
        this.root = null;
    }

    public BSTNode getRoot() {
        return root;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public int size(){
        return size(root);
    }

    private int size(BSTNode node){
        if (node == null) return 0;
        else return node.size;
    }

    public void insert(int key){
//        root = insert(root, key);
        root = insert(root, new BSTNode(null,key));
    }

    private BSTNode insert(BSTNode x, int key){
        if(x==null) return new BSTNode(null,key);

        if(key<x.key) x.left = insert(x.left,key);
        else if(key>x.key) x.right = insert(x.right, key);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    //NOTE: This code takes care of parent amendment as well while insertion, which is required by many applications of binary search trees such as finding nextLargest element.
    private BSTNode insert(BSTNode node, BSTNode child){
        if(node==null) return child;

        if(child.key<node.key){
            if(node.left == null){
                child.parent = node;
                node.left = child;
            }
            else node.left = insert(node.left, child);
        }
        //NOTE: We should always store distinct keys in binary tree (NO equal to sign). If we need to store duplicate values, implement a counter on each node that contains the count value.
        else if (child.key>node.key){
            if(node.right == null){
                child.parent = node;
                node.right = child;
            }
            else node.right = insert(node.right, child);
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
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

    public void deleteMin(){
        deleteMin(root);
    }

    private BSTNode deleteMin(BSTNode node){
        if(node.left==null) {
            if(node.right!=null) node.right.parent = node.parent; //PARENT CODE
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void deleteMax(){
        deleteMax(root);
    }

    private BSTNode deleteMax(BSTNode node){
        if(node.right == null) {
            if(node.left!=null) node.left.parent = node.parent; //PARENT CODE
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void delete(int key){
        root = delete(root,key);
    }

    private BSTNode delete(BSTNode node, int x){
        if(node == null) return null;
        if(x<node.key) node.left = delete(node.left, x);
        else if (x>node.key) node.right = delete(node.right, x);
        else {
            if(node.left==null) {
                if(node.right != null) node.right.parent = node.parent; //PARENT CODE
                return node.right;
            }
            if(node.right==null) {
                if(node.left != null) node.left.parent = node.parent; //PARENT CODE
                return node.left;
            }
            BSTNode temp = node;
            node = findMin(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
            node.parent = temp.parent; //PARENT CODE

            //PARENT CODE
            if(node.left != null) node.left.parent = node;
            if(node.right != null) node.right.parent = node;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    //Get number of keys with values <= val
    public int rank(int val){
        return rank(root, val);
    }

    private int rank(BSTNode node, int val){
        if(node == null) return 0;
        if(val>node.key)
            return 1+size(node.left)+rank(node.right,val);
        else if(val<node.key)
            return rank(node.left,val);
        else
            return 1 + size(node.left);
    }

    public BSTNode lowestCommonAncestor(int l, int r){
        return lowestCommonAncestor(root,l,r);
    }

    /* NOTE: Two other ways:
    1. via HashMap: store all parents of one of the nodes, check if any of the parents of the other other node is there. If yes, return, else don't.
    2. via recursion: same as iterative*/
    public BSTNode lowestCommonAncestor(BSTNode node, int l, int r){
        if(node == null) return null;
        while (node!=null){
            if(node.key>l && node.key>r)
                node = node.left;
            else if(node.key<l && node.key<r)
                node = node.right;
            else break;
        }
        return node;
    }

    public BSTNode invertTree(BSTNode root) {
        if(root==null)
            return null;
        if(root.left==null||root.right==null){
            if(root.left==null) root.left = root.right;
            else root.right = root.left;
            return root;
        }
        else{
            root.left = invertTree(root.right);
            root.right = invertTree(root.left);
        }
        return root;
    }

    //finds all the nodes in the BST within the range [l,r] starting the search at "node"
    private ArrayList<Integer> nodeList(BSTNode node, ArrayList<Integer> list, int l, int r){
        if(node==null)
            return null;
        if(node.key>=l && node.key<=r) list.add(node.key);
        if(node.key>=l) nodeList(node.left, list, l, r);
        if(node.key<=r) nodeList(node.right, list, l, r);
        return list;
    }

    public int[] list(int low, int high){
        BSTNode lca = lowestCommonAncestor(low, high);
        ArrayList<Integer> list = new ArrayList<>();
        list = nodeList(lca, list, low, high);
        return list.stream().mapToInt(i -> i).toArray();
    }

    public HashMap<BSTNode,BSTNode> inOrder(BSTNode node, HashMap<BSTNode,BSTNode> parent){
        if(node==null)
            return null;
        if(node.left!=null) parent.put(node.left,node);
        inOrder(node.left,parent);
        if(node.right!=null) parent.put(node.right,node);
        inOrder(node.right,parent);
        return parent;
    }

    public List<List<Integer>> findLeaves(BSTNode root){
        List<List<Integer>> list = new LinkedList<>();
        findLeavesHelper(root, list);
        return list;
    }

    private int findLeavesHelper(BSTNode node, List<List<Integer>> list){
        if(node==null) return -1;
        int depth = 1 + Math.max(findLeavesHelper(node.left, list),findLeavesHelper(node.right, list));
        if(depth>=list.size()) list.add(depth, new ArrayList<Integer>());
        list.get(depth).add(node.key);
        return depth;
    }

    // BAD implementation. Does not preserve vertical order. Fucking stupid. 
    public List<List<Integer>> verticalOrderTraversal(){
        TreeMap<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>();
        verticalOrderTraversalHelper(map, root, 0);
        return new ArrayList<>(map.values());
    }

    private void verticalOrderTraversalHelper(TreeMap<Integer,List<Integer>> map, BSTNode node, int hd){
        if(node == null) return;
        verticalOrderTraversalHelper(map, node.left, hd-1);
        if(map.containsKey(hd)){
            map.get(hd).add(node.key);
        } else{
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(node.key);
            map.put(hd,al);
        }
        verticalOrderTraversalHelper(map, node.right, hd+1);
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
        HashMap<BSTNode,BSTNode> parent = new HashMap<>();
//        parent = bst.inOrder(bst.root,parent);
        System.out.println(bst.verticalOrderTraversal());
//        BSTNode root = bst.invertTree(bst.root);
//        System.out.println(bst.findLeaves(bst.root));
//        System.out.println(parent);
//        System.out.println(bst.calculate("1+6/3"));
//        System.out.print("PRE ORDER: "); bst.printPreOrder();
//        System.out.println();
//        System.out.print("IN ORDER: "); bst.printInOrder();
//        System.out.println();
//        System.out.print("POST ORDER: "); bst.printPostOrder();
//        System.out.println();
//        System.out.println(bst.nextLarger(bst.findMin()).key);

        //Way to get sorted elements from binary tree: will be nlogn if the tree is balanced. AVL trees!
//        int minValCurrent = 0;
//        for(int i=0; i<keys.length-1; i++){
//            if (i==0)  minValCurrent = bst.findMin().key;
//            System.out.print(minValCurrent+" ");
//            minValCurrent = bst.nextLarger(bst.find(minValCurrent)).key;
//        }
//        System.out.println(minValCurrent+" ");
//        System.out.println("size: "+bst.size());
//        System.out.println("Rank 7: "+bst.rank(7));
//        bst.delete(5);
//        bst.printInOrder();
//        System.out.println("size: "+bst.size());
//        System.out.println("Rank 7: "+bst.rank(7));

        //NOTE: If l>bst.max() or r<bst.min() then this will throw null pointer exception
//        System.out.println(bst.lowestCommonAncestor(-1,0).key);
//        System.out.println("=====================");
//        System.out.printf(Arrays.toString(bst.list(6,8)));
    }

}
