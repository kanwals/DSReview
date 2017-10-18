package Graph;

import LinkedList.LinkedList;

public class DirectedGraph {

    private int V;
    private LinkedList<Integer> outgoing[];
    private LinkedList<Integer> incoming[];

    DirectedGraph(int v) {
        V = v;
        outgoing = new LinkedList[V];
        incoming = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            outgoing[i] = new LinkedList<Integer>();
            incoming[i] = new LinkedList<Integer>();
        }
    }

    public int getNumVertices(){
        return this.V;
    }

    public LinkedList<Integer>[] getOutgoingAdjacencyList(){
        return outgoing;
    }

    public LinkedList<Integer>[] getIncomingAdjacencyList(){
        return incoming;
    }

    public void addEdge(int v, int w){
        outgoing[v].appendToTail(outgoing[v].head,w);
        incoming[w].appendToTail(incoming[w].head, v);
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(8);
        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(1,5);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(2,6);
        graph.addEdge(3,0);
        graph.addEdge(3,4);
        graph.addEdge(5,2);
        graph.addEdge(5,7);
        graph.addEdge(7,6);
    }
}
