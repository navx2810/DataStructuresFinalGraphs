package entities;
import java.util.HashMap;

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
			visited.put(node, false);
		
	}
	
	public void findBestPath()
	{
		visited.put(origin, true);
		// Insert Dijkstra's Algorithm here
		
		printPath();
	}
	
	private void printPath()
	{
		// Print path here
		System.out.println("\nbest path\n");
	}
	
	
	


}
