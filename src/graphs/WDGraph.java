package graphs;

import java.util.ArrayList;

import entities.Node;

public class WDGraph 
{
	public ArrayList<Node> nodes;	// Adjacency List
	public Node entry, destination;
	
	public WDGraph() 
	{
		nodes = new ArrayList<Node>();
	}
		
	public void addEdge(Node origin, Node destination, Double weight)
	{
		origin.addEdgeTo(destination, weight);
	}
	
	public void setEntryAndDestination(Node entry, Node destination) 
	{
		this.entry = entry;
		this.destination = destination;
	}
}
