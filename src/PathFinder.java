import java.util.HashMap;

import entities.Node;
import graphs.WDGraph;


public class PathFinder {

	HashMap<Node, Boolean> visited;
	WDGraph graph;
	Node origin, destination;
//	Queue<Node> starts, ends; 	//TODO: place this in a PathManager class
	
	public PathFinder(WDGraph graph, Node origin, Node destination) {
		this.graph = graph;
		this.origin = origin;
		this.destination = destination;
		visited = new HashMap<Node, Boolean>();
		
		for(Node node : graph.nodes)
			visited.put(node, true);
	}
	
	private void findBestPath()
	{
		// Insert Dijkstra's Algorithm here
	}
	
	private void printPath()
	{
		// Print path here
	}
	
	
	


}
