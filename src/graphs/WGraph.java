package graphs;

import entities.Node;

public class WGraph extends WDGraph {

	@Override
	public void addEdge(Node origin, Node destination) {
		super.addEdge(origin, destination);
		super.addEdge(destination, origin);
	}
	
	
}
