package Graph;

import LinkedList.*;
import Stack.StackLL;

import java.util.Arrays;

public class DFS {

    private Graph dfsTree;
    private boolean[] explored;
    private StackLL<Integer> stack;
    private Graph graph;

    DFS(Graph graph){
        this.graph = graph;
        dfsTree = new Graph(graph.getNumVertices());
        stack = new StackLL<Integer>();
        explored = new boolean[graph.getNumVertices()];
        Arrays.fill(explored, false);
    }

    public Graph doDfsIterative(int s){

        LinkedList<Integer>[] adj = graph.getAdjacencyList();
        int[] parent = new int[graph.getNumVertices()];
        stack.push(s);
        parent[s]=s;
        while(!stack.isEmpty()){
            s = stack.pop();
            if(!explored[s]){
                System.out.print(s + " ");
                explored[s] = true;
                dfsTree.addEdge(s,parent[s]);
                Node currentNode = adj[s].head;
                while(currentNode!=null){
                    stack.push((int)currentNode.data);
                    parent[(int)currentNode.data] = s;
                    currentNode=currentNode.next;
                }
            }
        }
        return dfsTree;
    }

    private Graph dfs(LinkedList<Integer>[] adj, int s){

        explored[s] = true;
        System.out.print(s + " ");

        Node currentNode = adj[s].head;
        while(currentNode!=null){
            if(!explored[(int)currentNode.data]){
                dfs(adj, (int)currentNode.data);
                dfsTree.addEdge(s, (int)currentNode.data);
            }
            currentNode = currentNode.next;
        }


        return dfsTree;
    }
    public Graph doDfsRecursive(int s){
        LinkedList<Integer>[] adj = graph.getAdjacencyList();
        return dfs(adj, s);

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

        DFS dfs = new DFS(graph);
        dfs.doDfsIterative(2);
    }

}
