package wmich.edu.cs.CS3310.PA6_MinSpanningTree.AlvaroSerrano;

public interface IDisjointSet {

	//method that sets the array of tree roots that consists the disjoint set
	void setParent(int[]  parent);

	//method that returns the array of tree roots that consists the disjoint set
	int[] getParent();


	//method that performs a union between two set tree roots
	void union(int I, int j);

	//method that finds the disjoint set tree root index of vertex I and returns the index
	int find(int i);

	//method that initializes parent index of each vertex to itself in parent array
	void makeSet();
	
}
