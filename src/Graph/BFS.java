package Graph;

import LinkedList.*;
import Queue.QueueLL;

import java.util.Arrays;

public class BFS {

    private Graph bfsTree;
    private boolean[] discovered;
    private QueueLL<Integer> queue;
    private Graph graph;

    BFS(Graph graph){
        this.graph = graph;
        bfsTree = new Graph(graph.getNumVertices());
        queue = new QueueLL<>();
        discovered = new boolean[graph.getNumVertices()];
        Arrays.fill(discovered, false);
    }

    public Graph doBfs(int s){
        LinkedList<Integer>[] adj = graph.getAdjacencyList();

        discovered[s] = true;
        queue.enqueue(s);

        while(!queue.isEmpty()){
            s = queue.dequeue();
            System.out.print(s+" ");

            Node currentNode = adj[s].head;
            while(currentNode!=null){
                int n = (int)currentNode.data;
                if(!discovered[n]){
                    discovered[n]=true;
                    queue.enqueue(n);
                    bfsTree.addEdge(s,n);
                }
                currentNode = currentNode.next;
            }
        }

        return bfsTree;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(1,2);
        graph.addEdge(1,6);
        graph.addEdge(3,6);
        graph.addEdge(5,2);
        graph.addEdge(4,2);
        graph.addEdge(6,4);
        graph.addEdge(7,4);
        graph.addEdge(5,7);
        graph.addEdge(0,7);

        BFS bfs = new BFS(graph);
        bfs.doBfs(2);
    }


}
