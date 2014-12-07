package entities;

import java.util.ArrayList;
import java.util.Iterator;

public class Node 
{
	public static int NODE_COUNT = 0;
	public int id;
	public ArrayList<Edge> edges;
	public String locationName;
	
	public double longitude, latitude, height;
	
	public Node(int id, String locationName, double longitude, double latitude, double height) {
		this.id = id;
		this.locationName = locationName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
		edges = new ArrayList<Edge>();
	}

	public void addEdgeTo(Node node, double weight)
	{
		edges.add( new Edge(node, weight) );
	}
	
	public void addEdgeTo(Node node)
	{
		edges.add( new Edge(node) );
	}
	
	public boolean hasEdge(Edge edge)
	{
		if ( edges.contains(edge) )
			return true;
		return false;
	}
	
	public boolean isAdjacentToNode(Node node)
	{
		Iterator<Edge> it = edges.iterator();
		while ( it.hasNext() )
			if ( it.next().target == node )
				return true;
		return false;
	}

	@Override
	public String toString() {
		return id + "";
	}
}
