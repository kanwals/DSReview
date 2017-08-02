package Tree;

import Queue.QueueLL;

/**
 * Created by Gurkanwal on 8/2/2017.
 */
public class BinaryTree<T> {
    BinaryTreeNode root;

    BinaryTree(T data){
        root = new BinaryTreeNode(data);
    }

    int getHeight(BinaryTreeNode root){
        if(root == null)
            return 0;
        int lTreeHeight = getHeight(root.left);
        int rTreeHeight = getHeight(root.right);

        if(lTreeHeight > rTreeHeight)
            return lTreeHeight+1;
        else
            return rTreeHeight+1;
    }

    void printLevelOrder(BinaryTreeNode root){
        if(root == null)
            System.out.println(root.data + " ");
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
    }

    void printLevelOrderUsingQueue(BinaryTreeNode root){
        if (root == null)
            return;
        QueueLL<BinaryTreeNode> queue = new QueueLL<>();
        queue.enqueue(root);

        while(!queue.isEmpty()){
            BinaryTreeNode temp = queue.dequeue();
            System.out.print(temp.data + " ");
            if(temp.left!=null)
                queue.enqueue(temp.left);
            if(temp.right!=null)
                queue.enqueue(temp.right);
        }
    }

    void printGivenLevel(BinaryTreeNode root, int level){
        if(root == null){
            return;
        }
        if (level == 1){
            System.out.print(root.data + " ");
        } else {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree<>(1);
        tree.root.left = new BinaryTreeNode<>(2);
        tree.root.right = new BinaryTreeNode<>(3);
        tree.root.left.left = new BinaryTreeNode<>(4);

        System.out.println("Height of the Tree is: "+tree.getHeight(tree.root));
        System.out.print("Level Order Traversal: "); tree.printLevelOrder(tree.root);
        System.out.println();
        System.out.print("Level Order Traversal using Queue: "); tree.printLevelOrderUsingQueue(tree.root);
        System.out.println();
    }
}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode left, right;

    BinaryTreeNode(T data){
        this.data = data;
        left = right = null;
    }
}