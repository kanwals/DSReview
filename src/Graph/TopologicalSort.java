package Graph;

import LinkedList.LinkedList;
import LinkedList.Node;
import java.util.*;

public class TopologicalSort {
    DirectedGraph graph;
    int V;
    List<Integer> topoSortedArray;
    int[] incomingActiveEdgesCount;
    Set<Integer> active;
    Set<Integer> activeNoIncoming;


    public TopologicalSort(DirectedGraph graph) {
        this.graph = graph;
        this.V = graph.getNumVertices();
        incomingActiveEdgesCount = new int[graph.getNumVertices()];
        topoSortedArray = new ArrayList<>();
        active = new HashSet<Integer>();
        activeNoIncoming = new LinkedHashSet<>();

        LinkedList<Integer>[] outgoing = graph.getOutgoingAdjacencyList();
        LinkedList<Integer>[] incoming = graph.getIncomingAdjacencyList();

        for (int i = 0; i < V; i++) {
            active.add(i);
        }

        for (int i = 0; i < V; i++) {
            incomingActiveEdgesCount[i] = incoming[i].getSize();
        }

        for (int i = 0; i < V; i++) {
            if (incomingActiveEdgesCount[i] == 0)
                activeNoIncoming.add(i);
        }

        Iterator<Integer> iterator = activeNoIncoming.iterator();
        while(!activeNoIncoming.isEmpty()){
            int currentVal = iterator.next();
            topoSortedArray.add(currentVal);
            System.out.println(currentVal);
            active.remove(currentVal);
            activeNoIncoming.remove(currentVal);

            Node currentNode = outgoing[currentVal].head;

            while(currentNode!=null){
                incomingActiveEdgesCount[(int)currentNode.data] -= 1;
                currentNode=currentNode.next;
            }

            for (int i = 0; i < V; i++) {
                if (incomingActiveEdgesCount[i] == 0 && active.contains((int) i))
                    activeNoIncoming.add(i);
            }
            iterator = activeNoIncoming.iterator();
        }
    }

    public List<Integer> topoSort() {


        return topoSortedArray;
    }


    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(8);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 6);
        graph.addEdge(3, 0);
        graph.addEdge(3, 4);
        graph.addEdge(5, 2);
        graph.addEdge(5, 7);
        graph.addEdge(7, 6);

        TopologicalSort topologicalSort = new TopologicalSort(graph);
    }
}
