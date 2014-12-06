package entities;

public class Edge 
{
	Node target;
	double weight;
	
	
	
	public Edge(Node target, double weight) {
		this.target = target;
		this.weight = weight;
	}
	
	public Edge(Node target)
	{
		this(target, 1);
	}



	@Override
	public String toString() {
		return String.format("edge to %s| Weight: %s", target, weight);
	}
}
