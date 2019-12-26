package wmich.edu.cs.CS3310.PA6_MinSpanningTree.AlvaroSerrano;

public interface IEdge {

	//method that sets the source vertex of the edge
	void setSource(int source);

	//method that returns the source vertex of the edge
	int getSource();

	//method that sets the destination vertex of the edge
	void setDestination(int destination);

	//method that returns the destination vertex of the edge
	int getDestination();

	//method that sets the weight of the edge
	void setWeight(int weight);

	//method that returns the weight of the edge
	int getWeight();
	
}
