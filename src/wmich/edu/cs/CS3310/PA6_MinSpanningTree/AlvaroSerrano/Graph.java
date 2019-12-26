package wmich.edu.cs.CS3310.PA6_MinSpanningTree.AlvaroSerrano;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Graph implements IGraph {
	
	private List<IEdge> allEdges = new ArrayList<>();
	
	private int vertices;
	
	private DisjointSet disjoint;
	
	private List<IEdge> MST = new ArrayList<>();

	public Graph() {
		
	}
	
	public Graph(int vertices) {
        this.vertices = vertices;
    }
	
	@Override
	public void addEdge(int source, int destination, int weight) {
		IEdge edge = new Edge (source, destination, weight);
		allEdges.add(edge);
	}

	@Override
	public void setAllEdges(List<IEdge> allEdges) {
		this.allEdges = allEdges;
	}

	@Override
	public List<IEdge> getAllEdges() {
		return allEdges;
	}

	@Override
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	@Override
	public int getVertices() {
		return vertices;
	}

	@Override
	public void setDisjoint(DisjointSet disjoint) {
		this.disjoint = disjoint;
	}
	
	@Override
	public DisjointSet getDisjoint() {
		return disjoint;
	}
	
	@Override
	public List<IEdge> getMST() {
		return MST;
	}

	@Override
	public void setMST(List<IEdge> mst) {
		MST = mst;
	}

	@Override
	public int calculateMST() {
		
		int weight = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.getWeight()));
		
		//addd all edges to pq
		for(int i = 0; i < allEdges.size(); i++) {
			pq.add((Edge) allEdges.get(i));
		}
		
		//create a parent 
		disjoint = new DisjointSet();
		int [] parent = new int[vertices];
		disjoint.setParent(parent);
		disjoint.makeSet();
		
		//process vertices - 1 edges
		int index = 0;
		while(index < vertices - 1) {
			
			Edge edge = pq.remove();
			
			//Check if a cycle is formed
			int xSet = disjoint.find(edge.getSource());
			int ySet = disjoint.find(edge.getDestination());
			
			if(xSet != ySet) {
				//add edge
				MST.add(edge);
				index++;
			}
	
			disjoint.union(xSet, ySet);
		
		}
		System.out.println("=======================================\n"
				+ "\n\t........................."
				+ "\n\t........................."
				+ "\n\tCALCULATING MST..."
				+ "\n\t........................."
				+ "\n\t.........................\n\n\t ");
		
		System.out.println("\n CALCULATING NUMBER OF NODES IN MST..."
				+ "\n\n\t........................."
				+ "\n\t........................."
				+ "\n\t........................."
				+ "\n\t.........................\n\n\t " + "NUMBER OF NODES IN MST: " + disjoint.getParent().length + "\n\n");
		
		//Weights addition
		for (IEdge edge : MST) {
			
			weight += edge.getWeight();
			
		}
		
		return weight;
	}

	@Override
	public void printMST() {
		
		for(int i = 0; i < MST.size(); i++) {
			
			Edge edge = (Edge) MST.get(i);
			int index = i + 1;
			System.out.println("Edge-" + index +
					" \n\tsource: " + edge.getSource() + 
					" \n\tdestination: " + edge.getDestination() + 
					" \n\tweight: " + edge.getWeight() + "\n\n");
			
		}
			
	}

	@Override
	public void printGraph() {
		
		for(int i = 0; i < allEdges.size(); i++) {
			
			Edge edge = (Edge) allEdges.get(i);
			int index = i + 1; 
			System.out.println("Edge-" + index +
					" \n\tsource: " + edge.getSource() + 
					" \n\tdestination: " + edge.getDestination() + 
					" \n\tweight: " + edge.getWeight() + "\n\n");
			
		}

	}

}
