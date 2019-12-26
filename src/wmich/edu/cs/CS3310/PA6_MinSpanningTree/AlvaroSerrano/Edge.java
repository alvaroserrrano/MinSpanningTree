package wmich.edu.cs.CS3310.PA6_MinSpanningTree.AlvaroSerrano;

public class Edge implements IEdge {
	
	private int source;
	
	private int destination;
	
	private int weight;

	public Edge() {
	
	}
	
	public Edge (int source, int destination, int weight) {
		
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		
	}

	@Override
	public void setSource(int source) {
		this.source = source;
	}

	@Override
	public int getSource() { 
		return source;
	}

	@Override
	public void setDestination(int destination) {
		this.destination = destination;
	}

	@Override
	public int getDestination() {
		return destination;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int getWeight() {
		return weight;
	}

}
