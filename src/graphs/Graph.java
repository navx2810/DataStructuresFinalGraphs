package graphs;

import entities.Node;

public class Graph extends DGraph {

		@Override
		public void addEdge(Node origin, Node destination) {
			super.addEdge(origin, destination);
			super.addEdge(destination, origin);
		}
	
}
