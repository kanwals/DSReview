package Tree;

public class BSTNode {
    /* A node in the vanilla Binary Search Tree
     */
    int key;
    BSTNode parent;
    BSTNode left;
    BSTNode right;

    public BSTNode(BSTNode parent, int key){
        this.parent = parent;
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
