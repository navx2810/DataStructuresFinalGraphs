package entities;

import java.util.ArrayList;
import java.util.Iterator;

public class Node 
{
	public static int NODE_COUNT = 0;
	public int id;
	private ArrayList<Edge> edges;
	public String locationName;
	
	public int longitude, latitude, height;
	
	
	
	public Node(int id, String locationName, int longitude, int latitude,
			int height) {
		this.id = id;
		this.locationName = locationName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
		edges = new ArrayList<Edge>();
	}


	public void addEdge(Edge edge)
	{
		edges.add(edge);
	}
	
	public void addEdgeTo(Node node)
	{
		addEdge(new Edge(node));
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
