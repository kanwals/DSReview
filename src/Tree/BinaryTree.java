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

    void printLevelOrderInLevels(BinaryTreeNode root){
        if (root == null)
            return;
        QueueLL<BinaryTreeNode> queue = new QueueLL<>();
        queue.enqueue(root);

        while(true){
            int queueSize = queue.getCurrentLength();
            if(queueSize == 0)
                break;
            while(queueSize>0){
                BinaryTreeNode temp = queue.dequeue();
                System.out.print(temp.data + " ");
                if(temp.left!=null)
                    queue.enqueue(temp.left);
                if(temp.right!=null)
                    queue.enqueue(temp.right);
                queueSize--;
            }
            System.out.println();
        }
    }

    void printTree(BinaryTreeNode root){
        if (root == null)
            return;

        int height = getHeight(root);
        int level = 1;
        QueueLL<BinaryTreeNode> queue = new QueueLL<>();
        queue.enqueue(root);

        while(true){
            boolean isSameLevel = false;
            int queueSize = queue.getCurrentLength();
            if(queueSize == 0)
                break;
            while(queueSize>0){
                BinaryTreeNode temp = queue.dequeue();
                for (int i = 0; i < Math.pow(2,height-1) && !isSameLevel; i++) {
                    System.out.print("\t");
                }
                if((int)temp.data != -1111)
                    System.out.print(temp.data);
                else System.out.print(" ");
                isSameLevel = true;
                if(isSameLevel){
                    for (int i = 0; i < Math.pow(2,height); i++) {
                        System.out.print("\t");
                    }
                }
                if(temp.left!=null)
                    queue.enqueue(temp.left);
                else if((int)temp.data != -1111) queue.enqueue(new BinaryTreeNode(-1111));
//                else System.out.print("\t \t");
                if(temp.right!=null)
                    queue.enqueue(temp.right);
                else if((int)temp.data != -1111) queue.enqueue(new BinaryTreeNode(-1111));
//                else System.out.print("\t \t");
                queueSize--;
            }
            height--;
            level++;
            System.out.println();
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

    void printInorder(BinaryTreeNode root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    void printPreOrder(BinaryTreeNode root){
        if(root == null)
            return;
        System.out.print(root.data +" ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    void printPostOrder(BinaryTreeNode root){
        if(root == null)
            return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data +" ");
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree<>(1);
        tree.root.left = new BinaryTreeNode<>(2);
        tree.root.right = new BinaryTreeNode<>(3);
        tree.root.left.left = new BinaryTreeNode<>(4);
        tree.root.left.right = new BinaryTreeNode<>(5);
        tree.root.right.left = new BinaryTreeNode<>(6);
        tree.root.right.right = new BinaryTreeNode<>(7);
        tree.root.left.left.left = new BinaryTreeNode<>(8);
        tree.root.left.left.right = new BinaryTreeNode<>(9);
        tree.root.left.right.left = new BinaryTreeNode<>(10);
        tree.root.left.right.right = new BinaryTreeNode<>(11);
        tree.root.right.left.left = new BinaryTreeNode<>(12);
        tree.root.right.left.right = new BinaryTreeNode<>(13);
        tree.root.right.right.left = new BinaryTreeNode<>(14);
        tree.root.right.right.right = new BinaryTreeNode<>(15);

//        System.out.println("Height of the Tree is: "+tree.getHeight(tree.root));
//        System.out.print("Level Order Traversal: "); tree.printLevelOrder(tree.root);
//        System.out.println();
//        System.out.println("Level Order Traversal in Levels using Queue: "); tree.printLevelOrderInLevels(tree.root);
//        System.out.println();
        tree.printTree(tree.root);
        tree.printInorder(tree.root);
        System.out.println();
        tree.printPreOrder(tree.root);
        System.out.println();
        tree.printPostOrder(tree.root);
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