package entities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import graphs.WDGraph;


public class PathFinder {

	HashMap<Node, Boolean> visited;
	WDGraph graph;
	Node origin, destination;
	
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
		Queue<Node> nodeQueue = new LinkedList<Node>();
		HashMap<Node, Node> previousMap = new HashMap<Node, Node>();
		
		origin.minDistance = 0.0;
		
		nodeQueue.add(origin);
		
		while ( !nodeQueue.isEmpty() )
		{
			Node node = nodeQueue.poll();
			
			for(Edge edge : node.edges)
			{
				Node target = edge.target;
				double distanceThrough = node.minDistance + edge.weight;
				if ( distanceThrough < target.minDistance)
				{
					nodeQueue.remove( target );
					target.minDistance = distanceThrough;
					previousMap.put(target, node);
					nodeQueue.add( target );
				}
			}
		}	
		// Insert Dijkstra's Algorithm here
		
		printPath(previousMap);
	}
	
	private void printPath(HashMap<Node,Node> previousMap)
	{
		ArrayList<Node> path = new ArrayList<Node>();
		for( Node target = destination; target != null; target = previousMap.get(target))
			path.add(target);
		Collections.reverse(path);
		System.out.println("\nbest path\n");
	}
	
	
	


}
