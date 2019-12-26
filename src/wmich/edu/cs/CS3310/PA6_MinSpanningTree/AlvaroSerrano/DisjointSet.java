package wmich.edu.cs.CS3310.PA6_MinSpanningTree.AlvaroSerrano;

public class DisjointSet implements IDisjointSet {

	//ith element of the array is the parent of the ith item
	private int [] parent;
//	private int[] rank;
	private int n;
	
	public DisjointSet() {
		
	}
	
	public DisjointSet(int n) {
		this.n = n;
	}

	@Override
	public void setParent(int[] parent) {
		this.parent = parent;
		n = parent.length;
	}

	@Override
	public int[] getParent() {
		return parent;
	}

	@Override
	//Find representative of the set
	public int find(int i) {
		
		if(parent[i] != i ) {
			//if i is not the parent of itself, then i is not the representative of its set
			//call find() on i's parent and move i under the representative of this set
			parent[i] = find(parent[i]);
		}
		
		return parent[i];
		
	}
	
	@Override
	//Join the sets that contain i and j
	public void union(int i, int j) {
		
		//Find representatives of both set
		int iSet = find(i), jSet= find(j);
		
		//Check if i and j are on the same set
		if(iSet == jSet) {
			//Already together
			return;
		}
		
//		//Join by rank (smaller rank under bigger); Higher rank becomes parent
//		if(rank[iSet] < rank[jSet]) {
//			parent[iSet] = jSet;
//		}else if (rank[iSet] > rank[jSet]) {
//			parent[jSet] = iSet;
//		}else {
//			parent[jSet] = iSet;
//			rank[iSet] = rank[iSet + 1];
//		}
		
		parent[iSet] = jSet; 
		
	}

	@Override
	//Create a new element with a parent pointer to itself
	//Create n single item sets such that initially all elements are in their own set
	public void makeSet() {
		for (int i = 0; i < n; i++) {
			parent[i] = i;	//make parent itself
//			rank[i] = 0;	//initial rank as 0
		}
	}

}
