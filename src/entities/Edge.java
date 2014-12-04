package entities;

public class Edge 
{
	Node target;
	int weight;
	
	
	
	public Edge(Node target, int weight) {
		this.target = target;
		this.weight = weight;
	}
	
	public Edge(Node target)
	{
		this(target, 0);
	}



	@Override
	public String toString() {
		return String.format(" to %s| Weight: %s", target, weight);
	}
}
