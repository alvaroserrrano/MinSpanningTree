package wmich.edu.cs.CS3310.PA6_MinSpanningTree.AlvaroSerrano;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		
		//Initialize a min cost spanning tree with hard-coded vertices and edges
		
		int vertices = 7;
		
		int MSTWeight;
		
		Graph graph = new Graph();
		
		graph.setVertices(vertices);

		List<IEdge> allEdges = new ArrayList<>();
		
		graph.setAllEdges(allEdges);

		graph.addEdge(0, 1, 28);
		graph.addEdge(0, 5, 10);
		graph.addEdge(1, 2, 16);
		graph.addEdge(1, 6, 14);
		graph.addEdge(2, 3, 12);
		graph.addEdge(3, 6, 18);
		graph.addEdge(3, 4, 22);
		graph.addEdge(4, 5, 25);
		graph.addEdge(4, 6, 24);

		System.out.println("=======================================\n\t  THE ORIGINAL GRAPH...\t     ||\n=======================================");
		graph.printGraph();
		System.out.println("=======================================");
		
		//Call Krusal's implementation to complete the min cost spanning tree and return minimum cost
		MSTWeight = graph.calculateMST();
		
		//Print edges of the minimum cost spanning tree
		System.out.println("\n PRINTING OUT THE MST..."
				+ "\n\n\t........................."
				+ "\n\t........................."
				+ "\n\t.........................\n\n");
		graph.printMST();
		
		System.out.println("=======================================\n");
		System.out.println("\n CALCULATING WEIGHT OF THE MST..."
				+ "\n\n\t........................."
				+ "\n\t........................."
				+ "\n\t........................."
				+ "\n\t.........................\n\n\t " + "MST WEIGHT: " + MSTWeight + "\n\n");
		
		System.out.println("=======================================\n");
		
	}

}
