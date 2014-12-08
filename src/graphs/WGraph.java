package graphs;

import entities.Node;

public class WGraph extends WDGraph {

	@Override
	public void addEdge(Node origin, Node destination, Double weight) {
		super.addEdge(origin, destination, weight);
		super.addEdge(destination, origin, weight);
	}
	
	
}
