package graphs;

import entities.Node;

public class DGraph extends WDGraph {

	
	@Override
	protected double calculateDistances(Node origin, Node destination) {
		return 1;
	}
	
}
