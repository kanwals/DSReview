package Graph;

import LinkedList.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v){
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public int getNumVertices(){
        return this.V;
    }

    public LinkedList<Integer>[] getAdjacencyList(){
        return adj;
    }

    public void addEdge(int v, int w){
        adj[v].appendToTail(adj[v].head,w);
        adj[w].appendToTail(adj[w].head,v);
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
    }
}
