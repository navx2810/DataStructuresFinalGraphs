package graphs;

import entities.Node;


public class DGraph extends WDGraph {

	public void addEdge(Node origin, Node destination)
	{
		origin.addEdgeTo(destination, 1.0);
	}
	
}
